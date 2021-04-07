package org.solvd.healthSystem.interfaces;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
