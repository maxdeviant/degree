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
		<div class="container-fluid">
			<h1>Orders</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<table>
				<tr>
					<th>#</th>
					<th>Created</th>
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

							?>
						</td>
					</tr>
				<?php endforeach; ?>
			</table>
			
		</div>
	</div>
</body>
</html>