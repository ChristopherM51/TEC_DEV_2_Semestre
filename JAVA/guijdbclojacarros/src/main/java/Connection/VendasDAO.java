package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Carros;
import Model.Vendas;

/**
 * VendasDAO
 */
public class VendasDAO {
    // atributo
    private Connection connection;
    private List<Vendas> vendas;

    // construtor
    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas_lojacarros (COMPRADOR VARCHAR(255) PRIMARY KEY, CARRO_VENDIDO VARCHAR(255), METODO_PAGAMENTO VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Vendas> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        vendas = new ArrayList<>();
        // Cria uma lista para armazenar as vendas recuperadas do banco de dados
        try {
            String sql = "SELECT * FROM vendas_lojacarros";
            stmt = connection.prepareStatement(sql);
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro

                Vendas venda = new Vendas(
                        rs.getString("comprador"),
                        rs.getString("carro_Vendido"),
                        rs.getString("metodo_pagamento"));
                vendas.add(venda);// Adiciona o objeto Carros à lista de carros
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return vendas; // Retorna a lista de carros recuperados do banco de dados
    }

    // registar venda no banco
    public void registar(String comprador, String carroVendido, String metodoPagamento) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para registar na tabela
        String sql = "INSERT INTO vendas_lojacarros (comprador, carro_Vendido, metodo_Pagamento) VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, comprador);
            stmt.setString(2, carroVendido);
            stmt.setString(3, metodoPagamento);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String comprador, String carroVendido, String metodoPagamento) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela comprador
        String sql = "UPDATE vendas_lojacarros SET carro_vendido = ?, metodo_Pagamento = ?, WHERE comprador = ?";
        try {
            stmt = connection.prepareStatement(sql);
            // comprador é chave primaria não pode ser alterada.
            stmt.setString(1, comprador);
            stmt.setString(2, carroVendido);
            stmt.setString(3, metodoPagamento);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String comprador) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo comprador
        String sql = "DELETE FROM vendas_lojacarros WHERE comprador = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, comprador);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {

            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
