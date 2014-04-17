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
		<div class="container-fluid">
			<h1>Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<h2><?php echo $item->name; ?></h2>
			<br>
			<div class="col-md-6">
				<img class="item" src="./images/items/<?php echo $item['image']; ?>">
			</div>
			<div class="col-md-6">
				<span><strong>Price:&nbsp;</strong>$&nbsp;<?php echo number_format($item->price, 2); ?></span>
				<br>
				<span><strong>Category:&nbsp;</strong><?php echo ucfirst($item->category); ?></span>
				<br>
				<span><strong>Description:</strong></span>
				<div>
					<?php echo $item->description; ?>
				</div>
			</div>
			<br>
			<form class="form-horizontal col-lg-6" method="post" action="add.php" style="padding-top: 20px">
				<input type="hidden" name="id" value="<?php echo $item->id; ?>" />

				<div class="form-group">
					<label for="quantity" class="col-sm-2 control-label">Quantity</label>
					<div class="col-sm-2">
						<input class="form-control" type="text" name="quantity" value="1" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" type="submit"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
					</div>
				</div>
			</form>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-danger">
					<?php
						echo join("<br>", $session->errors->cart);
						$session->errors->cart = [];
					?>
				</p>
			</div>
		</div>
	</div>
</body>
</html>