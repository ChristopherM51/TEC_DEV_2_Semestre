package Controller;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.VendasDAO;
import Model.Vendas;

public class VendasControl {
    //
    // atributos
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    //
    // contrutor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    //
    // métodos do modelo CRUD
    //
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        // Obtém os vendas atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada vendas como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] {
                    venda.getComprador(), venda.getCarroVendido(), venda.getMetodoPagamento()});
        }
    }

    //
    // Método para registar um novo vendas no banco de dados
    public void registar(String comprador, String carroVendido, String metodoPagamento ) {
        Object[] options = { "NÃO", "SIM" };
        int acao = JOptionPane.showOptionDialog(
                null,
                "Deseja registar nova venda?",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (acao == 1) {
            new VendasDAO().registar(comprador, carroVendido, metodoPagamento);
            //
            // Chama o método de cadastro no banco de dados
            JOptionPane.showMessageDialog(null, "Venda concluida com sucesso");
            atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
        } else {
            JOptionPane.showMessageDialog(null, "Venda cancelada");
        }
    }

    //
    // Método para atualizar os dados de um vendas no banco de dados
    public void atualizar(String comprador, String carroVendido, String metodoPagamento) {
        new VendasDAO().atualizar(comprador, carroVendido, metodoPagamento);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }
}
