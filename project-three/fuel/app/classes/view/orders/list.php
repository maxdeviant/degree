<?php
	class View_Orders_List extends ViewModel {
		public function view() {
			$this->title = 'Orders &raquo; CSC 417';
			$this->user = Session::get('user');
		}
	}
?>