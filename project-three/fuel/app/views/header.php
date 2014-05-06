<!DOCTYPE html>
<html lang="en">
<head>
	<title><?php echo $title; ?></title>

	<meta charset="utf-8">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	
	<?php echo Asset::css('site.css'); ?>

	<link rel="shortcut icon" href="<?php echo Asset::get_file('favicon.ico', 'img'); ?>">
	<link rel="apple-touch-icon" href="<?php echo Asset::get_file('apple-touch-icon.png', 'img'); ?>">
	<link rel="apple-touch-icon" sizes="72x72" href="<?php echo Asset::get_file('apple-touch-icon-72x72.png', 'img'); ?>">
	<link rel="apple-touch-icon" sizes="114x114" href="<?php echo Asset::get_file('apple-touch-icon-114x114.png', 'img'); ?>">

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<?php echo Asset::js('sticky-table-headers.min.js'); ?>
</head>