<?php
include 'funcoes.php';
$km = $_GET['km'];
$combustivelGasto = $_GET['CG'];
$precoLitro = $_GET['PL'];

echo 'O consumo medio é de ' . consumo($km,$combustivelGasto)  .'kM/L';
echo '<br>';
echo 'O custo por km percorrido foi de ' . custoPorKm($km,$combustivelGasto,$precoLitro);
?>