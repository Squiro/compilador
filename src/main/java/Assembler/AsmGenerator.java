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
	private boolean inlist;
	
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
        	 br.write(generateFooters());

         } catch (Exception e) {
             System.out.println("Ocurrio un error al guardar el archivo codigo.asm");
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
			
			if (simbolValue != "-")
			{
				Integer length = sim.getLongitud();
				if (sim.getLongitud() != null)
				{
					value = "\"" + simbolValue +"\"";
					data += String.format("\t%s\tdb\t%s,'$',%d dup(?)\n", sim.getNombre(), value, length);
				}				
				else {
					value = Double.valueOf(simbolValue).toString();
					data += String.format("\t%s\tdd\t%s\n", sim.getNombre(), value);
				}
			}
			else
			{
				data += String.format("\t%s\tdd\t%s\n", sim.getNombre(), value);
			}		
			
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
			code += handleArithmeticOperation(terceto, "FADD", false);
			break;
		case "-":
			code += handleArithmeticOperation(terceto, "FSUB", false);
			break;
		case "*":
			code += handleArithmeticOperation(terceto, "FMUL", false);
			break;
		case "/":
			code += handleArithmeticOperation(terceto, "FDIV", false);
			break;
		case "DIV":
			code += handleArithmeticOperation(terceto, "FDIV", true);
			break;
		case "MOD":
			// Verificar que el orden de los operadores esté bien cargado
			code += handleArithmeticOperation(terceto, "FPREM", false);
			break;
		case ":=":
			code += handleAssing(terceto);
			break;
		case "CMP":
			code += handleCMP(terceto);
			break;
		case "BGE":
		case "BLE":
		case "BGT":
		case "BLT":
		case "BNE":
		case "BEQ":
		case "BI":
			code += handleJMP(terceto);
			break;
		case "WRITE":
			code += handleWrite(terceto);
			break;
		case "READ":
			code += handleRead(terceto);
			break;
		case "INLIST":
			code += handleInlist();
			break;
		case "LOAD": 
			code += handleLoad(terceto);
			break;
		case "ET": 
			code += handleET(terceto); 
			break;
		default:
			break;
		}
		
		return code;
	}
	
	private String handleArithmeticOperation(Terceto terceto, String operation, boolean convertToInt)
	{
		String code = "";
		String nombre = "@terceto" + terceto.getId();
		code += this.loadOperators(terceto);
		code += "\t" + operation  + "\n";
		code += convertToInt ? "\tFISTP " + nombre + "\n" :  "\tFSTP " + nombre + "\n";
		// Agregamos una var auxiliar donde guardamos el resultado de esta operación
		this.addVariableToData(nombre);
		return code;
	}
		
	private String handleAssing(Terceto terceto)
	{
		String code = "";
		code += "\tFLD " + this.getVariable(terceto.getThirdValue())  + "\n";
		code += "\tFSTP " + terceto.getSecondValue().toString() + "\n";
		return code;
	}
	
	private String handleCMP(Terceto terceto)
	{
		String code = "";
		code += this.loadOperators(terceto);
        code += "\tFXCH\n\tFCOMP\n\tFSTSW AX\n\tSAHF\n";
		return code;
	}
	
	private String handleJMP(Terceto terceto)
	{
		String code = "";
		Index idx = (Index) terceto.getSecondValue();
		Terceto tercetoET =  this.tercetoList.get(idx.getVal()-1);
		String et = tercetoET.getSecondValue().toString() + tercetoET.getId() + "\n";
		code += this.getJMP(terceto.getFirstValue().toString()) + et;
		return code;
	}
	
	private String getJMP(String branch)
	{
		String code = "";
		switch (branch) {
		case "BGE":
			code = "\tJAE ";
			break;
		case "BLE":
			code = "\tJBE ";
			break;
		case "BGT":
			code = "\tJA ";
			break;
		case "BLT":
			code = "\tJB ";
			break;
		case "BNE":
			code = "\tJNE ";
			break;
		case "BEQ":
			code = "\tJE ";
			break;
		case "BI":
			code = "\tJMP ";
			break;
		}
		
		return code;
	}
	
	private String handleWrite(Terceto terceto) {
		String code = "";
		String variable = this.getVariable(terceto.getSecondValue());
		
		if(tablaSimbolos.isString(variable)){
			code = "\tDisplayString " + variable + "\n";
        } else {
        	code = "\tDisplayFloat " + variable + " , 2 \n";
        }
		code += "\tnewline 1\n";
        return code;
	}
	
	private String handleRead(Terceto terceto) {
		 return "\tGetFloat " + this.getVariable(terceto.getSecondValue().toString()) + "\n";
	}
	
	private String handleInlist()
	{
		String code = "";
		// Load "@inlist0" and "@inlist1" constants and @inlistFoundFlag only once
		if (!this.inlist)
		{
			this.addVariableToData("@inlistFoundFlag", "0");
			this.addVariableToData("@inlist0", "0");
			this.addVariableToData("@inlist1", "1");
			this.inlist = true;
		}
		
		code += "\tFLD @inlist0 \n";
		code += "\tFSTP @inlistFoundFlag \n";
		
		return code;		
	}
	
	// Esta función solo carga una variale. Actualmente la usamos por el Inlist nada más (porque no queríamos cambiar mucho la lógica). 
	// No deberíamos usarla por otra razón.
	private String handleLoad(Terceto terceto)
	{
		String code = "";		
		code += "\tFLD " + this.getVariable(terceto.getSecondValue()) + "\n";		
		return code;		
	}
	
	private String handleET(Terceto terceto) {
		String code = "";
		String et = terceto.getSecondValue().toString() + terceto.getId();
		code +=  et +": \n";
		return code;
	}
	
	
	private void addVariableToData(String nombre)
	{
		this.header += String.format("\t%s\tdd\t%s\n", nombre, "?");
	}
	
	private void addVariableToData(String nombre, String value)
	{
		this.header += String.format("\t%s\tdd\t%s\n", nombre, value);
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
	
	private String generateFooters() {
        return "\tMOV EAX, 4C00h\n" +
        "\tINT 21h\n\n" +
        "\tEND start";
	}

}
