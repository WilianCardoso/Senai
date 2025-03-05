/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.calculadora;

/**
 *
 * @author wilian_g_cardoso
 */
public class Calculadora {

    public double soma(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;

    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throws new IllegalArgumentException("Divisão por zero não é permitida!");
        }
        return a / b;
    }

    public double pot(double a, double b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double resultadoSoma = calculadora.soma(1, 2);
        double resultadoSubtracao = calculadora.subtrair(1, 2);

        if (resultadoSoma == 3) {
            System.out.println("Correto!!");
        } else {
            System.out.println("Errado!!!");
        }
        if (resultadoSubtracao == -1) {
            System.out.println("Correto!!");
        } else {
            System.out.println("Errado!!!");
        }
    }
}
