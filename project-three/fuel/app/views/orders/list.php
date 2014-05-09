<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1>Orders</h1>

			<?php require_once(__DIR__ . '/../navigation.php'); ?>

			<hr />

			<table class="table table-striped table-condensed">
				<tr>
					<th>#</th>
					<th style="min-width: 100px;">Created</th>
					<th>Details</th>
				</tr>
				<?php foreach ($orders as $order): ?>
					<tr>
						<td><a href="<?php echo Router::get('order_details', array('id' => $order['id'])); ?>"><?php echo $order['id']; ?></a></td>
						<td>
							<?php
								$date = new DateTime();
								$date->setTimestamp($order['created_at']);
								echo $date->format('Y-m-d H:i:s');
							?>
						</td>
						<td>
							<?php
								$items = DB::select()->from('item_order')->where('order_id', $order['id'])->execute()->as_array();

								foreach ($items as $entry) {
									$item = DB::select()->from('item')->where('id', $entry['item_id'])->execute()->as_array();

									if (count($item) > 0) {
										$item = $item[0];
									}

									$names[] = $item['name'];
								}

								echo strlen(join(", ", $names)) < 125 ? join(", ", $names) : (substr(join(", ", $names), 0, 125) . "...");

								$names = [];
							?>
						</td>
					</tr>
				<?php endforeach; ?>
			</table>
		</div>
	</div>
</body>