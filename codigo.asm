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
	_2	dd	2.0
	_353	dd	353.0
	_constString1	db	"A ES MENOR QUE B",'$',16 dup(?)
	_constString2	db	"A SIGUE SIENDO MENOR QUE B",'$',26 dup(?)
	_constString3	db	"WHILE SUM 1000 A < B",'$',20 dup(?)
	_1000	dd	1000.0
	@terceto5	dd	?
	@terceto6	dd	?
	@terceto11	dd	?
	@terceto12	dd	?
	@terceto14	dd	?
	@terceto39	dd	?
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
	FLD _353
	FLD _20
	FMUL
	FSTP @terceto11
	FLD _2
	FLD @terceto11
	FMUL
	FSTP @terceto12
	FLD @terceto12
	FLD _10
	FSUB
	FSTP @terceto14
	FLD @terceto14
	FSTP b
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JAE END_IF22
THEN20: 
	DisplayString _constString1
	newline 1
END_IF22: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JA END_IF29
THEN27: 
	DisplayString _constString2
	newline 1
END_IF29: 
CMP_WHILE30: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JAE END_WHILE42
THEN35: 
	DisplayString _constString3
	newline 1
	FLD a
	FLD _1000
	FADD
	FSTP @terceto39
	FLD @terceto39
	FSTP a
	JMP CMP_WHILE30
END_WHILE42: 
ET_END43: 
	MOV EAX, 4C00h
	INT 21h

	END start