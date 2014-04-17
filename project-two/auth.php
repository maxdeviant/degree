<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	$params = (object) $_REQUEST;

	$username = trim($params->username);

	if (strrpos($username, '@')) {
		$user = R::findOne('user', 'email=?', array($username));
	} else {
		$user = R::findOne('user', 'name=?', array($username));
	}

	if (isset($user) && sha1($params->password) === $user->password) {
		$session->user = (object) $user->getProperties();
		unset($session->user->email);
		unset($session->user->password);
		header('location: .');
	} else {
		$session->message = "Invalid username and/or password.";
		header('location: login.php');
	}
?>