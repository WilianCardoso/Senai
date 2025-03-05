/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author wilian_g_cardoso
 */
public class CalculadoraTest {

    public CalculadoraTest() {
    }

    @Test
    void testSoma() {
        Calculadora c = new Calculadora();
        Assertions.assertEquals(5.3, c.soma(2.3, 3));
    }

    @Test
    void testSub() {
        Calculadora c = new Calculadora();
        Assertions.assertEquals(-1, c.subtrair(2, 3));
    }

    @Test
    void testDiv() {
        Calculadora c = new Calculadora();

        Assertions.assertEquals(2, c.div(8, 4));
    }

    @Test
    void testDivPorZero() {
        Calculadora c = new Calculadora();
        Exception exception = Assertions.assertThrows(
                IllegalAccessError.class, () -> {
                    c.div(3, 0);
                });
        Assertions.assertEquals(3, c.div(3, 0));
    }

    @Test
    void testPot() {
        Calculadora c = new Calculadora();
        Assertions.assertEquals(8, c.pot(2, 3));
    }

    @Test
    void testMult() {
        Calculadora c = new Calculadora();
        Assertions.assertEquals(6, c.mult(2, 3));
    }
}
