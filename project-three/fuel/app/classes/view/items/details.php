<?php
	class View_Items_Details extends ViewModel {
		public function view() {
			$this->title = $this->item['name'] . ' &raquo; CSC 417';
			$this->user = Session::get('user');
			$this->cart = Session::get('cart', array());
		}
	}
?>