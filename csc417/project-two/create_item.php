<!-- Marshall Bowers -->
<?php
    require_once "include/session.php";
    require_once "include/db.php";

    $session = new Session();

    if ($session->user->level < 1) {
        header('location: index.php');
        exit();
    }

    if (strpos($_SERVER['HTTP_REFERER'], "add_item.php") === false) {
        header('location: index.php');
        exit();
    }

    DB::init();

    $params = $_REQUEST;

    $params['name'] = trim($params['name']);
    $params['category'] = trim($params['category']);
    $params['price'] = trim($params['price']);
    $params['description'] = trim($params['description']);
    $params['image'] = trim($params['image']);

    $valid = true;

    if (strlen($params['name']) < 3) {
        $session->errors->create[] = "Item name must contain at least 3 characters.";
        $valid = false;
    }

    if (!is_numeric($params['price'])) {
        $session->errors->create[] = "Price must be a number.";
        $valid = false;
    }

    if (!$valid) {
        header('location: ' . $_SERVER['HTTP_REFERER']);
        exit();
    }

    $item = R::dispense('item');

    $item->name = $params['name'];
    $item->category = $params['category'];
    $item->price = $params['price'];
    $item->description = $params['description'];
    $item->image = $params['image'];

    $id = R::store($item);

    $session->success->create[] = "Item added successfully. ID: " . $id;

    header('location: add_item.php');
?>
