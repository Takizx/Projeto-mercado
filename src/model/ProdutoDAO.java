package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public void salvar(Produto p) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao guardar produto: " + e.getMessage());
        }
    }

    public ArrayList<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
                );
                produtos.add(p);
            }
            
        } catch (SQLException e) {
             System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public void atualizarEstoque(int idProduto, int quantidadeComprada) {
        String sql = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, quantidadeComprada);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar estoque: " + e.getMessage());
        }
    }
}