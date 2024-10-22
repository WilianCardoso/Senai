package dao;

import Tela.Carro;
import Tela.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author wilian_g_cardoso
 */
public class CarroDAO {

    //Conexão com o banco de dados
    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    //Construtor que estabelece a conexão com o banco ao inciar o DAO
    public CarroDAO() {
        this.con = new ConexaoBanco().getConexao();
    }

    //Método para fazer o cadastro de um carro 
    public void cadastrarCar(Carro carro) {
        String sql = "INSERT INTO car(desc_car,pot_car,cor_car)VALUES(?,?,?)"; // SQL para inserir carro
        try ( PreparedStatement ps = con.prepareStatement(sql)) {
            // Definindo os parâmetros da consulta com os atributos do carro
            ps.setInt(2, carro.getPot());
            ps.setString(3, carro.getCor());

            //executa a inserção
            ps.execute();
            ps.close();  // Fecha o PreparedStatement
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o carro!");
        }
    }

    public void removerCar(int idcar) throws SQLException {
        String sql = "DELETE FROM car WHERE cod_car=?"; // SQL para deletar um carro pelo código
        // Abre uma nova conexão temporária e prepara o comando SQL
        try ( Connection connection = new ConexaoBanco().getConexao();  PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idcar);// Define o código do carro a ser excluído
            ps.executeUpdate();// Executa a exclusão
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Não foi possível excluir!");
        }
    }

    public ArrayList<Carro> getCarros() {
        String SQL = "SELECT * FROM car"; // SQL para selecionar todos os carros
        ArrayList<Carro> carros = null; // Lista que armazenará os carros

        // Abre uma nova conexão temporária e prepara o comando SQL
        try ( Connection connection = new ConexaoBanco().getConexao();  PreparedStatement ps = connection.prepareStatement(SQL)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (carros == null) {
                        carros = new ArrayList<>();
                    }
                    Carro carro = new Carro();
                    carro.setCod(rs.getInt("cod_car"));
                    carro.setDesc(rs.getString("desc_car"));
                    carro.setPot(rs.getInt("pot_car"));
                    carro.setCor(rs.getString("cor_car"));
                    carros.add(carro);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carros;
    }

    //Método para alterar a potência de um carro específico no banco de dados.
    public void alterarCar(int cod, int pot) {
        String sql = "UPDATE car SET pot_car = ? WHERE cod_car = ?";// SQL para alterar a potência do carro

        try ( PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pot);
            ps.setInt(2, cod);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

        }
    }

}
