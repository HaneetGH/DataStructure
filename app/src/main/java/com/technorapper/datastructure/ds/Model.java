package com.technorapper.datastructure.ds;

public class Model {

    String value;
    int level;

    public Model getChild() {
        return child;
    }

    public void setChild(Model child) {
        this.child = child;
    }

    Model child;

    public Model(String value, int level, Model child) {
        this.value = value;
        this.level = level;
        this.child = child;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
