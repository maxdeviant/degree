<?php
	require_once "include/session.php";
	require_once "include/db.php";

	$session = new Session();
	DB::init();
?>
<?php include "include/header.php"; ?>
<body>
	<div class="container">
		<div class="sixteen columns">
			<h1>Cart</h1>

			<?php include "include/navigation.php"; ?>

			<hr />

			<?php foreach (array_keys($session->cart) as $entry): ?>
				<div>
					<?php
						$item = R::findOne('item', 'id=?', array($entry));
						echo $item['name'];
						echo " Amount: " . $session->cart[$entry];
					?>
				</div>
			<?php endforeach; ?>
		</div>
	</div>
</body>
</html>