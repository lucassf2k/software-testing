package com.lucassf2k.test;


import com.lucassf2k.main.PalindromeChecker;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;



public class PalindromoTestLucasVinicius {

    @Test
    void testSimplePalindrome() {
        assertThat(PalindromeChecker.check("radar")).isTrue();
    }

    @Test
    void testPalindromeWithSpaces() {
        assertThat(PalindromeChecker.check("Ame a ema")).isTrue();
    }

    @Test
    void testPalindromeWithPunctuation() {
        assertThat(PalindromeChecker.check("A man, a plan, a canal: Panama")).isTrue();
    }

    @Test
    void testPalindromeWithUppercaseAndSpaces() {
        assertThat(PalindromeChecker.check("No lemon, no melon")).isTrue();
    }

    @Test
    void testNumericPalindrome() {
        assertThat(PalindromeChecker.check("12321")).isTrue();
    }

    @Test
    void testEmptyString() {
        assertThat(PalindromeChecker.check("")).isTrue();
    }

    @Test
    void testSingleCharacter() {
        assertThat(PalindromeChecker.check("a")).isTrue();
    }

    @Test
    void testNullInput() {
        assertThat(PalindromeChecker.check(null)).isFalse();
    }

    @Test
    void testNonPalindromeWord() {
        assertThat(PalindromeChecker.check("banana")).isFalse();
    }

    @Test
    void testClassicPalindromePhrase() {
        assertThat(PalindromeChecker.check("Was it a car or a cat I saw?")).isTrue();
    }

    @Test
    void testClearlyNotPalindrome() {
        assertThat(PalindromeChecker.check("This is not")).isFalse();
    }

    @Test
    void teste() {
        assertThat(PalindromeChecker.check("A grama é amarga")).isTrue();
    }
}
