<?php defined('COREPATH') or exit('No direct script access allowed'); ?>

INFO - 2014-05-08 18:40:59 --> Fuel\Core\Request::__construct - Creating a new main Request with URI = "cart"
INFO - 2014-05-08 18:40:59 --> Fuel\Core\Request::execute - Called
INFO - 2014-05-08 18:40:59 --> Fuel\Core\Request::execute - Setting main Request
INFO - 2014-05-08 18:41:00 --> Fuel\Core\Request::__construct - Creating a new main Request with URI = "cart"
INFO - 2014-05-08 18:41:00 --> Fuel\Core\Request::execute - Called
INFO - 2014-05-08 18:41:00 --> Fuel\Core\Request::execute - Setting main Request
INFO - 2014-05-08 18:41:31 --> Fuel\Core\Request::__construct - Creating a new main Request with URI = "cart"
INFO - 2014-05-08 18:41:31 --> Fuel\Core\Request::execute - Called
INFO - 2014-05-08 18:41:31 --> Fuel\Core\Request::execute - Setting main Request
ERROR - 2014-05-08 18:41:31 --> 21000 - SQLSTATE[21000]: Cardinality violation: 1241 Operand should contain 1 column(s) with query: "INSERT INTO `item_order` (`item_id`, `order_id`, `quantity`, `price`) VALUES (31, ('114', 1), '1', '19.99')" in /Users/Marshall/Sites/csc417/project-three/fuel/core/classes/database/pdo/connection.php on line 234
