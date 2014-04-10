<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if (!isset($session->user)) {
		header('location: login.php');
	}

	DB::init();

	$orders = R::find('order', 'user_id=?', [$session->user->id]);
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="sixteen columns">
			<h1>Orders</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<?php foreach ($orders as $order): ?>
				<div>
					<?php echo "Order #: $order->id"; ?>
				</div>
			<?php endforeach; ?>
		</div>
	</div>
</body>
</html>