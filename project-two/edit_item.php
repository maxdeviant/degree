<?php
	require_once "include/session.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Edit Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			
		</div>
	</div>
</body>
</html>