<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Valide os dados do formulário
    $imgProduto = isset($_POST['imgProduto']) ? $_POST['imgProduto'] : '';
    $nomeProduto = isset($_POST['nomeProduto']) ? $_POST['nomeProduto'] : '';
    $descricao = isset($_POST['descricao']) ? $_POST['descricao'] : '';
    $preco = isset($_POST['preco']) ? $_POST['preco'] : '';
    $tag1 = isset($_POST['tag1']) ? $_POST['tag1'] : '';
    $tag2 = isset($_POST['tag2']) ? $_POST['tag2'] : '';
    $tag3 = isset($_POST['tag3']) ? $_POST['tag3'] : '';

        // Configurações de conexão com o banco de dados
        $host = 'localhost';
        $dbusuario = 'root';
        $dbSenha = '';
        $dbname = "sa3pwfe";

        // Conexão com o banco de dados
        $conexao = new mysqli($host, $dbusuario, $dbSenha, $dbname);

        if ($conexao->connect_error) {
            die("Erro na conexão com o banco de dados: " . $conexao->connect_error);
        } 

        // Query SQL para inserção de dados
        $query = "INSERT INTO produtos (id, imgProduto, nomeProduto, descricao, preco, tag1, tag2, tag3) 
                   VALUES (null , ?, ?, ?, ?, ?, ?, ?)";
        $stmt = $conexao->prepare($query);

        if ($stmt === false) {
            $erro = 'Erro na preparação da consulta: ' . $conexao->error;
        } else {
            $stmt->bind_param('sssssss', $imgProduto, $nomeProduto, $descricao, $preco, $tag1, $tag2, $tag3);
        
            if ($stmt->execute()) {
                echo "Cadastro concluído";
                header('Location: cadastroProduto.php');
                exit();
            } else {
                $erro = 'Erro ao executar a consulta: ' . $stmt->error;
            }
        }
        
        $conexao->close();
    }
?>

<!DOCTYPE html>
<html>

<head>
    <title>Página de Cadastro de Produto</title>
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
            <div> <label for="imgProduto">imgProduto:</label>
                <input type="file" id="imgProduto" name="imgProduto" multiple>
            </div>
            <div> <label for="nomeProduto">Nome do Produto:</label>
                <input type="text" id="nomeProduto" name="nomeProduto">
            </div>
            <div> <label for="descricao">descricao:</label>
                <input type="text" id="descricao" name="descricao">
            </div>
            <div> <label for="preco">preco:</label>
                <input type="text" id="preco" name="preco">
            </div>
            <div> <label for="tag1">tag1:</label>
                <input type="text" id="tag1" name="tag1">
            </div>
            <div> <label for="tag2">tag2:</label>
                <input type="text" id="tag2" name="tag2">
            </div>
            <div> <label for="tag3">tag3:</label>
                <input type="text" id="tag3" name="tag3" required>
            </div>
            <div>
                <input type="submit" value="Cadastrar">
            </div>
        </form>
    </div>
</body>

</html>