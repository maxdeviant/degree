<?php require_once(__DIR__.'/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<?php require_once(__DIR__.'/../navigation.php'); ?>

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
								<td><a href="item.php?item_id=<?php echo $item['id']; ?>"><?php echo $item['name']; ?></a></td>
								<td><?php echo ucfirst($item['category']); ?></td>
								<td><?php echo "$ " . number_format($item['price'], 2); ?></td>
							</tr>
						<?php endforeach; ?>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>