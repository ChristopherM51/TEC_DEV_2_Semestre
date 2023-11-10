<?php
function analise($n1) {
    $n1;
    
    if ($n1 == 0) {
        return "Igual a Zero";
    } else if ($n1 > 0) {
        return "Valor Positivo";
    } else {
        return "Valor Negativo";
    }
}
?>