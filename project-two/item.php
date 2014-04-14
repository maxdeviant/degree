<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();

	$params = (object) $_REQUEST;

	$item = R::findOne('item', 'id=?', array($params->item_id));
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
			<form action="add.php">
				<input type="hidden" name="id" value="<?php echo $item->id; ?>" />
				<input type="text" class="fa fa-key" name="amount" value="1" />

				<button type="submit"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
			</form>
		</div>
	</div>
</body>
</html>