import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacoesAgendamento {
    // atributos
    private List<Usuario> Agendamento;
    private DefaultTableModel tableModel;
    private JTable table;
    // construtor
    public OperacoesAgendamento(List<Usuario> Agendamento, DefaultTableModel tableModel, JTable table) {
        this.Agendamento = Agendamento;
        this.tableModel = tableModel;
        this.table = table;
    }
    // metodos do crud
    public void cadastrarUsuario(String nome, String data, String hora, String observacao) {
        int dataInt = Integer.parseInt(data);
        Usuario usuario = new Usuario(nome, dataInt);
        Agendamento.add(usuario);
        atualizarTabela();
    }

    public void atualizarUsuario(int linhaSelecionada, String nome, String data) {
        if (linhaSelecionada != -1) {
            int dataInt = Integer.parseInt(data);
            Usuario usuario = new Usuario(nome, dataInt);
            Agendamento.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

    public void apagarUsuario(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            Agendamento.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    public void apagarTodosAgendamento() {
        Agendamento.clear();
        atualizarTabela();
    }

    public void salvarAgendamento() {
        Serializacao.serializar("dados.txt", Agendamento);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : Agendamento) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getdata() });
        }
    }
}