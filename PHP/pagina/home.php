<?php
$x = 1;

if($x>=2):
	header ('Location: sucesso.php');
else:
	header('Location: erro.php');
endif;
?>