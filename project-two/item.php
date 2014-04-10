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
			<button style="float: right;"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
		</div>
	</div>
</body>
</html>