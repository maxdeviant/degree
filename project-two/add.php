<?php
	require_once "include/session.php";

	$session = new Session();

	$params = (object) $_REQUEST;

	if (isset($session->cart)) {
		$session->cart[$params->id] = $params->quantity;
	} else {
		$session->cart = array($params->id => $params->quantity);
	}

	header('location: cart.php');
?>