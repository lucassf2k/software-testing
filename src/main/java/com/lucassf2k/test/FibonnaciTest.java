package com.lucassf2k.test;

import com.lucassf2k.main.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonnaciTest {
    // ----- Casos inválidos (partição: n < 0) -----

    @Test
    void testNegativeInputBeyondBoundary() {
        assertThat(Fibonacci.calculate(-10)).isEqualTo(-1);
    }

    @Test
    void testNegativeInputAtBoundary() {
        assertThat(Fibonacci.calculate(-1)).isEqualTo(-1);
    }

    // ----- Caso base válido (n == 0) -----

    @Test
    void testZeroInput() {
        assertThat(Fibonacci.calculate(0)).isEqualTo(0);
    }

    // ----- Casos especiais válidos (n == 1 ou 2) -----

    @Test
    void testOneInput() {
        assertThat(Fibonacci.calculate(1)).isEqualTo(1);
    }

    @Test
    void testTwoInput() {
        assertThat(Fibonacci.calculate(2)).isEqualTo(1);
    }

    // ----- Casos válidos gerais (3 ≤ n ≤ 46) -----

    @Test
    void testThreeInput() {
        assertThat(Fibonacci.calculate(3)).isEqualTo(2);
    }

    @Test
    void testTenInput() {
        assertThat(Fibonacci.calculate(10)).isEqualTo(55);
    }

    @Test
    void testUpperValidBoundary() {
        assertThat(Fibonacci.calculate(46)).isEqualTo(1836311903);
    }

    // ----- Casos inválidos acima do limite (n > 46) -----

    @Test
    void testFirstInvalidAboveUpperBoundary() {
        assertThat(Fibonacci.calculate(47)).isEqualTo(-1);
    }

    @Test
    void testFarBeyondUpperBoundary() {
        assertThat(Fibonacci.calculate(100)).isEqualTo(-1);
    }
}
