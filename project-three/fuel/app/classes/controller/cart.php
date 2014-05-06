<?php
	class Controller_Cart extends Controller {
		public function action_details() {
			$view = ViewModel::forge('cart/details');

			return Response::forge($view);
		}
	}
?>