<?php
$area= $_GET["area"];
$coberturaLitro = 3;
$coberturaLata = 54;
$coberturaGalao = 10.8;
$precoLata = 80;
$precoGalao = 25;
//Calcular quantidade de litros necessaria com margem de 10%
function quantidadeLitros ($area,$coberturaLitro){
    $retorno = (($area*1.1)/$coberturaLitro);
    return $retorno;
}
//Calcular a quantidade de galoes
function quantidadeGaloes ($area,$coberturaGalao){
    $retorno = (($area*1.1)/$coberturaGalao);
    return $retorno;
}
//calcular preço em latas
function precoEmLatas ($area,$coberturaLata,$precoLatas){
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
function precoMisto (){
    $quantidadeLatas = floor(($area*1.1)/($coberturaLata));
    $quantidadeGaloes = ceil(($quantidadeLatas)/($coberturaGalao));
    $retorno = $quantidadeLatas*$precoLata+$quantidadeGaloes*$precoGalao;
    return $retorno;
}

echo "A quantidade de area a ser pintada é de $area";
echo "A quantidade de Latas de necessarias é de" ($quantidadeLitros);
echo "o preço em Latas é de " ($precoLata);
echo "A quantidade de Galões de necessarios é de" ($quantidadeGaloes);
echo "o preço em Galões é de " ($precoGalao);
echo "O preço mesclando Latas e Galões é de " ($precoMisto);
?>