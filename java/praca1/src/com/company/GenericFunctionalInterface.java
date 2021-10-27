package com.company;

import java.util.List;

@FunctionalInterface
public interface GenericFunctionalInterface<N extends Number> {
    N sumNumbers(List<N> list);

}
