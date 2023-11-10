import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Container extends JFrame {
    public Container() {
        this.setBounds(50, 100, 400, 150);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);// seta a posição e o tamanho da janela
        FlowLayout flow = new FlowLayout();// Define o layout do container
        this.setLayout(flow);// Seta layout do container
        for (int i = 1; i <= 6; i++)
            this.add(new JButton("aperte " + i));// Adiciona um botão
        this.setVisible(true);// Exibe a janela
    }

}
