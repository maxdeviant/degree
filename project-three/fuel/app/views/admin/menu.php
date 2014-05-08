<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Administration</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<div class="col-sm-offset-4 col-sm-10">
				<button class="btn btn-default" onclick="manageOrders()"><i class="fa fa-envelope-o">&nbsp;Manage Orders</i></button>
				<button class="btn btn-default" onclick="addItem()"><i class="fa fa-plus">&nbsp;Add Item</i></button>
				<button class="btn btn-default" onclick="editItem()"><i class="fa fa-edit">&nbsp;Edit Item</i></button>
			</div>
		</div>
	</div>
	<script>
		function manageOrders() {
			window.location = '<?php echo Router::get('manage_orders'); ?>';
		}

		function addItem() {
			window.location = '<?php echo Router::get('add_item'); ?>';
		}

		function editItem() {
			window.location = '<?php echo Router::get('edit_item'); ?>';
		}
	</script>
</body>