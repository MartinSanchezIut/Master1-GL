
grammar grammaire;

atomExpr returns [ PPExpr value ] :
c = Number { $value = new PPCte(Integer.parseInt($c.text));}
| 'true' { $value = new PPTrue(); }
| 'false' { $value = new PPFalse(); }
;
fun returns [ PPExpr value ] :
 e25 = calleeExpr '(' e26 = listExpr ')'{$value = new PPFunCall($e25.value,$e26.value);}
| e27 = atomExpr e28 = atomExpr {$value = new PPArrayGet($e27.value,$e28.value);}
//| e29 = type e30 = atomExpr {$value = new PPArrayAlloc($e29.text,$e30.value);} //marche pas 
;

unOperation returns [ PPUnOp value ] :
| '-' e2 = atomExpr { $value = new PPInv($e2.value); } 
| 'not' e3 = atomExpr { $value = new PPNot($e3.value); }
;


var returns [ PPExpr value ] :
c = Alphabet { $value = new PPVar($c.text);}
;


binExpr returns [PPBinOp value]:
e1 = atomExpr '+' e2 = atomExpr { $value = new PPAdd($e1.value, $e2.value); }
| e3 = atomExpr '-' e4 = atomExpr { $value = new PPSub($e3.value, $e4.value); }
| e5 = atomExpr '*' e6 = atomExpr { $value = new PPMul($e5.value, $e6.value); }
| e7 = atomExpr '/' e8 = atomExpr { $value = new PPDiv($e7.value, $e8.value); };




//pas sur
listExpr returns [ArrayList <PPExpr> value ]
@init { $value = new ArrayList<PPExpr>() ;} :
( e = atomExpr {$value.add($e.value);})
;


bincond returns [PPBinOp value]:
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
| x = func { $value = new User($x.text); }
;



insExpr returns [ PPInst value ]:
e1 = Alphabet ':=' e2 = atomExpr { $value = new PPAssign($e1.text, $e2.value); }
| 'if' e6 = bincond 'then' e7 = insExpr 'else' e8 = insExpr { $value = new PPCond($e6.value, $e7.value, $e8.value); }
| e11 = atomExpr e12 = atomExpr e13 = atomExpr {$value = new PPArraySet($e11.value, $e12.value ,$e13.value  );}// a compléter
|e14 = calleeExpr e15 = listExpr{$value = new PPProcCall($e14.value, $e15.value );}// a compléter
|e16 = insExpr e17 = insExpr{$value = new PPSeq($e16.value, $e17.value );} // a compléter
| 'While' e9 = bincond 'do' e10 = insExpr { $value = new PPWhile($e9.value, $e10.value); }
;


funproc returns [ PPDef value ]:
//e1 = Alphabet e2 = listExpr  e3 = listExpr e4= insExpr e5 = type { $value = new PPFun($e1.text, $e2.value ,$e3.value ,e4.value,e5.value ); } //marche pas
;

type    : entier | Bool |array;
entier : 'Int';
Bool    : 'Bool';
array : 'array of' type;
Alphabet: ('a..z')+;
Number : ('0'.. '9')+ ;
func    : ('a..z''A..Z')('a..z''A..Z''0..9')*;
WS : [\t\r\n ]+ -> skip ;