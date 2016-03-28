package com.samodeika.luxoft;

public class TestMain {

    public static void main(String[] args) {
        Pair pair = new Pair() {
            @Override
            public Object getKey() {
                return null;
            }

            @Override
            public Object getValue() {
                return null;
            }
        };


        MyImmutable.Builder b = MyImmutable.getBuilder(1);
        b.withName("Pesho").withCountry("Bulgaria").build();

    }

}
