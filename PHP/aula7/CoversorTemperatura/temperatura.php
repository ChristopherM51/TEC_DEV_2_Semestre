<?php
	//Conversor de temperatura
	$temperaturaF = $_GET['temperaturaF'];
	$temperaturaC = $_GET['temperaturaC'];
	$farenheit;
	$celsius;

	$farenheit = $temperaturaC*(9/5)+32;
	$celsius = ($temperaturaF-32)*(5/9);

	printf("$temperaturaF graus Farenheit são %.2f", $celsius);
	echo("em graus celsius");
	echo "<br>";
	printf("$temperaturaC graus Celsius são %.2f", $farenheit);
	echo("em graus Farenheit");
?>