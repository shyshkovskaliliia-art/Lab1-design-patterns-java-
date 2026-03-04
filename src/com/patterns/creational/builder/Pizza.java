package com.patterns.creational.builder;

import java.util.List;

public class Pizza {
    private String size;
    private String dough;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    private boolean extraCheese;

    private Pizza() {}

    @Override
    public String toString() {
        return "Pizza {" +
                "\n  size='"   + size   + "'" +
                "\n  dough='"  + dough  + "'" +
                "\n  sauce='"  + sauce  + "'" +
                "\n  cheese='" + cheese + "'" +
                "\n  toppings=" + toppings +
                "\n  extraCheese=" + extraCheese +
                "\n}";
    }

    public static class Builder {
        private Pizza pizza = new Pizza();

        public Builder(String size, String dough) {
            pizza.size  = size;
            pizza.dough = dough;
        }

        public Builder sauce(String sauce) {
            pizza.sauce = sauce; return this;
        }
        public Builder cheese(String cheese) {
            pizza.cheese = cheese; return this;
        }
        public Builder toppings(List<String> toppings) {
            pizza.toppings = toppings; return this;
        }
        public Builder extraCheese(boolean extra) {
            pizza.extraCheese = extra; return this;
        }
        public Pizza build() { return pizza; }
    }
}