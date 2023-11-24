<?php
        class Carro{
            private $marca;
            private $modelo;
            private $cor;
            //contrutor
            public function __construct($marca,$modelo,$cor){
                $this->marca = $marca;
                $this->setModelo($modelo);
                $this->setCor($cor);
            }
            //getters
            public function getMarca(){
                return $this->marca;
            }
            public function getModelo(){
                return $this->modelo;
            }
            public function getCor(){
                return $this->cor;
            }
            //setters
            public function setMarca($m){
                $this->marca = $m;
            }
            public function setModelo($m){
                $this->modelo = $m;
            }
            public function setCor($c){
                $this->cor = $c;
            }
        }

$carro = new Carro("Toyota","Hilux","Rosa Choque");

// $carro->setMarca("Honda");
// $carro->setModelo("City");

echo "Marca: " . $carro->getMarca() . "\n";
echo "Modelo: " . $carro->getModelo() . "\n";
echo "Cor: " . $carro->getCor() . "\n";

$carro2 = new Carro("","","");

$carro2->setMarca(readline("Digite a marca do veiculo: "));
$carro2->setModelo(readline("Digite o modelo do veiculo "));
$carro2->setCor(readline("Digite a cor do veiculo: "));

echo "\n";
echo "Marca: " . $carro2->getMarca(). "\n";
echo "Modelo: " . $carro2->getModelo() . "\n";
echo "Cor: " . $carro2->getCor() . "\n";
?>
