package Assembler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import com.unlam.compilador.Terceto;

import SymbolTable.*;

public class AsmGenerator {
	
	private SymbolTable tablaSimbolos;
	private ArrayList<Terceto> tercetoList;
	
	public AsmGenerator(SymbolTable tablaSimbolos, ArrayList<Terceto> tercetoList) {
		this.tablaSimbolos = tablaSimbolos;
		this.tercetoList = tercetoList;
	}
	
	public void generateAsm()
	{
        try (BufferedWriter br = new BufferedWriter(new FileWriter("./codigo.asm"))) {
        	 br.write(generateHeaders());
        	 br.write(generateCode());
        	 br.write(generateFooters());


         } catch (Exception e) {
             System.out.println("Ocurrio un error al guardar el archivo");
             e.printStackTrace();
         }
	}
	
	private String generateHeaders() {
        String includes = "include number.asm\n include macros2.asm\n\n .MODEL LARGE ;Modelo de Memoria\n .386 ;Tipo de Procesador\n .STACK 200h ;Bytes en el Stack\n\n";
        String data = ".DATA\n %s\n";
        String dataVariables = generateData();
        return includes + String.format(data, dataVariables);        
	}
	
	private String generateData() {		
		String data = "";
		for (Simbolo sim : tablaSimbolos.getLista()) {
			String value = "";
			String simbolValue = sim.getValor();
			
			if (simbolValue != null)
			{
				Integer length = sim.getLongitud();
				if (length != null)
				{
					value = "\"" + simbolValue +"\"";
					data.concat(String.format("\t%s\tdb\t%s,'$',%d dup(?)\n", sim.getNombre(), value, length));
				}				
				else {
					value = Double.valueOf(simbolValue).toString();
				}
			}
			
			data.concat(String.format("\t%s\tdd\t%s\n", sim.getNombre(), value));
		}
		
		return data + "\n";
	}
	
	private String generateCode() {
        String code = ".CODE\n\n" +
                        "start:\n" +
                        "\tMOV EAX,@DATA\n" +
                        "\tMOV DS,EAX\n" +
                        "\tMOV ES,EAX\n\n";
		
        for (Terceto terceto : tercetoList) {
			
		}
        
        return null;
	}
	
	private void generateFooters() {
		
	}

}
