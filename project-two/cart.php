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
					<th>Amount</th>
					<th>Subtotal</th>
				</tr>
				<?php foreach (array_keys($session->cart) as $entry):
					$item = R::findOne('item', 'id=?', array($entry));
				?>
				<tr>
					<td><?php echo $item['name']; ?></td>
					<td><?php echo $session->cart[$entry]; ?></td>
					<td><?php echo "$ " . $session->cart[$entry] * $item->price; ?></td>
				</tr>
				<?php endforeach; ?>
			</table>

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