package com.lucassf2k.test;

import com.lucassf2k.main.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

public class DateTest {

    // --- P1: Mês inválido (fora do intervalo 1-12) ---

    @Test
    void testMonthBelowMinimum() {
        assertThrows(IllegalArgumentException.class,
                () -> new Date(0, 10, 2025));
    }

    @Test
    void testMonthAboveMaximum() {
        assertThatThrownBy(() -> new Date(13, 10, 2025))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("month");
    }

    // --- P2: Mês válido ---

    @Test
    void testValidMonth() {
        final var date = new Date(1, 15, 2025);
        assertThat(date.toString()).isEqualTo("1/15/2025");
    }

    // --- P3/P4: Dias válidos e inválidos para meses (exceto fevereiro) ---

    @Test
    void testValidDayForApril() {
        final var date = new Date(4, 30, 2025); // abril tem 30 dias
        assertThat(date.toString()).isEqualTo("4/30/2025");
    }

    @Test
    void testInvalidDayForApril() {
        assertThatThrownBy(() -> new Date(4, 31, 2025))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("day");
    }

    @Test
    void testInvalidDayForJune() {
        assertThatThrownBy(() -> new Date(6, 31, 2025))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("day");
    }

    // --- P5: Fevereiro com 29 dias em ano bissexto ---

    @Test
    void testLeapYearFebruary29() {
        final var date = new Date(2, 29, 2020);
        assertThat(date.toString()).isEqualTo("2/29/2020");
    }

    // --- P6: Fevereiro com 29 dias em ano não bissexto ---

    @Test
    void testNonLeapYearFebruary29() {
        assertThatThrownBy(() -> new Date(2, 29, 2023))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("day");
    }

    // --- P7: Fevereiro com até 28 dias ---

    @Test
    void testFebruary28() {
        final var date = new Date(2, 28, 2025);
        assertThat(date.toString()).isEqualTo("2/28/2025");
    }

    @Test
    void testFebruary30() {
        assertThatThrownBy(() -> new Date(2, 30, 2025))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("day");
    }

    // --- Fronteiras extras ---

    @Test
    void testMinimumMonthAndDay() {
        final var date = new Date(1, 1, 2025);
        assertThat(date.toString()).isEqualTo("1/1/2025");
    }

    @Test
    void testMaximumMonthAndDay() {
        final var date = new Date(12, 31, 2025);
        assertThat(date.toString()).isEqualTo("12/31/2025");
    }

    @Test
    void testMinimumDayInMay() {
        final var date = new Date(5, 1, 2025);
        assertThat(date.toString()).isEqualTo("5/1/2025");
    }

    @Test
    void testMaximumDayInJanuary() {
        final var date = new Date(1, 31, 2025);
        assertThat(date.toString()).isEqualTo("1/31/2025");
    }
}
