package com.solvd.medicalInsuranceSystem.interfaces;

@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}
