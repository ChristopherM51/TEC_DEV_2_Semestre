<?php
include 'funcoes.php';

echo "Números perfeitos até 1000:<br>";
for ($i = 1; $i <= 1000; $i++) {
    if (isNumeroPerfeito($i)) {
        echo $i . " ";
    }
}
?>