<!-- Marshall Bowers -->
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
<title>Store &raquo; CSC417</title>
</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<?php require_once "include/navigation.php"; ?>

			<hr>

			<table class="table table-striped">
				<tr>
					<th id="name-header" class="interactive" onclick="sortName();">Name&nbsp;<i class="fa"></i></th>
					<th id="category-header" class="interactive" onclick="sortCategory();">Category&nbsp;<i class="fa"></th>
					<th id="price-header" class="interactive" onclick="sortPrice();">Price&nbsp;<i class="fa"></th>
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
		(function () {
			var sort = "<?php echo $sort; ?>";

			if (sort === 'by_name_asc') {
				$('#name-header i').addClass('fa-sort-asc');
			} else if (sort === 'by_name_desc') {
				$('#name-header i').addClass('fa-sort-desc');
			} else {
				$('#name-header i').addClass('fa-sort');
			}

			if (sort === 'by_category_asc') {
				$('#category-header i').addClass('fa-sort-asc');
			} else if (sort === 'by_category_desc') {
				$('#category-header i').addClass('fa-sort-desc');
			} else {
				$('#category-header i').addClass('fa-sort');
			}

			if (sort === 'by_price_asc') {
				$('#price-header i').addClass('fa-sort-asc');
			} else if (sort === 'by_price_desc') {
				$('#price-header i').addClass('fa-sort-desc');
			} else {
				$('#price-header i').addClass('fa-sort');
			}
		})();

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