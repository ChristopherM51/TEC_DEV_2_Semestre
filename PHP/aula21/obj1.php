<?php

    class Login{
        
        private $usuario;
        private $senha;

        // Getters / Setters
        public function getUsuario(){
            return $this->usuario;
        }
        public function setUsuario($user){
            $this->usuario = $user;
        }
        public function getSenha(){
            return $this->senha;
        }
        public function setSenha($pass){
            $this->senha = $pass;
        }
        public function Logar(){
            if ($this->usuario =="userphp" and $this->senha == "1234"):
                echo "Logado com sucesso!";
        else:
            echo "Dados inválidos";
        endif;
        }
    }
    $logar = new Login();
    // $logar->usuario = "userphp";
    // $logar->senha = "1234";
    $logar->setUsuario("userphp");
    $logar->setSenha("1234");
    $logar->Logar();

    echo "<br>"."Usuario: ";
    echo $logar->getUsuario();
    echo "<br>"."Senha: ";
    echo $logar->getSenha();
?>