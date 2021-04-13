import Analizadores.AnalizadorLexico;
import Analizadores.AnalizadorLexicoPunto2;
import Analizadores.AnalizadorSintactico;
import java_cup.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String args[])
    {
        String fileName = "prueba.txt";
        try {
        	AnalizadorLexico lexer = new AnalizadorLexico(new FileReader(fileName));
        	Symbol token = null;        	
        	do {
        		token = lexer.next_token();
        	}
        	while (token != null);       	
        	
        	
            //@SuppressWarnings("deprecation") AnalizadorSintactico sintactico = new AnalizadorSintactico(new AnalizadorLexico(new FileReader(fileName)));
            //sintactico.parse();
            System.out.println("Corri� " + fileName);
        } catch (FileNotFoundException e) {
            System.err.	println("El archivo " + fileName + " no existe");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Hubo un error");
            e.printStackTrace();
        }
    }
}
