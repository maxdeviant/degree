<ul class="navigation">
	<li>
		<i class="fa fa-home"></i>
		<?php echo Html::anchor(Router::get('home'), 'Home'); ?>
	</li>
	<li>
		<i class="fa fa-shopping-cart"></i>
		<?php echo Html::anchor(Router::get('cart'), 'Cart'); ?>
	</li>
	<li class="right">
		<i class="fa fa-sign-in"></i>
	</li>
</ul>