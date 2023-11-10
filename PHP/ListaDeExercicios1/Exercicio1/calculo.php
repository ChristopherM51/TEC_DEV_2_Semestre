<?php
include 'funcoes.php';
$area = $_GET["a"];

echo "A quantidade de area a ser pintada é de: $area";
echo "<br>";
echo "A quantidade de Latas de necessarias é de " .quantidadeLatas($area,$coberturaLata);
echo "<br>";
echo "O preço em Latas é de " .precoEmLatas($area,$coberturaLata,$precoLata);
echo "<br>";
echo "A quantidade de Galões de necessarios é de" .quantidadeGaloes($area,$coberturaGalao);
echo "<br>";
echo "O preço em Galões é de " .precoEmGaloes($area,$coberturaGalao,$precoGalao);
echo "<br>";
echo "O preço mesclando Latas e Galões é de " .precoMisto($area,$coberturaLata,$coberturaGalao,$precoLata,$precoGalao);
?>