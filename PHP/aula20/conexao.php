<?php
define ('HOST','127.0.0.1');
define ('USUARIO','admin');
define ('SENHA','admin');
define ('DB','aluno');

$conexao = mysqli_connect (HOST,USUARIO,SENHA,DB) or die ('Não foi possivel conectar');

?>