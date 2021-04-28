package SymbolTable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.logging.Logger;

public class SymbolTable {

    public static Logger LOGGER = Logger.getLogger(SymbolTable.class.getName());

    private List<Simbolo> symbolList;

    public SymbolTable() {
        this.symbolList = new LinkedList<Simbolo>();
    }

    // Getters & Setters
    public List<Simbolo> getLista(){
        return symbolList;
    }

    // Public methods

    public void add(String nombre, String tipo, String valor, Integer longitud) {
        if(!isInTable(nombre)){
            symbolList.add(new Simbolo(nombre, tipo, valor, longitud));
        }
    }

    // cambiar algoritmo de asignacion de tipos a los identificadores (cada vez que encontras un tipo, añadiselo a los identificadores que hayas encontrado antes)
    // Es decir, cada vez que vas encontrando identificadores, los guardás en una cola/lista. Cuando encontrás un tipo, vacías esa lista, y le agregás 
    // a esos identificadores el tipo encontrado. 
    // Esto es porque nuestro lenguaje permite declaraciones de este tipo:
    // a, b, c : FLOAT;
    // Si hay un identificador en la cola y nunca se le asignó su tipo, bueno, hay un problema. De todas formas no debería pasar, porque la regla sintáctica
    // debería exigir que las declaraciones sean "ID: TIPO"
    public void addVariables(Queue<String> colaNombre, Queue<String> colaTipoDato) {
        String nombre;
        String tipoDato;

        if(colaNombre.size() != colaTipoDato.size()) {
            throw new Error("Error sintáctico: La cantidad de variables declaradas no coincide con la cantidad de tipos de datos declarados."); 
        }
        while(colaNombre.peek() != null ) {
            nombre = colaNombre.poll();
            tipoDato = colaTipoDato.poll();

            if(!isInTable(nombre)) {
                add(nombre, tipoDato, null, null);
            } 
            else {
                throw new Error("Error sintáctico: '"+nombre+"' ya esta declarada."); 
            }
        }
    }

    public Boolean isInTable(String nombre) {
        return symbolList.stream().anyMatch(simbolo -> simbolo.getNombre().equals(nombre));
    }

    public void save() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("ts.txt"))) {

            br.write(String.format("%-30s|%-30s|%-30s|%-30s\n", "NOMBRE", "TIPODATO", "VALOR", "LONGITUD"));
            symbolList.forEach(simbolo -> {
                try {
                    br.write(simbolo.toString() + "\n");
                } catch (IOException e) {
                    LOGGER.severe("Ocurrio un error al guardar los simbolos");
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            LOGGER.severe("Ocurrio un error al guardar el archivo");
            e.printStackTrace();
        }
    }
}