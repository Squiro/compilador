package com.unlam.compilador;

public class TercetoFactory {

    public static Terceto getTerceto(int id, Object... val) {

        int cant = val.length;
        Terceto tercetoReturn = null;
        switch (cant) {
            case 1:
                tercetoReturn = new Terceto(id, val[0]);
                break;
            case 2:
                tercetoReturn = new Terceto(id, val[0], val[1]);
                break;
            case 3:
                tercetoReturn = new Terceto(id, val[0], val[1], val[2]);
                break;
            default:
                tercetoReturn = new Terceto(id);
        }
        return tercetoReturn;
    }
}
