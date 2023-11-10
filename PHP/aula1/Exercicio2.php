<?php
//1- Media de aluno
	function media ($a,$b,$c,$d){
		$retorno = (($a+$b+$c+$d)/4);

	if ($retorno >=7){
			echo "Aprovado com nota $retorno";
	} elseif ($retorno>=5){
			echo "Exame com nota $retorno";
	} else {
			echo "Reprovado com nota $retorno";
	}

	}
	echo media(6,7,8,9);
	echo"<br><hr>";

//2- Função fatorial
	function fatorial ($n){
		$retorno;

		if ($n == 0){
		     $retorno =1;
		} else {
			$retorno = ($n*fatorial($n-1));
		}
		return $retorno;
		}
		echo fatorial (10);
//3- Imprimir numeros pares
		function pares($vetor = array()){
			
			foreach ($vetor as $par) {
				if ($par %2 == 0);
				echo "$par é par";
			}
		}
	
echo pares (1,2,3,4,5,6,7,8,9);

?>