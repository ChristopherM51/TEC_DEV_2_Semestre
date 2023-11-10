<?php
$servername = "nome_do_servidor";
$username = "nome_de_usuario";
$password = "senha";
$dbname = "nome_do_banco_de_dados";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    header("Location: erro.html");
    exit();
} else {
    $nome = $_POST['nome'];
    $endereco = $_POST['endereco'];
    $email = $_POST['email'];
    $sexo = $_POST['sexo'];
    $data_nascimento = $_POST['data_nascimento'];

    $sql = "INSERT INTO usuarios (nome, endereco, email, sexo, data_nascimento)
            VALUES ('$nome', '$endereco', '$email', '$sexo', '$data_nascimento')";

    if ($conn->query($sql) === TRUE) {
        header("Location: sucesso.html");
        exit();
    } else {
        header("Location: erro.html");
        exit();
    }
}
$conn->close();
?>