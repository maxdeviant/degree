<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	$params = (object) $_REQUEST;

	$username = trim($params->username);
	$user = R::findOne('user', 'email=?', array($username));

	if (!isset($user)) {
		$session->message = "Invalid username.";
		header('location: login.php');
	} elseif (sha1($params->password) === $user->password) {
		$session->user = (object) $user->getProperties();
		unset($session->user->email);
		unset($session->user->password);
		header('location: .');
	} else {
		$session->username = $params->username;
		$session->message = "Invalid password.";
		header('location: login.php');
	}
?>