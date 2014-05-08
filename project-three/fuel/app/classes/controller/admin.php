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

			return Response::forge($view);
		}

		public function action_edit() {
			$view = ViewModel::forge('admin/edit');

			return Response::forge($view);
		}
	}
?>