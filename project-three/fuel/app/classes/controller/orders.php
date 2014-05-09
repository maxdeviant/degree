<!-- Marshall Bowers -->
<?php
	class Controller_Orders extends Controller {
		public function action_list() {
			$view = ViewModel::forge('orders/list');

			$user = Session::get('user');

			if (!isset($user)) {
				return Response::forge(ViewModel::forge('users/login'));
			}

			$view->orders = DB::select()->from('order')->where('user_id', $user['id'])->order_by('created_at', 'desc')->execute()->as_array();

			return Response::forge($view);
		}

		public function get_details() {
			$view = ViewModel::forge('orders/details');

			$id = $this->param('id');

			$user = Session::get('user');

			$order = DB::select()->from('order')->where('id', $id)->execute()->as_array();

			if (count($order) > 0) {
				$view->order = $order[0];
			} else {
				return Response::forge(ViewModel::forge('main/404'), 404);
			}

			if (!($user['id'] === $view->order['user_id'] || $user['level'] > 0)) {
				return Response::forge(ViewModel::forge('main/401'), 401);
			}

			$view->items = DB::select()->from('item_order')->where('order_id', $id)->execute()->as_array();

			$view->total = 0;

			return Response::forge($view);
		}

		public function post_details() {
			if (isset($_POST['id'])) {
				$id = $_POST['id'];

				$user = Session::get('user');

				if ($user['level'] === 0) {
					return Response::forge(ViewModel::forge('main/401'), 401);
				} else {
					$order = DB::select()->from('order')->where('id', $id)->execute()->as_array()[0];
					$items = DB::select()->from('item_order')->where('order_id', $id)->execute()->as_array();

					foreach ($items as $item) {
						DB::delete('item_order')->where('id', $item['id'])->execute();
					}

					DB::delete('order')->where('id', $order['id'])->execute();
				}
			} else {
				return 'No ID given.';
			}
		}
	}
?>