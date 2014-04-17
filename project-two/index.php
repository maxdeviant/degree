<?php
	require_once "include/db.php";
	DB::init();

	if (!isset($_REQUEST['sort'])) {
		header('location: index.php?sort=by_name_asc');
	} else {
		$sort = $_REQUEST['sort'];
	}

	if ($sort === 'by_name_asc') {
		$items = R::findall('item', '1 order by name asc');
	}

	if ($sort === 'by_name_desc') {
		$items = R::findall('item', '1 order by name desc');
	}

	if ($sort === 'by_category_asc') {
		$items = R::findall('item', '1 order by category asc');
	}

	if ($sort === 'by_category_desc') {
		$items = R::findall('item', '1 order by category desc');
	}

	if ($sort === 'by_price_asc') {
		$items = R::findall('item', '1 order by price asc');
	}

	if ($sort === 'by_price_desc') {
		$items = R::findall('item', '1 order by price desc');
	}
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr>

			<table class="table table-striped">
				<tr>
					<th class="interactive" onclick="sortName();">Name</th>
					<th class="interactive" onclick="sortCategory();">Category</th>
					<th class="interactive" onclick="sortPrice();">Price</th>
				</tr>
				<?php foreach ($items as $item): ?>
					<tr>
						<td><a href="item.php?item_id=<?php echo $item->id; ?>"><?php echo $item->name; ?></a></td>
						<td><?php echo ucfirst($item->category); ?></td>
						<td><?php echo "$ " . number_format($item->price, 2); ?></td>
					</tr>
				<?php endforeach; ?>
			</table>
		</div>
	</div>
	<script>
		function sortName() {
			var sort = "<?php echo $sort; ?>";

			if (sort === 'by_name_asc') {
				window.location = 'index.php?sort=by_name_desc';
			} else {
				window.location = 'index.php?sort=by_name_asc';
			}
		}

		function sortCategory() {
			var sort = "<?php echo $sort; ?>";

			if (sort === 'by_category_asc') {
				window.location = 'index.php?sort=by_category_desc';
			} else {
				window.location = 'index.php?sort=by_category_asc';
			}
		}

		function sortPrice() {
			var sort = "<?php echo $sort; ?>";

			if (sort === 'by_price_asc') {
				window.location = 'index.php?sort=by_price_desc';
			} else {
				window.location = 'index.php?sort=by_price_asc';
			}
		}
	</script>
</body>
</html>