package com.samodeika.multithreading;

public class MySyncClass {

    private int cnt;
    private int loopSize;

    public MySyncClass(int loopSize) {
        this.loopSize = loopSize;
    }

    public void incrementWithThousand() {
        for (int i = 0; i < loopSize; i++) {
            increment();
        }
    }

    private void increment() {
        synchronized (this) {
            cnt++;
        }
    }

    public int getCnt() {
        return cnt;
    }
}
