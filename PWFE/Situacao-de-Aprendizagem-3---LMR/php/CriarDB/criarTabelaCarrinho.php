<?php
$servername = "127.0.0.1";
$username = "root";
$password = '';
$dbname = "sa3pwfe";

// Cria a conexão
$conexao = new mysqli($servername, $username, $password, $dbname);

// Verifica a conexão
if ($conexao->connect_error) {
    die("Conexão falhou: " . $conexao->connect_error);
}

// Cria a tabela carrinho
$sql_carrinho = "CREATE TABLE carrinho (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    img VARCHAR(255),
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    valor DECIMAL(10,2) NOT NULL,
    quantidade INT(6) NOT NULL
)";

if ($conexao->query($sql_carrinho) === TRUE) {
    echo "Tabela carrinho criada com sucesso";
} else {
    echo "Erro ao criar tabela carrinho: " . $conexao->error;
}

// Fecha a conexão
$conexao->close();
?>