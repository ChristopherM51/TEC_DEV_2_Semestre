package TryCatch;

import javax.swing.JOptionPane;

public class exemplo {

    public static void main(String[] args) {
        //
        double numero1 = 0;
        double numero2 = 0;
        boolean rodando = true;
        while (rodando) {
            try {
                numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Numero"));
                rodando = false;
            } catch (NumberFormatException erro1) {
                JOptionPane.showMessageDialog(null, "Erro - Digite um valor valido");
            }
        }
        //
        String[] options = { "+", "-", "x", "/", "Sair" };
        int operacao = JOptionPane.showOptionDialog(null, "Escolha a Operação", "CALCULADORA",
                JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, options[0]);
        //
        rodando = true;
        while (rodando) {
            try {
                numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Numero"));
                rodando = false;
            } catch (ArithmeticException erro2) {
                JOptionPane.showMessageDialog(null, "Divisão por Zero não é permitida!");
            } catch (NumberFormatException erro1) {
                JOptionPane.showMessageDialog(null, "Erro - Digite um valor valido");
            }
            if (operacao == 0) {
                JOptionPane.showMessageDialog(null, "O resultado é "
                        + (numero1 + numero2));
            } else if (operacao == 1) {
                JOptionPane.showMessageDialog(null, "O resultado é "
                        + (numero1 - numero2));
            } else if (operacao == 2) {
                JOptionPane.showMessageDialog(null, "O resultado é "
                        + (numero1 * numero2));
            } else if (operacao == 3) {
                JOptionPane.showMessageDialog(null, "O resultado é "
                        + (numero1 / numero2));
            } else {
                rodando = false;
            }
        }
    }
}
