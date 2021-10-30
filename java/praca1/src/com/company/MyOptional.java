package com.company;

//import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Optional;

public class MyOptional<T> {
    private T value;

    private MyOptional() {
    }

    private MyOptional(T value) {
        this.value = value;
    }
//spróbować napisać metodę!
    /*static <T> of(T value){
        new MyOptional(value);
        return Optional<>
    }*/
}
