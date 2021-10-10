grammar grammaire;

/*
boolExpr returns [ PPExpr value ] :
| 'true' { $value = new PPTrue(); }
| 'false' { $value = new PPFalse(); }
;

cteExpr returns [ PPExpr value ] :
x = Number { $value = new PPCte(Integer.parseInt($x.text));}
;

varExpr returns [ PPExpr value ] :
'var ' x = VarFormat { $value = new PPVar($x.text);}
;
atomExpr returns [ PPExpr value ] :
boolExpr | cteExpr | varExpr* ; */

evaluableExpr returns [ PPExpr value] :
    atomExpr | binOpExpr | calleeExpr | funCallExpr;

atomExpr returns [ PPExpr value ] :
x = Number { $value = new PPCte(Integer.parseInt($x.text));}
| 'true' { $value = new PPTrue(); }
| 'false' { $value = new PPFalse(); }
//| 'var' x = VarFormat { $value = new PPVar($x.text);}
| c = VarFormat { $value = new PPVar($c.text);}
;

unOpExpr returns [ PPUnOp value ] :
| '-' a = atomExpr { $value = new PPInv($a.value); } 
| 'not' c = atomExpr { $value = new PPNot($c.value); }
;

typeExpr returns [ Type value ]:
    'integer' { $value = new Int(); } 
    | 'bool' { $value = new Bool(); }
    | 'array of ' z = typeExpr { $value = new Array($z.value); }
;

binOpExpr returns [PPBinOp value]:
e1 = atomExpr '+' e2 = atomExpr { $value = new PPAdd($e1.value, $e2.value); }
| e3 = atomExpr '-' e4 = atomExpr { $value = new PPSub($e3.value, $e4.value); }
| e5 = atomExpr '*' e6 = atomExpr { $value = new PPMul($e5.value, $e6.value); }
| e7 = atomExpr '/' e8 = atomExpr { $value = new PPDiv($e7.value, $e8.value); }
| e9 = atomExpr 'AND' e10 = atomExpr { $value = new PPAnd($e9.value, $e10.value); } 
| e11 = atomExpr 'OR' e12 = atomExpr { $value = new PPOr($e11.value, $e12.value); } 
| e13 = atomExpr '<' e14 = atomExpr { $value = new PPLt($e13.value, $e14.value); } 
| e15 = atomExpr '<=' e16 = atomExpr { $value = new PPLe($e15.value, $e16.value); } 
| e17 = atomExpr '=' e18 = atomExpr { $value = new PPEq($e17.value, $e18.value); } 
| e19 = atomExpr '!=' e20 = atomExpr { $value = new PPNe($e19.value, $e20.value); } 
| e21 = atomExpr '>=' e22 = atomExpr { $value = new PPGe($e21.value, $e22.value); } 
| e23 = atomExpr '>' e24 = atomExpr { $value = new PPGt($e23.value, $e24.value); } 
;

calleeExpr returns [Callee value]:
'read' { $value = new Read(); }
|'write' { $value = new Write(); }
| x = VarFormat { $value = new User($x.text); }
;

listExpr returns [ArrayList<PPExpr> value]
    @init{$value = new ArrayList<PPExpr>();} : 
(e = atomExpr {$value.add($e.value);})*
//| (f = varExpr {$value.add($f.value);})+
;

funCallExpr returns [PPExpr value]:
a = calleeExpr '(' b = listExpr ')'{ $value = new PPFunCall($a.value,$b.value);}
| x = atomExpr '[' y = atomExpr ']'{ $value = new PPArrayGet($x.value,$y.value);}
| 'new array of ' t8 = typeExpr '['t9 = atomExpr']' { $value = new PPArrayAlloc($t8.value, $t9.value );}
//x = varExpr '[' y = atomExpr ']'{ $value = new PPArrayGet($x.value,$y.value);}
;

insExpr returns [ PPInst value ]:
e1 = VarFormat ':=' e2 = evaluableExpr { $value = new PPAssign($e1.text, $e2.value); }
| e11 = atomExpr '['e12 = atomExpr ']' ':=' e13 = evaluableExpr { $value = new PPArraySet($e11.value, $e12.value ,$e13.value);}
| 'if' e6 = evaluableExpr 'then' e7 = insExpr 'else' e8 = insExpr { $value = new PPCond($e6.value, $e7.value, $e8.value); }
| 'while' e9 = evaluableExpr 'do' e10 = insExpr { $value = new PPWhile($e9.value, $e10.value); }
| e14 = calleeExpr '('e15 = listExpr')'{$value = new PPProcCall($e14.value, $e15.value );}
| 'skip'{new PPSkip();}
| e16 = insExpr ';' e17 = insExpr{$value = new PPSeq($e16.value, $e17.value );}
;

pairExpr returns [Pair<String,Type> value ]:
    c = VarFormat ':' d =  typeExpr { $value = new Pair($c.text, $d.value); }
    | 'var' c = VarFormat ':' d =  typeExpr { $value = new Pair($c.text, $d.value); }
;
pairArrayExpr returns [ArrayList <Pair<String,Type>> value ]
    @init { $value = new ArrayList<Pair<String,Type>>() ;} :
(e = pairExpr {$value.add($e.value);})
;

funcExpr returns [ PPDef value ]:
e1 = VarFormat '(' e2 = pairArrayExpr ')' ':' e5 = typeExpr e3 = pairArrayExpr e4= insExpr  
{ $value = new PPFun($e1.text, $e2.value ,$e3.value , $e4.value, $e5.value ); }

e1 = VarFormat '(' e2 = pairArrayExpr ')' e3 = pairArrayExpr e4= insExpr  
{ $value = new PPProc($e1.text, $e2.value ,$e3.value ,$e4.value ); }
;


listDefExpr returns [ArrayList <PPDef> value ]
    @init { $value = new ArrayList<PPDef>() ;} :
(e = funcExpr {$value.add($e.value);})+
;

progExpr returns [ PPProg value ]:
e1 = pairArrayExpr e2 = listDefExpr e3 = insExpr 
{ $value = new PPProg($e1.value, $e2.value, $e3.value); }
;

//VarFormat: ('a'..'z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
VarFormat: ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
//FunFormat: ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
//FunFormat: ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
//FunFormat: ('A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
Alphabet: ('a'..'z' | 'A'..'Z')+;
Number  : ('0'..'9')+ ;
WS : [ \t\r\n]+ -> skip ;