<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
		exit();
	}

	if (strpos($_SERVER['HTTP_REFERER'], "edit_item.php") === false) {
		header('location: index.php');
		exit();
	}

	DB::init();

	$params = $_REQUEST;

	$params['name'] = trim($params['name']);
	$params['category'] = trim($params['category']);
	$params['price'] = trim($params['price']);
	$params['description'] = trim($params['description']);
	$params['image'] = trim($params['image']);

	$item = R::load('item', $params['id']);

	$item->name = $params['name'];
	$item->category = $params['category'];
	$item->price = $params['price'];
	$item->description = $params['description'];
	$item->image = $params['image'];

	$id = R::store($item);

	$session->success->update[] = "Item edited successfully.";

	header('location: edit_item.php?item_id=' . $id);
?>