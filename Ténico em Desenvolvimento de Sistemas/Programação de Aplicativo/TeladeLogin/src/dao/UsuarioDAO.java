/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Telas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wilian_g_cardoso
 */
public class UsuarioDAO {

    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    public UsuarioDAO() {
        this.con = new ConexaoBanco().getConexao();
    }

    public Usuario logar(String email, String senha) {
        Usuario usuario = null;
        String sql = "select* from login where nom_login = ? and pas_login = ?";

        try (Connection connection = new ConexaoBanco().getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setUsu(rs.getString("nom_login"));
                    usuario.setPass(rs.getString("pas_login"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public void cadastrarUsu(Usuario usuario) {
        String sql = "insert into login(user_login,nom_login,pas_login)values(?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(2, usuario.getNome());
            ps.setString(1, usuario.getUsu());
            ps.setString(3, usuario.getPass());

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuario!");
        }
    }

    public void removerUsu(int idlogin) throws SQLException {
        String sql = "Delete from login where cod_login=?";
        try (Connection connection = new ConexaoBanco().getConexao();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idlogin);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Não foi possível excluir!");
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        String SQL = "Select * from login";
        ArrayList<Usuario> usuarios = null;

        try (Connection connection = new ConexaoBanco().getConexao();
                PreparedStatement ps = connection.prepareStatement(SQL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (usuarios == null) {
                        usuarios = new ArrayList<>();
                    }
                    Usuario usuario = new Usuario();
                    usuario.setCod(rs.getInt("cod_login"));
                    usuario.setNome(rs.getString("nom_login"));
                    usuario.setUsu(rs.getString("user_login"));
                    usuario.setPass(rs.getString("pas_login"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    public void alterarUsu(int codigo, String password) {
        String sql = "update login set pas_login = ? cod_login = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, password);
            ps.setInt(2, codigo);
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            
        }
    }

}
