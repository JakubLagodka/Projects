package com.company;

//import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Optional;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public T orElse(T defaultValue) {
//        if (value == null)
//            return defaultValue;
//        return value;
        return value == null ? defaultValue : value;
    }

    public T orElseGet(Supplier<T> supplier) {
        return value == null ? supplier.get() : value;

    }

    public <X extends Throwable> T orElseThrow(Supplier<X> supplier) throws X {
        if (value != null)
            return value;

        throw supplier.get();
    }

    public void ifPresentOrElse(Consumer<T> consumer, Runnable runnable) {
        if (value == null)
            runnable.run();
        else
            consumer.accept(value);
    }

    public MyOptional<T> filter(Predicate<T> predicate) {
        if (value == null)
            return this;

        return predicate.test(value) ? this : empty();
    }

    public <V> MyOptional<V> map(Function<T, V> function) {
        if (value == null)
            return empty();
        return of(function.apply(value));
    }
}
