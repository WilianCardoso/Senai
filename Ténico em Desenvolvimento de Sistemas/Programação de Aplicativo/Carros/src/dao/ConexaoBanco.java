/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author wilian_g_cardoso
 */
public class ConexaoBanco {
    public Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbcarro","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco!");
        }
        return null;
    }
}
