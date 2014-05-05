<?php
return array(
	'_root_'  => 'splash/index',
	'_404_'   => 'splash/404',

	'/'  => array('splash/index', 'name' => 'home'),
	'items/:id' => array('items/details', 'name' => 'item_details'),
	'login' => array('users/login', 'name' => 'login'),
);