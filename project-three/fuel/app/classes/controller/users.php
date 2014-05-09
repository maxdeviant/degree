<?php
	class Controller_Users extends Controller {
		public function get_register() {
			$view = ViewModel::forge('users/register');

			$user = Session::get('user');

			if (isset($user)) {
				return Response::forge(ViewModel::forge(''));
			}

			return Response::forge($view);
		}

		public function post_register() {
			$view = ViewModel::forge('users/register');

			if (isset($_POST['submit'])) {
				$name = trim($_POST['name']);
				$email = trim($_POST['email']);
				$password = trim($_POST['password']);
				$confirm = trim($_POST['confirm']);

				$view->error = array();
				$valid = true;

				if (strlen($name) < 3) {
					$view->error[] = 'Name must contain at least 3 characters.';
					$valid = false;
				}

				if (!strrpos($email, '@')) {
					$view->error[] = 'Email must be valid.';
					$valid = false;
				}

				if (strlen($password) < 4) {
					$view->error[] = 'Make your password somewhat hard to guess. 4 characters or more, please.';
					$valid = false;
				}

				if ($password !== $confirm) {
					$view->error[] = 'Passwords do not match.';
					$valid = false;
				}

				if (!$valid) {
					return Response::forge($view);
				}

				$view = ViewModel::forge('main/index');

				$id = DB::insert('user')->set(array(
					'name' => $name,
					'email' => $email,
					'password' => sha1($password),
					'level' => 0
				))->execute();

				$sort = ['name', 'asc'];

				$view->bind('sort', $sort);
				$view->items = DB::select()->from('item')->order_by($sort[0], $sort[1])->execute()->as_array();

				unset($_POST['submit']);

				return Response::forge($view);
			}
		}

		public function get_login() {
			$view = ViewModel::forge('users/login');

			$user = Session::get('user');

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
				$session = Session::instance();
				Session::set('user', $user);
			}

			$sort = ['name', 'asc'];
			$view->bind('sort', $sort);

			$view->items = DB::select()->from('item')->order_by($sort[0], $sort[1])->execute()->as_array();

			return Response::forge($view);
		}

		public function action_logout() {
			$view = ViewModel::forge('main/index');

			Session::delete('user');

			$sort = ['name', 'asc'];
			$view->bind('sort', $sort);

			$view->items = DB::select()->from('item')->order_by($sort[0], $sort[1])->execute()->as_array();

			return Response::forge($view);
		}
	}
?>