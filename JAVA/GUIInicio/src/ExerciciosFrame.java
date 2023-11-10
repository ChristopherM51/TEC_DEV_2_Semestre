import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ExerciciosFrame extends JFrame {
    public ExerciciosFrame() {
        this.setBounds(50, 100, 4000, 1500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);// seta a posição e o tamanho da janela
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);// Define o layout do containerFlowLayout (FlowLayout.LEFT);// Define o layout do container
        JLabel label = new JLabel("Qualquer coisa");
        this.add(label);
        JTextField campo = new JTextField(15);
        this.add(campo);//Redimensiona a janela
        this.setLayout(flow);// Seta layout do container
        for (int i = 1; i <= 6; i++)
            this.add(new JButton("aperte " + i));// Adiciona um botão
        this.setVisible(true);// Exibe a janela
    }
}