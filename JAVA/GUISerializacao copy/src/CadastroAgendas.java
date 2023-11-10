import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CadastroAgendas extends JPanel {
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputUsuario;
    private JTextField inputDescricao;
    private DefaultTableModel tableModel;
    private JTable table;

    private List<Agenda> agendas = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroAgendas() {
        //
        // construção da tabela de agendas
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Descricao");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        //
        // adicionar componentes
        inputData = new JTextField(8);
        inputHora = new JTextField(5);
        inputUsuario = new JTextField(20);
        inputDescricao = new JTextField(20);
        //
        // cria botões
        JButton cadastrarButton = new JButton("Agendar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Desmarcar");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        // adiciona botões e componentes ao painel
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Usuario:"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);
        //
        // set layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        //
        // verifica se doc txt ja existe
        // File arquivo = new File("dados.txt");
        // if (arquivo.exists()) {
            // usuarios = Serializacao.deserializar("dados.txt");
            // atualizarTabela();
        // }

        // tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());                
            }
        });
        // chamando obj da classe operações
        OperacoesAgendas operacoes = new OperacoesAgendas(agendas, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.CadastroAgendas(inputData.getText(),inputHora.getText(),inputUsuario.getText(),inputDescricao.getText() );
                inputData.setText("");
                inputHora.setText("");
                inputUsuario.setText("");
                inputDescricao.setText("");
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarAgendas(linhaSelecionada, inputData.getText(),inputHora.getText(),inputUsuario.getText(),inputDescricao.getText() );
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarAgendas(linhaSelecionada);
            }
        });
        // salvarButton.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
                // operacoes.salvarUsuarios();
            // }
        // });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agenda agenda : agendas) {
            tableModel.addRow(new Object[] { inputData.getText(),inputHora.getText(),inputUsuario.getText(),inputDescricao.getText()});
        }
    }
}