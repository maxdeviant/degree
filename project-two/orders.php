<?php
	require_once "include/session.php";

	$session = new Session();

	if (!isset($session->user)) {
		header('location: login.php');
	}
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="sixteen columns">
			<h1>Orders</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />


		</div>
	</div>
</body>
</html>