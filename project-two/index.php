<?php
	require_once "include/db.php";
	DB::init();

	$items = R::findall('item', '1 order by name asc');
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div id="storefront" class="sixteen columns">
			<h1>Store</h1>

			<?php include "include/navigation.php"; ?>

			<hr />

			<?php foreach ($items as $item): ?>
				<div class="five columns">
					<h5><?php echo $item['name']; ?></h5>
					<hr />
					<!-- <img src="<?php echo $item['image']; ?>"> -->
					<div class="item" style="background: url(<?php echo $item['image']; ?>) no-repeat 0 center;"></div>
					<span>
						<span class="bold">Price: </span>$<?php echo $item['price']; ?>
					</span>
					<br>
					<span>
						<span class="bold">Category: </span><?php echo $item['category']; ?>
					</span>
					<!-- <span>Description: <?php echo $item['description']; ?></span> -->
				</div>
			<?php endforeach; ?>
		</div>
	</div>
</body>
</html>