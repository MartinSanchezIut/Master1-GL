(* #use "extension.ml";; *)

let rec get_vars l = function
 |Var n ->if not(List.mem n l) then l @ [n] else l
 |Not f ->get_vars l f
 |And (f1, f2) ->
 let l1 = get_vars l f1 in
 let l2 = get_vars l1 f2 in l2
 |Or (f1, f2) ->
 let l1 = get_vars l f1 in
 let l2 = get_vars l1 f2 in l2
 |Imp (f1, f2) ->
 let l1 = get_vars l f1 in
 let l2 = get_vars l1 f2 in l2
 |Equ (f1, f2) ->
 let l1 = get_vars l f1 in
 let l2 = get_vars l1 f2 in l2
 |_ ->l;;