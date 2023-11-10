<?php
function isNumeroPerfeito($numero) {
    $somaFatores = 0;
    for ($i = 1; $i < $numero; $i++) {
        if ($numero % $i === 0) {
            $somaFatores += $i;
        }
    }
    return $somaFatores === $numero;
}