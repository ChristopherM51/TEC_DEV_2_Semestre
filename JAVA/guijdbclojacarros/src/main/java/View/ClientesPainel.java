package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Controller.ClientesControl;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Clientes;

public class ClientesPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField cliNomeField, cliCpfField, cliEmailField, cliTelefoneField,
            cliEnderecoField, cliNumeroField, cliDataNascimentoField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ClientesPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        cliNomeField = new JTextField(20);
        inputPanel.add(cliNomeField);
        inputPanel.add(new JLabel("Cpf"));
        cliCpfField = new JTextField(20);
        inputPanel.add(cliCpfField);
        inputPanel.add(new JLabel("Email"));
        cliEmailField = new JTextField(20);
        inputPanel.add(cliEmailField);
        inputPanel.add(new JLabel("Telefone"));
        cliTelefoneField = new JTextField(20);
        inputPanel.add(cliTelefoneField);
        inputPanel.add(new JLabel("Endereco"));
        cliEnderecoField = new JTextField(20);
        inputPanel.add(cliEnderecoField);
        inputPanel.add(new JLabel("Numero"));
        cliNumeroField = new JTextField(20);
        inputPanel.add(cliNumeroField);
        inputPanel.add(new JLabel("Data de Nascimento"));
        cliDataNascimentoField = new JTextField(20);
        inputPanel.add(cliDataNascimentoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Cpf", "Email", "Telefone", "Endereco", "Numero", "Data de Nascimento" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria o banco de dados caso não tenha sido criado
        new ClientesDAO().criaTabela();
        // incluindo elementos do banco na criação do painel
        atualizarTabela();
        // tratamento de eventos(construtor)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cliNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cliCpfField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 1)));
                    cliEmailField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cliTelefoneField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 3)));
                    cliEnderecoField.setText((String) table.getValueAt(linhaSelecionada, 4));
                    cliNumeroField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 5)));
                    cliDataNascimentoField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 6)));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        // tratamento para botão cadastrar
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(
                    cliNomeField.getText(),
                    Integer.parseInt(cliCpfField.getText()),
                    cliEmailField.getText(),
                    Integer.parseInt(cliTelefoneField.getText()),
                    cliEnderecoField.getText(),
                    Integer.parseInt(cliNumeroField.getText()),
                    Integer.parseInt(cliDataNascimentoField.getText()));
            cliNomeField.setText("");
            cliCpfField.setText("");
            cliEmailField.setText("");
            cliTelefoneField.setText("");
            cliEnderecoField.setText("");
            cliNomeField.setText("");
            cliDataNascimentoField.setText("");
        });

        // tratamento do botão editar

        editar.addActionListener(e -> {
            operacoes.atualizar(
                    cliNomeField.getText(),
                    Integer.parseInt(cliCpfField.getText()),
                    cliEmailField.getText(),
                    Integer.parseInt(cliTelefoneField.getText()),
                    cliEnderecoField.getText(),
                    Integer.parseInt(cliNumeroField.getText()),
                    Integer.parseInt(cliDataNascimentoField.getText()));
            cliNomeField.setText("");
            cliCpfField.setText("");
            cliEmailField.setText("");
            cliTelefoneField.setText("");
            cliEnderecoField.setText("");
            cliNomeField.setText("");
            cliDataNascimentoField.setText("");
        });

        // tratamento do botão apagar

        apagar.addActionListener(e -> {
            operacoes.apagar(cliCpfField.getText());
            cliNomeField.setText("");
            cliCpfField.setText("");
            cliEmailField.setText("");
            cliTelefoneField.setText("");
            cliEnderecoField.setText("");
            cliNomeField.setText("");
            cliDataNascimentoField.setText("");

        });
    }

    // métodos(atualizar tabela)
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new ClientesDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Clientes carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] {
                    carro.getNome(), carro.getCpf(), carro.getEmail(), carro.getTelefone(), carro.getEndereco() });
        }
    }

}