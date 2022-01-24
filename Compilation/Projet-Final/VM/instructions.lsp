
(setq liste_registre '(:R0 :R1 :R2 :R3 :R4 :R5 :R6 :R7 :R8 :R9 :R10 :R11 :SP :BP :FP :PC))
(defun is_register (registre)
  (position registre liste_registre)

  )
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
    ((is_register src ) (set-prop vm dst (getProp vm src)))
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
  (mv-STORE mv src :SP)
    (mv-INCR mv :SP)
  )

(defun mv-POP (mv src)
  (mv-DECR mv :SP)
(mv-MOVE mv (aref (getProp mv :memoire) (getProp mv :SP)) src)
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
(format t "
~d
" (getProp mv :LC))
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

(defun vm-JGT( vm label) ; saut si plus grand


  (if (and  (eql (getProp vm :FLT) 0)(eql (getProp vm :FEQ) 0) (eql (getProp vm :FGT) 1))
  (vm-JMP vm label)
)

)
(defun vm-JGE( vm label) ;saut plus grand ou egal
  (if (and  (eql (getProp vm :FLT) 0) (or (eql (getProp vm :FEQ) 1) (eql (getProp vm :FGT)1)))
  (vm-JMP vm label)

)

)


(defun vm-JLT( vm label) ; saut plus petit
  (if (and  (eql (getProp vm :FLT) 1) (and (eql (getProp vm :FEQ) 0) (eql (getProp vm :FGT) 0)))
   (vm-JMP vm label)
)
)
(defun vm-JLE( vm label) ; plus petit ou egal

  (if (and  (or (eql (getProp vm :FLT) 1) (eql (getProp vm :FEQ) 1)) (eql (getProp vm :FGT) 0))
  (vm-JMP vm label)
)
)

(defun vm-JEQ( vm label) ; si egal

  (if (and  (eql (getProp vm :FLT) 0) (and (eql (getProp vm :FEQ) 1)  (eql (getProp vm :FGT) 0)))
  (vm-JMP vm label)
)

)

(defun vm-JNE( vm label) ; si different

  (if (and  (eql (getProp vm :FLT) 1) (and (eql (getProp vm :FEQ) 0)  (eql (getProp vm :FGT) 1)))
  (vm-JMP vm label)

)
)





(defun vm-TEST( vm label)


)


(defun vm-JTRUE( vm label)

(if (getProp vm :FNIL)
  (vm-JMP vm label)

)


)



(defun vm-JNIL( vm label)

(if (not (getProp vm :FNIL))
  (vm-JMP vm label)

)

)


(defun mv_NOP (vm))





(defun mv_HALT (vm)
	(set-prop vm :exitVM 1)
)