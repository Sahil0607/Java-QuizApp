package com.project.quizapp.utils;


public class ValidationUtils {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void requireNonEmpty(String str, String errorMessage) {
        if (isNullOrEmpty(str)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void requirePositive(Integer value, String errorMessage) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

