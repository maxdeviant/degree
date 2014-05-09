<?php
	class View_Admin_Manage extends ViewModel {
		public function view() {
			$this->title = 'Manage Orders &raquo; CSC 417';
			$this->user = Session::get('user');
			$this->names = [];
		}
	}
?>