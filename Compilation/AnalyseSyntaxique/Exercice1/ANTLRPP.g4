grammar ANTLRPP;


binExpr returns [PPBinOp value]:
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



atomExpr returns [ PPExpr value ]:
c = Number { $value = new PPCte(Integer.parseInt($c.text)); }
| e1 = Alphabet { $value = new PPVar($e1.text); }
| '-' e2 = atomExpr { $value = new PPInv($e2.value); } 
| 'not' e3 = atomExpr { $value = new PPNot($e3.value); }
| 'true' { $value = new PPTrue(); }
| 'false' { $value = new PPFalse(); }
| e4 = calleeExpr '(' e5 = atomExpr*')' { $value = new PPFunCall($e4.value, new ArrayList<>() ); }
| e6 = array '[' e7 = Number']' { $value = new PPArrayGet($e6.text, Integer.parseInt($e7.text)); }
| 'new array of' e8 = type '[' e9 = Number ']'{ $value = new PPArrayAlloc($e8.text, Integer.parseInt($e9.text)); }
;

insExpr returns [ PPInst value ]:
e1 = Alphabet ':=' e2 = type { $value = new PPAssign($e1.text, $e2.text); }
| e3 = Alphabet '[' e4 = Number ']' ':=' e5 = type   { $value = new PPAPPArraySet($e3.text, $e4.text, $e5.text); }
| 'if' e6 = atomExpr 'then' e7 = insExpr 'else' e8 = insExpr { $value = new PPCond($e6.text, $e7.text, $e8.text); }
;

func    : ('a..z''A..Z')('a..z''A..Z''0..9')*;

calleeExpr returns [Callee value]:
'read' { $value = new Read(); }
|'write' { $value = new Write(); }
| x = func { $value = new User($x.text); }
;


type    : Integer | Bool | array;

array   : 'array of' type ;
Integer : 'integer';
Bool    : 'boolean';

Number  : ('0'..'9')+;
Alphabet: ('a..z')+;

WS      : [ \t\r\n]+ -> skip ;