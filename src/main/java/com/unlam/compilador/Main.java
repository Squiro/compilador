package com.unlam.compilador;

import Analizadores.AnalizadorLexico;
import Analizadores.AnalizadorSintactico;
import java_cup.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException
    {    	
        String fileName = "prueba.txt";
        try {     	
            @SuppressWarnings("deprecation") AnalizadorSintactico sintactico = new AnalizadorSintactico(new AnalizadorLexico(new FileReader(fileName)));
            sintactico.parse();
            System.in.read();
        } catch (FileNotFoundException e) {
            System.err.	println("El archivo " + fileName + " no existe");
            e.printStackTrace();
            System.in.read();
        } catch (Exception e) {
            System.err.println("Hubo un error al ejecutar el programa: ");
            System.err.println(e);
            e.printStackTrace();
            System.in.read();
        }
    }
}
