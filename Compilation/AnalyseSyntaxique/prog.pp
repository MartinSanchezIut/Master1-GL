var n : integer

f (n : integer) : integer
var i : integer
if n = 0 then
    f := 1
else
    f := 1;
    i := 1;
    while i <= n do
        f := f * i ;
        i := i + 1

n := read();
write(f(n))

(progExpr 
    (pairArrayExpr 
        (pairExpr var n : 
            (typeExpr integer)
        )
    )
    listDefExpr 
        (insExpr f 
            ( n : integer )
        : integer var i : integer if n = 0 then f := 1 else f := 1 ; i := 1 ; while i <= n do f := f * i ; i := i + 1 n : = read ( ) ; write ( f ( n ) )))
