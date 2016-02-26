<!-- Marshall Bowers -->
<?php
    class View_Cart_Details extends ViewModel {
        public function view() {
            $this->title = 'Cart &raquo; CSC 417';
            $this->user = Session::get('user');
            $this->cart = Session::get('cart');
            $this->total = 0;
        }
    }
?>
