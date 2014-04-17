<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";

	$session = new Session();

	$params = (object) $_REQUEST;

	if ($params->quantity <= 0) {
		$session->errors->cart[] = "Please select a positive number.";
		header('location: ' . $_SERVER['HTTP_REFERER']);
		exit();
	}

	if (isset($session->cart)) {
		$session->cart[$params->id] = $params->quantity;
	} else {
		$session->cart = array($params->id => $params->quantity);
	}

	header('location: cart.php');
?>