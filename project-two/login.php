<?php
	require_once "include/session.php";

	$session = new Session();

	if (isset($session->user)) {
		require_once("index.php");
		exit();
	}

	$message = $session->message;
	unset($session->message);
?>

<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Login</h1>

			<?php include "include/navigation.php"; ?>

			<hr />

			<form action="auth.php" method="post" autocomplete="off">
				Username: <input type="text" name="username" placeholder="Username" />
				Password: <input type="password" name="password" placeholder="Password" />

				<button type="submit">Login</button>
			</form>

			<?php echo $message; ?>
		</div>
	</div>
</body>
</html>