<?php
	class Controller_Admin extends Controller {
		public function action_menu() {
			$view = ViewModel::forge('admin/menu');

			$user = Session::get('user');

			if (!isset($user) || $user['level'] === 0) {
				return Response::forge(ViewModel::forge('main/401'));
			}

			return Response::forge($view);
		}

		public function action_manage() {
			$view = ViewModel::forge('admin/manage');

			$user = Session::get('user');

			if (!isset($user) || $user['level'] === 0) {
				return Response::forge(ViewModel::forge('main/401'));
			}

			$view->orders = DB::select()->from('order')->order_by('created_at', 'asc')->execute()->as_array();

			return Response::forge($view);
		}

		public function get_add() {
			$view = ViewModel::forge('admin/add');

			$user = Session::get('user');

			if (!isset($user) || $user['level'] === 0) {
				return Response::forge(ViewModel::forge('main/401'));
			}

			$categories = DB::query('select distinct category from item')->execute()->as_array();
			sort($categories);

			$view->categories = $categories;

			return Response::forge($view);
		}

		public function post_add() {
			$view = ViewModel::forge('admin/add');

			$categories = DB::query('select distinct category from item')->execute()->as_array();
			sort($categories);

			$view->categories = $categories;

			if (isset($_POST['submit'])) {
				$name = trim($_POST['name']);
				$category = trim($_POST['category']);
				$price = trim($_POST['price']);
				$description = trim($_POST['description']);
				$image = trim($_POST['image']);

				$view->sticky = array(
					'name' => $name,
					'category' => $category,
					'price' => $price,
					'description' => $description,
					'image' => $image
				);

				$view->error = array();
				$valid = true;

				if (strlen($name) < 3) {
					$view->error[] = 'Item name must contain at least 3 characters.';
					$valid = false;
				}

				if (!is_numeric($price)) {
					$view->error[] = 'Price must be a number.';
					$valid = false;
				}

				if (!$valid) {
					return Response::forge($view);
				}

				try {
					$id = DB::insert('item')->set(array(
						'name' => $name,
						'category' => $category,
						'price' => $price,
						'description' => $description,
						'image' => $image
					))->execute();

					$view->success = 'Item created successfully. ID: ' . $id[0];
				} catch (Exception $e) {
					$view->error[] = 'Name must be unique.';
				}

				unset($_POST['submit']);

				unset($view->sticky);
				$view->sticky = null;

				return Response::forge($view);
			}
		}

		public function action_edit() {
			$view = ViewModel::forge('admin/edit');

			$user = Session::get('user');

			if (!isset($user) || $user['level'] === 0) {
				return Response::forge(ViewModel::forge('main/401'));
			}

			$view->items = DB::select()->from('item')->order_by('name', 'asc')->execute()->as_array();

			if (isset($_POST['item_id'])) {
				$id = $_POST['item_id'];
			} else {
				$id = $view->items[0]['id'];
			}

			$item = DB::select()->from('item')->where('id', $id)->execute()->as_array()[0];

			$view->item = $item;

			if (isset($_POST['submit'])) {
				$id = $_POST['id'];
				$name = $_POST['name'];
				$price = trim($_POST['price']);
				$category = $_POST['category'];
				$description = trim($_POST['description']);
				$image = trim($_POST['image']);

				DB::update('item')->set(array(
					'price' => $price,
					'description' => $description,
					'image' => $image
				))->where('id', $id)->execute();

				unset($_POST['submit']);
			}

			return Response::forge($view);
		}
	}
?>