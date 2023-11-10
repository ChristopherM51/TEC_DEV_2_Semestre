import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploNomeSobrenome extends JFrame {
    // Atributos 
    public JTextField caixa1;
    public JTextField caixa2;
    public JLabel texto;

    // Construtor
    public ExemploNomeSobrenome() {
        super("Nome Sobrenome");
        // criar painel principal
        JPanel mainPainel = new JPanel(new GridLayout(3, 2));
        this.add(mainPainel);
        // Criar os componentes
        // Nome
        mainPainel.add(new JLabel("Nome:"));
        //JTextField 
        caixa1 = new JTextField();
        mainPainel.add(caixa1);
        // Sobrenome
        mainPainel.add(new JLabel("Sobrenome"));
        //JTextField 
        caixa2 = new JTextField();
        mainPainel.add(caixa2);
        // Botao
        JButton botao = new JButton("Concatenar");
        mainPainel.add(botao);
        // texto final
        //JLabel 
        texto = new JLabel();
        mainPainel.add(texto);
        // Set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        this.setVisible(true);
        // tratamento de eventos
        // 1º forma: e->{}
        // botao.addActionListener(e->{
        // Concatenar o texto das caixas
        // texto.setText(caixa1.getText()+" "+caixa2.getText());
        // Apagar o texto das caixas
        // caixa1.setText("");
        // caixa2.setText("");
        // });
        // 2ª Forma: Chamar evento
        // botao.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e){
        // Concatena o texto das caixas
        // texto.setText(caixa1.getText() + " " + caixa2.getText());
        // Apagar o texto das caixas
        // caixa1.setText("");
        // caixa2.setText("");
        // }
        // });
        // 3ª forma: Chamando pelo Handler(manipulador)
        Handler evento = new Handler();
        botao.addActionListener(evento);
    }

    public class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Concatenar o texto das caixas
            texto.setText(caixa1.getText() + " " + caixa2.getText());
            // Apagar o texto das caixas
            caixa1.setText("");
            caixa2.setText("");
        }
    }
}