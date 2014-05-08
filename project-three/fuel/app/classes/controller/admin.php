<?php
	class Controller_Admin extends Controller {
		public function action_menu() {
			$view = ViewModel::forge('admin/menu');

			return Response::forge($view);
		}

		public function action_manage() {
			$view = ViewModel::forge('admin/manage');

			$view->orders = DB::select()->from('order')->order_by('created_at', 'asc')->execute()->as_array();

			return Response::forge($view);
		}

		public function action_add() {
			$view = ViewModel::forge('admin/add');

			$categories = DB::query('select distinct category from item')->execute()->as_array();
			sort($categories);

			$view->categories = $categories;

			return Response::forge($view);
		}

		public function action_edit() {
			$view = ViewModel::forge('admin/edit');

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