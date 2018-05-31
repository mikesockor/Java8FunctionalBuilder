package com.startup.efficient;

import java.util.function.Supplier;

public final class CoolPerson extends Builder<CoolPerson> {

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public static Supplier<Builder<CoolPerson>> builder = CoolPerson::new;

}

