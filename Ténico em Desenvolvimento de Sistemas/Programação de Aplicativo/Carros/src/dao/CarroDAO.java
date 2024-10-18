package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wilian_g_cardoso
 */
public class CarroDAO {
        private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    public CarroDAO() {
        this.con = new ConexaoBanco().getConexao();
    }
}
