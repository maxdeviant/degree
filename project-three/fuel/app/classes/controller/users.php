<?php
	class Controller_Users extends Controller {
		public function action_login() {
			$view = ViewModel::forge('users/login');



			return Response::forge($view);
		}

		public function action_logout() {

		}
	}
?>