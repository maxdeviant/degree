<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}

	DB::init();

	$orders = R::findall('order', '1 order by created_at asc');
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Manage Orders</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<table class="table table-striped table-condensed">
				<tr>
					<th>#</th>
					<th style="min-width: 100px;">Created</th>
					<th>Username</th>
					<th>Email</th>
					<th>Details</th>
				</tr>
				<?php foreach ($orders as $order): ?>
					<tr>
						<td><?php echo $order->id; ?></td>
						<td>
							<?php
								$date = new DateTime();
								$date->setTimestamp($order->created_at);
								echo $date->format('Y-m-d H:i:s');
							?>
						</td>
						<td>
							<?php
								$user = R::findOne('user', 'id=?', array($order->user_id));
								echo ucfirst($user->name);
							?>
						</td>
						<td><?php echo $user->email; ?></td>
						<td>
							<?php
								$ids = R::find('item_order', 'order_id=?', array($order->id));

								foreach (array_keys($ids) as $key) {
									$items[] = R::findOne('item', 'id=?', array($key))->name;
								}

								echo strlen(join(", ", $items)) < 75 ? join(", ", $items) : (substr(join(", ", $items), 0, 75) . "...");
							?>
						</td>
					</tr>
				<?php endforeach; ?>
			</table>
		</div>
	</div>
</body>
</html>