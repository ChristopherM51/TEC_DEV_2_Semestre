<?php
	//Circunferencia e Perimetro
	$raio = $_GET['raio'];
	$circunferencia;
	$area;

	$circunferencia = $raio*2*M_PI;
	$area = M_PI*$raio*$raio;

	printf("A circunferencia é de: %.2f", $circunferencia);
	echo "<br>";
	printf("A Área é de: %.2f",$area);
?>