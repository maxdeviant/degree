<!-- Marshall Bowers -->
<?php
	class View_Admin_Menu extends ViewModel {
		public function view() {
			$this->title = 'Admin &raquo; CSC 417';
			$this->user = Session::get('user');
		}
	}
?>