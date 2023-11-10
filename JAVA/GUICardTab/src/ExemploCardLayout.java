import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class ExemploCardLayout extends JFrame {
    //Construtor
    public ExemploCardLayout() {
        super("Exemplo de CardLayout");
        JPanel painel1 = new JPanel();//Principal
        //Elemento de seleção dos Cards JComboBox
        String itensCB[] = {"Card 1","Card 2"};
        JComboBox cb = new JComboBox<>(itensCB);
        painel1.add(cb);
        //criar os cards
        JPanel cards = new JPanel();//Card principal - vai permitir a navegação
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        //Criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão 1"));
        card1.add(new JButton("Botão 2"));
        card1.add(new JButton("Botão 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("Card com Jtext",20));
        //add cards a pilha
        cards.add(card1,itensCB[0]);
        cards.add(card2,itensCB[1]);
        painel1.add(cards);
        this.add(painel1);
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,300,300);
        this.setVisible(true);
        //Criar a ação para o ComboBox
        cb.addItemListener(e->{
            cl.show(cards, (String) e.getItem());
        });

    }
}