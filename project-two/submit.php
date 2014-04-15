<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	if (isset($session->user)) {
		print_r($session->cart);
		print_r($session->user);

		$date = new DateTime();

		$order = R::dispense('order');

		$order->user_id = $session->user->id;
		$order->created_at = $date->getTimestamp();

		$id = R::store($order);

		$session->cart = [];

		header("location: .");
	} else {
		header("location: login.php");
	}
?>