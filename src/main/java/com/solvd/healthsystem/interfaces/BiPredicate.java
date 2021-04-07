package com.solvd.healthsystem.interfaces;

@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}
