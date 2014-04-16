<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}

	DB::init();

	$categories = R::getAll('select distinct category from item');
	sort($categories);

	$item = R::findOne('item', 'id=?', array(22));
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Edit Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<form class="form-horizontal" action="update_item.php" method="post">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="name" placeholder="Name" value="<?php echo $item->name; ?>" />
					</div>
				</div>
				<div class="form-group">
					<label for="price" class="col-sm-2 control-label">Price</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="price" placeholder="0.00" value="<?php echo $item->price; ?>" />
					</div>
				</div>
				<div class="form-group">
					<label for="category" class="col-sm-2 control-label">Category</label>
					<div class="col-sm-10">
						<select class="form-control" name="category">
						<?php foreach($categories as $category): ?>
							<?php if ($category['category'] === $item->category): ?>
								<option value="<?php echo $category['category']; ?>" selected="selected"><?php echo ucfirst($category['category']); ?></option>
							<?php else: ?>
								<option value="<?php echo $category['category']; ?>"><?php echo ucfirst($category['category']); ?></option>
							<?php endif; ?>
						<?php endforeach; ?>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<textarea class="form-control" name="description" placeholder="Description" rows="10"><?php echo $item->description; ?></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="image" class="col-sm-2 control-label">Image</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="image" placeholder="Image" value="<?php echo $item->image; ?>"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" type="submit" name="submit">Add</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>