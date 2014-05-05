<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr>

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

		function sortName() {

		}

		function sortCategory() {

		}

		function sortPrice() {
			
		}
	</script>
</body>
</html>