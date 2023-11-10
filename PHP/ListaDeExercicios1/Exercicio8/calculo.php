<?php
include 'funcoes.php';
echo "Números primos até 1000:<br>";
for ($i = 2; $i <= 1000; $i++) {
    if (isPrimo($i)) {
        echo $i . " ";
    }
}
?>