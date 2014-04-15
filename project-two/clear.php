<?php
	require_once "include/session.php";

	$session = new Session();

	$session->cart = [];

	header("location: cart.php");
?>