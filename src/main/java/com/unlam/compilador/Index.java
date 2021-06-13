package com.unlam.compilador;

public class Index {

    private int val;

    public Index(){
        
    }

    public Index(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
