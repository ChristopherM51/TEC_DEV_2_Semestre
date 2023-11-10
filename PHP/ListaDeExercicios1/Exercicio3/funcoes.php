<?php
function divisor($n1, $n2) {
    $i = 0;
    $n0 = 0;
    
    if ($n2 == 0) {
        return "Erro, impossível dividir por zero.";
    } else if ($n1 >= $n2) {
        while ($n1 >= $n2) {
            $n1 -= $n2;
            $i++;
        }
        $n0 = $n1;
    } else if ($n2 >= $n1) {
        while ($n2 >= $n1) {
            $n2 -= $n1;
            $i++;
        }
        $n0 = $n2;
    }

    return $i . " e resto " . $n0;
}