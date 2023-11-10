<?php
include 'funcoes.php';
$lado1 = $_GET['lado1'];
$lado2 = $_GET['lado2'];
$lado3 = $_GET['lado3'];
echo 'Os 3 lados informados ' . triangulo($lado1,$lado2,$lado3);
?>