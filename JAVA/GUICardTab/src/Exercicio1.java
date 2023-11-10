import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class Exercicio1 extends JFrame {
    //Construtor
    public Exercicio1() {
        super("Exercicio 1");
        JPanel painel1 = new JPanel();//Principal
        String itensCB[] = {"Card 1","Card 2", "Card 3"};
        JButton cb = new JButton("Next");
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
        card2.add(new JButton("Botão 2"));
        card2.add(new JButton("Botão 3"));
        card2.add(new JButton("Botão 1"));
        JPanel card3 = new JPanel();
        card3.add(new JButton("Botão 3"));
        card3.add(new JButton("Botão 2"));
        card3.add(new JButton("Botão 1"));
        //add cards a pilha
        //Pode ser chamado pela posição ou pelo nome do elemento no vetor
        cards.add(card1,"Card 1");//Chama pelo nome
        cards.add(card2,itensCB[1]);//Chama pela posição no vetor
        cards.add(card3,itensCB[2]);
        painel1.add(cards);
        this.add(painel1);
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,300,300);
        this.setVisible(true);
        //Criar a ação para o ComboBox
        cb.addActionListener(e->{
            cl.next(cards);
        });

    }
}