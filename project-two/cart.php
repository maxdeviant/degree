<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Cart</h1>

			<?php include "include/navigation.php"; ?>

			<hr />

			<table class="table table-striped">
				<tr>
					<th>Item</th>
					<th>Price</th>
					<th>Amount</th>
					<th>Subtotal</th>
				</tr>
				<?php foreach (array_keys($session->cart) as $entry):
					$item = R::findOne('item', 'id=?', array($entry));
					$total += $session->cart[$entry] * $item->price;
				?>
				<tr>
					<td><?php echo $item['name']; ?></td>
					<td><?php echo "$ " . number_format($item->price, 2); ?></td>
					<td><?php echo $session->cart[$entry]; ?></td>
					<td><?php echo "$ " . number_format($session->cart[$entry] * $item->price, 2); ?></td>
				</tr>
				<?php endforeach; ?>
			</table>

			<h3 class="total">Total: $<?php echo number_format($total, 2); ?></h3>

			<form class="form-group" method="post" action="submit.php">
				<input class="btn btn-default" type="submit" value="Submit Order" />
			</form>

			<form class="form-group" method="post" action="clear.php">
				<input class="btn btn-default" type="submit" value="Clear Cart" />
			</form>
		</div>
	</div>
</body>
</html>