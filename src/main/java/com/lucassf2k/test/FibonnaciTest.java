package com.lucassf2k.test;

import com.lucassf2k.main.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonnaciTest {
    @Test
    void validateInput() {
        assertThat(Fibonacci.calculate(0)).isEqualTo(0);
        assertThat(Fibonacci.calculate(1)).isEqualTo(1);
        assertThat(Fibonacci.calculate(2)).isEqualTo(1);
        assertThat(Fibonacci.calculate(-1)).isEqualTo(-1);
        assertThat(Fibonacci.calculate(46)).isNotZero();
        assertThat(Fibonacci.calculate(46)).isPositive();
        assertThat(Fibonacci.calculate(47)).isEqualTo(-1);
    }

    @Test
    void fibonacciForTen() {
        assertThat(Fibonacci.calculate(10)).isEqualTo(55);
    }

    @Test
    void fibonacciValid() {
        assertThat(Fibonacci.calculate(3)).isEqualTo(2);
        assertThat(Fibonacci.calculate(26)).isEqualTo(121_393);
    }
}
