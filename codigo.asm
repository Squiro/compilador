include number.asm
include macros2.asm

.MODEL LARGE ;Modelo de Memoria
 .386 ;Tipo de Procesador
.STACK 200h ;Bytes en el Stack

.DATA
 	_10	dd	10.0
	@terceto3	dd	?
.CODE

start:
	MOV EAX,@DATA
	MOV DS,EAX
	MOV ES,EAX

	FLD _10
	FLD _10
	FADD 
	FSTP @terceto3
