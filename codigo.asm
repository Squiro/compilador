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
	_constString0	db	"Hola profe!!! :) :)",'$',19 dup(?)
	_constString1	db	":)",'$',2 dup(?)
	@terceto4	dd	?
	@terceto5	dd	?
	@terceto10	dd	?
	@terceto11	dd	?
	@terceto13	dd	?
	@terceto101	dd	?
	@terceto102	dd	?
	@terceto103	dd	?
	@terceto128	dd	?
	@terceto130	dd	?
	@terceto132	dd	?
	@terceto133	dd	?
	@terceto137	dd	?
	@terceto157	dd	?
	@terceto159	dd	?
	@terceto161	dd	?
	@terceto163	dd	?
	@terceto187	dd	?
	@terceto231	dd	?
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
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE IF_ELSE38
	DisplayFloat @terceto38 , 2 
	newline 1
THEN19: 
	FLD b
	FSTP a
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND31
	DisplayFloat @terceto31 , 2 
	newline 1
	FLD b
	FLD _0
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE ET_LAZY_AND31
	DisplayFloat @terceto31 , 2 
	newline 1
	JMP THEN33
	DisplayFloat @terceto33 , 2 
	newline 1
ET_LAZY_AND31: 
	JMP END_WHILE37
	DisplayFloat @terceto37 , 2 
	newline 1
THEN33: 
	FLD b
	FSTP a
	JMP THEN33
	DisplayFloat @terceto33 , 2 
	newline 1
END_WHILE37: 
IF_ELSE38: 
	JMP END_IF42
	DisplayFloat @terceto42 , 2 
	newline 1
	FLD a
	FSTP b
END_IF42: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JB END_IF50
	DisplayFloat @terceto50 , 2 
	newline 1
THEN47: 
	FLD _10
	FSTP a
END_IF50: 
	FLD a
	FLD _2
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE END_WHILE59
	DisplayFloat @terceto59 , 2 
	newline 1
THEN55: 
	FLD _0
	FSTP b
	JMP THEN55
	DisplayFloat @terceto55 , 2 
	newline 1
END_WHILE59: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE END_WHILE68
	DisplayFloat @terceto68 , 2 
	newline 1
THEN64: 
	FLD _0
	FSTP b
	JMP THEN64
	DisplayFloat @terceto64 , 2 
	newline 1
END_WHILE68: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE END_WHILE91
	DisplayFloat @terceto91 , 2 
	newline 1
THEN73: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE END_WHILE89
	DisplayFloat @terceto89 , 2 
	newline 1
THEN78: 
	FLD a
	FLD b
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE END_WHILE87
	DisplayFloat @terceto87 , 2 
	newline 1
THEN83: 
	FLD _0
	FSTP b
	JMP THEN83
	DisplayFloat @terceto83 , 2 
	newline 1
END_WHILE87: 
	JMP THEN78
	DisplayFloat @terceto78 , 2 
	newline 1
END_WHILE89: 
	JMP THEN73
	DisplayFloat @terceto73 , 2 
	newline 1
END_WHILE91: 
	FLD a
	FLD _2.35688
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE INLIST_CMP104
	DisplayFloat @terceto104 , 2 
	newline 1
	FLD @inlist1
	FSTP @inListFoundFlag
	FLD _34
	FLD d
	FMUL
	FSTP @terceto101
	FLD b
	FLD @terceto101
	FMUL
	FSTP @terceto102
	FLD a
	FLD @terceto102
	FADD
	FSTP @terceto103
INLIST_CMP104: 
	FLD a
	FLD @terceto103
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE INLIST_CMP109
	DisplayFloat @terceto109 , 2 
	newline 1
	FLD @inlist1
	FSTP @inListFoundFlag
INLIST_CMP109: 
	FLD a
	FLD _10000
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE INLIST_CMP114
	DisplayFloat @terceto114 , 2 
	newline 1
	FLD @inlist1
	FSTP @inListFoundFlag
INLIST_CMP114: 
	FLD a
	FLD c
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE INLIST_CMP119
	DisplayFloat @terceto119 , 2 
	newline 1
	FLD @inlist1
	FSTP @inListFoundFlag
INLIST_CMP119: 
	FLD a
	FLD _2
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JE INLIST_LOAD123
	DisplayFloat @terceto123 , 2 
	newline 1
	FLD @inlist1
	FSTP @inListFoundFlag
INLIST_LOAD123: 
	FLD @inListFoundFlag
@inListFoundFlag124: 
	FLD _23
	FLD _23434
	FMUL
	FSTP @terceto128
	FLD @terceto128
	FLD _23434
	FADD
	FSTP @terceto130
	FLD @terceto130
	FLD _23
	FPREM
	FSTP @terceto132
	FLD _23
	FLD @terceto132
	FMUL
	FSTP @terceto133
	FLD @terceto133
	FSTP a
	FLD _345
	FLD _234
	FDIV
	FISTP @terceto137
	FLD @terceto137
	FSTP b
	DisplayFloat _Hola profe!!! :) :) , 2 
	newline 1
	GetFloat b
	FLD b
	FLD _10
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND150
	DisplayFloat @terceto150 , 2 
	newline 1
	FLD l
	FLD _20
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE ET_LAZY_AND150
	DisplayFloat @terceto150 , 2 
	newline 1
	JMP THEN152
	DisplayFloat @terceto152 , 2 
	newline 1
ET_LAZY_AND150: 
	JMP IF_ELSE191
	DisplayFloat @terceto191 , 2 
	newline 1
THEN152: 
	FLD _10
	FSTP a
	FLD _34934
	FLD _345
	FMUL
	FSTP @terceto157
	FLD @terceto157
	FLD _2
	FADD
	FSTP @terceto159
	FLD @terceto159
	FLD _3
	FADD
	FSTP @terceto161
	FLD @terceto161
	FLD _43
	FDIV
	FISTP @terceto163
	FLD @terceto163
	FSTP a
	FLD c
	FLD _14
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE ET_LAZY_AND174
	DisplayFloat @terceto174 , 2 
	newline 1
	FLD z
	FLD _99
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JA ET_LAZY_AND174
	DisplayFloat @terceto174 , 2 
	newline 1
	JMP THEN176
	DisplayFloat @terceto176 , 2 
	newline 1
ET_LAZY_AND174: 
	JMP END_WHILE190
	DisplayFloat @terceto190 , 2 
	newline 1
THEN176: 
	FLD b
	FLD _10
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE END_IF184
	DisplayFloat @terceto184 , 2 
	newline 1
THEN181: 
	FLD _0
	FSTP b
END_IF184: 
	FLD c
	FLD _1
	FADD
	FSTP @terceto187
	FLD @terceto187
	FSTP c
	JMP THEN176
	DisplayFloat @terceto176 , 2 
	newline 1
END_WHILE190: 
IF_ELSE191: 
	JMP END_IF195
	DisplayFloat @terceto195 , 2 
	newline 1
	FLD _15
	FSTP d
END_IF195: 
	FLD var1
	FLD _423
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE OR_CMP201
	DisplayFloat @terceto201 , 2 
	newline 1
	JMP ETIQUETA_OR206
	DisplayFloat @terceto206 , 2 
	newline 1
OR_CMP201: 
	FLD var2
	FLD _20
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE IF_ELSE235
	DisplayFloat @terceto235 , 2 
	newline 1
ETIQUETA_OR206: 
THEN207: 
	DisplayFloat _:) , 2 
	newline 1
	FLD var3
	FLD _14
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JBE OR_CMP214
	DisplayFloat @terceto214 , 2 
	newline 1
	JMP ETIQUETA_OR219
	DisplayFloat @terceto219 , 2 
	newline 1
OR_CMP214: 
	FLD var4
	FLD _99
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JA END_WHILE234
	DisplayFloat @terceto234 , 2 
	newline 1
ETIQUETA_OR219: 
THEN220: 
	FLD b
	FLD _10
	FXCH
	FCOMP
	FSTSW AX
	SAHF
	JNE END_IF228
	DisplayFloat @terceto228 , 2 
	newline 1
THEN225: 
	FLD _0
	FSTP b
END_IF228: 
	FLD c
	FLD _1
	FADD
	FSTP @terceto231
	FLD @terceto231
	FSTP c
	JMP THEN220
	DisplayFloat @terceto220 , 2 
	newline 1
END_WHILE234: 
IF_ELSE235: 
	JMP END_IF239
	DisplayFloat @terceto239 , 2 
	newline 1
	FLD _15
	FSTP d
END_IF239: 
ET_END240: 
