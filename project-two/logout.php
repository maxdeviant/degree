<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";

	$session = new Session();
	unset($session->user);
	header('location: .');
?>