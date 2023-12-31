package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

public class CarrosControl {
    //
    // atributos
    private List<Carros> carros;
    private DefaultTableModel tableModel;
    private JTable table;
    //
    // contrutor
    public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros;
        this.tableModel = tableModel;
        this.table = table;
    }

    //
    // métodos do modelo CRUD
    //
    // Método para atualizar a tabela de exibição com dados do banco de dados
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

    //
    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String placa, String marca, String modelo, int ano, double valor) {
        Object[] options = { "NÃO", "SIM" };
        int acao = JOptionPane.showOptionDialog(
                null,
                "Deseja cadastrar novo veiculo?",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (acao == 1) {
            new CarrosDAO().cadastrar(placa, marca, modelo, ano, valor);
            //
            // Chama o método de cadastro no banco de dados
            atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
            JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado");
        }
    }

    //
    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String placa, String marca, String modelo, int ano, double valor) {
        new CarrosDAO().atualizar(placa, marca, modelo, ano, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    //
    // Método para apagar um carro do banco de dados
    public void apagar(String placa) {
        Object[] options = { "NÃO", "SIM" };
        int acao = JOptionPane.showOptionDialog(
                null,
                "Tem Certeza que deseja Excluir?",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (acao == 1) {
            new CarrosDAO().apagar(placa);
            // Chama o método de exclusão no banco de dados
            atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
            JOptionPane.showMessageDialog(null, "Cadastro excluido");
        } else {
            JOptionPane.showMessageDialog(null, "Ação cancelada");
        }
    }

}
