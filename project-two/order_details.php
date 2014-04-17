<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if (!isset($session->user)) {
		header('location: login.php');
		exit();
	}

	DB::init();

	R::setStrictTyping(false);

	$id = $_REQUEST['id'];

	$order = R::find('order', 'id=?', array($id));

	$items = R::find('item_order', 'order_id=?', array($id));

	$total = 0;
?>
<?php include "include/header.php"; ?>
<title>Order Details &raquo; CSC417</title>
</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Order Details</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<h2>Order <?php echo $id; ?></h2>
			<table class="table table-striped">
				<tr>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
				</tr>
				<?php foreach ($items as $entry):
					$item = R::findOne('item', 'id=?', array($entry->item_id));
					$total += $entry->quantity * $item->price
				?>
				<tr>
					<td><?php echo $item->name; ?></td>
					<td><?php echo number_format($item->price, 2); ?></td>
					<td><?php echo $entry->quantity; ?></td>
					<td><?php echo "$ " . number_format($entry->quantity * $item->price, 2); ?></td>
				</tr>
				<?php endforeach; ?>
			</table>

			<h3 class="total">Total: $<?php echo $total; ?></h3>

			<?php if ($session->user->level > 0): ?>
				<button class="btn btn-default" onclick="verify(<?php echo $id; ?>);">Process Order</button>
			<?php endif; ?>
		</div>
	</div>
	<script>
		function verify(id) {
			var response = confirm("Do you want this order to be processed?");

			if (response) {
				window.location = 'process.php?id=' + id;
			}
		}
	</script>
</body>
</html>