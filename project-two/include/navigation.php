<?php
	require_once "include/session.php";
	$session = new Session();
?>
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
		<?php if (!isset($session->user)): ?>
			<a href="login.php">Login</a>
		<?php else: ?>
			<a href="logout.php">Logout</a>
		<?php endif ?>
	</li>
</ul>

<?php if (isset($session->user)): ?>
	<h4><i class="fa fa-user" style="color: #333"></i> <?php echo ucfirst($session->user->name); ?></h4>
<?php endif ?>