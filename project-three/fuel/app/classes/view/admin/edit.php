<!-- Marshall Bowers -->
<?php
	class View_Admin_Edit extends ViewModel {
		public function view() {
			$this->title = 'Edit Item &raquo; CSC 417';
			$this->user = Session::get('user');
		}
	}
?>