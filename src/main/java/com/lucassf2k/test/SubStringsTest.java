package com.lucassf2k.test;

import com.lucassf2k.main.SubStrings;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SubStringsTest {
    @Test
    void simpleCase() {
        assertThat(SubStrings.substringsBetween("abcd", "a", "d"))
                .isEqualTo(new String[]{"bc"});
    }
    @Test
    void manySubstrings() {
        assertThat(SubStrings.substringsBetween("abcdabcdab", "a", "d")).
                isEqualTo(new String[] { "bc", "bc" });
    }

    @Test
    void openAndCloseTagsThatAreLongerThan1Char() {
        assertThat(SubStrings.substringsBetween("aabcddaabfddaab", "aa", "dd")).
                isEqualTo(new String[] {"bc", "bf"});
    }

    @Test
    void strIsNullOrEmpty() {
        assertThat(SubStrings.substringsBetween(null, "a", "d")).isEqualTo(null);
    }

    @Test
    void noSubstringBetweenOpenAndCloseTags() {
        assertThat(SubStrings.substringsBetween("aabb", "aa", "bb"));
    }

}
