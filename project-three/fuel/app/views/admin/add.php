<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Add Item</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<form class="form-horizontal" action="" method="post">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="name" placeholder="Name" <?php if (isset($sticky)) { echo 'value="' . $sticky['name'] . '"'; } ?> />
					</div>
				</div>
				<div class="form-group">
					<label for="price" class="col-sm-2 control-label">Price</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="price" placeholder="0.00" <?php if (isset($sticky)) { echo 'value="' . $sticky['price'] . '"'; } ?> />
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
						<textarea class="form-control" name="description" placeholder="Description" rows="10"><?php if (isset($sticky)) { echo $sticky['description']; } ?></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="image" class="col-sm-2 control-label">Image</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="image" placeholder="Image" <?php if (isset($sticky)) { echo 'value="' . $sticky['image'] . '"'; } ?> />
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
						if (isset($success)) {
							echo $success;
						}
					?>
				</p>
			</div>

			<div class="col-sm-offset-2 col-sm-6">
				<p class="text-danger">
					<?php
						if (isset($error)) {
							echo join('<br>', $error);
							$error = [];
						}
					?>
				</p>
			</div>
		</div>
	</div>
</body>