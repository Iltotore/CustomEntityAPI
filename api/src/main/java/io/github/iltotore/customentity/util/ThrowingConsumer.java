package io.github.iltotore.customentity.util;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

    @Override
    default void accept(T t) {
        try {
            throwingAccept(t);
        } catch(Throwable e){
            throw new RuntimeException(e);
        }
    }

    void throwingAccept(T t) throws Throwable;
}
