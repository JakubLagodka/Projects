package com.company;

@FunctionalInterface
public interface GenericFunctionalInterface<T, R> {
    R sumNumbers(T t);

}
