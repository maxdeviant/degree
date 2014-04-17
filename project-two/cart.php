<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	if (isset($_REQUEST['id'])) {
		$session->cart[$_REQUEST['id']] = $_REQUEST['quantity'];
	}

	if (isset($_REQUEST['remove'])) {
		unset($session->cart[$_REQUEST['remove']]);
	}
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
					<th>Quantity</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
				<?php foreach (array_keys($session->cart) as $entry):
					$item = R::findOne('item', 'id=?', array($entry));
					$total += $session->cart[$entry] * $item->price;
				?>
				<tr>
					<td><?php echo $item['name']; ?></td>
					<td><?php echo "$ " . number_format($item->price, 2); ?></td>
					<td><input type="text" id="item-<?php echo $item->id; ?>" value="<?php echo $session->cart[$entry]; ?>" onchange="update(<?php echo $item->id; ?>);" /></td>
					<td><?php echo "$ " . number_format($session->cart[$entry] * $item->price, 2); ?></td>
					<td><i class="fa fa-times" onclick="removeEntry(<?php echo $item->id; ?>);"></i></td>
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
	<script>
		function update(id) {
			var quantity = $('#item-' + id).val();

			if (quantity <= 0) {
				quantity = 1;
			}
			
			window.location = "cart.php?id=" + id + "&quantity=" + quantity;
		}

		function removeEntry(id) {
			window.location = "cart.php?remove=" + id;
		}
	</script>
</body>
</html>