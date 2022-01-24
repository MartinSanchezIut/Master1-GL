
(require "vm.lsp")

(require "instructions.lsp")
(require "getterSetter.lsp")
(defun make-test (vm)

(make-machine vm)








(mv-MOVE vm '(:CONST 5) :R0)
;;(cdr '(:CONST 4))
(format T "addition 7+5 :  ~d
" (mv-ADD vm '(:CONST 7) :R0))


(format T "soustraction 7-12 : ~d
" (mv-SUB vm '(:CONST 7) :R0))


(format T "multiplication 7*5 : ~d
" (mv-MULT vm '(:CONST 7) :R0))


(format T "division 35/7 : ~d
" (mv-DIV vm '(:CONST 7) :R0))

(format T "incre 5: ~d
" (mv-INCR vm :R0))



(mv-MOVE vm :R0 :R1)
(mv-MOVE vm '(:CONST 0) :R0)
(format T "R1 =  ~d
" (getProp vm :R1))


(mv-MOVE vm '(:CONST 10) :R3)
(mv-MOVE vm :R3 :R0)
(format T "R0 =  ~d
" (getProp vm :R0))

(mv-MOVE vm '(:CONST 0) :R0)
(format T "R1 =  ~d
" (getProp vm :R1))

(format T "R0 =  ~d
" (getProp vm :R0))

(mv-MOVE vm :R1 :R0)

(format T "R0 =  ~d
" (getProp vm :R0))


(mv-MOVE vm :R0 :R1)

(format T "R1 =  ~d
" (getProp vm :R1))


(format T "decr 6: ~d
" (mv-DECR vm :R0))


(format T "MOVE 69 dans le registre R2:
")
(mv-MOVE vm '(:CONST 69) :R2)
(format T "R2 =  ~d
" (getProp vm :R2))



(format T "StORE DANS LA MEMOIRE a la case 500 fournie a R1:
")

(mv-MOVE vm '(:CONST 500) :R1)
(format T "R1: ~d
"  (getProp vm :R1))



(mv-STORE vm :R2 :R1)

(format T "MEMOIRE 500: ~d
"  (aref (getProp vm :memoire) 500))

;;(write (get vm :memoire))


(format T "Fait un Load de la case 500 dans R3
")
(mv-LOAD vm :R1 :R3)


(format T "R3 =  ~d
" (getProp vm :R3))


(mv-MOVE vm '(:CONST 5) :R0)


(mv-MOVE vm '(:CONST 7) :R1)


(format T "Comparaison entre 5 et 7")
(mv-CMP vm :R0 :R1)

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)

(format T "Comparaison entre 7 et 5")
(mv-CMP vm :R1 :R0)

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)



(format T "Comparaison entre 7 et 7")
(mv-CMP vm :R1 :R1)

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)


(format T "Avec constante
")


(format T "Comparaison entre 5 et 7")
(mv-CMP vm '(:CONST 5) '(:CONST 7))

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)

(format T "Comparaison entre 7 et 5")
(mv-CMP vm '(:CONST 7) '(:CONST 5))

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)



(format T "Comparaison entre 7 et 7")
(mv-CMP vm '(:CONST 7) '(:CONST 7))

(format T "affichage flag  =  FLT : ~d  FEQ : ~d    FGT : ~d
" (getProp vm :FLT)
 (getProp vm :FEQ)
 (getProp vm :FGT)
)

(format T "Je créer mon label
")

(vm_LABEL vm 'monlabel)





(mv-MOVE vm '(:CONST 900) :PC)


(mv-INCR vm :PC)
(mv-INCR vm :PC)
(mv-INCR vm :PC)

(format T "PC =  ~d
" (getProp vm :PC))


(format T "affichage etiquette  =  valeur de l'etiquette : ~d
"(vm_get_hashTab_etq_resolu vm 'monlabel )
)

(format T "JUMP
"
)

(vm-JMP vm 'monlabel)

(format T "PC =  ~d
" (getProp vm :PC))



(mv-MOVE vm 0 :R0)


(format T "R0 =  ~d
" (getProp vm :R0))



(format T "SP : ~d
" (getProp vm :SP))


(format T "JSR
")


(vm-JSR vm 'if)

(format T "SP : ~d
" (getProp vm :SP))

(format T "RTN
")

(vm-RTN vm)
(format T "SP : ~d
" (getProp vm :SP))

(format T "R0 =  ~d
" (getProp vm :R0))


(format T "FIN
")






)

