<?php

	//media de aluno
	$nota1 = 6;
	$nota2 = 8;
	$nota3 = 4;
	$nota4 = 10;

	$media = ($nota1+$nota2+$nota3+$nota4)/4

	if ($media >= 7 ){
		echo "Aprovado";
	} elseif ($media>=5){
			echo "Exame";
	} echo "Reprovado";

	//aposentadoria
	$sexo = mulher;
	$tempo_de_sevico = 30;

	if ($sexo = mulher && tempo_de_sevico >= 30){
		echo "Aposenta";
	} elseif ($sexo!=mulher && tempo_de_sevico >= 35){
		echo "Aposenta";
	} echo "Não Aposenta";
?>