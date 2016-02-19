package com.samodeika.luxoft;

public class MyImmutable {
    private static MyImmutable form;
    private String name;
    private String country;
    private int createAction;

    private void setName(String name) {
        this.name = name;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setCreateAction(int createAction) {
        this.createAction = createAction;
    }

    public static Builder getBuilder(int createAction) {
        return new Builder(createAction);
    }

    static class Builder {
        private String name = "";
        private String country = "";
        private int createAction;

        private Builder(int createAction) {
            this.createAction = createAction;
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public void build() {
            form.setName(this.name);
            form.setCountry(this.country);
            form.setCreateAction(this.createAction);
        }
    }
}
