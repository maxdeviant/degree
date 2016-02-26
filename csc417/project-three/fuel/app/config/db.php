<?php
/**
 * Use this file to override global defaults.
 *
 * See the individual environment DB configs for specific config information.
 */

return array(
	'default' => array(
		'type' => 'pdo',
		'connection'  => array(
			'dsn'        => 'mysql:host=127.0.0.1;dbname=phpstore',
			'username'   => 'guest',
			'password'   => '',
		),
	),
);
