package Analizadores;
import java_cup.runtime.*;

/* Directivas */
%%     

%public
%class AnalizadorLexico
%cupsym Simbolos
%cup
%column
%line
%ignorecase
%unicode

%{
    int RANGO_ENTERO = (int) (Math.pow(2, 16)-1);
    float RANGO_FLOAT = (float) (Math.pow(2, 32)-1);
    int RANGO_STRING = 30;
    int RANGO_IDENTIFICADOR = 256;
    private Symbol symbol(int type) {
          // System.out.println("[LEX] TOKEN < " + Simbolos.terminalNames[type] + " > : " + yytext());
          return new Symbol(type, yyline, yycolumn, yytext());
    }
    private Symbol symbol(int type, Object value) {
          return new Symbol(type, yyline, yycolumn, value);
    }
%}

/* Declaraciones de REGEX utiles */
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]
DIGITO 	    =	[0-9]
LETRA 	    =	[a-zA-Z]

// Construcciones del lenguaje
// -/ Así son los comentarios en el 2°Cuat de LyC -/ Comentario /- /-
COMMENT = "-/" ~"/-"
NESTED_COMMENT = "-/" .* {COMMENT} ~ "/-"
IDENTIFICADOR = {LETRA}[a-zA-Z0-9_]*({LETRA}|{DIGITO})*

// Constantes
CONSTANTE_ENTERA =  {DIGITO}+
CONSTANTE_FLOAT =  {DIGITO}+"."{DIGITO}* | {DIGITO}*"."{DIGITO}+
CONSTANTE_STRING =  \".*\"

// Palabras reservadas
IF = "if"
ELSE = "else"
WHILE = "while"
DECVAR = "DECVAR"
ENDDEC = "ENDDEC"
WRITE = "WRITE"
READ = "READ"
INLIST = "INLIST"
MOD = "MOD"
DIV = "DIV"
INTEGER_TYPE = "INTEGER"
FLOAT_TYPE = "FLOAT"
STRING_TYPE = "STRING"

// Operadores lógicos y ariméticos
OP_GT = ">" 
OP_LT = "<" 
OP_GTE = ">=" 
OP_LTE = "<=" 
OP_NE = "!="
OP_PLUS = "+" 
OP_MINUS = "-" 
OP_MULTI = "*" 
OP_DIVISION = "/"
OP_NOT = "!" 
OP_AND = "&&"
OP_OR = "||" 
OP_ASIG = ":="
OP_EQ = "=="
OP_TYPE = ":"

// Caracteres especiales
COMA = ","
PUNTO_COMA = ";"
PAREN_OPEN = "("
PAREN_CLOSE = ")"
CORCHETE_OPEN = "["
CORCHETE_CLOSE = "]"
LLAVE_OPEN = "{"
LLAVE_CLOSE = "}"

%%
<YYINITIAL> {

// Keywords
{IF}	                       { return symbol(Simbolos.IF); }
{ELSE}	                 { return symbol(Simbolos.ELSE); }
{WHILE}	                 { return symbol(Simbolos.WHILE); }
{DECVAR}	                 { return symbol(Simbolos.DECVAR); }
{ENDDEC}	                 { return symbol(Simbolos.ENDDEC); }
{WRITE}	                 { return symbol(Simbolos.WRITE); }
{READ}	                 { return symbol(Simbolos.READ); }
{INLIST}	                 { return symbol(Simbolos.INLIST); }
{MOD}                        { return symbol(Simbolos.MOD); }
{DIV}                        { return symbol(Simbolos.DIV); }
{INTEGER_TYPE}	           { return symbol(Simbolos.INTEGER_TYPE); }
{FLOAT_TYPE}	           { return symbol(Simbolos.FLOAT_TYPE); }
{STRING_TYPE}	           { return symbol(Simbolos.STRING_TYPE); }

// Operadores

{OP_GT}                      { return symbol(Simbolos.OP_GT); }
{OP_LT}                      { return symbol(Simbolos.OP_LT); }
{OP_GTE}                     { return symbol(Simbolos.OP_GTE); }
{OP_LTE}                     { return symbol(Simbolos.OP_LTE); }
{OP_NE}                      { return symbol(Simbolos.OP_NE); }
{OP_PLUS}                    { return symbol(Simbolos.OP_PLUS); }
{OP_MINUS}                   { return symbol(Simbolos.OP_MINUS); }
{OP_MULTI}                   { return symbol(Simbolos.OP_MULTI); }
{OP_DIVISION}                { return symbol(Simbolos.OP_DIVISION); }
{OP_NOT}                     { return symbol(Simbolos.OP_NOT); }
{OP_AND}                     { return symbol(Simbolos.OP_AND); }
{OP_OR}                      { return symbol(Simbolos.OP_OR); }
{OP_ASIG}                    { return symbol(Simbolos.OP_ASIG); }
{OP_EQ}                      { return symbol(Simbolos.OP_EQ); }
{OP_TYPE}                    { return symbol(Simbolos.OP_TYPE); }

// Caracteres especiales
{COMA}                         { return symbol(Simbolos.COMA); }
{PUNTO_COMA}                   { return symbol(Simbolos.PUNTO_COMA); }
{PAREN_OPEN}                   { return symbol(Simbolos.PAREN_OPEN); }
{PAREN_CLOSE}                  { return symbol(Simbolos.PAREN_CLOSE); }
{CORCHETE_OPEN}                { return symbol(Simbolos.CORCHETE_OPEN); }
{CORCHETE_CLOSE}               { return symbol(Simbolos.CORCHETE_CLOSE); }
{LLAVE_OPEN}                   { return symbol(Simbolos.LLAVE_OPEN); }
{LLAVE_CLOSE}                  { return symbol(Simbolos.LLAVE_CLOSE); }


{NESTED_COMMENT}	           { /* do nothing */ }
{COMMENT}	                 { /* do nothing */ }
{IDENTIFICADOR}	           { 
                                    String id = new String(yytext());
                                    int length = id.length();

                                    if(length <= RANGO_IDENTIFICADOR ){
                                          return symbol(Simbolos.IDENTIFICADOR); 
                                    }                                          
                                    else
                                    {
                                          System.err.println("El identificador [" + yytext() + "] esta fuera del limite de los los identificadores. (Se obtuvo " + length + ", maximo " + RANGO_IDENTIFICADOR + ")");                                    
                                          System.in.read();
                                          throw new Error("El identificador [" + yytext() + "] esta fuera del limite de los los identificadores. (Se obtuvo " + length + ", maximo " + RANGO_IDENTIFICADOR + ")");                                    
                                    }
                             }

{CONSTANTE_ENTERA}	     {                             
                                    Integer constInt = Integer.parseInt(yytext());

                                    if(Math.abs(constInt) <= RANGO_ENTERO ){
                                          return symbol(Simbolos.CONSTANTE_ENTERA);
                                    }                                          
                                    else
                                    {
                                          System.err.println("La constante [" + yytext() + "] esta fuera del limite de los enteros. (Se obtuvo " + constInt + ", maximo " + RANGO_ENTERO + ")");
                                          System.in.read();
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los enteros. (Se obtuvo " + constInt + ", maximo " + RANGO_ENTERO + ")"); 
                                    }
                             }
{CONSTANTE_FLOAT}            {
                                    Double constFloat = Double.parseDouble(yytext());
                                    if (Math.abs(constFloat) <= RANGO_FLOAT)
                                          return symbol(Simbolos.CONSTANTE_FLOAT);
                                    else
                                    {
                                          System.err.println("La constante [" + yytext() + "] esta fuera del limite de los flotantes. (Se obtuvo " + constFloat + ", maximo " + RANGO_FLOAT + ")");
                                          System.in.read();
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los flotantes. (Se obtuvo " + constFloat + ", maximo " + RANGO_FLOAT + ")");
                                    }
                              }

{CONSTANTE_STRING}            { 
                                    String constString = new String(yytext());
                                    // Restamos 2 por las comillas
                                    if (constString.length()-2 <= RANGO_STRING)
                                          return symbol(Simbolos.CONSTANTE_STRING); 
                                    else
                                    {
                                          System.err.println("La constante [" + yytext() + "] excede el largo permitido para un string. (Se obtuvo " + constString.length() + ", maximo " + RANGO_STRING + ")");
                                          System.in.read();
                                          throw new Error("La constante [" + yytext() + "] excede el largo permitido para un string. (Se obtuvo " + constString.length() + ", maximo " + RANGO_STRING + ")");
                                    } 
                              }                              
{WhiteSpace}                  { /* do nothing */ }

}

//--------> Errores Lexicos
[^]   {
            System.out.println("Error Léxico: --> " + yytext() + " <-- Linea " + (yyline+1) + " Columna " + yycolumn);
            throw new Error("Error léxico");
      }
<<EOF>>                          { return symbol(Simbolos.EOF); }