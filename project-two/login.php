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

			<form class="form-horizontal" action="auth.php" method="post" autocomplete="off">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">Username</label>
					<div class="col-sm-3">
						<input class="form-control" type="text" name="username" placeholder="Username" />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-3">
						<input class="form-control" type="password" name="password" placeholder="Password" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button class="btn btn-default" type="submit">Login</button>
					</div>
				</div>
			</form>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-danger">
					<?php echo $message; ?>
				</p>
			</div>
		</div>
	</div>
</body>
</html>