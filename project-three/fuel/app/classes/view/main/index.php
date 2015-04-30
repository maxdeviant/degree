<!-- Marshall Bowers -->
<?php
    class View_Main_Index extends ViewModel {
        public function view() {
            $this->title = 'Store &raquo; CSC 417';
            $this->user = Session::get('user');
        }
    }
?>
