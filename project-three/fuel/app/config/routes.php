<?php
return array(
	'_root_' => 'main/index',
	'_404_' => 'main/404',
	'_401_' => 'main/401',
	'/' => array('main/index', 'name' => 'home'),
	'items/:id' => array('items/details', 'name' => 'item_details'),
	'cart' => array('cart/details', 'name' => 'cart'),
	'orders' => array('orders/list', 'name' => 'orders'),
	'orders/:id' => array('orders/details', 'name' => 'order_details'),
	'login' => array('users/login', 'name' => 'login'),
	'logout' => array('users/logout', 'name' => 'logout'),
	'admin' => array('admin/menu', 'name' => 'admin'),
	'admin/manage_orders' => array('admin/manage', 'name' => 'manage_orders'),
	'admin/add_item' => array('admin/add', 'name' => 'add_item'),
	'admin/edit_item' => array('admin/edit', 'name' => 'edit_item'),
);