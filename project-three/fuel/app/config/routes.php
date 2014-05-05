<?php
return array(
	'_root_'  => 'splash/index',  // The default route
	'_404_'   => 'splash/404',    // The main 404 route
	
	'hello(/:name)?' => array('welcome/hello', 'name' => 'hello'),
);