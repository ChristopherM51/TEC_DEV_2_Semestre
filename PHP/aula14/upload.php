<?php
//pasta onde quer salvar os arquivos (obs: permissões de escrita habilitadas)
$dir = "img/";
//recebendo o arquivo multipart
$file = $_FILES["arquivo"];
//Move o arquivo da pasta temporaria de upload para a pasta de destino
if (move_uploaded_file($file["tmp_name"], $dir.$file["name"])){
    echo "Arquivo enviado com sucesso!";
}
else{
    echo "Erro, o arquivo não pode ser enviado.";
}
?>