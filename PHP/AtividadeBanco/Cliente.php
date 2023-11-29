<?php
  class Cliente {
    private $nome;
    private $numeroConta;
    private $saldo;

    public function __construct($nome, $numeroConta) {
        $this->nome = $nome;
        $this->numeroConta = $numeroConta;
        $this->saldo = 100.00; // Saldo inicial de R$100,00
    }

    public function abrirConta() {
        echo "Informe os dados para abrir a conta:\n";
            $this->nome = readline("Nome: ");
            $this->numeroConta = readline("Número da Conta: ");
            echo "Conta aberta com sucesso.\n";
        }

    public function sacar($valor) {
        if($valor > 0 && $valor <= $this->saldo) {
            $this->saldo -= $valor;
            echo "Saque de R$ ".$valor." realizado com sucesso.\n";
        } else {
            echo "Saldo insuficiente ou valor inválido para saque.\n";
        }
    }

    public function depositar($valor) {
        if($valor > 0) {
            $this->saldo += $valor;
            echo "Depósito de R$ ".$valor." realizado com sucesso.\n";
        } else {
            echo "Valor inválido para depósito.\n";
        }
    }

    public function consultarSaldo() {
        echo "Saldo atual: R$ ".$this->saldo."\n";
    }

    public function consultarDadosCliente() {
        echo "Nome: ".$this->nome."\n";
        echo "Número da Conta: ".$this->numeroConta."\n";
        echo "Saldo: R$ ".$this->saldo."\n";
    }
}
?>