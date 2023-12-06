<?php
$erro = '';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Valide os dados do formulário
    $nome = isset($_POST['nome']) ? $_POST['nome'] : '';
    $usuario = isset($_POST['usuario']) ? $_POST['usuario'] : '';
    $senha = isset($_POST['senha']) ? $_POST['senha'] : '';
    $confirmaSenha = isset($_POST['confirmaSenha']) ? $_POST['confirmaSenha'] : '';
    $img = isset($_POST['img']) ? $_POST['img'] : '';
    $nascimento = isset($_POST['nascimento']) ? $_POST['nascimento'] : '';
    $cpf = isset($_POST['cpf']) ? $_POST['cpf'] : '';
    $rua = isset($_POST['rua']) ? $_POST['rua'] : '';
    $n = isset($_POST['n']) ? $_POST['n'] : '';
    $complemento = isset($_POST['complemento']) ? $_POST['complemento'] : '';
    $cidade = isset($_POST['cidade']) ? $_POST['cidade'] : '';
    $uf = isset($_POST['uf']) ? $_POST['uf'] : '';
    $cep = isset($_POST['cep']) ? $_POST['cep'] : '';
    $email = isset($_POST['email']) ? $_POST['email'] : '';

    // Verifica se as senhas coincidem
    $erro = '';
    if ($senha !== $confirmaSenha) {
        $erro = 'As senhas não coincidem.';
    } else {
        // Configurações de conexão com o banco de dados
        $host = 'localhost';
        $dbUsuario = 'root';
        $dbSenha = '';
        $dbname = "sa3pwfe";

        // Conexão com o banco de dados
        $conexao = new mysqli($host, $dbUsuario, $dbSenha, $dbname);

        if ($conexao->connect_error) {
            die("Erro na conexão com o banco de dados: " . $conexao->connect_error);
        }

        // Query SQL para inserção de dados
        $query = "INSERT INTO clientes (img, admin, nome, sobrenome, nascimento, cpf, rua, n, complemento, cidade, uf, cep, email, senha, usuario) 
                   VALUES (?, false, ?, '', '', '', ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        $stmt = $conexao->prepare($query);

        // Hash da senha
        $senhaHash = password_hash($senha, PASSWORD_DEFAULT);

        // Ajuste da string de definição de tipo e vinculação
        $stmt->bind_param('ssssssssssssssss', $img, $nome, $rua, $n, $complemento, $cidade, $uf, $cep, $email, $senhaHash, $usuario);

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
            margin-top: 200px;
            display: flex;
            justify-content: center;
            align-items: center;
            /* height: 100vh; */
        }

        .cadastro-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 600px;
        }

        h2 {
            text-align: center;
            font-size: 40px;
        }

        p {
            text-align: center;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        form div {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            width: 300px;

            & p {
                transform: translateX(-15px);
            }
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            margin: 0 10px;
            padding: 10px;
            transform: translateY(20px);
            background-color: white;
            width: min-content;
        }

        input {
            width: 250px;

        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;

            &:hover {
                border-color: #007bff;
            }
        }

        input:focus {
            border-color: red;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 270px;
            transform: translateY(-10px);
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="cadastro-container">
        <h2>Cadastro</h2>
        <p>Preencha os campos com cuidado</p>

        <?php if(isset($erro)) {
            echo '<p class="error-message">'.$erro.'</p>';
        } ?>

        <form method="post">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required>
            </div>
            <div>
                <label for="usuario">Usuário:</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>
            <div> <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div>
            <div> <label for="confirmaSenha">Confirmar Senha:</label>
                <input type="password" id="confirmaSenha" name="confirmaSenha" required>
            </div>
            <div> <label for="img">Imagem:</label>
                <input type="text" id="img" name="img">
            </div>
            <div> <label for="nascimento">Nascimento:</label>
                <input type="text" id="nascimento" name="nascimento">
            </div>
            <div> <label for="cpf">CPF:</label>
                <input type="text" id="cpf" name="cpf">
            </div>
            <div> <label for="rua">Rua:</label>
                <input type="text" id="rua" name="rua">
            </div>
            <div> <label for="n">Nº:</label>
                <input type="text" id="n" name="n">
            </div>
            <div> <label for="complemento">Complemento:</label>
                <input type="text" id="complemento" name="complemento">
            </div>
            <div> <label for="cidade">Cidade:</label>
                <input type="text" id="cidade" name="cidade">
            </div>
            <div> <label for="uf">UF:</label>
                <input type="text" id="uf" name="uf">
            </div>
            <div> <label for="cep">CEP:</label>
                <input type="text" id="cep" name="cep">
            </div>
            <div> <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div>
                <p>Já possui cadastro?
                    <a href="login.php">Clique aqui</a>
                </p>
                <input type="submit" value="Cadastrar">
            </div>
        </form>
    </div>
</body>

</html>