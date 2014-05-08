<?php
	class Controller_Orders extends Controller {
		public function action_list() {
			$view = ViewModel::forge('orders/list');

			$user = Session::get('user');

			$view->orders = DB::select()->from('order')->where('user_id', $user['id'])->order_by('created_at', 'desc')->execute()->as_array();

			return Response::forge($view);
		}

		public function action_details() {
			$view = ViewModel::forge('orders/details');

			$id = $this->param('id');

			$user = Session::get('user');

			$order = DB::select()->from('order')->where('id', $id)->execute()->as_array();

			if (count($order) > 0) {
				$view->order = $order[0];
			} else {
				return Response::forge(ViewModel::forge('main/404'), 404);
			}

			if ($user['id'] !== $view->order['user_id']) {
				return Response::forge(ViewModel::forge('main/401'), 401);
			}

			$view->items = DB::select()->from('item_order')->where('order_id', $id)->execute()->as_array();

			$view->total = 0;

			return Response::forge($view);
		}
	}
?>