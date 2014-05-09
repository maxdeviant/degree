<!-- Marshall Bowers -->
<?php
	class View_Admin_Add extends ViewModel {
		public function view() {
			$this->title = 'Add Item &raquo; CSC 417';
			$this->user = Session::get('user');
		}
	}
?>