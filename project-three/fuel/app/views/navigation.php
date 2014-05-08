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
			<?php
				if (!isset($user)) {
					echo Html::anchor(Router::get('login'), 'Login');
				} else {
					echo Html::anchor(Router::get('logout'), 'Logout');
				}
			?>
	</li>
	<?php if (isset($user)): ?>
		<li class="right">
			<i class="fa fa-credit-card"></i>
			<?php echo Html::anchor(Router::get('orders'), 'Orders'); ?>
		</li>
		<?php if ($user['level'] > 0): ?>
			<li class="right">
				<i class="fa fa-cogs"></i>
				<?php echo Html::anchor(Router::get('admin'), 'Admin'); ?>
			</li>
		<?php endif ?>
	<?php endif ?>
</ul>

<?php if (isset($user)): ?>
	<h4><i class="fa fa-user" style="color: #333"></i>&nbsp;<?php echo ucfirst($user['name']); ?></h4>
<?php endif ?>