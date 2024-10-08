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
    
    public UsuarioDAO(){
        this.con = new ConexaoBanco().getConexao();
    }
    
    public Usuario logar(String email, String senha){
     return null;
    }
    
    public void cadastrarUsu(Usuario usuario){
        
    }
    
    public void removerUsu(int idlogin)throws SQLException{
        
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return null;
    }
    
    public void alterarUsu(int codigo, String password){
        
    }
    
}
