package com.startup.efficient;

import java.util.function.Supplier;

public final class CoolPerson extends Builder<CoolPerson> {

    private final String name;
    private final String lastName;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    private CoolPerson() {
        this.name = null;
        this.lastName = null;
    }

    public static final Supplier<Builder<CoolPerson>> builder = CoolPerson::new;

}

