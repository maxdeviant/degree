<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Item</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<h2><?php echo $item['name']; ?></h2>
			<br>
			<div class="col-md-6">
				<img class="item" src="<?php echo Asset::get_file($item['image'], 'img', 'items/'); ?>">
			</div>
			<div class="col-md-6">
				<span><strong>Price:&nbsp;</strong>$&nbsp;<?php echo number_format($item['price'], 2); ?></span>
				<br>
				<span><strong>Category:&nbsp;</strong><?php echo ucfirst($item['category']); ?></span>
				<br>
				<span><strong>Description:</strong></span>
				<div><?php echo $description; ?></div>
			</div>
			<br>
			<form class="form-horizontal col-lg-6" method="" action="" style="padding-top: 20px">
				<div class="form-group">
					<label for="quantity" class="col-sm-2 control-label">Quantity</label>
					<div class="col-sm-2">
						<input class="form-control" type="text" id="quantity" value="1" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" type="button" onclick="add(<?php echo $item['id']; ?>);"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
						<p class="text-danger" id="response"></p>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		function add(id) {
			var quantity = Math.round($('#quantity').val());

			if (quantity <= 0 || isNaN(quantity)) {
				quantity = 1;
			}

			$.post(window.location, { 'id': id, 'quantity': quantity }, function (data) {
				window.location = '<?php echo Router::get('cart'); ?>';
			});
		}
	</script>
</body>
</html>