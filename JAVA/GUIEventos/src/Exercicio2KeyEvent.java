import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio2KeyEvent extends JFrame {
    public Exercicio2KeyEvent() {
        super("Exercicio2");
        // Cria janela principal
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        // Cria campo de texto de descrição
        mainPanel.add(new JLabel("Digite seu Texto:"));
        JLabel texto2 = new JLabel();
        mainPanel.add(texto2);
        // Cria caixa de texto
        JTextField texto = new JTextField(20);
        // Cria campo de texto de saida
        mainPanel.add(new JLabel("Seu texto:"));
        mainPanel.add(texto);
        JLabel textoTranscricao = new JLabel();
        // Adiciona a janela principal
        mainPanel.add(textoTranscricao);
        // Set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,300,200);
        this.setVisible(true);
        // Tratamento de eventos
        texto.addKeyListener (new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e ){
                char typedKey = e.getKeyChar();
                textoTranscricao.setText(texto.getText());
                texto2.setText(""+typedKey);
            }
            @Override
            public void keyPressed(KeyEvent e){
                //Este método é chamado quando uma tecla é pressionada
            }
            @Override
            public void keyReleased(KeyEvent e){
                // Este método é chamado quando uma tecla é liberada
            }
        });
    }
}
