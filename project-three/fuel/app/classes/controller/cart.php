<?php
	class Controller_Cart extends Controller {
		public function action_details() {
			$view = ViewModel::forge('cart/details');

			$cart = Session::get('cart');

			if ($cart === null) {
				Session::set('cart', array());
			}

			return Response::forge($view);
		}
	}
?>