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
            cliEnderecoField, ;
    private List<Clientes> carros;
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
        inputPanel.add(new JLabel("Placa"));
        cliTelefoneField = new JTextField(20);
        inputPanel.add(cliTelefoneField);
        inputPanel.add(new JLabel("Marca"));
        cliNomeField = new JTextField(20);
        inputPanel.add(cliNomeField);
        inputPanel.add(new JLabel("Modelo"));
        cliCpfField = new JTextField(20);
        inputPanel.add(cliCpfField);
        inputPanel.add(new JLabel("Ano"));
        cliEmailField = new JTextField(20);
        inputPanel.add(cliEmailField);
        inputPanel.add(new JLabel("Valor"));
        cliEnderecoField = new JTextField(20);
        inputPanel.add(cliEnderecoField);
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
                new String[] { "Placa", "Marca", "Modelo", "Ano", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria o banco de dados caso não tenha sido criado
        new CarrosDAO().criaTabela();
        // incluindo elementos do banco na criação do painel
        atualizarTabela();
        // tratamento de eventos(construtor)
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cliTelefoneField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cliNomeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cliCpfField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cliEmailField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 3 )));
                    cliEnderecoField.setText(String.valueOf( table.getValueAt(linhaSelecionada, 4)));
                }
            }
        });

        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        // tratamento para botão cadastrar
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(cliTelefoneField.getText(),
                    cliNomeField.getText(),
                    cliCpfField.getText(),
                    Integer.parseInt(cliEmailField.getText()),
                    Double.parseDouble(cliEnderecoField.getText()));
            cliTelefoneField.setText("");
            cliNomeField.setText("");
            cliCpfField.setText("");
            cliEmailField.setText("");
            cliEnderecoField.setText("");
        });

        // tratamento do botão editar

        editar.addActionListener(e -> {
            operacoes.atualizar(cliTelefoneField.getText(),
                    cliNomeField.getText(),
                    cliCpfField.getText(),
                    Integer.parseInt(cliEmailField.getText()),
                    Double.parseDouble(cliEnderecoField.getText()));
            cliTelefoneField.setText("");
            cliNomeField.setText("");
            cliCpfField.setText("");
            cliEmailField.setText("");
            cliEnderecoField.setText("");
        });

        // tratamento do botão apagar

        apagar.addActionListener(e -> {
           
                operacoes.apagar(cliTelefoneField.getText());
                cliTelefoneField.setText("");
                cliNomeField.setText("");
                cliCpfField.setText("");
                cliEmailField.setText("");
                cliEnderecoField.setText("");
            

        });
    }

    // métodos(atualizar tabela)
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] {
                    carro.getPlaca(), carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getValor() });
        }
    }

}