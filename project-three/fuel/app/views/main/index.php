<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<div id="storefront">
				<table class="table table-striped">
					<thead style="background: #f9f9f9;">
						<tr>
							<th id="name-header" class="interactive" onclick="sortName();">Name&nbsp;<i class="fa"></i></th>
							<th id="category-header" class="interactive" onclick="sortCategory();">Category&nbsp;<i class="fa"></th>
							<th id="price-header" class="interactive" onclick="sortPrice();">Price&nbsp;<i class="fa"></th>
						</tr>
					</thead>
					<tbody>
						<?php foreach ($items as $item): ?>
							<tr>
								<td><?php echo Html::anchor(Router::get('item_details', array('id' => $item['id'])), $item['name']) ?></a></td>
								<td><?php echo ucfirst($item['category']); ?></td>
								<td><?php echo "$ " . number_format($item['price'], 2); ?></td>
							</tr>
						<?php endforeach; ?>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function () {
			$('table').stickyTableHeaders({ scrollableArea: $('#storefront') });
		});

		(function () {
			var sort = ['<?php echo $sort[0]; ?>', '<?php echo $sort[1]; ?>'];

			if (sort[0] === 'name' && sort[1] === 'asc') {
				$('#name-header i').addClass('fa-sort-asc');
			} else if (sort[0] === 'name' && sort[1] === 'desc') {
				$('#name-header i').addClass('fa-sort-desc');
			} else {
				$('#name-header i').addClass('fa-sort');
			}

			if (sort[0] === 'category' && sort[1] === 'asc') {
				$('#category-header i').addClass('fa-sort-asc');
			} else if (sort[0] === 'category' && sort[1] === 'desc') {
				$('#category-header i').addClass('fa-sort-desc');
			} else {
				$('#category-header i').addClass('fa-sort');
			}

			if (sort[0] === 'price' && sort[1] === 'asc') {
				$('#price-header i').addClass('fa-sort-asc');
			} else if (sort[0] === 'price' && sort[1] === 'desc') {
				$('#price-header i').addClass('fa-sort-desc');
			} else {
				$('#price-header i').addClass('fa-sort');
			}
		})();

		function sortName() {
			var sort = ['<?php echo $sort[0]; ?>', '<?php echo $sort[1]; ?>'];

			if (sort[0] === 'name' && sort[1] === 'asc') {
				$.post(window.location, { 'sort': ['name', 'desc'] }, function (data) {
					$(document.body).html(data);
				});
			} else {
				$.post(window.location, { 'sort': ['name', 'asc'] }, function (data) {
					$(document.body).html(data);
				});
			}
		}

		function sortCategory() {
			var sort = ['<?php echo $sort[0]; ?>', '<?php echo $sort[1]; ?>'];

			if (sort[0] === 'category' && sort[1] === 'asc') {
				$.post(window.location, { 'sort': ['category', 'desc'] }, function (data) {
					$(document.body).html(data);
				});
			} else {
				$.post(window.location, { 'sort': ['category', 'asc'] }, function (data) {
					$(document.body).html(data);
				});
			}
		}

		function sortPrice() {
			var sort = ['<?php echo $sort[0]; ?>', '<?php echo $sort[1]; ?>'];

			if (sort[0] === 'price' && sort[1] === 'asc') {
				$.post(window.location, { 'sort': ['price', 'desc'] }, function (data) {
					$(document.body).html(data);
				});
			} else {
				$.post(window.location, { 'sort': ['price', 'asc'] }, function (data) {
					$(document.body).html(data);
				});
			}
		}
	</script>
</body>
</html>