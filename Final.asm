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
	@terceto193	dd	?
	@inlist0	dd	0
	@inlist1	dd	1
	@inlistFoundFlag203	dd	?
	@inlistFoundFlag225	dd	?
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
	FFREE
	JNE END_IF29
THEN27: 
	DisplayString _constString4
	newline 1
END_IF29: 
	DisplayString _constString5
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JAE IF_ELSE40
THEN37: 
	DisplayString _constString6
	newline 1
	JMP END_IF42
IF_ELSE40: 
	DisplayString _constString7
	newline 1
END_IF42: 
	DisplayString _constString8
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JBE IF_ELSE53
THEN50: 
	DisplayString _constString9
	newline 1
	JMP END_IF55
IF_ELSE53: 
	DisplayString _constString10
	newline 1
END_IF55: 
	DisplayString _constString11
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JB IF_ELSE66
THEN63: 
	DisplayString _constString12
	newline 1
	JMP END_IF68
IF_ELSE66: 
	DisplayString _constString13
	newline 1
END_IF68: 
	DisplayString _constString14
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JB IF_ELSE79
THEN76: 
	DisplayString _constString15
	newline 1
	JMP END_IF81
IF_ELSE79: 
	DisplayString _constString16
	newline 1
END_IF81: 
	DisplayString _constString17
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JE IF_ELSE92
THEN89: 
	DisplayString _constString18
	newline 1
	JMP END_IF94
IF_ELSE92: 
	DisplayString _constString19
	newline 1
END_IF94: 
	DisplayString _constString20
	newline 1
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JBE IF_ELSE105
THEN102: 
	DisplayString _constString21
	newline 1
	JMP END_IF107
IF_ELSE105: 
	DisplayString _constString22
	newline 1
END_IF107: 
	DisplayString _constString23
	newline 1
	FILD a
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE ET_LAZY_AND122
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE ET_LAZY_AND122
	JMP THEN124
ET_LAZY_AND122: 
	JMP END_IF126
THEN124: 
	DisplayString _constString24
	newline 1
END_IF126: 
	DisplayString _constString25
	newline 1
	FILD a
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE ET_LAZY_AND141
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE ET_LAZY_AND141
	JMP THEN143
ET_LAZY_AND141: 
	JMP END_IF145
THEN143: 
	DisplayString _constString26
	newline 1
END_IF145: 
	DisplayString _constString27
	newline 1
	FILD b
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JBE END_IF164
THEN153: 
	DisplayString _constString28
	newline 1
	FILD b
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE END_IF163
THEN161: 
	DisplayString _constString29
	newline 1
END_IF163: 
END_IF164: 
	DisplayString _constString30
	newline 1
	FILD b
	FILD a
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JBE END_IF189
THEN172: 
	DisplayString _constString31
	newline 1
CMP_WHILE174: 
	FILD a
	FILD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JAE END_WHILE188
THEN181: 
	FILD a
	FLD _10000
	FADD
	FISTP a
	DisplayInteger a 
	newline 1
	JMP CMP_WHILE174
END_WHILE188: 
END_IF189: 
	DisplayString _constString32
	newline 1
	FLD _2
	FLD _2
	FDIV 
	FISTP @terceto193
	FILD @terceto193
	FISTP c
	DisplayInteger c 
	newline 1
	DisplayString _constString33
	newline 1
	FLD _5
	FLD _2
	FXCH 
	FPREM 
	FISTP c
	DisplayInteger c 
	newline 1
	DisplayString _constString34
	newline 1
	FILD @inlist0 
	FISTP @inlistFoundFlag203
	FILD c
	FLD _0
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_CMP209
	FILD @inlist1
	FISTP @inlistFoundFlag203
INLIST_CMP209: 
	FILD c
	FLD _1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_CMP214
	FILD @inlist1
	FISTP @inlistFoundFlag203
INLIST_CMP214: 
	FILD c
	FLD _2
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_LOAD218
	FILD @inlist1
	FISTP @inlistFoundFlag203
INLIST_LOAD218: 
	FILD @inlistFoundFlag203
	FILD @inlist1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE END_IF223
THEN221: 
	DisplayString _constString35
	newline 1
END_IF223: 
	DisplayString _constString36
	newline 1
	FILD @inlist0 
	FISTP @inlistFoundFlag225
	FILD c
	FLD _3
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_CMP231
	FILD @inlist1
	FISTP @inlistFoundFlag225
INLIST_CMP231: 
	FILD c
	FLD _4
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_CMP236
	FILD @inlist1
	FISTP @inlistFoundFlag225
INLIST_CMP236: 
	FILD c
	FLD _5
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE INLIST_LOAD240
	FILD @inlist1
	FISTP @inlistFoundFlag225
INLIST_LOAD240: 
	FILD @inlistFoundFlag225
	FILD @inlist1
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	FFREE
	JNE IF_ELSE246
THEN243: 
	DisplayString _constString37
	newline 1
	JMP END_IF248
IF_ELSE246: 
	DisplayString _constString38
	newline 1
END_IF248: 
ET_END249: 
	MOV EAX, 4C00h
	INT 21h

	END start