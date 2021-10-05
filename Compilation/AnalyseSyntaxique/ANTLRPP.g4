grammar ANTLRPP;



binExpr returns [PPBinOp value]:
e1 = atomExpr '+' e2 = atomExpr { $value = new PPAdd($e1.value, $e2.value); }
| e3 = atomExpr '-' e4 = atomExpr { $value = new PPSub($e3.value, $e4.value); }
| e5 = atomExpr '*' e6 = atomExpr { $value = new PPMul($e5.value, $e6.value); }
| e7 = atomExpr '/' e8 = atomExpr { $value = new PPDiv($e7.value, $e8.value); }
| e9 = atomExpr 'AND' e10 = atomExpr { $value = new PPAnd($e9.value, $10.value); } 
| e11 = atomExpr 'OR' e12 = atomExpr { $value = new PPAnd($e11.value, $12.value); } 
;



atomExpr returns [ PPExpr value ]:
c = Number { $value = new PPcte(Integer.parseInt($c.text));}
| e1 = Alphabet { $value = new PPVar($e1.value); }
| '-' e2 = atomExpr { $value = new PPInv($e2.value); } 
| 'not' e3 = atomExpr { $value = new PPNot($e3.value); }
| 'true' { $value = new PPTrue(); }
| 'false' { $value = new PPFalse(); }
| e4 = calleeExpr '(' e5 = atomExpr*')' { $value = new PPFunCall(e4.value, e5.value); }
;


calleeExpr returns [Callee value]:
'read' { $value = new Read(); }
|'write' { $value = new Write(); };

type : Integer | Bool | array;

array : 'array of' type ;
Integer : 'integer';
Bool : 'boolean';

Number : ('0'..'9')+;
Alphabet : ('a..z')+;

WS : [ \t\r\n]+ -> skip ;