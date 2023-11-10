<?php 
	
	$server = "127.0.0.1";
	$user = "root";
	$pass = "";
	$db = "banco";


	$conn = new mysqli($server, $user, $pass, $db);

	if($conn->connect_error){
		echo "Sem conexao";
		exit();
	}

	echo "Conectado";

	//mysql_close();

?>