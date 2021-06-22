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
	_constString0	db	"LA REPUTA MADRE",'$',15 dup(?)
	_10	dd	10.0
	_20	dd	20.0
	_30	dd	30.0
	_2394	dd	2394.0
	_123	dd	123.0
	_243	dd	243.0
	@terceto5	dd	?
	@terceto6	dd	?
	@terceto11	dd	?
	@terceto12	dd	?
	@terceto14	dd	?
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
	FSTP @terceto5
	FLD _10
	FLD @terceto5
	FADD
	FSTP @terceto6
	FLD @terceto6
	FSTP a
	FLD _123
	FLD _243
	FMUL
	FSTP @terceto11
	FLD _2394
	FLD @terceto11
	FMUL
	FSTP @terceto12
	FLD @terceto12
	FLD _10
	FSUB
	FSTP @terceto14
	FLD @terceto14
	FSTP b
	DisplayFloat _10 , 2 
	newline 1
ET_END17: 
	MOV EAX, 4C00h
	INT 21h

	END start