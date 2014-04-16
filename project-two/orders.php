<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if (!isset($session->user)) {
		header('location: login.php');
		exit();
	}

	DB::init();

	// R::setStrictTyping(false);

	$orders = R::find('order', 'user_id=?', array($session->user->id));
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Orders</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<table class="table table-striped table-condensed">
				<tr>
					<th>#</th>
					<th style="min-width: 100px;">Created</th>
					<th>Details</th>
				</tr>
				<?php foreach ($orders as $order): ?>
					<tr>
						<td><a href="order_details?id=<?php echo $order->id; ?>"><?php echo $order->id; ?></a></td>
						<td>
							<?php
								$date = new DateTime();
								$date->setTimestamp($order->created_at);
								echo $date->format('Y-m-d H:i:s');
							?>
						</td>
						<td>
							<?php
								$ids = R::find('item_order', 'order_id=?', array($order->id));

								foreach (array_keys($ids) as $key) {
									$items[] = R::findOne('item', 'id=?', array($key))->name;
								}

								// echo substr(join(", ", $items), 0, 50) . "...";

								echo strlen(join(", ", $items)) < 125 ? join(", ", $items) : (substr(join(", ", $items), 0, 125) . "...");

								// echo join(", ", $items);
							?>
						</td>
					</tr>
				<?php endforeach; ?>
			</table>
		</div>
	</div>
</body>
</html>