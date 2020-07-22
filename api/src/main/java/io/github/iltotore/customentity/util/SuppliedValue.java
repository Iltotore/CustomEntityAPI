package io.github.iltotore.customentity.util;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SuppliedValue<T> implements Supplier<Optional<T>> {

    private Supplier<T> supplier;
    private Optional<T> value = Optional.empty();

    private SuppliedValue(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public Optional<T> get() {
        if(!value.isPresent()) value = Optional.ofNullable(supplier.get());
        return value;
    }

    public static <T> SuppliedValue<T> of(Supplier<T> supplier){
        return new SuppliedValue<>(supplier);
    }

    public static <T> SuppliedValue<T> of(Supplier<T> supplier, Consumer<T> sideEffect){
        return of(() -> {
            T t = supplier.get();
            sideEffect.accept(t);
            return t;
        });
    }

    public static <T> SuppliedValue<T> empty(){
        return new SuppliedValue<>(() -> null);
    }
}
