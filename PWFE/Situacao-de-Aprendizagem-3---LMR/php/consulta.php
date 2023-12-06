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