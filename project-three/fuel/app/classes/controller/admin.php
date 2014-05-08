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

		public function action_add() {
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