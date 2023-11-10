package TryCatch;

import javax.swing.JOptionPane;

public class exemploThrow {
    public static void main(String[] args) {
        // digitação de senhas
        boolean testeSenha = true;
        String user = JOptionPane.showInputDialog(null, "Informe um nome de usuario");
        while (testeSenha) {
            String senha = JOptionPane.showInputDialog(null, "Informe uma senha de 6 digitos"
            +"\nA senha precisa ser diferente no nome de login"
            +"\nE da data de nasciemnto");
            try {
                if (senha.length() != 6 ) {
                    throw new Exception("Senha invalida, digite uma senha de 6 digitos");
                }
            String dataNascimento = JOptionPane.showInputDialog(null, "Informe a data de nascimento [dd/mm/aa]");
            dataNascimento = dataNascimento.replace("/", "");
            
                if (senha.equals(user)){
                    throw new Exception("Senha invalida, digite uma senha diferente do nome de usuario");
                }
                if (senha.equals(dataNascimento)){
                    throw new Exception("Senha invalida, digite uma senha diferente da data de nascimento");
                }
                testeSenha = false;
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                
            }
        }
    }
}


