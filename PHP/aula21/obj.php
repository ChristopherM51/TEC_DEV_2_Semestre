<?php

// Definindo a classe Pessoa
class Pessoa
{
    // Definindo atributos
    public $nome;
    public $idade;
    // Definindo ações/métodos
    public function Falar()
    {
        echo $this->nome . ", de " . $this->idade . " anos, esta falando...";
    }
}
// criando um objeto do tipo Pessoa - instancia do objeto
$p = new Pessoa();
$p->nome = "Joãozinho";
$p->idade = 15;

//var_dump($p);

$p->Falar();
//echo "<br> Nome: " .$p->nome;
//echo "<br> Idade: " .$p->idade;
?>