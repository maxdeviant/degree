<?php
	class Controller_Splash extends Controller {
		public function action_index() {
			return Response::forge(ViewModel::forge('splash/index'));
		}

		public function action_404() {
			return Response::forge(View::forge('splash/404'));
		}
	}
?>