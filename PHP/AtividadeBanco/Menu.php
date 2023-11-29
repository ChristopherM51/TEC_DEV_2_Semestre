<?php

    require_once 'Cliente.php';
    
    $cliente = new Cliente("", "", "", "", "", "", "");
    
    do {
        echo "==== Menu ====\n";
        echo "1 - Abrir conta\n";
        echo "2 - Consultar Saldo\n";
        echo "3 - Sacar\n";
        echo "4 - Depositar\n";
        echo "5 - Consultar dados do cliente\n";
        echo "6 - Sair\n";
    
        $opcao = readline("Escolha uma opção: ");
    
        switch ($opcao) {
            case 1:
                $cliente->abrirConta();
                break;
            case 2:
                $cliente->consultarSaldo();
                break;
            case 3:
                $valorSaque = readline("Informe o valor para saque: ");
                $cliente->sacar($valorSaque);
                break;
            case 4:
                $valorDeposito = readline("Informe o valor para depósito: ");
                $cliente->depositar($valorDeposito);
                break;
            case 5:
                $cliente->consultarDadosCliente();
                break;
            case 6:
                echo "Saindo do programa. Até mais!\n";
                break;
            default:
                echo "Opção inválida. Tente novamente.\n";
        }
    } while ($opcao != 6);
?>