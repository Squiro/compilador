# LyC 2021 1C - Compilador

Este repositorio contiene el compilador hecho por el grupo 2 de LyC 2021 1C. 

El mismo está desarrollado en base a las siguientes herramientas y lenguajes de programación:

* Java
* JFLEX (lexer)
* JCUP (parser)

## JFLEX y CUP

El repositorio contiene los binarios de JFLEX y JCUP incorporados localmente en la ruta /lib, para no tener que depender de tener instaladas dichas herramientas en el sistema.

Además, se incluye un archivo *run-jflex.bat*, el cual se encarga de ejecutar estas herramientas sobre los archivos .jflex y .cup, con el fin de "compilarlos" en sus clases .java correspondientes. Este archivo deberá ejecutarse cada vez que se realice una modificación tanto al léxico como a la gramática del lenguaje.