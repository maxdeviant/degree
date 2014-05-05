<?php require_once(__DIR__.'/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Store</h1>

			<ul class="navigation">
				<li>
					<i class="fa fa-home"></i>
					<a href="./">Home</a>
				</li>
				<li>
					<i class="fa fa-shopping-cart"></i>
					<a href="cart.php">Cart</a>
				</li>
				<li class="right">
					<i class="fa fa-sign-in"></i>
				</li>
			</ul>

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
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>