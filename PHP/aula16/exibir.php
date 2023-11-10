<?php
$host = "localhost";
$username = "root";
$password = "";
$db = "repositorio";

$conn = mysqli_connect($host, $username, $password, $db) or die("Impossível conectar ao banco: " . mysqli_connect_error());

$query = "SELECT * FROM arquivos";
$result = mysqli_query($conn, $query) or die("Impossível executar a query: " . mysqli_error($conn));

while ($row = mysqli_fetch_object($result)) {
    $imagemPath = $row->nome; // O campo 'nome' deve conter o caminho da imagem completo
    echo "<img src='getImagem.php?PicNum={$row->id}' \ >";
}

mysqli_close($conn);

?>
