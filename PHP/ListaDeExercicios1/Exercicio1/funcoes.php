<?php
$coberturaLata = 54;
$coberturaGalao = 10.8;
$precoLata = 80;
$precoGalao = 25;
//Calcular quantidade de litros necessaria com margem de 10%
function quantidadeLatas ($area,$coberturaLata){
    $retorno = ceil(($area*1.1)/$coberturaLata);
    return $retorno;
}
//Calcular a quantidade de galoes
function quantidadeGaloes ($area,$coberturaGalao){
    $retorno = ceil(($area*1.1)/$coberturaGalao);
    return $retorno;
}
//calcular preço em latas
function precoEmLatas ($area,$coberturaLata,$precoLata){
    $quantidadeLatas = ceil(($area*1.1)/($coberturaLata));
    $retorno = $quantidadeLatas*$precoLata;
    return $retorno;
}
//calcular preço em galoes
function precoEmGaloes ($area,$coberturaGalao,$precoGalao){
    $quantidadeGaloes = ceil(($area*1.1)/($coberturaGalao));
    $retorno = $quantidadeGaloes*$precoGalao;
    return $retorno;
}
//calcular preço misto
function precoMisto ($area,$coberturaLata,$coberturaGalao,$precoLata,$precoGalao){
    $quantidadeLatas = floor(($area*1.1)/($coberturaLata));
    $quantidadeGaloes = ceil(($quantidadeLatas)/($coberturaGalao));
    $retorno = $quantidadeLatas*$precoLata+$quantidadeGaloes*$precoGalao;
    return $retorno;
}


?>