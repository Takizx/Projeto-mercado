package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void salvar(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, cpf, admin) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setBoolean(3, u.isAdmin());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao guardar utilizador: " + e.getMessage());
        }
    }

    public Usuario buscar(String nome, String cpf) {
        String sql = "SELECT * FROM usuarios WHERE nome = ? AND cpf = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getString("nome"), 
                    rs.getString("cpf"), 
                    rs.getBoolean("admin")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao procurar utilizador: " + e.getMessage());
        }
        return null; 
    }
}