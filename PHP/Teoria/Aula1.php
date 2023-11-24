		<?php

			$str = "pla";
			var_dump($str);

			if(is_string($str)):
				echo "É uma variavel string";
			else:
				echo "Não é uma variavel string";
			endif;

			echo "<hr><br>";
			
			//int
			$numero = 4;
			var_dump($numero);

			if(is_int($numero)):

				echo "É uma variavel inteira";
			else:
				echo "Não é uma variavel inteira";
		endif;
			echo "<hr><br>";

			//ponto flutuante
			$real = 2;
			var_dump($real);

			if(is_float($real)):

				echo "É uma variavel float";
			else:
				echo "Não é uma variavel foat";
		endif;
			echo "<hr><br>";

			//bool
			$bool = true;
			var_dump($bool);

			if(is_bool($bool)):

				echo "É uma variavel booleana";
			else:
				echo "Não é uma variavel booleana";
		endif;
			
			echo("<hr>");

			//array
			$frutas = array("Melancia","Uva","Morango");
			var_dump($frutas);

			if(is_array($frutas)):

				echo "É uma variavel array";
			else:
				echo "Não é uma variavel array";
		endif;
			echo("<hr><br>");

			//objeto
			class Alunos{

				public $nome;
				public function nomeAluno($nome){
					$this->$nome = $nome;
				}
			}

			$aluno = new Alunos;
			$aluno->nomeAluno("João");
			var_dump($aluno);

			echo("<hr><br>");

			//NULL
			$saldo = NULL;
			var_dump($saldo);

			echo("<hr><br>");

			//Switch
			$i = 3;

			switch ($i) {
				case 0:
					echo "i é igual a 0";
					break;
				case 1:
					echo "i é igual a 1";
					break;
				case 2:
					echo "i é igual a 2";
					break;
				default:
					echo "i não é igual a 0, 1 ou 2";
			
			//While
			$x=0;
			while($x<=5){
				echo "Numero: $x <br>";
				$x++;
			}

			//do-while

			do{
				echo "Numero: $x \n";
				$x = $x +1;
			} while ($x <= 5);

			//for
			$x = 0;

			for($x = 1; $i <= 10; i++){
				echo $i . "<br>" . "\n";
				echo ("<hr");
			}

			//forma 3
			$cores = array ("Verde"."Amarelo"."Azul"."Vermelho");

			foreach ($cores as $cor) {
				echo "Cor: $cor <br>";
			}
		?>