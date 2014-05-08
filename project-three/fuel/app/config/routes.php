<?php
return array(
	'_root_'  => 'main/index',
	'_404_'   => 'main/404',

	'/'  => array('main/index', 'name' => 'home'),
	'items/:id' => array('items/details', 'name' => 'item_details'),
	'cart' => array('cart/details', 'name' => 'cart'),
	'login' => array('users/login', 'name' => 'login'),
	'logout' => array('users/logout', 'name' => 'logout'),
);