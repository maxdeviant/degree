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

			$id = $_POST['id'];

			if ($_POST['type'] === 'update') {
				$cart[$id] = $_POST['quantity'];
			} else if ($_POST['type'] === 'remove') {
				unset($cart[$id]);
			}

			Session::set('cart', $cart);
		}
	}
?>