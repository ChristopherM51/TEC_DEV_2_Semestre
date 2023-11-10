<?php
function fatorial ($n){
		$retorno;

		if ($n == 0){
		     $retorno =1;
		} else {
			$retorno = ($n*fatorial($n-1));
		}
		return $retorno;
		}
?>