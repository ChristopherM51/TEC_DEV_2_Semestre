
<?php
session_start();
include('conexao.php');

// Processamento da exclusão
if (isset($_GET['delete'])) {
    $id = urldecode($_GET['delete']);

    if ($id) {
        $confirmacao = true; // ou qualquer lógica que você queira para a confirmação

        if ($confirmacao) {
            $queryDelete = "DELETE FROM produtos WHERE id = ?";
            $stmtDelete = $conexao->prepare($queryDelete);

            if ($stmtDelete) {
                $stmtDelete->bind_param('i', $id);
                $stmtDelete->execute();

                if ($stmtDelete->affected_rows > 0) {
                    $stmtDelete->close();
                    header('Location: dashboardProdutos.php?delete_success=true');
                    exit();
                } else {
                    echo "Erro ao excluir o produto. Erro: " . $stmtDelete->error;
                }
            } else {
                echo "Erro na preparação da consulta de exclusão.";
            }
        } else {
            echo "Exclusão cancelada pelo usuário.";
        }
    } else {
        echo "ID do produto inválido.";
    }
}

// Consulta para obter os produtos
$query = "SELECT * FROM produtos";

$resultado = $conexao->query($query);

if ($resultado === false) {
    echo "Erro na query: " . $conexao->error;
} else {
    // Resto do código para processar o resultado da consulta
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
    <!-- Estilos -->
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
    <div class="cadastro-container">
        <!-- Formulário de cadastro -->
    </div>

    <h2>Lista de Produtos</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Imagem do Produto</th>
            <th>Nome do Produto</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>tag1</th>
            <th>tag2</th>
            <th>tag3</th>
            <th>Ações</th>
        </tr>
        <?php
        // Listagem dos produtos
        if ($resultado->num_rows > 0) {
            while ($row = $resultado->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . (isset($row['id']) ? $row['id'] : '') . "</td>";
                echo "<td>" . $row['imgProduto'] . "</td>";
                echo "<td>" . $row['nomeProduto'] . "</td>";
                echo "<td>" . $row['descricao'] . "</td>";
                echo "<td>" . $row['preco'] . "</td>";
                echo "<td>" . $row['tag1'] . "</td>";
                echo "<td>" . $row['tag2'] . "</td>";
                echo "<td>" . $row['tag3'] . "</td>";
                echo "<td>
                    <a class='delete-button' href='cadastroProdutos.php?delete=" . $row['id'] . "' onclick='return confirmDelete(this)'>Excluir</a>
                    </td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='9'>Nenhum registro encontrado.</td></tr>";
        }
        ?>
    </table>

    <!-- Script para confirmação de exclusão -->
    <script>
        function confirmDelete(link) {
            if (confirm("Tem certeza que deseja excluir este Produto?")) {
                window.location.href = link.href;
            }
            return false;
        }
    </script>
</body>
</html>
<?php
// Fechar a conexão com o banco de dados
$conexao->close();
?>
