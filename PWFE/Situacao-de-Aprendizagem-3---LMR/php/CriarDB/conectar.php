<?php
$servername = "127.0.0.1";
$username = "root";
$password = '';
$dbname = "sa3pwfe";

// Cria a conexão
$conexao = new mysqli($servername, $username, $password);

// Verifica a conexão
if ($conexao->connect_error) {
    die("Conexão falhou: " . $conexao->connect_error);
}

// Cria o banco de dados
$sql_create_db = 'CREATE DATABASE IF NOT EXISTS ' . $dbname;
if ($conexao->query($sql_create_db) === TRUE) {
    echo "Banco de dados criado com sucesso";
} else {
    echo "Erro ao criar banco de dados: " . $conexao->error;
}

// Fecha a conexão
$conexao->close();
?>