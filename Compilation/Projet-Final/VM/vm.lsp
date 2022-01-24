

(require "getterSetter.lsp")
(require "instructions.lsp")

(defun make-machine (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :nom) nomVM)
    (setf (get nomVM :R0) 0)



    (setf (get nomVM :R1) 0)
    (setf (get nomVM :R2) 0)
    (setf (get nomVM :R3) 0)
    (setf (get nomVM :R4) 0)
    (setf (get nomVM :R5) 0)
    (setf (get nomVM :R6) 0)
    (setf (get nomVM :R7) 0)
    (setf (get nomVM :R8) 0)
    (setf (get nomVM :R9) 0)
    (setf (get nomVM :R10) 0)
    (setf (get nomVM :R11) 0)
    

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
        (vm_set_hashTab_etq_resolu vm (car (cdr (car asm))) (getProp vm :PC))
        ;(vm_LABEL vm (car (cdr (car asm))))
        
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


      
      (setq fun  (car (getmemoire vm (getProp vm :LC))))



      (format T "position programme: ~d
    "  (getProp vm :LC))


              (format T "Valeur R0: ~d
    "  (getProp vm :R0))

      (format T "Valeur R1: ~d
    "  (getProp vm :R1))

                  (format T "Valeur R2: ~d
    "  (getProp vm :R2))

        (format T "Valeur executé: ~d
    " (getmemoire vm (getProp vm :LC)))

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

          ((eq fun 'SUB)
          (mv-SUB vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )


          ((eq fun 'DIV)
          (mv-DIV vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          )

          ((eq fun 'MOVE)

          (mv-MOVE vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
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
          ;(format t " ~d " (get vm :memoire))
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

          ((eq fun 'CMP)
          (mv-CMP vm (car (cdr (getmemoire vm (getProp vm :LC)))) (car (cdr (cdr (getmemoire vm (getProp vm :LC))))))
          (mv-INCR vm :LC)
          (getProp vm :FEQ)
          (getProp vm :FGT)
          )

           ((eq fun 'HALT)
          (mv_HALT vm )
          (mv-INCR vm :LC)
          )

      
      
      )



)
    (getProp vm :R0)
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