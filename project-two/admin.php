<!-- Marshall Bowers -->
<?php
	require_once "include/session.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
		exit();
	}
?>
<?php include "include/header.php"; ?>
<title>Administration &raquo; CSC417</title>
</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Administration</h1>

			<?php require_once "include/navigation.php"; ?>

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