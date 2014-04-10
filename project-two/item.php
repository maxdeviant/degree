<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	$params = (object) $_REQUEST;

	$item = R::load('item', $params->item_id);
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="sixteen columns">
			<h1>Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<h2><?php echo $item->name; ?></h2>
			<br>
			<div>
				<img class="item" src="./images/items/<?php echo $item['image']; ?>">
			</div>
			<br>
			<form action="add_to_cart.php">
				<input type="text" class="fa fa-key" value="1" />

				<button type="submit"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
			</form>
		</div>
	</div>
</body>
</html>