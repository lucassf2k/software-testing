package com.lucassf2k.main;

public class PalindromeChecker {
    private PalindromeChecker() {}

    public static boolean check(final String str) {
        if (str == null || str.isEmpty()) return false;
        final var normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
