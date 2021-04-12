package Tabla;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class TablaDeSimbolos {

    public static Logger LOGGER = Logger.getLogger(TablaDeSimbolos.class.getName());

    private List<Simbolo> listaDeSimbolos;

    public TablaDeSimbolos() {
        this.listaDeSimbolos = new LinkedList<Simbolo>();
    }

    public void agregarEnTabla(String nombre, String tipo, String valor, Integer longitud) {
        if(!estaEnTabla(nombre)){
            listaDeSimbolos.add(new Simbolo(nombre, tipo, valor, longitud));
        }
    }

    public Boolean estaEnTabla(String nombre) {
        return listaDeSimbolos.stream().anyMatch(simbolo -> simbolo.getNombre().equals(nombre));
    }


    public void guardarTabla() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("ts.txt"))) {

            br.write(String.format("%-30s|%-30s|%-30s|%-30s\n", "NOMBRE", "TIPODATO", "VALOR", "LONGITUD"));
            listaDeSimbolos.forEach(simbolo -> {
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