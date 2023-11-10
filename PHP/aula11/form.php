<?php
// Conexão com o banco de dados
$host = 'localhost';
$usuario = 'root';
$senha = '';
$banco = 'clientes';
// Cria uma conexao com o banco de dados
$conexao = mysqli_connect($host, $usuario, $senha, $banco);
//Verifica se a conexao foi bem sucedida
if ($conexao) {
    //Recupera os dados do formulario
    $name = $_POST['name'];
    $email = $_POST['email'];
    $data_nascimento = $_POST['data_nascimento'];
    $endereco = $_POST['endereco'];

    // Insere os dados na tabela do banco
    $sql = "INSERT INTO cliente (name, email, dataNasc, endereco) VALUES ('$name','$email','$data_nascimento','$endereco')";
    mysqli_query($conexao, $sql);

    // Verifica se a inserção foi bem sucedida
    if (mysqli_affected_rows($conexao) > 0) {
        //redireciona para uma pagina de sucesso
        header('Location: sucesso.php');
    } else {
        // Redireciona para uma pagina de erro
        header('Location: erro.php');
    }
} else {
    // Redireciona para uma pagina de erro
    header('Location: erro.php');
}