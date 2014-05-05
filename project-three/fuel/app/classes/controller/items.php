<?php
	class Controller_Items extends Controller {
		public function action_details() {
			$view = ViewModel::forge('items/details');

			$id = $this->param('id');

			$view->item = DB::select()->from('item')->where('id', $id)->execute()->as_array()[0];

			$view->set('description', $view->item['description'], false);

			return Response::forge($view);
		}

		// public function action_404() {
		// 	return Response::forge(ViewModel::forge('splash/404'));
		// }
	}
?>