<?php
function multiplicador($n1,$n2){
    $retorno = 0;

    for ($i= 1; $i <=$n2; $i++) {
        $retorno += $n1;
    }
    return $retorno;
}
?>