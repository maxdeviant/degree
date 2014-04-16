<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
		exit();
	}

	DB::init();

	R::setStrictTyping(false);

	$id = $_REQUEST['id'];

	$order = R::load('order', $id);
	$items = R::find('item_order', 'order_id=?', array($id));

	print_r(array_keys($items));

	foreach (array_keys($items) as $key => $value) {
		$entry = R::load('item_order', $value);
		R::trash($entry);
	}

	R::trash($order);

	header('location: manage_orders.php');
?>