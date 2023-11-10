package Calculadora;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora extends JFrame {
    public Calculadora() {
        super("Calculadora");
        // colocar e posicionar 16 botoes
        this.setBounds(200, 200, 400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        this.setLayout((LayoutManager) flow);
        int m = 1;
        for (int i = 1; i <= 4; i++) {
            JPanel painel = new JPanel();
            painel.setSize(400, 100);
            this.setContentPane(painel);
            for (int j = 1; j <= 16; j++) {
                JButton but = new JButton("" + m);
                but.setSize(90, 90);
                this.add(but);
                m++;
            }
            this.setVisible(true);
        }
    }
}
