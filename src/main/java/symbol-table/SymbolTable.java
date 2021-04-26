package Tabla;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
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