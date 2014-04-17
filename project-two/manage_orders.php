<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
		exit();
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
								$user = R::findOne('user', 'id=?', array($order->user_id));
								echo ucfirst($user->name);
							?>
						</td>
						<td><?php echo $user->email; ?></td>
						<td>
							<?php
								$items = R::find('item_order', 'order_id=?', array($order->id));

								foreach ($items as $entry) {
									$item = R::findOne('item', 'id=?', array($entry->item_id));
									$names[] = $item->name;
								}

								echo strlen(join(", ", $names)) < 75 ? join(", ", $names) : (substr(join(", ", $names), 0, 75) . "...");

								$names = [];
							?>
						</td>
					</tr>
				<?php endforeach; ?>
			</table>
		</div>
	</div>
</body>
</html>