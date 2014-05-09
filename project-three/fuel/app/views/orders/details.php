<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Order Details</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<h2>Order <?php echo $order['id']; ?></h2>
			<table class="table table-striped">
				<tr>
					<th>Item</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
				</tr>
				<?php foreach ($items as $entry):
					$item = DB::select()->from('item')->where('id', $entry['item_id'])->execute()->as_array()[0];

					$total += $entry['quantity'] * $item['price']
				?>
				<tr>
					<td><?php echo $item['name']; ?></td>
					<td><?php echo number_format($item['price'], 2); ?></td>
					<td><?php echo $entry['quantity']; ?></td>
					<td><?php echo "$ " . number_format($entry['quantity'] * $item['price'], 2); ?></td>
				</tr>
				<?php endforeach; ?>
			</table>

			<h3 class="total">Total: $<?php echo $total; ?></h3>

			<?php if ($user['level'] > 0): ?>
				<button class="btn btn-default" onclick="verify(<?php echo $order['id']; ?>);">Process Order</button>
			<?php endif; ?>
		</div>
	</div>
	<script>
		function verify(id) {
			var response = confirm('Do you want this order to be processed?');

			if (response) {
				$.post(window.location, { 'id': id }, function (data) {
					window.location.reload();
				});
			}
		}
	</script>
</body>