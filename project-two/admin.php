<?php
	require_once "include/session.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Administration</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<div class="col-sm-offset-4 col-sm-10">
				<button class="btn btn-default" onclick="manageOrders()">Manage Orders</button>
				<button class="btn btn-default" onclick="addItem()">Add Item</button>
				<button class="btn btn-default" onclick="editItem()">Edit Item</button>
			</div>
		</div>
	</div>
	<script>
		function manageOrders() {
			window.location = 'manage_orders.php';
		}

		function addItem() {
			window.location = 'add_item.php';
		}

		function editItem() {
			window.location = 'edit_item.php';
		}
	</script>
</body>
</html>