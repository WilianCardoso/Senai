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

    }

    public void removerUsu(int idlogin) throws SQLException {

    }

    public ArrayList<Usuario> getUsuarios() {
        return null;
    }

    public void alterarUsu(int codigo, String password) {

    }

}
