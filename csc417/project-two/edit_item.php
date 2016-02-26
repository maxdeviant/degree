<!-- Marshall Bowers -->
<?php
    require_once "include/session.php";
    require_once "include/db.php";

    $session = new Session();

    if ($session->user->level < 1) {
        header('location: index.php');
        exit();
    }

    DB::init();

    $items = R::findall('item', '1 order by name asc');

    if (isset($_GET['item_id'])) {
        $item = R::findOne('item', 'id=?', array($_GET['item_id']));
    }
?>
<?php include "include/header.php"; ?>
<title>Edit Item &raquo; CSC417</title>
</head>
<body>
    <div class="container">
        <div class="container-fluid">
            <h1>Edit Item</h1>

            <?php require_once "include/navigation.php"; ?>

            <hr />

            <form class="form-horizontal" method="get" name="myform">
                <div class="form-group">
                    <label for="item_id" class="col-sm-2 control-label">Item</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="item_id" onchange="myform.submit();">
                        <option>Choose an item...</option>
                        <?php foreach($items as $i): ?>
                            <?php if ($i->id === $item->id): ?>
                                <option value="<?php echo $i->id; ?>" selected="selected"><?php echo htmlspecialchars($i->name); ?></option>
                            <?php else: ?>
                                <option value="<?php echo $i->id; ?>"><?php echo htmlspecialchars($i->name); ?></option>
                            <?php endif; ?>
                        <?php endforeach; ?>
                        </select>
                    </div>
                </div>
            </form>

            <br><br>

            <form class="form-horizontal" action="update_item.php" method="post">
                <input type="hidden" name="id" value="<?php echo $item->id; ?>" />
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="name" placeholder="Name" value="<?php echo htmlspecialchars($item->name); ?>" readonly />
                    </div>
                </div>
                <div class="form-group">
                    <label for="price" class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="price" placeholder="0.00" value="<?php echo htmlspecialchars($item->price); ?>" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="category" value="<?php echo ucfirst($item->category); ?>" readonly />
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="description" placeholder="Description" rows="10"><?php echo htmlspecialchars($item->description); ?></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="image" class="col-sm-2 control-label">Image</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="image" placeholder="Image" value="<?php echo $item->image; ?>"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-default" type="submit" name="submit">Update</button>
                    </div>
                </div>
            </form>

            <div class="col-sm-offset-2 col-sm-6">
                <p class="text-success">
                    <?php
                        echo join("<br>", $session->success->update);
                        $session->success->update = [];
                    ?>
                </p>
            </div>

            <div class="col-sm-offset-2 col-sm-6">
                <p class="text-danger">
                    <?php
                        echo join("<br>", $session->errors->update);
                        $session->errors->update = [];
                    ?>
                </p>
            </div>
        </div>
    </div>
</body>
</html>
