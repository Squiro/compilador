package com.unlam.compilador;

public class Terceto {

    private int id;
    private Object val1 = null;
    private Object val2 = null;
    private Object val3 = null;
    private int count;

    public Terceto() {

    }

    public Terceto(int id) {
        this.id = id;
    }

    public Terceto(int id, Object val1) {
        this.id = id;
        this.val1 = val1;
        this.count = 1;
    }

    public Terceto(int id, Object val1, Object val2) {
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
        this.count = 2;
    }

    public Terceto(int id, Object val1, Object val2, Object val3) {
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.count = 3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getFirstValue() {
        return val1;
    }

    public void setFirstValue(Object val1) {
        this.val1 = val1;
    }

    public Object getSecondValue() {
        return val2;
    }

    public void setSecondValue(Object val2) {
        this.val2 = val2;
    }

    public Object getThirdValue() {
        return val3;
    }

    public void setThirdValue(Object val3) {
        this.val3 = val3;
    }
    
    public int getCount() {
    	return this.count;
    }

    @Override
    public String toString() {
        return String.format("[%d] = (%s, %s, %s)", this.id, this.val1, this.val2, this.val3);
    }

}
