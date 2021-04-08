package com.solvd.files.enums;

public enum FilePath {
    INPUT("src/main/java/com/solvd/files/input.txt"),
    OUTPUT("src/main/java/com/solvd/files/output.txt");

    public String contentRootPath;

    FilePath(String contentRootPath) {
        this.contentRootPath = contentRootPath;
    }
}
