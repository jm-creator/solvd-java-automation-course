package com.solvd.healthsystem.interfaces;

@FunctionalInterface
public interface Consumer<T> {
    void supply(T t);
}
