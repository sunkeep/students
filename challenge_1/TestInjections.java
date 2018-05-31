package com.company;

import com.sun.istack.internal.Nullable;

public class TestInjections {
    private static final int MAX_LENGTH = 25;

    public static boolean isStringCorrect(@Nullable String inputValue) {
        if (inputValue == null) return false;
        if (inputValue.length() < MAX_LENGTH) return false;
        return inputValue.matches("^(https)://[-a-zA-Z0-9@#/%?=~_|!:,.;]*[?-a-zA-Z0-9+&@#/%=~_|]");
    }
}
