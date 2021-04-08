package com.solvd.files.enums;

public enum Constrains {

    DOT("."),
    COLON(":"),
    SEMICOLON(";"),
    COMMA(","),
    QUOTATIONS("'"),
    QUESTION("?"),
    EXCLAMATION("!");

    private String value;

    Constrains(String value) {
        this.value = value;
    }

    public static String generateRegEx() {
        return String.format("[%s|%s|%s|%s|%s|%s|%s]",
                COMMA.value,
                SEMICOLON.value,
                COLON.value,
                DOT.value,
                QUESTION.value,
                QUOTATIONS.value,
                EXCLAMATION.value);
    }


    public String getValue() {
        return value;
    }
}
