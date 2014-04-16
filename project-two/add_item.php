<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();

	if ($session->user->level < 1) {
		header('location: index.php');
	}

	DB::init();

	$categories = R::getAll('select distinct category from item');
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Add Item</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr />

			<form class="form" action="" method="post">
				<div class="form-group">
					<label for="name" class="control-label">Name</label>
					<div class="">
						<input class="form-control" type="text" name="name" placeholder="Name" />
					</div>
				</div>
				<div class="form-group">
					<label for="price" class="control-label">Price</label>
					<div class="">
						<input class="form-control" type="text" name="price" placeholder="$ 0.00" />
					</div>
				</div>
				<div class="form-group">
					<label for="category" class="control-label">Category</label>
					<div class="">
						<!-- <input class="form-control" type="" name="" placeholder="" /> -->
						<select class="form-control">
						<?php foreach($categories as $category): ?>
							<option><?php echo ucfirst($category['category']); ?></option>
						<?php endforeach; ?>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="" class="control-label"></label>
					<div class="">
						<input class="form-control" type="" name="" placeholder="" />
					</div>
				</div>
				<div class="form-group">
					<label for="" class="control-label"></label>
					<div class="">
						<input class="form-control" type="" name="" placeholder="" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>