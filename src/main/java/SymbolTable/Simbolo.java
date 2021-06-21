package SymbolTable;

public class Simbolo {
    private String nombre;
    private String valor;
    private DataTypes tipo;
    private Integer longitud;

    public Simbolo(String nombre, DataTypes tipo, String valor, Integer longitud) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DataTypes getTipo() {
        return tipo;
    }

    public void setTipo(DataTypes tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    private String toStringObject(Object o) {
        return o != null ? "" + o : "-";
    }

    @Override
    public String toString() {
        return String.format(
                "%-30s|%-30s|%-30s|%-30s", toStringObject(nombre), toStringObject(tipo), toStringObject(valor), toStringObject(longitud)
        );
    }
}