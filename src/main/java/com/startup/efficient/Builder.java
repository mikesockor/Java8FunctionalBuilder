package com.startup.efficient;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class Builder<T> {

    // reflection way
    public final BiConsumer<String, Object> setter = (fieldName,object)-> {
        try {
            Class classOf = this.getClass();
            Field field = classOf.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, object);
            field.setAccessible(false);
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    };

    public final Builder<T> and(Consumer<Builder<T>> input) {
        input.accept(this);
        return this;
    }

    public final T build() {
        return (T) this;
    }
}
