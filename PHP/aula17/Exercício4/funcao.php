<?php
function calculadora($n1,$n2) {    
    if ($n1 == 0) {
        return "Igual a Zero";
    } else if ($n1 > 0) {
        return "Valor Positivo";
    } else {
        return "Valor Negativo";
    }
}
?>