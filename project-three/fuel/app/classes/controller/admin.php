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
				$description = trim($_POST['name']);
				$image = trim($_POST['image']);

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

				$id = DB::insert('item')->set(array(
					'name' => $name,
					'category' => $category,
					'price' => $price,
					'description' => $description,
					'image' => $image
				))->execute();

				$view->success = 'Item created successfully. ID: ' . $id[0];

				unset($_POST);

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

			if (!isset($_POST['item_id'])) {
				$id = $view->items[0]['id'];
			} else {
				$id = $_POST['item_id'];
			}

			$view->item = DB::select()->from('item')->where('id', $id)->execute()->as_array()[0];

			return Response::forge($view);
		}
	}
?>