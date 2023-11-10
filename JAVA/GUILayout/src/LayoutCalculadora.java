import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.*;

public class LayoutCalculadora {
    public LayoutCalculadora() {
        JFrame janelaP= new JFrame ("Janela Calculadora");
        JPanel painelB = new JPanel();
        JPanel painelV = new JPanel();
        //cria novo painel
        BorderLayout border = new BorderLayout();
        //cria Layout Border
        janelaP.setLayout(border);
        //Seta "Border" como Layout
        janelaP.getContentPane().add(painelB,BorderLayout.CENTER);
        janelaP.getContentPane().add(painelV,BorderLayout.NORTH);
        //cria Textfield
        JTextField caixa1 = new JTextField(25);
        //adiciona o textField no PainelV
        painelV.add(caixa1);
        GridLayout grid = new GridLayout(4,4);
        painelB.setLayout(grid);
        String textobotoes[] = {"C","1","2","3","+","4","5","6","-","7","8","9","*","/","0","="};
        for (int i = 0; i < textobotoes.length; i++) {
            painelB.add(new JButton(textobotoes[i]));            
        }
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
    }

    private Component JTextField(int i) {
        return null;
    }
}
