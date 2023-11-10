<?php
function fatorial1 ($n1){
	if ($n1 == 0){
	     $retorno =1;
	} else {
		$retorno = ($n1*fatorial1($n1-1));
	}
	return $retorno;
	};
?>