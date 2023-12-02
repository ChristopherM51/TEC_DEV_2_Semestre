<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Valide os dados do formulário
    $nome = $_POST['nome'];
    $usuario = $_POST['usuario'];
    $senha = $_POST['senha'];

    if (empty($nome) || empty($usuario) || empty($senha)) {
        $erro = 'Todos os campos são obrigatórios.';
    } else {
        // Inserir os dados no banco de dados com declarações preparadas para segurança

        // Configurações de conexão com o banco de dados
        $host = '127.0.0.1';
        $dbUsuario = 'root';
        $dbSenha = '';
        $nomeBanco = 'aluno';

        // Conexão com o banco de dados
        $conexao = new mysqli($host, $dbUsuario, $dbSenha, $nomeBanco);

        if ($conexao->connect_error) {
            die("Erro na conexão com o banco de dados: " . $conexao->connect_error);
        }

        // Query SQL para inserção de dados
        $query = "INSERT INTO login (user, pass) VALUES (?, MD5(?))";
        $stmt = $conexao->prepare($query);
        $stmt->bind_param('ss', $usuario, $senha);

        if ($stmt->execute()) {
            // Cadastro bem-sucedido
            header('Location: login.php'); // Redirecionar para a página de login
            exit();
        } else {
            $erro = 'Erro ao cadastrar. Tente novamente.';
        }

        // Fechar a conexão com o banco de dados
        $conexao->close();
    }
}
?>
<!DOCTYPE html>
<html>

<head>
    <title>Página de Cadastro</title>
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .cadastro-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        h2 {
            text-align: center;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <div class="cadastro-container">
        <h2>Cadastro</h2>
        <?php if (isset($erro)) {
            echo '<p class="error-message">' . $erro . '</p>';
        } ?>
        <form method="post">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>

            <label for="usuario">Usuário:</label>
            <input type="text" id="usuario" name="usuario" required>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>

            <p>Ja possui cadastro? 
            <a href="login.php">Clique aqui</a></p>
            <input type="submit" value="Cadastrar">
        </form>
    </div>
</body>

</html>