<?php
function consumo($km,$combustivelGasto) {
    $retorno = $km/$combustivelGasto;
    return $retorno;
}
function custoPorKm($km,$combustivelGasto,$precoLitro) {
    $retorno = $combustivelGasto/$km*$precoLitro;
    return $retorno;
}
?>