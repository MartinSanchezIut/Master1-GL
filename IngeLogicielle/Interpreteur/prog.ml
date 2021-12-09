(* #use "prog.ml";; *)
type form =
|Top |Bot
|Var of string
|Not of form
|And of form * form
|Or of form * form
|Imp of form * form
|Equ of form * form;;
 (* ------------------------- *)
 (* toString *)
 let rec string_of_form = function
 |Top ->"true"
 |Bot ->"false"
 |Var n ->n
 |Not f ->"~" ^ (string_of_form f) (*^ est concat ́enation *)
 |And (f1, f2) ->
 "(" ^ (string_of_form f1) ^ "/\\" ^ (string_of_form f2) ^ ")"
 |Or (f1, f2) ->
 "(" ^ (string_of_form f1) ^ "\\/" ^ (string_of_form f2) ^ ")"
 |Imp (f1, f2) ->
 "(" ^ (string_of_form f1) ^ "->" ^ (string_of_form f2) ^ ")"
 |Equ (f1, f2) ->
 "(" ^ (string_of_form f1) ^ "<->" ^ (string_of_form f2) ^ ")";;
 let f = Imp (And (Var "A", Var "B"), Or (Not (Var "C"), Top));;
 print_endline (string_of_form f);;
 (* ------------------------- *)
 (* simplification des formules *)
 let simplif_and = function
 |(f, Top) |(Top, f) ->f
 |(_, Bot) |(Bot, _) ->Bot
 |(l, r) ->And (l, r);;
 let simplif_or = function
 |(_, Top) |(Top, _) ->Top
 |(f, Bot) |(Bot, f) ->f
 |(l, r) ->Or (l, r);;
 let simplif_imp = function
 |(_, Top) |(Bot, _) ->Top
 |(f, Bot) ->Not f
 |(Top, f) ->f
 |(l, r) ->Imp (l, r);;
 let simplif_equ = function
 |(f, Top) |(Top, f) ->f
 |(_, Bot) |(Bot, _) ->Bot
 |(l, r) ->Equ (l, r);;

 let rec simplif_form = function
 |And (f1, f2) ->
 let f1' = simplif_form f1
 and f2' = simplif_form f2 in
 simplif_and (f1', f2')
 |Or (f1, f2) ->
 let f1' = simplif_form f1
 and f2' = simplif_form f2 in
 simplif_or (f1', f2')
 |Imp (f1, f2) ->
 let f1' = simplif_form f1
 and f2' = simplif_form f2 in
 simplif_imp (f1', f2')
 |Equ (f1, f2) ->
 let f1' = simplif_form f1
 and f2' = simplif_form f2 in
 simplif_equ (f1', f2')
 |f ->f;;
 let f = And (Var "A", Or (Var "B", Top));;
 let f' = simplif_form f;;
 print_endline (string_of_form f);;
 print_endline (string_of_form f');;
 (* ------------------------- *)
 (*  ́evaluation des formules *)
 let rec eval_form l = function
 |Top ->true
 |Bot ->false
 |Var n ->
 (try List.assoc n l
 with Not_found ->failwith (n ^ " not in the assignment!"))
 |Not f ->not (eval_form l f)
 |And (f1, f2) ->
 let f1' = eval_form l f1
 and f2' = eval_form l f2 in
 f1' && f2'
 |Or (f1, f2) ->
 let f1' = eval_form l f1
 and f2' = eval_form l f2 in
 f1' ||f2'
 |Imp (f1, f2) ->
 let f1' = eval_form l f1
 and f2' = eval_form l f2 in
 (not f1') ||f2'
 |Equ (f1, f2) ->
 let f1' = eval_form l f1
 and f2' = eval_form l f2 in
 f1' = f2';;
 let f = Imp (Var "A", Imp (Var "B", Var "A"));;
 let l = [("A", true); ("B", true)];;
 eval_form l f;;