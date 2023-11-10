<?php
if (isset($_POST['enviar-formulario'])):
    $formatos = array("png", "jpeg", "jpg", "git", "pdf");
    $qtArquivos = count($_FILES['arquivo']['name']);
    $cont = 0;

    while ($cont < $qtArquivos):
        $extensao = pathinfo($_FILES['arquivo']['name'][$cont], PATHINFO_EXTENSION);
        if (in_array($extensao, $formatos)):
            //echo "existe";
            $pasta = "arquivo/";
            $temporario = $_FILES['arquivo']['tmp_name'][$cont];
            $novoNome = uniqid() . ".$extensao";
            
            if (move_uploaded_file($temporario, $pasta . $novoNome)):
                echo "Upload feito com sucesso. <br>";
            else:
                echo "Erro, não foi possivel fazer o upload. <br>";
            endif;
        else:
            //echo "Não existe";
            echo "Formato invalida: " . $extensao . "<br>";
        endif;
        $cont++;
    endwhile;
endif;
?>