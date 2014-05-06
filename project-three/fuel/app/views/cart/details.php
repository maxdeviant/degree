<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Cart</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<table class="table table-striped">
				<tr>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="text" id="item-" value="" onchange="update();" /></td>
					<td></td>
					<td><i class="fa fa-times" onclick="removeEntry();"></i></td>
				</tr>
			</table>

			<h3 class="total">Total: $</h3>

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