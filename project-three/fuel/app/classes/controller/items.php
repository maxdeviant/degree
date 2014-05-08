<?php
	class Controller_Items extends Controller {
		public function action_details() {
			$view = ViewModel::forge('items/details');

			$id = $this->param('id');

			$item = DB::select()->from('item')->where('id', $id)->execute()->as_array();

			if (count($item) > 0) {
				$view->item = $item[0];
			} else {
				return Response::forge(ViewModel::forge('main/404'), 404);
			}

			$view->set('description', $view->item['description'], false);

			return Response::forge($view);
		}

		public function post_details() {
			$id = $_POST['id'];
			$quantity = $_POST['quantity'];

			$cart = Session::get('cart');

			$cart[$id] = $quantity;

			Session::set('cart', $cart);

			return '<br>Item(s) successfully added to cart.';
		}
	}
?>