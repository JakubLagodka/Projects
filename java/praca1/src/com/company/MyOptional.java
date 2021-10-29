package com.company;

public class MyOptional<T> {
    private T value;

    private MyOptional() {
    }

    private MyOptional(T value) {
        this.value = value;
    }
//spróbować napisać metodę!
    //static <T> of(){}
}
