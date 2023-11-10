<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "repositorio";
$PicNum = $_GET["PicNum"];

$conn = mysqli_connect($host, $username, $password, $db) or die("Impossível conectar ao banco: " . mysqli_connect_error());

$query = "SELECT * FROM arquivos WHERE id = ?";
$stmt = mysqli_prepare($conn, $query);
mysqli_stmt_bind_param($stmt, "s", $PicNum);
mysqli_stmt_execute($stmt);

$result = mysqli_stmt_get_result($stmt); // Use mysqli_stmt_get_result para obter o resultado da instrução preparada

if ($row = mysqli_fetch_object($result)) {
    header("Content-type: image/gif");
    echo $row->nome; // Este campo deve conter os dados binários da imagem
} else {
    echo "Imagem não encontrada";
}

mysqli_close($conn);
?>
