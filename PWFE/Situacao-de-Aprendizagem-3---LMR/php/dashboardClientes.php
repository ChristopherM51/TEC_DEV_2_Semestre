<?php
session_start();
include('conexao.php');

// Função para excluir um usuário pelo e-mail
if (isset($_GET['delete'])) {
    $emailUsuario = urldecode($_GET['delete']);

    if ($emailUsuario) {
        $confirmacao = true; // ou qualquer lógica que você queira para a confirmação

        if ($confirmacao) {
            // Executar a consulta de exclusão usando declaração preparada
            $queryDelete = "DELETE FROM clientes WHERE email = ?";
            $stmtDelete = $conexao->prepare($queryDelete);

            // Verificar se a preparação da consulta foi bem-sucedida
            if ($stmtDelete) {
                $stmtDelete->bind_param('s', $emailUsuario);
                $stmtDelete->execute();

                // Verificar se a exclusão foi bem-sucedida
                if ($stmtDelete->affected_rows > 0) {
                    $stmtDelete->close();
                    header('Location: dashboardClientes.php?delete_success=true');
                    exit();
                } else {
                    echo "Erro ao excluir o usuário. Erro: " . $stmtDelete->error;
                }
            } else {
                echo "Erro na preparação da consulta de exclusão.";
            }
        } else {
            // Cancelar a exclusão
            echo "Exclusão cancelada pelo usuário.";
        }
    } else {
        echo "Email do usuário inválido.";
    }
}

// Função para obter os detalhes de um cliente pelo ID
function obterClientePorID($conexao, $idCliente)
{
    $stmt = $conexao->prepare("SELECT * FROM clientes WHERE id_cliente = ?");
    $stmt->bind_param('i', $idCliente);
    $stmt->execute();
    $resultado = $stmt->get_result();
    $cliente = $resultado->fetch_assoc();
    $stmt->close();

    return $cliente;
}

// Consulta para selecionar todos os registros da tabela "clientes"
$stmt = $conexao->prepare("SELECT * FROM clientes");
$stmt->execute();
$resultado = $stmt->get_result();

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

        th,
        td {
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
            <th>Admin</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Nascimento</th>
            <th>CPF</th>
            <th>Endereço</th>
            <th>Email</th>
            <th>Ações</th>
        </tr>
        <?php
        if ($resultado->num_rows > 0) {
            while ($row = $resultado->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . (isset($row['id_cliente']) ? $row['id_cliente'] : '') . "</td>";
                echo "<td>" . ($row['admin'] ? 'Sim' : 'Não') . "</td>";
                echo "<td>" . $row['nome'] . "</td>";
                echo "<td>" . $row['sobrenome'] . "</td>";
                echo "<td>" . $row['nascimento'] . "</td>";
                echo "<td>" . $row['cpf'] . "</td>";
                echo "<td>" . $row['rua'] . ", " . $row['n'] . " - " . $row['cep'] . " - " . $row['cidade'] . " - " . $row['uf'] . " - " . $row['complemento'] . "</td>";
                echo "<td>" . $row['email'] . "</td>";
                echo "<td>
                <a class='edit-button' href='editar_usuario.php?id=" . (isset($row['id_cliente']) ? $row['id_cliente'] : '') . "'>Editar</a>
                <a class='delete-button' href='cadastroCliente.php?delete=" . urlencode($row['email']) . "' onclick='return confirmDelete(this)'>Excluir</a>
                </td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='9'>Nenhum registro encontrado.</td></tr>";
        }
        ?>
    </table>
</body>
<script>
function confirmDelete(link) {
            if (confirm("Tem certeza que deseja excluir este cliente?")) {
                window.location.href = link.href;
            }
            return false;
        }
</script>
</html>

<?php
// Fechar a conexão com o banco de dados
$conexao->close();
?>