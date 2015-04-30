<!-- Marshall Bowers -->
<?php require_once(__DIR__ . '/../header.php'); ?>
<body>
    <div class="container">
        <div class="container-fluid">
            <h1>Cart</h1>

            <?php require_once(__DIR__ . '/../navigation.php'); ?>

            <hr />

            <table class="table table-striped">
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th></th>
                </tr>
                <?php foreach (array_keys($cart) as $entry):
                    $item = DB::select()->from('item')->where('id', $entry)->execute()->as_array()[0];

                    $total += $cart[$entry] * $item['price'];
                ?>
                    <tr>
                        <td><?php echo $item['name']; ?></td>
                        <td><?php echo "$ " . number_format($item['price'], 2); ?></td>
                        <td><input type="text" id="item-<?php echo $item['id']; ?>" value="<?php echo $cart[$entry]; ?>" onchange="update(<?php echo $item['id']; ?>);" /></td>
                        <td><?php echo "$ " . number_format($cart[$entry] * $item['price'], 2); ?></td>
                        <td><i class="fa fa-times" onclick="removeEntry(<?php echo $item['id']; ?>);"></i></td>
                    </tr>
                <?php endforeach; ?>
            </table>

            <h3 class="total">Total: $<?php echo number_format($total, 2); ?></h3>

            <form class="form-group" method="post" action="">
                <input class="btn btn-default" type="button" onclick="submitOrder()" value="Submit Order" />
            </form>

            <form class="form-group" method="post" action="">
                <input class="btn btn-default" type="button" onclick="clearCart()" value="Clear Cart" />
            </form>
        </div>
    </div>
    <script>
        function update(id) {
            var quantity = Math.round($('#item-' + id).val());

            if (quantity <= 0 || isNaN(quantity)) {
                quantity = 1;
            }

            $.post(window.location, { 'type': 'update', 'id': id, 'quantity': quantity }, function (data) {
                window.location.reload();
            });
        }

        function removeEntry(id) {
            $.post(window.location, { 'type': 'remove', 'id': id }, function (data) {
                window.location.reload();
            });
        }

        function submitOrder() {
            $.post(window.location, { 'type': 'submit' }, function (data) {
                window.location.reload();
            });
        }

        function clearCart() {
            $.post(window.location, { 'type': 'clear' }, function (data) {
                window.location.reload();
            });
        }
    </script>
</body>
</html>
