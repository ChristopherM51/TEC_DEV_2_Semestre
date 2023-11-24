<?php
	$salario = $_GET['salario'];
	$horas = $_GET['nhoras'];
	$bruto;
	$liquido;
	$ir = 0.11;
	$inss = 0.08;
	$sindicato = 0.05;
	//Salario bruto
	function bruto ($salario,$horas){
		$bruto = ($salario*$horas);
		return $bruto;
	}
	//Salario liquido
	function liquido($bruto,$ir,$inss,$sindicato){
		$liquido = ($bruto-($bruto*$ir*$inss*$sindicato));
		return $liquido;
	}
	//INSS
	function inss($bruto,$inss){
		$liquido = ($bruto*$inss);
		return $liquido;
	}
	//IR
	function inss($bruto,$ir){
		$liquido = ($bruto*$ir);
		return $liquido;
	}
	printf("O salario bruto é de R$ %.2f", bruto($salario,$horas));
	echo "<br>";
	printf("INSS R$ %.2f", $bruto);
	echo "<br>";
	printf("IR R$ %.2f", $bruto);
	echo "<br>";
	printf("sindicato R$ %.2f", $bruto);
	echo "<br>";
	printf("O salario liquido é de R$ %.2f", liquido($bruto,$ir,$inss,$sindicato));
?>