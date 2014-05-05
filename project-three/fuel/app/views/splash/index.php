<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
	<?php echo Asset::css('site.css'); ?>

	<link rel="shortcut icon" href="images/favicon.ico">
	<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<title>Store &raquo; CSC417</title>
</head>
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