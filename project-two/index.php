<?php
	require_once "include/db.php";
	DB::init();

	$items = R::findall('item', '1 order by name asc');
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="sixteen columns">
			<h1>Store</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr>

			<div id="storefront" class="sixteen columns">
				<?php foreach ($items as $item): ?>
					<div class="entry">
						<h5><a href="./item.php?item_id=<?php echo $item['id']; ?>"><?php echo $item['name']; ?></a></h5>
						<br>
						<div>
							<img class="item" src="./images/items/<?php echo $item['image']; ?>">
						</div>
						<br>
						<span>
							<span class="bold">Price: </span>$<?php echo $item['price']; ?>
						</span>
						<br>
						<span>
							<span class="bold">Category: </span><?php echo ucfirst($item['category']); ?>
						</span>
						<br>
						<!-- <span>
							<span class="bold">Description: </span><?php echo $item['description']; ?>
						</span> -->
					</div>
					<hr>
				<?php endforeach; ?>
			</div>
		</div>
	</div>
</body>
</html>