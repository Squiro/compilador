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
    int RANGO_ENTERO = Integer.MAX_VALUE;
    float RANGO_FLOAT = Float.MAX_VALUE;
    int RANGO_STRING = 30;
    private Symbol symbol(int type) {
          System.out.println("[LEX] TOKEN < " + Simbolos.terminalNames[type] + " > : " + yytext());
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

//DIGITO_BINARIO  = [0-1]
//DIGITO_HEXA     = [a-fA-F0-9]

// Construcciones del lenguaje
// -/ Así son los comentarios en el 2°Cuat de LyC -/ Comentario /- /-
COMMENT = "-/" ~"/-" | "-/" ~ "-/" ~ "/-" ~ "/-"
IDENTIFICADOR = {LETRA}[a-zA-Z0-9_]*({LETRA}|{DIGITO})+

// Constantes

CONSTANTE_ENTERA =  {DIGITO}+
CONSTANTE_FLOAT =  {DIGITO}+"."{DIGITO}+
STRING =  \".*\"

// Palabras reservadas
IF = "IF"
WHILE = "WHILE"
DECVAR = "DECVAR"
ENDDEC = "ENDDEC"
INTEGER = "INT"
FLOAT = "FLOAT"
WRITE = "WRITE"
READ = "READ"
INLIST = "INLIST"

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
OP_MODULE = "%" 
OP_INCREMENT = "++" 
OP_DECREMENT = "--"
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

%%
<YYINITIAL> {

// Keywords
{IF}	                       { return symbol(Simbolos.IF); }
{WHILE}	                 { return symbol(Simbolos.WHILE); }
{DECVAR}	                 { return symbol(Simbolos.DECVAR); }
{ENDDEC}	                 { return symbol(Simbolos.ENDDEC); }
{INTEGER}	                 { return symbol(Simbolos.INTEGER); }
{FLOAT}	                 { return symbol(Simbolos.FLOAT); }
{WRITE}	                 { return symbol(Simbolos.WRITE); }
{READ}	                 { return symbol(Simbolos.READ); }
{INLIST}	                 { return symbol(Simbolos.INLIST); }

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
{OP_MODULE}                  { return symbol(Simbolos.OP_MODULE); }
{OP_INCREMENT}               { return symbol(Simbolos.OP_INCREMENT); }
{OP_DECREMENT}               { return symbol(Simbolos.OP_DECREMENT); }
{OP_NOT}                     { return symbol(Simbolos.OP_NOT); }
{OP_AND}                     { return symbol(Simbolos.OP_AND); }
{OP_OR}                      { return symbol(Simbolos.OP_OR); }
{OP_ASIG}                    { return symbol(Simbolos.OP_ASIG); }
{OP_EQ}                      { return symbol(Simbolos.OP_EQ); }
{OP_TYPE}                      { return symbol(Simbolos.OP_TYPE); }

// Caracteres especiales
{COMA}                         { return symbol(Simbolos.COMA); }
{PUNTO_COMA}                   { return symbol(Simbolos.PUNTO_COMA); }
{PAREN_OPEN}                   { return symbol(Simbolos.PAREN_OPEN); }
{PAREN_CLOSE}                  { return symbol(Simbolos.PAREN_CLOSE); }
{CORCHETE_OPEN}                { return symbol(Simbolos.CORCHETE_OPEN); }
{CORCHETE_CLOSE}               { return symbol(Simbolos.CORCHETE_CLOSE); }


{COMMENT}	                 { return symbol(Simbolos.COMMENT); }
{IDENTIFICADOR}	           { return symbol(Simbolos.IDENTIFICADOR); }

{CONSTANTE_ENTERA}	     {                             
                                    Integer constInt = Integer.parseInt(yytext());

                                    if(Math.abs(constInt) <= RANGO_ENTERO ){
                                          return symbol(Simbolos.CONSTANTE_ENTERA);
                                    }                                          
                                    else
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los enteros."); 
                             }
{CONSTANTE_FLOAT}            {
                                    Double constFloat = Double.parseDouble(yytext());
                                    if (Math.abs(constFloat) <= RANGO_FLOAT)
                                          return symbol(Simbolos.CONSTANTE_FLOAT);
                                    else
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los flotantes.");
                              }

{STRING}                      { 
                                    String constString = new String(yytext());
                                    if (constString.length <= RANGO_STRING)
                                          return symbol(Simbolos.STRING); 
                                    else 
                                          throw new Error("La constante [" + yytext() + "] excede el largo permitido para un string.");
                              }                              
{WhiteSpace}                  { /* do nothing */ }

}

//--------> Errores Lexicos
[^]   {
            System.out.println("Error Léxico: --> " + yytext() + " <-- Linea " + (yyline+1) + " Columna " + yycolumn);
            throw new Error("Error léxico");
      }
<<EOF>>                          { /*return symbol(Simbolos.EOF);*/ throw new Error("END OF FILE"); }