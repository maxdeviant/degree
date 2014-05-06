<?php
	class Controller_Users extends Controller {
		public function get_login() {
			$view = ViewModel::forge('users/login');

			return Response::forge($view);
		}

		public function post_login() {
			$view = ViewModel::forge('main/index');

			$username = trim($_POST['username']);
			$password = trim($_POST['password']);

			if (strrpos($username, '@')) {
				$user = DB::select()->from('user')->where('email', $username)->execute()->as_array()[0];
			} else {
				$user = DB::select()->from('user')->where('name', $username)->execute()->as_array()[0];
			}

			if (isset($user) && sha1($password) === $user['password']) {
				View::bind_global('user', $user);
			}

			$sort = ['name', 'asc'];
			$view->bind('sort', $sort);

			$view->items = DB::select()->from('item')->order_by($sort[0], $sort[1])->execute()->as_array();

			return Response::forge($view);
		}

		public function action_logout() {

		}
	}
?>