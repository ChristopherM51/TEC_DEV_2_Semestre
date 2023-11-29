<?php
    require_once 'Veiculo.php';
    require_once 'Carro.php';

    $veiculo = new Veiculo();
    //$veiculo->marca = "Honda";
    //$veiculo->setMarca("Toyota");
    //echo $veiculo->marca . "<br>";
    //echo $veiculo->getMarca() . "<br>";

    $veiculo->setModelo("GSR100");
    echo $veiculo->getModelo() . "<br>";

    $veiculo->setCor = ("Preta");
    $veiculo->getCor();
    $veiculo->chamarAcao();
   
    echo var_dump($veiculo);
?>