package com.company;

//import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Optional;


import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyOptional<T> {
    private T value;

    private MyOptional() {
    }

    private MyOptional(T value) {
        this.value = value;
    }

    static <T> MyOptional<T> of(T value) {
        return new MyOptional<>(value);
    }

    static <T> MyOptional<T> empty() {
        return new MyOptional<>();
    }

    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("value does not exist");
        }
        return this.value;
    }

    public void ifPresent(Consumer<T> consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }
}
