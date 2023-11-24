<?php
    
    class Veiculo{
        private $marca;
        private $modelo;

        public function Ligar(){
            echo "Ligando...\n";
        }
        public function Desligar(){
            echo "Desligando...\n";
        }
    }
    
    class Carro extends Veiculo{
        private $numPortas;

        public function acelerar(){
            echo "Acelerando o carro...\n";
        }
    }

    class Moto extends Veiculo{
        private $numRodas;

        public function acelerar(){
            echo "Acelerando a moto...\n";
        }
    }

    $carro = new Carro("","","");
    $carro->marca = "Honda";
    echo $carro->marca;
    var_dump($carro);

    $moto = new moto();
    $moto->Ligar();
    $moto->acelerar();
    $moto->Desligar();
    // var_dump($moto);
    ?>