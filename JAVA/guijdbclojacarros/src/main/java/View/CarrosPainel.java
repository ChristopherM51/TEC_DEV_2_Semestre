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

import Connection.CarrosDAO;
import Controller.CarrosControl;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Carros;

public class CarrosPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField,
            carValorField;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public CarrosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Marca"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Valor"));
        carValorField = new JTextField(20);
        inputPanel.add(carValorField);
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
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carAnoField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 3 )));
                    carValorField.setText(String.valueOf( table.getValueAt(linhaSelecionada, 4)));
                }
            }
        });

        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        // tratamento para botão cadastrar
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(carPlacaField.getText(),
                    carMarcaField.getText(),
                    carModeloField.getText(),
                    Integer.parseInt(carAnoField.getText()),
                    Double.parseDouble(carValorField.getText()));
            carPlacaField.setText("");
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carValorField.setText("");
        });

        // tratamento do botão editar

        editar.addActionListener(e -> {
            operacoes.atualizar(carPlacaField.getText(),
                    carMarcaField.getText(),
                    carModeloField.getText(),
                    Integer.parseInt(carAnoField.getText()),
                    Double.parseDouble(carValorField.getText()));
            carPlacaField.setText("");
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carValorField.setText("");
        });

        // tratamento do botão apagar

        apagar.addActionListener(e -> {
           
                operacoes.apagar(carPlacaField.getText());
                carPlacaField.setText("");
                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carValorField.setText("");
            

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