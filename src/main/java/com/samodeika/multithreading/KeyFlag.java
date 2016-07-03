package com.samodeika.multithreading;

public class KeyFlag {

    private String page;
    private boolean isVisited;

    public KeyFlag() {
    }

    public KeyFlag(String page) {
        this.page = page;
    }

    public KeyFlag(String page, boolean isVisited) {
        this.page = page;
        this.isVisited = isVisited;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyFlag keyFlag = (KeyFlag) o;

        if (isVisited != keyFlag.isVisited) return false;
        return page.equals(keyFlag.page);

    }

    @Override
    public int hashCode() {
        int result = page.hashCode();
        result = 31 * result + (isVisited ? 1 : 0);
        return result;
    }
}
