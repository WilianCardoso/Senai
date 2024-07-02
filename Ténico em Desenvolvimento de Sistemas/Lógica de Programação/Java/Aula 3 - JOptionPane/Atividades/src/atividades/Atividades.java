/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividades;

import javax.swing.JOptionPane;

/**
 *
 * @author wilian_g_cardoso
 */
public class Atividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //conversao();
        // rendimento();
        //concessionaria();
        //reajuste();
        gasolina();
    }

    public static void conversao() {
        // TODO code application logic here
        double dollar, real, cotacao;
        cotacao = Double.parseDouble(JOptionPane.showInputDialog("Informe a cotação do dólar"));
        dollar = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade de dólares"));
        real = cotacao * dollar;
        JOptionPane.showMessageDialog(null, "Você tem R$" + real);
    }

    public static void rendimento() {
        double poupanca = 0.009, valor, vl_f;
        valor = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor que deseja investir"));
        vl_f = poupanca * valor;
        JOptionPane.showMessageDialog(null, "O valor que rendeu após um mês foi: " + vl_f);
    }

    public static void concessionaria() {
        double valor, result1, result;
        int ano;
        valor = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor do carro"));
        ano = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ano do carro"));
        if (ano < 2000) {
            result1 = valor * 0.18;
            result = valor - result1;
            JOptionPane.showMessageDialog(null, "O valor a ser pago será de R$" + result + ", e o desconto foi de R$" + result1);
        } else {
            result1 = valor * 0.09;
            result = valor - result1;
            JOptionPane.showMessageDialog(null, "O valor a ser pago será de R$" + result + ", e o desconto foi de R$" + result1);
        }
    }

    public static void reajuste() {
        double vl_salario, result1, result;
        vl_salario = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor do seu salário"));
        if (vl_salario < 3300) {
            result1 = vl_salario * 0.5;
            result = result1 + vl_salario;
            JOptionPane.showMessageDialog(null, "Seu salário ficou R$" + result);
        } else if (vl_salario >= 3000 || vl_salario < 11000) {
            result1 = vl_salario * 0.2;
            result = result1 + vl_salario;
            JOptionPane.showMessageDialog(null, "Seu salário ficou R$" + result);
        } else if (vl_salario > 11000 || vl_salario < 22000) {
            result1 = vl_salario * 0.15;
            result = result1 + vl_salario;
            JOptionPane.showMessageDialog(null, "Seu salário ficou R$" + result);
        } else {
            result1 = vl_salario * 0.1;
            result = result1 + vl_salario;
            JOptionPane.showMessageDialog(null, "Seu salário ficou R$" + result);
        }
    }

    public static void gasolina() {
        double distancia, litros, result;
        distancia = Double.parseDouble(JOptionPane.showInputDialog("Entre com a distância percorrida:"));
        litros = Double.parseDouble(JOptionPane.showInputDialog("Entre com a quantidade de litros gastos:"));
        result = distancia / litros;
        JOptionPane.showMessageDialog(null, "O consumo médio desse automóvel foi de " + result+ "L");
    }

}
