package com.samodeika.luxoft;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {

    }

    public Singleton getInstance() {
        if(this.singleton == null) {
            return new Singleton();
        }
        return this.singleton;
    }

}
