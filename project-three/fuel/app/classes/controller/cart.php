<?php
	class Controller_Cart extends Controller {
		public function get_details() {
			$view = ViewModel::forge('cart/details');

			$cart = Session::get('cart');

			if ($cart === null) {
				Session::set('cart', array());
			}

			return Response::forge($view);
		}

		public function post_details() {
			$cart = Session::get('cart');

			$user = Session::get('user');

			if ($_POST['type'] === 'update') {
				$id = $_POST['id'];

				$cart[$id] = $_POST['quantity'];
			} else if ($_POST['type'] === 'remove') {
				$id = $_POST['id'];

				unset($cart[$id]);
			} else if ($_POST['type'] === 'submit') {
				$date = new DateTime();

				if (isset($user)) {
					if (count($cart) > 0) {
						$order_id = DB::insert('order')->set(array(
							'user_id' => $user['id'],
							'created_at' => $date->getTimestamp()
						))->execute();

						foreach ($cart as $key => $value) {
							$item = DB::select()->from('item')->where('id', $key)->execute()->as_array()[0];

							DB::insert('item_order')->set(array(
								'item_id' => $key,
								'order_id' => $order_id[0],
								'quantity' => $value,
								'price' => $item['price']
							))->execute();
						}

						$cart = [];
					}
				} else {
					return Response::forge(ViewModel::forge('users/login'));
				}
			} else if ($_POST['type'] === 'clear') {
				$cart = [];
			}

			Session::set('cart', $cart);
		}
	}
?>