<?php
$servername = "127.0.0.1";
$username = "root";
$password = ''; // Substitua com sua senha
$dbname = "sa3pwfe";

// Cria a conexão
$conexao = new mysqli($servername, $username, $password, $dbname);

// Verifica a conexão
if ($conexao->connect_error) {
    die("Conexão falhou: " . $conexao->connect_error);
}

// Cria a tabela produtos
$sql_produtos = "CREATE TABLE produtos (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    imgProduto VARCHAR(250),
    nomeProduto VARCHAR(50) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    tag1 VARCHAR(30),
    tag2 VARCHAR(30),
    tag3 VARCHAR(30)
)";

if ($conexao->query($sql_produtos) === TRUE) {
    echo "Tabela produtos criada com sucesso";
} else {
    echo "Erro ao criar tabela produtos: " . $conexao->error;
}

// Fecha a conexão
$conexao->close();
?>