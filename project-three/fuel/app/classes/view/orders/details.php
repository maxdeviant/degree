<!-- Marshall Bowers -->
<?php
    class View_Orders_Details extends ViewModel {
        public function view() {
            $this->title = 'Order ' . $this->order['id'] . ' &raquo; CSC 417';
            $this->user = Session::get('user');
        }
    }
?>
