package app;

import Connection.ConnectionDAO;

public class Main {
    public static void main(String[] args) {
        new ConnectionDAO().criarTabela();
        new ConnectionDAO().inserir(1,"Christopher", "chris@gmail.com");
        new ConnectionDAO().atualizarID(1, "Christopher", "chris@gmail.com");
        new ConnectionDAO().buscarPorId(1);
        new ConnectionDAO().apagarID(1);
    }
}