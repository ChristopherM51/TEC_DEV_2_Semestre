<?php
function tabuada($n1) {
    $n1;
    for($i=0;$i<=10;$i++){
        $resultado = $n1 * $i;
        echo $n1 . "X" . $i . "=" . $resultado;
        echo "<br>";  
    }
}
?>