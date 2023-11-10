<?php

include_once("connect.php");
//Verificando a conexao
if(!$conn){
	die("Falha na conexao!" . mysqli_connect_erro());
}

echo "Conectado com sucesso!";

mysqli_close($conn);
?>