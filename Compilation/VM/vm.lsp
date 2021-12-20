;; Fonctions structurelles de la machine virtuelle.
;; nom : Nom de la machine.
;; R0, R1, R2 : Registres.
;; BP : Base Pointer initialisé à 100, pile montante.
;; SP : Stack Pointer, si pile vide SP = BP.
;; PC : Program Counter, compteur ordinal, position dans le code.
;; FP : Frame Pointer

;; FLT : Drapeau de comparaison "plus petit".
;; FEQ : Drapeau de comparaison "égalité".
;; FGT : Drapeau de comparaison "plus grand".

;; taille : Taille allouée à la mémoire (pile + tas + code).
;; memtab : Mémoire de la machine.

;; LC : Load Counter, position du chargement du code.
;; etiq : Table de hashage pour les étiquettes.
;; etiqNR : Table de hashage des étiquettes non résolues


(require "getterSetter.lsp")
(require "instructions.lsp")

(defun make-machine (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :nom) nomVM)
    (setf (get nomVM :R0) 0)
    (setf (get nomVM :R1) 0)
    (setf (get nomVM :R2) 0)

    ;; Var globale ??
    (setf (get nomVM :BP) 100)
    (setf (get nomVM :SP) (get nomVM :BP)) 
    (setf (get nomVM :FP) (get nomVM :BP))

    ;; Var globale ??
    (setf (get nomVM :MAXPILE) (floor(* tailleMem 0.9)))

    (setf (get nomVM :FLT) 0)
    (setf (get nomVM :FEQ) 0)
    (setf (get nomVM :FGT) 0)
    (setf (get nomVM :FNIL) 0)



    (setf (get nomVM :exitVM) 0)

    ;; (setf (get nomVM :taille) tailleMem)
    ;; creer le tableau de la memoire
    (reset-memoire nomVM tailleMem)

    (setf (get nomVM :etiq) (make-hash-table :size tailleMem))
    (setf (get nomVM :etiqNR) (make-hash-table :size tailleMem))

    (setf (get nomVM :PC) 900)
    (setf (get nomVM :LC) 900)

    (printVM nomVM)
)

(defun reset-memoire (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :taille) tailleMem)
    (setf (get nomVM :memoire) (make-array tailleMem))

    ;; Load counter et program counter 
    (setf (get nomVM :PC) tailleMem)
    (setf (get nomVM :LC) tailleMem) 
)






(defun vm_chargeur(vm asm)
  (let ((asm (LI_TO_ASM (LISP2LI exprLisp nil) 0)))
  (print "~~~~~~CHARGEUR~~~~~~")
  (loop
    while (not (atom asm))
    do
    (progn
      (print (car asm))
      (vm_move vm (car asm) 'R0)
      (vm_store vm 'R0 'PCO)
      (vm_load vm 'PCO 'R1)
      (if (eq (car (vm_get_register vm 'R1)) 'LABEL)
        (vm_label vm (cdr (vm_get_register vm 'R1))))
    (vm_incr vm 'PCO)

    (setf asm (cdr asm))))
  (vm_move vm '(HALT) 'R0)
  (vm_store vm 'R0 'PCO)
  (vm_incr vm 'PCO))
  
  
)




(defun chargeur (vm asm)

(loop
  do
  (setf (aref (getProp vm :memoire) (getProp vm :PC)) (car asm))

        (if (eq (car (car asm)) 'LABEL)
        (vm_LABEL vm (car (cdr (car asm))))
        
        )
           (mv-INCR vm :PC)
 (setf asm (cdr asm))
while (not (atom asm))
)
  (setf (aref (getProp vm :memoire) (getProp vm :PC)) '(HALT))
  (mv-INCR vm :PC)
  


)




(defun vm-execution (vm)



(loop
while(eq (getProp vm :exitVM) 0)
do
      ;(let ((fun (car (vm_get_register vm 'R2)))
      ;(args (cdr (vm_get_register vm 'R2))))

      (format T "Valeur Exit: ~d
    "  (getProp vm :exitVM))
      
      (setq fun  (car (getmemoire vm (getProp vm :LC))))

      (cond
        ((eq fun 'LOAD)
          (vm_load vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )
        ((eq fun 'ADD)

          (mv-ADD vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )
        ((eq fun 'MULT)
          (mv-MULT vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'DIV)
          (mv-DIV vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'MOVE)

          (mv-MOVE vm (car (cdr (getmemoire vm (getProp vm :LC))))  (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))

          (mv-INCR vm :LC)
          )

          ((eq fun 'INCR)
          (mv-INCR vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'DECR)
          (mv-DECR vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'PUSH)
          (mv-PUSH vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'POP)
          (mv-POP vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )


        ((eq fun 'LABEL)
          (vm_LABEL vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

        ((eq fun 'JMP)
          (vm-JMP vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'RTN)
          (vm-RTN vm )
          (mv-INCR vm :LC)
          )


          ((eq fun 'JGT)
          (vm-JGT vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'JGE)
          (vm-JGE vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'JLT)
          (vm-JLT vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'JLE)
          (vm-JLE vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'JEQ)
          (vm-JEQ vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'JNE)
          (vm-JNE vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'JTRUE)
          (vm-JTRUE vm (car (cdr (getmemoire vm (getProp vm :LC)))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'NOP)
          (mv_NOP vm )
          (mv-INCR vm :LC)
          )

           ((eq fun 'HALT)
          (mv_HALT vm )
          (mv-INCR vm :LC)
          )

      
      
      )


)
)







(defun vm_exec (vm exprLisp)
  (print (list 'PCO (vm_get_register vm 'PC)))
  (vm_set_flag_OFF vm :FNIL)
  (read)
  (vm_chargeur vm exprLisp)
  (print "~EXECUTION~")
  (loop
    ;while (vm_get_register vm 'R2)
    while (not (vm_get_flag vm :FNIL))
    do
     (progn
      (vm_load vm 'PC 'R2)
      (let ((fun (car (vm_get_register vm 'R2)))
      (args (cdr (vm_get_register vm 'R2))))
    (vm_state vm)
    (print (vm_get_register vm 'R2))
    (read)
    (cond
      ((eq fun 'LOAD)
        (progn
          (vm_load vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'STORE)
        (progn
          (vm_store vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'MOVE)
        (progn
          (vm_move vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'ADD)
        (progn
          (vm_add vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'SUB)
        (progn
          (vm_sub vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'MUL)
        (progn
          (vm_mul vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'DIV)
        (progn
          (vm_div vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'INCR)
        (progn
          (vm_incr vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'DECR)
        (progn
          (vm_decr vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'PUSH)
        (progn
          (vm_push vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'POP)
        (progn
          (vm_pop vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'LABEL)
        (progn
          (vm_label vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'JMP)
        (progn
          (vm_jmp vm (first args))))
      ((eq fun 'JSR)
        (progn
          (vm_jsr vm (first args))))
      ((eq fun 'RTN)
        (progn
          (vm_rtn vm)))
      ((eq fun 'CMP)
        (progn
          (vm_cmp vm (first args) (second args))
          (vm_incr vm 'PC)))
      ((eq fun 'JGT)
        (progn
          (vm_jgt vm (first args))))
      ((eq fun 'JGE)
        (progn
          (vm_jge vm (first args))))
      ((eq fun 'JLT)
        (progn
          (vm_jlt vm (first args))))
      ((eq fun 'JLE)
        (progn
          (vm_jle vm (first args))))
      ((eq fun 'JEQ)
        (progn
          (vm_jeq vm (first args))))
      ((eq fun 'JNE)
        (progn
          (vm_jne vm (first args))))
      ((eq fun 'TEST)
        (progn
          (vm_test vm (first args))
          (vm_incr vm 'PC)))
      ((eq fun 'JTRUE)
        (progn
          (vm_jtrue vm (first args))))
      ((eq fun 'JNIL)
        (progn
          (vm_jnil vm (first args))))
      ((eq fun 'APPLY)
          (progn
            (vm_apply vm (first args) (second args))
            (vm_incr vm 'PC)))
      ((eq fun 'NOP)
        (progn
          (vm_nop vm)
          (vm_incr vm 'PC)))
      ((eq fun 'HALT)
        (progn
          (vm_halt vm)
          (vm_incr vm 'PC)))))))
  (print (list "Le resultat de " exprLisp "est :" (vm_get_register vm 'R0))))









(defun chargerDuCode (vm code)
  (let 
    (etiquetes (make-hash-table :size (getProp mv :taille)))
    (etiquetesIndef (make-hash-table :size (getProp mv :taille)))
    (expression asm)
    (next (car asm))
  )

  (loop (while expression) 




    ;(do (setf expression (cdr expression)))
    ;(do (setf next (car expression)))
  )  
)

;; CE TRUC EST PAS A NOUS !!!
(defun load-machine (mv asm)
  (let ((exp asm);
	(inst (car asm))
	(etiqLoc (make-hash-table :size (get-taille mv)))
	(etiqLocNR (make-hash-table :size (get-taille mv))))
  


    (set-hash etiqLocNR 'nb 0)
    (loop while exp
	  do
	  (case (car inst)
	   ('@ (case-adr mv exp inst etiqLoc etiqLocNR))
	    ('VARG (case-varg mv exp inst))
	    ('JSR (case-saut mv exp inst))
	    ('FEntry (case-fonction mv exp inst))
	    (otherwise (case-other mv exp inst etiqLoc etiqLocNR))
	    )
	  do (setf exp (cdr exp))
	  do (setf inst (car exp))
	  )
    )
  )

(defun executer (maVM)
    (write "Executer")
)





(defun printVM (vm)
    (write "-*-*-*-*-*-*-*-*-*-*-")
    (format t "~%Nom : ~S " (getProp vm :nom))
    (format t "~%R0 : ~S " (getProp vm :R0))
    (format t "~%R1 : ~S " (getProp vm :R1))
    (format t "~%R2 : ~S " (getProp vm :R2))

    (format t "~%BP : ~S " (getProp vm :BP))
    (format t "~%SP : ~S " (getProp vm :SP))
    (format t "~%FP : ~S " (getProp vm :FP))

    (format t "~%Max pile : ~S " (getProp vm :MAXPILE))

    (format t "~%FTL : ~S " (getProp vm :FLT))
    (format t "~%FEQ : ~S " (getProp vm :FEQ))
    (format t "~%FGT : ~S " (getProp vm :FGT))

    (format t "~%PC : ~S " (getProp vm :PC))
    (format t "~%LC : ~S " (getProp vm :LC))
    (format t "~%-*-*-*-*-*-*-*-*-*-*-")
)