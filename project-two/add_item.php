<!-- Marshall Bowers -->
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
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Add Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<form class="form-horizontal" action="create_item.php" method="post">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="name" placeholder="Name" />
					</div>
				</div>
				<div class="form-group">
					<label for="price" class="col-sm-2 control-label">Price</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="price" placeholder="0.00" />
					</div>
				</div>
				<div class="form-group">
					<label for="category" class="col-sm-2 control-label">Category</label>
					<div class="col-sm-10">
						<select class="form-control" name="category">
						<?php foreach($categories as $category): ?>
							<option value="<?php echo $category['category']; ?>"><?php echo ucfirst($category['category']); ?></option>
						<?php endforeach; ?>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<textarea class="form-control" name="description" placeholder="Description" rows="10"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="image" class="col-sm-2 control-label">Image</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="image" placeholder="Image" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" type="submit" name="submit">Add</button>
					</div>
				</div>
			</form>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-success">
					<?php
						echo join("<br>", $session->success->create);
						$session->success->create = [];
					?>
				</p>
			</div>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-danger">
					<?php
						echo join("<br>", $session->errors->create);
						$session->errors->create = [];
					?>
				</p>
			</div>
		</div>
	</div>
</body>
</html>