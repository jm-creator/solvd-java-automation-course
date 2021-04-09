package com.solvd.medicalInsuranceSystem.interfaces;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
