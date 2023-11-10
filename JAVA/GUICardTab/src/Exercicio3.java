import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Exercicio3 extends JFrame {
    public Exercicio3() {
        super("Exercicio 3");
        //Cria workSpace e adiciona ao Frame
        JPanel workSpace = new JPanel(new BorderLayout());
        this.add(workSpace);
        //Painel para adicionar cards
        JPanel cardsPanel = new JPanel();
        //setLayout do cardsPanel
        CardLayout cl = new CardLayout();
        cardsPanel.setLayout(cl);
        //criar os Cards
        JPanel home = new JPanel();
        JPanel login = new JPanel();
        JPanel cadastro = new JPanel();
        //add ao cardsPanel
        cardsPanel.add(home,"Home");
        cardsPanel.add(login,"Login");
        cardsPanel.add(cadastro,"Cadastro");
        //diferenciando os paineis
        //Pagina inicial
        JButton homeButtonLogin = new JButton("Login");
        JButton homeButtonCadastro = new JButton("Cadastro");
        home.add(new JLabel("Página inicial"));
        home.add(homeButtonLogin);
        home.add(homeButtonCadastro);
        //Pagina Login
        JButton loginButtonHome = new JButton("Home");
        JButton loginButtonCadastro = new JButton("Cadastro");
        login.add(new JLabel("Página Login"));
        login.add(loginButtonHome);
        login.add(loginButtonCadastro);
        //Pagina Cadastro
        JButton cadastroButtonHome = new JButton("Home");
        JButton cadastroButtonLogin = new JButton("Login");
        cadastro.add(new JLabel("Página cadastro"));
        cadastro.add(cadastroButtonHome);
        cadastro.add(cadastroButtonLogin);
        //set finais
        workSpace.add(cardsPanel,BorderLayout.CENTER);
        this.add(workSpace);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        //criar as acoes
        homeButtonLogin.addActionListener(e->{
            cl.show(cardsPanel,homeButtonLogin.getText());
        });
        homeButtonCadastro.addActionListener(e->{
            cl.show(cardsPanel,homeButtonCadastro.getText());
        });
        loginButtonHome.addActionListener(e->{
            cl.show(cardsPanel,loginButtonHome.getText());
        });
        loginButtonCadastro.addActionListener(e->{
            cl.show(cardsPanel,loginButtonCadastro.getText());
        });
        cadastroButtonHome.addActionListener(e->{
            cl.show(cardsPanel,cadastroButtonHome.getText());
        });
        cadastroButtonLogin.addActionListener(e->{
            cl.show(cardsPanel,cadastroButtonLogin.getText());
        });
    }
}