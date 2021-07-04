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
        try (BufferedWriter br = new BufferedWriter(new FileWriter("./Final.asm"))) {

        	 this.header = generateHeaders();
        	 this.code = generateCode();
        	 br.write(this.header);
        	 br.write(this.code);
        	 br.write(generateFooters());

         } catch (Exception e) {
             System.out.println("Ocurrio un error al guardar el archivo Final.asm");
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
			code += handleArithmeticOperation(terceto, "FADD");
			break;
		case "-":
			code += handleArithmeticOperation(terceto, "FSUB");
			break;
		case "*":
			code += handleArithmeticOperation(terceto, "FMUL");
			break;
		case "/":
			code += handleArithmeticOperation(terceto, "FDIV");
			break;
		case "DIV":
			code += handleDiv(terceto);
			break;
		case "MOD":
			code += handleMod(terceto);
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
			code += handleInlist(terceto.getId());
			break;
		case "ET": 
			code += handleET(terceto); 
			break;
		case "STORE": 
			code += handleStore(terceto); 
			break;
		default:
			break;
		}
		
		return code;
	}
	
	private String handleArithmeticOperation(Terceto terceto, String operation)
	{
		String code = "";
		code += this.loadOperands(terceto, false);
		code += "\t" + operation  + "\n";
		return code;
	}
	
	private String handleMod(Terceto terceto)
	{
		String code = "";
		code += this.loadOperands(terceto, false);
		code += "\tFXCH \n";
		code += "\tFPREM \n";
		return code;
	}
	
	private String handleDiv(Terceto terceto)
	{
		String code = "";
		String nombre = "@terceto" + terceto.getId();
		code += this.loadOperands(terceto, false);
		code += "\tFDIV \n";
		code +=  "\tFISTP " + nombre + "\n";
		code +=  "\tFILD " + nombre + "\n";
		// Agregamos una var auxiliar donde guardamos el resultado de esta operaci�n
		this.addVariableToData(nombre, DataTypes.INTEGER);
		return code;
	}
		
	private String handleAssing(Terceto terceto)
	{
		String code = "";
		
		code += getLoad(this.getVariable(terceto.getThirdValue(), false));
		
		String variable = terceto.getSecondValue().toString();
		Object type = tablaSimbolos.getType(variable);
		if (tablaSimbolos.getType(variable) == DataTypes.INTEGER)
		{
			code += "\tFISTP " + variable + "\n";
		} else
		{
			code += "\tFSTP " + variable + "\n";
		}		
		
		return code;
	}
	
	private String handleCMP(Terceto terceto)
	{
		String code = "";
		code += this.loadOperands(terceto, true);
        code += "\tFXCH\n\tFCOMP\n\tFSTSW AX\n\tSAHF\n\tFFREE\n";
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
		String variable = this.getVariable(terceto.getSecondValue(), false);
		
		if(tablaSimbolos.isString(variable)){
			code = "\tDisplayString " + variable + "\n";
        } else if (tablaSimbolos.getType(variable) == DataTypes.INTEGER) {
        	code = "\tDisplayInteger " + variable + " \n";
        } else {
        	code = "\tDisplayFloat " + variable + " , 2 \n";
        }
		code += "\tnewline 1\n";
        return code;
	}
	
	private String handleRead(Terceto terceto) {
		 return "\tGetFloat " + this.getVariable(terceto.getSecondValue().toString(), false) + "\n";
	}
	
	private String handleInlist(int inlistId)
	{
		String code = "";
		// Load "@inlist0" and "@inlist1" constants and @inlistFoundFlag only once
		if (!this.inlist)
		{
			this.addVariableToData("@inlist0", DataTypes.INTEGER, "0");
			this.addVariableToData("@inlist1", DataTypes.INTEGER, "1");
			this.inlist = true;
		}
		
		String flag = "@inlistFoundFlag" + inlistId;
		this.addVariableToData(flag, DataTypes.INTEGER);
		code += "\tFILD @inlist0 \n";
		code += "\tFISTP " + flag + "\n";
		
		return code;		
	}
		
	private String handleET(Terceto terceto) {
		String code = "";
		String et = terceto.getSecondValue().toString() + terceto.getId();
		code +=  et +": \n";
		return code;
	}
	
	private String handleStore(Terceto terceto) {
		String code = "";	
		
		Index ind =  (Index) terceto.getSecondValue();
		
		Terceto ter = this.tercetoList.get(ind.getVal()-1);
		String nombre = "";
		
		if (ter.getCount() > 1)
		{
			nombre = "@terceto" + ind.getVal();	
			
			if (this.tablaSimbolos.isInTable(nombre))
			{
				return "";
			}			
		}
		else
		{
			if (this.tablaSimbolos.isInTable(ter.getFirstValue().toString()))
			{
				return "";
			}
			nombre = ter.getFirstValue().toString();
		}		

		code += "\tFSTP " + nombre + "\n";
		this.addVariableToData(nombre, DataTypes.FLOAT);	
		return code;
	}
	
	
	private void addVariableToData(String nombre, DataTypes type)
	{
		this.tablaSimbolos.add(nombre, type, null, null);
		this.header += String.format("\t%s\tdd\t%s\n", nombre, "?");
	}
	
	private void addVariableToData(String nombre, DataTypes type, String value)
	{
		this.tablaSimbolos.add(nombre, type, value, null);
		this.header += String.format("\t%s\tdd\t%s\n", nombre, value);
	}
	
	private String loadOperands(Terceto terceto, boolean isCMP) {
		String code = "";
		
		code += getLoad(this.getVariable(terceto.getSecondValue(), isCMP));
		code += getLoad(this.getVariable(terceto.getThirdValue(), isCMP));			
	
		return code;
	}
		
	// Recibe un "second" o "third" value de un terceto. Si es un index,
	// Busca el terceto asociado a ese index. Si el terceto es un terceto que contiene solo una constante
	// devuelve esa constante como variable. 
	// Caso contrario, estamos ante un terceto as� por ejemplo (*, 12, 43), lo que significa que debemos devolver la variable auxiliar
	// donde guardamos el resultado de dicho terceto.
	private String getVariable(Object value, boolean isCMP)
	{
		if (value.getClass() == Index.class)
		{
			Index val = (Index) value;
			int index = val.getVal();
			Terceto ter =  this.tercetoList.get(index-1);
			
			if (ter.getCount() > 1)
			{
				if (isCMP)
				{
					return "@terceto" + index;
				}
				else
					return "";
			}
			else
				return ter.getFirstValue().toString();			
		}
		
		return value.toString();
	}
	
	// Checks datatype and returns FLD or FILD
	private String getLoad(String variable)
	{
		if (variable == "")
			return "";
		
		String code = "";
		
		if (this.tablaSimbolos.getType(variable) == DataTypes.INTEGER)
		{
			code += "\tFILD " + variable + "\n";
		} else 
		{
			code += "\tFLD " + variable  + "\n";
		}	
		
		return code;
	}
	
	private String generateFooters() {
        return "\tMOV EAX, 4C00h\n" +
        "\tINT 21h\n\n" +
        "\tEND start";
	}

}
