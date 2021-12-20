
(setq liste_registre '(:R0 :R1 :R2 :SP :BP :FP :PC))

(defun is_register (registre)
  (position registre liste_registre))


(defun mv-LOAD (vm adr reg)
    (cond 
    ((listp adr ) (set-prop vm reg (getmemoire vm (car (cdr adr)) )))
    ((is_register adr ) (set-prop vm reg (getmemoire vm (getProp vm adr) )))
    ((numberp adr ) (set-prop vm reg (getmemoire vm adr )))
    )
)


(defun mv-STORE (vm reg adr)
    (cond 
    ((listp adr ) (setmemoire vm (car (cdr adr)) (getProp vm reg)))
    ((is_register adr ) (setmemoire vm (getProp vm adr) (getProp vm reg)))
    ((numberp adr ) (setmemoire vm adr (getProp vm reg)))
    )


    (if (listp adr)
    (setmemoire vm (car (cdr adr)) (getProp vm reg))
    (setmemoire vm (getProp vm adr) (getProp vm reg))
    )
)


(defun mv-MOVE (vm src dst)
    (cond 
    ((listp src ) (set-prop vm dst (car (cdr src))))
    ((is_register src ) (set-prop vm dst (get vm src)))
    ((numberp src ) (set-prop vm dst src))
    ( (set-prop vm dst src))
    )

)


(defun mv-ADD (vm src dst)
    (if (listp src)
        (set-prop vm dst (+ (getProp vm dst)  (car (cdr src))) )
        (set-prop vm dst (+ (getProp vm dst) (getProp vm src)) )
    )
)

(defun mv-SUB (vm src dst)
    (if (listp src)
        (set-prop vm dst (- (getProp vm dst)  (car (cdr src))) )
        (set-prop vm dst (- (getProp vm dst) (getProp vm src)) )
    )
)

(defun mv-MULT (vm src dst)
    (if (listp src)
        (set-prop vm dst (* (getProp vm dst)  (car (cdr src))) )
        (set-prop vm dst (* (getProp vm dst) (getProp vm src)) )
    )
)

(defun mv-DIV (vm src dst)
    (if (listp src)
        (set-prop vm dst (/ (getProp vm dst)  (car (cdr src))) )
        (set-prop vm dst (/ (getProp vm dst) (getProp vm src)) )
    )
)


(defun mv-INCR (vm reg)
    (mv-ADD vm  '(:CONST 1) reg)
)
(defun mv-DECR (vm reg)
    (mv-SUB vm  '(:CONST 1) reg)
)

(defun mv-PUSH (mv src)
  (mv-INCR mv :SP)
  (mv-STORE mv src :SP)
  )

(defun mv-POP (mv dst)
  (mv-LOAD mv src :SP)
  (mv-DECR mv :SP)
)





(defun isLABEL (arg)
	(and (consp arg) (eql (car arg) 'LABEL))
)

(defun vm_LABEL( mv label)

  (if (not (vm_get_hashTab_etq_resolu mv label))
   (vm_set_hashTab_etq_resolu mv label (getProp mv :LC))
  )
   
)


(defun vm-JMP( mv label)

(mv-MOVE mv (vm_get_hashTab_etq_resolu mv label) :LC)



)


(defun vm-JSR( mv label)


(mv-INCR mv :LC)
(mv-PUSH mv :LC)
(vm-JMP mv label)

)



(defun vm-RTN(mv)


(mv-LOAD mv :SP :R0)
(mv-DECR mv :SP)
(vm-JMP mv :R0)


)




(defun mv-CMP (mv reg1 reg2)
(if (listp reg1)
    (setq gauche (car (cdr reg1)))
    (setq gauche (getProp mv reg1))

)

(if (listp reg2)
    (setq droite (car (cdr reg2)))
    (setq droite (getProp mv reg2))

)
    (cond 
    
    ((eql gauche droite ) (setFlag mv 0 1 0))
    ((< gauche droite ) (setFlag mv 1 0 0))
    ((> gauche droite ) (setFlag mv 0 0 1))
    )
)

(defun vm-JGT( mv label) ; saut si plus grand


  (if (and  (not (getProp vm :FLT))(not (getProp vm :FEQ))(getProp vm :FGT))
  (vm_jmp vm label)
  (vm_incr vm :LC))

)


(defun vm-JGE( mv label) ;saut plus grand ou egal
  (if (and  (not (getProp vm :FLT)) (or (getProp vm :FEQ) (getProp vm :FGT)))
  (vm_jmp vm label)
  (vm_incr vm :LC))

)


(defun vm-JLT( mv label) ; saut plus petit

  (if (and  (getProp vm :FLT) (and (not (getProp vm :FEQ)) (not (getProp vm :FGT))))
  (vm_jmp vm label)
  (vm_incr vm :LC))

)

(defun vm-JLE( mv label) ; plus petit ou egal

  (if (and  (or (getProp vm :FLT) (getProp vm :FEQ)) (not (getProp vm :FGT)))
  (vm_jmp vm label)
  (vm_incr vm :LC))

)

(defun vm-JEQ( mv label) ; si egal

  (if (and  (not (getProp vm :FLT)) (and (getProp vm :FEQ)  (not (getProp vm :FGT))))
  (vm_jmp vm label)
  (vm_incr vm :LC))
)

(defun vm-JNE( mv label) ; si different

  (if (and  (getProp vm :FLT) (and (not (getProp vm :FEQ))  (getProp vm :FGT)))
  (vm_jmp vm label)
  (vm_incr vm :LC))

)

(defun vm_set_flag_ON (vm drapeau)
  (if (is_flag_? drapeau)
    (setf (get vm drapeau) T)
    (warn "ERR 2: doit etre un drapeau")))
(trace vm_set_flag_ON)

;permet de changer la valeur du drapeau
(defun vm_set_flag_OFF (vm drapeau)
  (if (is_flag_? drapeau)
    (setf (get vm drapeau) nil)
    (warn "ERR 2: doit etre un drapeau")))





(defun vm-TEST( mv label)


)


(defun vm-JTRUE( mv label)

(if (getProp vm :FNIL)

  (vm_jmp vm label)
  (vm_incr vm :LC)

)


)



(defun vm-JNIL( mv label)

(if (not (getProp vm :FNIL))

  (vm_jmp vm label)
  (vm_incr vm :LC)

)

)


(defun mv_NOP (vm))





(defun mv_HALT (vm)
	(set-prop vm :exitVM 1)
)

;; Gestion symboles resolus

;;(defun setSymbole (vm symb adr)
;;	(setf (gethash symb (get vm :etiq)) adr)
;;)

;;(defun mv-LABEL (mv label)
;;setf (gethash symb (get vm :etiq)) adr)
;;)
