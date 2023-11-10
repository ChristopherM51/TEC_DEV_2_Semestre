<?php

//1- Soma
	function soma ($a,$b){
		$retorno = ($a+$b);
		return $retorno;
	}
	echo soma(6,7);
	echo"<br><hr>";

//2- Subitração
	function subitracao ($a,$b){
		$retorno = ($a-$b);
		return $retorno;
	}
	echo subitracao(6,7);
	echo"<br><hr>";

//3- Multiplicação
	function multiplicacao ($a,$b){
		$retorno = ($a+$b);
		return $retorno;
	}
	echo multiplicacao(6,7);
	echo"<br><hr>";
//4- Divisão
	function divisao ($a,$b){
		
	if ($b == 0){
		echo "Operação invalida, impossivel dividir por ZERO";
	} else {
		$retorno = ($a/$b);
		return $retorno;
	}
}
	echo divisao(6,0);
	echo"<br><hr>";
	
?>