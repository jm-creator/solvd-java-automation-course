package com.solvd.medicalInsuranceSystem.interfaces;

@FunctionalInterface
public interface Consumer<T> {
    void supply(T t);
}
