<?php
// Configurações de conexão com o banco de dados
$host = '127.0.0.1';
$dbUsuario = 'root';
$dbSenha = '';
$nomeBanco = 'clientes';

// Conexão com o banco de dados
$conexao = new mysqli($host, $dbUsuario, $dbSenha, $nomeBanco);

if ($conexao->connect_error) {
    die("Erro na conexão com o banco de dados: " . $conexao->connect_error);
}

// Função para excluir um usuário pelo ID
if (isset($_GET['delete'])) {
    $idUsuario = $_GET['delete'];
    $queryDelete = "DELETE FROM login WHERE userid = ?";
    $stmtDelete = $conexao->prepare($queryDelete);
    $stmtDelete->bind_param('i', $idUsuario);
    $stmtDelete->execute();
    $stmtDelete->close();

    // Redirecionar de volta para a página de lista após a exclusão
    header('Location: lista_usuarios.php');
    exit();
}

// Consulta para selecionar todos os registros da tabela "login"
$query = "SELECT * FROM login";
$resultado = $conexao->query($query);

?>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuários</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            margin-right: 10px;
        }

        .edit-button {
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .edit-button:hover {
            background-color: #0056b3;
        }

        .delete-button {
            background-color: #ff0000;
            color: #fff;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .delete-button:hover {
            background-color: #cc0000;
        }
    </style>
</head>
<body>
    <h2>Lista de Usuários</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Usuário</th>
            <th>Ações</th>
        </tr>
        <?php
        if ($resultado->num_rows > 0) {
            while ($row = $resultado->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . $row['userid'] . "</td>";
                echo "<td>" . $row['user'] . "</td>";
                echo "<td>
                        <a class='edit-button' href='editar_usuario.php?id=" . $row['userid'] . "'>Editar</a>
                        <a class='delete-button' href='lista_usuarios.php?delete=" . $row['userid'] . "' onclick='return confirm(\"Tem certeza que deseja excluir este usuário?\")'>Excluir</a>
                      </td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='3'>Nenhum registro encontrado.</td></tr>";
        }
        ?>
    </table>
</body>
</html>


<?php
// Fechar a conexão com o banco de dados
$conexao->close();
?>