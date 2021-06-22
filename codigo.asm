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
	_10	dd	10.0
	_20	dd	20.0
	_30	dd	30.0
	_2394	dd	2394.0
	_123	dd	123.0
	_243	dd	243.0
	@terceto4	dd	?
	@terceto5	dd	?
	@terceto10	dd	?
	@terceto11	dd	?
	@terceto13	dd	?
.CODE

start:
	MOV EAX,@DATA
	MOV DS,EAX
	MOV ES,EAX

	FLD _20
	FLD _30
	FMUL
	FSTP @terceto4
	FLD _10
	FLD @terceto4
	FADD
	FSTP @terceto5
	FLD @terceto5
	FSTP a
	FLD _123
	FLD _243
	FMUL
	FSTP @terceto10
	FLD _2394
	FLD @terceto10
	FMUL
	FSTP @terceto11
	FLD @terceto11
	FLD _10
	FSUB
	FSTP @terceto13
	FLD @terceto13
	FSTP b
