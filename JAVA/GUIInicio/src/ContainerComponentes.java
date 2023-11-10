import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ContainerComponentes extends JFrame {
    int clickCount = 0;
    public ContainerComponentes(){
        super("JFrame");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I am a Swing button");
        JLabel texto = new JLabel("Number of button clicks: ");
        JPanel painel = new JPanel();
        painel.add(but);
        painel.add(texto);
        this.getContentPane().add(painel);
        this.pack();
        this.setVisible(true);
        but.addActionListener(e ->{
            clickCount++;
            texto.setText("Number of clicks: "+clickCount);
        });
        
    }
}
