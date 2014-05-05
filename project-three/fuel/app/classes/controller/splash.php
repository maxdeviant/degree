<?php
	class Controller_Splash extends Controller {
		public function action_index() {
			$view = ViewModel::forge('splash/index');

			$view->items = DB::select()->from('item')->execute()->as_array();

			return Response::forge($view);
		}

		public function action_404() {
			return Response::forge(ViewModel::forge('splash/404'));
		}
	}
?>