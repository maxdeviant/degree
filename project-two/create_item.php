<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}

	if (strpos($_SERVER['HTTP_REFERER'], "add_item.php") === false) {
		header('location: index.php');
	}

	DB::init();

	$params = $_REQUEST;

	$item = R::dispense('item');

	$item->name = $params['name'];
	$item->category = $params['category'];
	$item->price = $params['price'];
	$item->description = $params['description'];
	$item->image = $params['image'];

	$id = R::store($item);

	header('location: add_item.php');
?>