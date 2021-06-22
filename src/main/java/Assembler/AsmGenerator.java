package Assembler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import com.unlam.compilador.Index;
import com.unlam.compilador.Terceto;

import SymbolTable.*;

public class AsmGenerator {
	
	private SymbolTable tablaSimbolos;
	private ArrayList<Terceto> tercetoList;
	private String header;
	private String code;
	
	public AsmGenerator(SymbolTable tablaSimbolos, ArrayList<Terceto> tercetoList) {
		this.tablaSimbolos = tablaSimbolos;
		this.tercetoList = tercetoList;
	}
	
	public void generateAsm()
	{
        try (BufferedWriter br = new BufferedWriter(new FileWriter("./codigo.asm"))) {

        	 this.header = generateHeaders();
        	 this.code = generateCode();
        	 br.write(this.header);
        	 br.write(this.code);
        	 //br.write(generateFooters());

         } catch (Exception e) {
             System.out.println("Ocurrio un error al guardar el archivo");
             e.printStackTrace();
         }
	}
	
	private String generateHeaders() {
        String includes = "include number.asm\ninclude macros2.asm\n\n.MODEL LARGE ;Modelo de Memoria\n .386 ;Tipo de Procesador\n.STACK 200h ;Bytes en el Stack\n\n";
        String data = ".DATA\n %s";
        String dataVariables = generateData();
        return includes + String.format(data, dataVariables);   
	}
	
	private String generateData() {		
		String data = "";
		
		for (Simbolo sim : tablaSimbolos.getLista()) {
			String value = "?";
			String simbolValue = sim.getValor();
			
			if (simbolValue != null)
			{
				Integer length = sim.getLongitud();
				if (length != null)
				{
					value = "\"" + simbolValue +"\"";
					data += String.format("\t%s\tdb\t%s,'$',%d dup(?)\n", sim.getNombre(), value, length);
				}				
				else {
					value = Double.valueOf(simbolValue).toString();
				}
			}
			
			data += String.format("\t%s\tdd\t%s\n", sim.getNombre(), value);
		}
		
		return data;   
	}
	
	private String generateCode() {
        String code = ".CODE\n\n" +
                        "start:\n" +
                        "\tMOV EAX,@DATA\n" +
                        "\tMOV DS,EAX\n" +
                        "\tMOV ES,EAX\n\n";
		
        for (Terceto terceto : tercetoList) {
			if (terceto.getCount() > 1)
			{
				code += handleOperation(terceto);
			}
		}
        
        return code;
	}
	
	private String handleOperation(Terceto terceto) 
	{
		String operation = terceto.getFirstValue().toString();
		String code = "";
		
		switch (operation) {
		case "+":
			code += handlePlus(terceto);
			break;

		default:
			break;
		}
		
		return code;
	}
	
	private String handlePlus(Terceto terceto)
	{
		String code = "";
		String nombre = "@terceto" + terceto.getId();
		code += this.loadOperators(terceto);
		code += "\tFADD \n";
		code += "\tFSTP " + nombre + "\n";
		// ACA DEBERIAS AGREGAR LA VARIABLE AUX EN EL .DATA DEL ASSEMBLER
		this.addVariableToData(nombre);
		return code;
	}
	
	private void addVariableToData(String nombre)
	{
		this.header += String.format("\t%s\tdd\t%s\n", nombre, "?");
	}
	
	private String loadOperators(Terceto terceto) {
		String code = "";
		code += "\tFLD " +  this.getVariable(terceto.getSecondValue()) + "\n";
		code += "\tFLD " +  this.getVariable(terceto.getThirdValue()) + "\n";
		return code;
	}
	
	// Recibe un "second" o "third" value de un terceto. Si es un index,
	// Busca el terceto asociado a ese index. Si el terceto es un terceto que contiene solo una constante
	// devuelve esa constante como variable. 
	// Caso contrario, estamos ante un terceto así por ejemplo (*, 12, 43), lo que significa que debemos devolver la variable auxiliar
	// donde guardamos el resultado de dicho terceto.
	private String getVariable(Object value)
	{
		if (value.getClass() == Index.class)
		{
			Index val = (Index) value;
			int index = val.getVal();
			Terceto ter =  this.tercetoList.get(index-1);
			if (ter.getCount() > 1)
				return "@terceto" + index;
			else
				return ter.getFirstValue().toString();
		}
		
		return value.toString();
	}
	
	private void generateFooters() {
		
	}

}
