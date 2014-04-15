<?php
	require_once "include/session.php";

	$session = new Session();

	$params = (object) $_REQUEST;

	if (isset($session->cart)) {
		$session->cart[$params->id] = $params->amount;
	} else {
		$session->cart = array($params->id => $params->amount);
	}

	header('location: cart.php');
?>