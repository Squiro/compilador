include number.asm
include macros2.asm

.MODEL LARGE ;Modelo de Memoria
 .386 ;Tipo de Procesador
.STACK 200h ;Bytes en el Stack

.DATA
 	a	dd	?
	b	dd	?
	c	dd	?
	d	dd	?
	e	dd	?
	f	dd	?
	_constString0	db	"Holaa :)",'$',8 dup(?)
	_10	dd	10.0
	_20	dd	20.0
	_30	dd	30.0
	_2	dd	2.0
	_353	dd	353.0
	_constString1	db	"VALORES INICIALES: ",'$',19 dup(?)
.CODE

start:
	MOV EAX,@DATA
	MOV DS,EAX
	MOV ES,EAX

	DisplayString _constString0
	newline 1
	FLD _20
	FLD _30
	FMUL
	FLD _10
	FADD
	FISTP a
	FLD _353
	FLD _20
	FMUL
	FLD _2
	FMUL
	FLD _10
	FSUB
	FISTP b
	DisplayString _constString1
	newline 1
	DisplayInteger a 
	newline 1
	DisplayInteger b 
	newline 1
ET_END19: 
	MOV EAX, 4C00h
	INT 21h

	END start