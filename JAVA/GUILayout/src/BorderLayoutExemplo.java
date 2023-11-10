import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExemplo {
    public BorderLayoutExemplo(){
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        BorderLayout border = new BorderLayout(); //cria config de Layout
        janelaP.setLayout(border); //Aplica config de Layout
        janelaP.add(new JButton("West"),BorderLayout.WEST);
        janelaP.add(new JButton("NORTH"),BorderLayout.NORTH);
        janelaP.add(new JButton("EAST"),BorderLayout.EAST);
        janelaP.add(new JButton("SOUTH"),BorderLayout.SOUTH);
        janelaP.add(new JButton("CENTER"),BorderLayout.CENTER);
        //set JFrame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
    }
}
