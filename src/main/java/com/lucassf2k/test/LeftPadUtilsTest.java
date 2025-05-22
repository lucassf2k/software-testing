package com.lucassf2k.test;

import com.lucassf2k.main.LeftPadUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.of;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LeftPadUtilsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void test(final String originalStr, final int size, final String padString, final String expectedStr) {
        assertThat(LeftPadUtils.leftPad(originalStr, size, padString)).isEqualTo(expectedStr);
    }

    public static Stream<Arguments> generator() {
        return Stream.of(
                of(null, 10, "-", null),
                of("", 5, "-", "-----"),
                of("abc", -1, "-", "abc"),
                of("abc", 5, null, " abc"),
                of("abc", 5, "", "  abc"),
                of("abc", 5, "-", "--abc")
        );
    }
}
