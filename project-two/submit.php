<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	R::setStrictTyping(false);

	if (isset($session->user)) {
		$date = new DateTime();

		$order = R::dispense('order');

		$order->user_id = $session->user->id;
		$order->created_at = $date->getTimestamp();

		$id = R::store($order);

		foreach ($session->cart as $key => $value) {
			$item = R::findOne('item', 'id=?', array($key));

			$joined = R::dispense('item_order');

			$joined->item_id = $key;
			$joined->order_id = $id;
			$joined->quantity = $value;
			$joined->price = $item->price;

			$foo = R::store($joined);
		}

		$session->cart = [];

		header("location: .");
	} else {
		header("location: login.php");
	}
?>