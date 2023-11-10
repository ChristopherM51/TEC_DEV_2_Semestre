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

public class AgendamentoUsuarios extends JPanel {
    private JTextField inputNome;
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputObservacoes;
    private DefaultTableModel tableModel;
    private JTable table;

    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    public AgendamentoUsuarios() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Observacoes");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        inputNome = new JTextField(20);
        inputData = new JTextField(8);
        inputHora = new JTextField(5);
        inputObservacoes = new JTextField(20);
        JButton cadastrarButton = new JButton("Agendar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Desmarcar");
        JButton apagarTodosButton = new JButton("Desmarcar Todos");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputObservacoes);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputData.setText(table.getValueAt(linhaSelecionada, 1).toString());
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputObservacoes.setText(table.getValueAt(linhaSelecionada, 1).toString());

                }
            }
        });
        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarUsuario(inputNome.getText(), inputData.getText());
                inputNome.setText("");
                inputData.setText("");
                
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),

                        inputData.getText());

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosUsuarios();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getData() });
        }
    }
}