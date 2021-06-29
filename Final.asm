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
	_constString2	db	"if sin else",'$',11 dup(?)
	_constString3	db	"a == a",'$',6 dup(?)
	_constString4	db	"TRUE",'$',4 dup(?)
	_constString5	db	"if a < b",'$',8 dup(?)
	_constString6	db	"TRUE",'$',4 dup(?)
	_constString7	db	"FALSE",'$',5 dup(?)
	_constString8	db	"if a > b",'$',8 dup(?)
	_constString9	db	"TRUE",'$',4 dup(?)
	_constString10	db	"FALSE",'$',5 dup(?)
	_constString11	db	"if a >= b",'$',9 dup(?)
	_constString12	db	"TRUE",'$',4 dup(?)
	_constString13	db	"FALSE",'$',5 dup(?)
	_constString14	db	"if a <= b",'$',9 dup(?)
	_constString15	db	"TRUE",'$',4 dup(?)
	_constString16	db	"FALSE",'$',5 dup(?)
	_constString17	db	"if a != b",'$',9 dup(?)
	_constString18	db	"TRUE",'$',4 dup(?)
	_constString19	db	"FALSE",'$',5 dup(?)
	_constString20	db	"if !(a <= b)",'$',12 dup(?)
	_constString21	db	"TRUE",'$',4 dup(?)
	_constString22	db	"FALSE",'$',5 dup(?)
	_constString23	db	"if (a == a && b == b)",'$',21 dup(?)
	_constString24	db	"Me parece que es true.",'$',22 dup(?)
	_constString25	db	"if (a > b || b > a)",'$',19 dup(?)
	_constString26	db	"TRUE",'$',4 dup(?)
	_constString27	db	"if anidado",'$',10 dup(?)
	_constString28	db	"b > a",'$',5 dup(?)
	_constString29	db	"b == b",'$',6 dup(?)
	_constString30	db	"IF con while anidado",'$',20 dup(?)
	_constString31	db	"while a < b",'$',11 dup(?)
	_10000	dd	10000.0
	_constString32	db	"2 DIV 2",'$',7 dup(?)
	_constString33	db	"5 MOD 2",'$',7 dup(?)
	_5	dd	5.0
	_constString34	db	"INLIST (c; [0; 1; 2])",'$',21 dup(?)
	_0	dd	0.0
	_1	dd	1.0
	_constString35	db	"TRUE",'$',4 dup(?)
	_constString36	db	"INLIST (c; [3; 4; 5])",'$',21 dup(?)
	_3	dd	3.0
	_4	dd	4.0
	_constString37	db	"TRUE",'$',4 dup(?)
	_constString38	db	"FALSE",'$',5 dup(?)
	@terceto5	dd	?
	@terceto6	dd	?
	@terceto11	dd	?
	@terceto12	dd	?
	@terceto14	dd	?
	@terceto154	dd	?
	@terceto163	dd	?
	@terceto169	dd	?
	@inlist0	dd	0
	@inlist1	dd	1
	@inlistFoundFlag173	dd	?
	@inlistFoundFlag195	dd	?
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
	FISTP a
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
	FISTP b
	DisplayString _constString1
	newline 1
	DisplayInteger a 
	newline 1
	DisplayInteger b 
	newline 1
	DisplayString _constString2
	newline 1
	DisplayString _constString3
	newline 1
	FILD a
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE END_IF27
THEN25: 
	DisplayString _constString4
	newline 1
END_IF27: 
	DisplayString _constString5
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JAE IF_ELSE36
THEN33: 
	DisplayString _constString6
	newline 1
	JMP END_IF38
IF_ELSE36: 
	DisplayString _constString7
	newline 1
END_IF38: 
	DisplayString _constString8
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE IF_ELSE47
THEN44: 
	DisplayString _constString9
	newline 1
	JMP END_IF49
IF_ELSE47: 
	DisplayString _constString10
	newline 1
END_IF49: 
	DisplayString _constString11
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JB IF_ELSE58
THEN55: 
	DisplayString _constString12
	newline 1
	JMP END_IF60
IF_ELSE58: 
	DisplayString _constString13
	newline 1
END_IF60: 
	DisplayString _constString14
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JB IF_ELSE69
THEN66: 
	DisplayString _constString15
	newline 1
	JMP END_IF71
IF_ELSE69: 
	DisplayString _constString16
	newline 1
END_IF71: 
	DisplayString _constString17
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE IF_ELSE80
THEN77: 
	DisplayString _constString18
	newline 1
	JMP END_IF82
IF_ELSE80: 
	DisplayString _constString19
	newline 1
END_IF82: 
	DisplayString _constString20
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE IF_ELSE91
THEN88: 
	DisplayString _constString21
	newline 1
	JMP END_IF93
IF_ELSE91: 
	DisplayString _constString22
	newline 1
END_IF93: 
	DisplayString _constString23
	newline 1
	FILD a
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND104
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND104
	JMP THEN106
ET_LAZY_AND104: 
	JMP END_IF108
THEN106: 
	DisplayString _constString24
	newline 1
END_IF108: 
	DisplayString _constString25
	newline 1
	FILD a
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND119
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND119
	JMP THEN121
ET_LAZY_AND119: 
	JMP END_IF123
THEN121: 
	DisplayString _constString26
	newline 1
END_IF123: 
	DisplayString _constString27
	newline 1
	FILD b
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE END_IF138
THEN129: 
	DisplayString _constString28
	newline 1
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE END_IF137
THEN135: 
	DisplayString _constString29
	newline 1
END_IF137: 
END_IF138: 
	DisplayString _constString30
	newline 1
	FILD b
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE END_IF159
THEN144: 
	DisplayString _constString31
	newline 1
CMP_WHILE146: 
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JAE END_WHILE158
THEN151: 
	FILD a
	FLD _10000
	FADD
	FSTP @terceto154
	FLD @terceto154
	FISTP a
	DisplayInteger a 
	newline 1
	JMP CMP_WHILE146
END_WHILE158: 
END_IF159: 
	DisplayString _constString32
	newline 1
	FLD _2
	FLD _2
	FDIV
	FISTP @terceto163
	FILD @terceto163
	FISTP c
	DisplayInteger c 
	newline 1
	DisplayString _constString33
	newline 1
	FLD _5
	FLD _2
	 FXCH 
	 FPREM 
	FSTP @terceto169
	FLD @terceto169
	FISTP c
	DisplayInteger c 
	newline 1
	DisplayString _constString34
	newline 1
	FILD @inlist0 
	FISTP @inlistFoundFlag173
	FILD c
	FLD _0
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_CMP179
	FILD @inlist1
	FISTP @inlistFoundFlag173
INLIST_CMP179: 
	FILD c
	FLD _1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_CMP184
	FILD @inlist1
	FISTP @inlistFoundFlag173
INLIST_CMP184: 
	FILD c
	FLD _2
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_LOAD188
	FILD @inlist1
	FISTP @inlistFoundFlag173
INLIST_LOAD188: 
	FILD @inlistFoundFlag173
	FILD @inlist1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE END_IF193
THEN191: 
	DisplayString _constString35
	newline 1
END_IF193: 
	DisplayString _constString36
	newline 1
	FILD @inlist0 
	FISTP @inlistFoundFlag195
	FILD c
	FLD _3
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_CMP201
	FILD @inlist1
	FISTP @inlistFoundFlag195
INLIST_CMP201: 
	FILD c
	FLD _4
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_CMP206
	FILD @inlist1
	FISTP @inlistFoundFlag195
INLIST_CMP206: 
	FILD c
	FLD _5
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE INLIST_LOAD210
	FILD @inlist1
	FISTP @inlistFoundFlag195
INLIST_LOAD210: 
	FILD @inlistFoundFlag195
	FILD @inlist1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE IF_ELSE216
THEN213: 
	DisplayString _constString37
	newline 1
	JMP END_IF218
IF_ELSE216: 
	DisplayString _constString38
	newline 1
END_IF218: 
ET_END219: 
	MOV EAX, 4C00h
	INT 21h

	END start