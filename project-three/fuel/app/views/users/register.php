<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Register</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<form class="form-horizontal" action="" method="post" autocomplete="off">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-3">
						<input class="form-control" type="text" name="name" placeholder="John Smith" autofocus />
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-3">
						<input class="form-control" type="text" name="email" placeholder="john@fuelstore.com" autofocus />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-3">
						<input class="form-control" type="password" name="password" placeholder="Password" />
					</div>
				</div>
				<div class="form-group">
					<label for="confirm" class="col-sm-2 control-label">Confirm Password</label>
					<div class="col-sm-3">
						<input class="form-control" type="password" name="confirm" placeholder="Confirm Password" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button class="btn btn-default" type="submit" name="submit">Register</button>
					</div>
				</div>
			</form>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-danger">
					<?php
						if (isset($error)) {
							echo join('<br>', $error);
							$error = [];
						}
					?>
				</p>
			</div>
		</div>
	</div>
</body>
</html>