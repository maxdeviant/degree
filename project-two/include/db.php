<!-- Marshall Bowers -->
<?php
    require_once "rb.php";

    class DB {
        public static function getProperties() {
            return self::mysqlProperties();
        }

        private static $_initialized = false;

        public function init() {
            $properties = self::getProperties();

            if (self::$_initialized) {
                return $properties;
            }

            if ($properties['db'] == 'mysql') {
                R::setup($properties['url'], $properties['username'], $properties['password']);
            }

            R::freeze(true);
            self::$_initialized = true;

            return $properties;
        }

        private static function mysqlProperties() {
            $host = '127.0.0.1';
            $dbname = 'phpstore';
            $username = 'root';
            $password = '';
            $url = "mysql:host=$host;dbname=$dbname";

            return array(
                'db' => 'mysql',
                'dbname' => $dbname,
                'username' => $username,
                'password' => $password,
                'host' => $host,
                'url' => $url
            );
        }
    }
?>
