<?php
function triangulo($lado1, $lado2, $lado3)
{

    if ($lado1 > ($lado2 + $lado3) || $lado2 > ($lado1 + $lado3) || $lado3 > ($lado2 + $lado1)) {
        return "não formam um triangulo";
    } else if ($lado1 == $lado2 && $lado3 == $lado1) {
        return "formam um triangulo equilatero";
    } else if ($lado1 == $lado2 || $lado1 == $lado3 || $lado2 == $lado3) {
        return "formam um triangulo isóceles";
    } else {
        return "formam um triangulo escaleno";
    }
}