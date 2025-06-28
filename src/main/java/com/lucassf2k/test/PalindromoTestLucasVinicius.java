package com.lucassf2k.test;

import com.lucassf2k.main.PalindromeChecker;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class PalindromoTestLucasVinicius {

    /**
     * Testa um palíndromo simples com letras minúsculas.
     */
    @Test
    void testSimplePalindrome() {
        assertThat(PalindromeChecker.check("radar")).isTrue();
    }

    /**
     * Testa um palíndromo com espaços e letras maiúsculas.
     */
    @Test
    void testPalindromeWithSpaces() {
        assertThat(PalindromeChecker.check("Ame a ema")).isTrue();
    }

    /**
     * Testa um palíndromo contendo pontuação e letras maiúsculas.
     */
    @Test
    void testPalindromeWithPunctuation() {
        assertThat(PalindromeChecker.check("A man, a plan, a canal: Panama")).isTrue();
    }

    /**
     * Testa uma frase palindrômica com letras maiúsculas e espaços.
     */
    @Test
    void testPalindromeWithUppercaseAndSpaces() {
        assertThat(PalindromeChecker.check("No lemon, no melon")).isTrue();
    }

    /**
     * Testa um número palindrômico representado como string.
     */
    @Test
    void testNumericPalindrome() {
        assertThat(PalindromeChecker.check("12321")).isTrue();
    }

    /**
     * Testa string vazia. Por padrão, consideramos que uma string vazia não é um palíndromo.
     */
    @Test
    void testEmptyString() {
        assertThat(PalindromeChecker.check("")).isFalse();
    }

    /**
     * Testa uma string de um único caractere, que é considerada um palíndromo.
     */
    @Test
    void testSingleCharacter() {
        assertThat(PalindromeChecker.check("a")).isTrue();
    }

    /**
     * Testa o comportamento quando a entrada é {@code null}.
     */
    @Test
    void testNullInput() {
        assertThat(PalindromeChecker.check(null)).isFalse();
    }

    /**
     * Testa uma palavra que claramente não é um palíndromo.
     */
    @Test
    void testNonPalindromeWord() {
        assertThat(PalindromeChecker.check("banana")).isFalse();
    }

    /**
     * Testa uma frase clássica que é um palíndromo mesmo com espaços e pontuação.
     */
    @Test
    void testClassicPalindromePhrase() {
        assertThat(PalindromeChecker.check("Was it a car or a cat I saw?")).isTrue();
    }

    /**
     * Testa uma frase comum que definitivamente não é um palíndromo.
     */
    @Test
    void testClearlyNotPalindrome() {
        assertThat(PalindromeChecker.check("This is not")).isFalse();
    }

    /**
     * Teste adicional: string quase simétrica mas que não é palíndromo.
     */
    @Test
    void teste() {
        assertThat(PalindromeChecker.check("acbdcba")).isFalse();
    }
}
