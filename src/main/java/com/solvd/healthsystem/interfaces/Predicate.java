package com.solvd.healthsystem.interfaces;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
