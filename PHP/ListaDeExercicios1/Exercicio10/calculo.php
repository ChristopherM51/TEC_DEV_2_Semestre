<?php
include 'funcoes.php';
$valor = $_GET['numPorcento']; // Valor de entrada
$porcentagem5 = calcularPorcentagem($valor, 5);
$porcentagem50 = calcularPorcentagem($valor, 50);

echo "5% de " . $valor . " é: " . $porcentagem5 . "<br>";
echo "50% de " . $valor . " é: " . $porcentagem50;
?>