import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio5 extends JFrame {
    int pontuacao = 0;
    public Exercicio5() {
        super("Quiz");
        // Cria pagina workSpace
        JPanel workSpace = new JPanel(new BorderLayout());
        this.add(workSpace);
        // Cria painel para as paginas das perguntas
        JPanel painelDePerguntas = new JPanel();
        // setlayout do painelDePerguntas
        CardLayout cl = new CardLayout();
        painelDePerguntas.setLayout(cl);
        // Criar cards das perguntas
        JPanel iniciar = new JPanel();
        JPanel q1 = new JPanel();
        JPanel q2 = new JPanel();
        JPanel q3 = new JPanel();
        JPanel q4 = new JPanel();
        JPanel q5 = new JPanel();
        // Criar card de resultado
        JPanel resultado = new JPanel();
        // Adiciona cards de perguntas ao painel de perguntas
        painelDePerguntas.add(iniciar,"Iniciar");
        painelDePerguntas.add(q1, "Questão 1");
        painelDePerguntas.add(q2, "Questão 2");
        painelDePerguntas.add(q3, "Questão 3");
        painelDePerguntas.add(q4, "Questão 4");
        painelDePerguntas.add(q5, "Questão 5");
        painelDePerguntas.add(resultado, "Resultado");
        //construir preenchimento de cada card
        //Pagina Inicial
        JButton start = new JButton("Start");
        iniciar.add(new JLabel("Presione Start para iniciar"));
        iniciar.add(start);
        //Questão 1
        JButton next1 = new JButton("Next1");
        q1.add(new JLabel("Quanto é 4x4?"));
        JTextField respostaPergunta1 = new JTextField(5);
        q1.add(next1);
        q1.add(respostaPergunta1);
        //Questão 2
        JButton next2 = new JButton("Next2");
        q2.add(new JLabel("Quanto é 4x6?"));
        JTextField respostaPergunta2= new JTextField(5);
        q2.add(next2);
        q2.add(respostaPergunta2);
        //Questão 3
        JButton next3 = new JButton("Next3");
        q3.add(new JLabel("Quanto é 4x8?"));
        JTextField respostaPergunta3= new JTextField(5);
        q3.add(next3);
        q3.add(respostaPergunta3);
        //Questão 4
        JButton next4 = new JButton("Next4");
        q4.add(new JLabel("Quanto é 4x12?"));
        JTextField respostaPergunta4= new JTextField(5);
        q4.add(next4);
        q4.add(respostaPergunta4);
        //Questão 5
        JButton next5 = new JButton("Next5");
        q5.add(new JLabel("Quanto é 4x17?"));
        JTextField respostaPergunta5= new JTextField(5);
        q5.add(next5);
        q5.add(respostaPergunta5);
        //Resultado
        JButton jogarNovamente = new JButton("Jogar Novamente");
        JLabel resultadoFinal = new JLabel();
        resultado.add(new JLabel("Sua pontuacao foi:"));
        resultado.add(resultadoFinal);
        resultado.add(jogarNovamente);
        //sets fianis
        workSpace.add(painelDePerguntas,BorderLayout.CENTER);
        this.add(workSpace);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        //
        start.addActionListener(e->{
            cl.next(painelDePerguntas);
        });
        next1.addActionListener(e->{
            if (respostaPergunta1.getText().equals("16")){
               pontuacao+=1;
            }
            cl.next(painelDePerguntas);
        });
        next2.addActionListener(e->{
            if (respostaPergunta1.getText().equals("24")){
                pontuacao+=1;
            }
            cl.next(painelDePerguntas);
        });
        next3.addActionListener(e->{
            if (respostaPergunta1.getText().equals("32")){
                pontuacao+=1;
            }
            cl.next(painelDePerguntas);
        });
        next4.addActionListener(e->{
            if (respostaPergunta1.getText().equals("48")){
                pontuacao+=1;
            }
            cl.next(painelDePerguntas);
        });
        next5.addActionListener(e->{
            if (respostaPergunta1.getText().equals("68")){
                pontuacao+=1;
            }
            resultadoFinal.setText("" +pontuacao);
            cl.next(painelDePerguntas);
        });
        jogarNovamente.addActionListener(e->{
            cl.first(painelDePerguntas);
        });
    }
}
