package com.local.builder;

public class GarlicBurger extends Burger {
    @Override
    public String name() {
        return "GarlicBurger";
    }

    @Override
    public float price() {
        return 4f;
    }
}
