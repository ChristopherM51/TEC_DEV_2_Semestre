package View;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Controller.CarrosControl;
import Controller.VendasControl;
import Model.Carros;
import Model.Clientes;
import Model.Vendas;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendasPainel extends JPanel {
    JComboBox<String> carrosComboBox;
    List<Carros> carros;
    JComboBox<String> clientesComboBox;
    List<Clientes> clientes;
    JButton venderButton = new JButton("Vender");
    JButton editarButton = new JButton("Editar");
    JButton excluirButton = new JButton("Excluir");
    JButton listarVendasButton = new JButton("Listar");

    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public VendasPainel() {
        super();

        clientesComboBox = new JComboBox<>();
        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome()
                    + " " + cliente.getCpf());
        }
        add(clientesComboBox);
        add(listarVendasButton);

        carrosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");

        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getPlaca()
                    + " " + carro.getMarca()
                    + " " + carro.getModelo());
        }
        add(carrosComboBox);
        add(venderButton);
    }

    public void atualizarComboBox() {
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.removeAllItems();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }

        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] {"Placa", "Marca", "Modelo", "Ano",  "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria o banco de dados caso não tenha sido criado
        new CarrosDAO().criaTabela();
        // incluindo elementos do banco na criação do painel
       // atualizarTabela();

    //     // ERROS ABAIXO - EXCLUIR CODIGOS PARA RODAR
    //     // ERROS ABAIXO - EXCLUIR CODIGOS PARA RODAR
    //     // ERROS ABAIXO - EXCLUIR CODIGOS PARA RODAR
    //     // ERROS ABAIXO - EXCLUIR CODIGOS PARA RODAR

    //     // tratamento de Eventos
    //     table.addMouseListener(new MouseAdapter() {
    //         @Override
    //         public void mouseClicked(MouseEvent evt) {
    //             linhaSelecionada = table.rowAtPoint(evt.getPoint());
    //             if (linhaSelecionada != -1) {

    //             }
    //         }
    //     });

    //     // Cria um objeto operacoes da classe CarrosControl para executar operações no
    //     // banco de dados
    //     CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

    //     // Configura a ação do botão "cadastrar" para adicionar um novo registro no
    //     // banco de dados

    //     venderButton.addActionListener(e -> {
    //         // String marca = carMarcaField.getText();
    //         // String modelo = carModeloField.getText();
    //         // String anoStr = carAnoField.getText();
    //         // String placa = carPlacaField.getText();
    //         // String valorStr = carValorField.getText();

    //         // Verifica se os campos obrigatórios não estão vazios
    //         // if (marca.isEmpty() || modelo.isEmpty() || anoStr.isEmpty() || placa.isEmpty() || valorStr.isEmpty()) {
    //         //     // Exibe uma mensagem de erro ao usuário
    //         //     JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro de Cadastro",
    //         //             JOptionPane.ERROR_MESSAGE);
    //         //     return;
    //         // }

    //         try {
    //             // int ano = Integer.parseInt(anoStr);
    //             // double valor = Double.parseDouble(valorStr);
    //             // operacoes.cadastrar(marca, modelo, Integer.toString(ano), placa, Double.toString(valor));
    //             // // Limpa os campos após o cadastro bem-sucedido
    //             // carMarcaField.setText("");
    //             // carModeloField.setText("");
    //             // carAnoField.setText("");
    //             // carPlacaField.setText("");
    //             // carValorField.setText("");
    //         } catch (NumberFormatException ex) {
    //             // Exibe uma mensagem de erro ao usuário se houver problemas na conversão
    //             JOptionPane.showMessageDialog(this, "Ano e Valor devem ser números válidos.", "Erro de Cadastro",
    //                     JOptionPane.ERROR_MESSAGE);
    //         }
    //     });

    //     // Tratamento do botao editar
    //     editarButton.addActionListener(e -> {
    //         Object[] options = { "   Sim   ", "   Não   " };
    //         int n = JOptionPane.showOptionDialog(
    //                 null,
    //                 "Deseja realmente atualizar o cadastro?",
    //                 "Confirmar edição de cadastro?",
    //                 JOptionPane.YES_NO_OPTION,
    //                 JOptionPane.WARNING_MESSAGE,
    //                 null,
    //                 options,
    //                 options[1]);

    //         // if (n == 0) {
    //         //     operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(),
    //         //             carAnoField.getText(), carPlacaField.getText(), carValorField.getText());

    //         //     // Limpa os campos após a atualização, independentemente do sucesso ou falha
    //         //     carMarcaField.setText("");
    //         //     carModeloField.setText("");
    //         //     carAnoField.setText("");
    //         //     carPlacaField.setText("");
    //         //     carValorField.setText("");
    //         // }
    //     });
    // }

    // // Metodos (Atualizar tabela)
    // // Método para atualizar a tabela de exibição com dados do banco de dados
    // private void atualizarTabela() {
    //     tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    //     carros = new CarrosDAO().listarTodos();
    //     // Obtém os carros atualizados do banco de dados
    //     NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    //     for (Carros carro : carros) {
    //         // Formata o valor como moeda
    //         String valorFormatado = currencyFormat.format(Double.parseDouble(carro.getValor()));

    //         // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    //         tableModel.addRow(new Object[] {
    //                 carro.getMarca(),
    //                 carro.getModelo(),
    //                 carro.getAno(),
    //                 carro.getPlaca(),
    //                 valorFormatado // Adiciona o valor formatado como moeda
    //         });
    //     }
    // }
}
}