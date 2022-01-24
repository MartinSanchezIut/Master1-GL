
(defun init ()

(setq table (make-hash-table)) 
(setq table2 (make-hash-table)) 
)


(defun compilation-loop(exp) 
(setq d (append () ()))
  (loop
  while(not (atom exp))
  do
      (setq env (make-hash-table)) 
      (setq d (append d (compilation (car exp) env)))
    


    (setq exp (cdr exp))
)

d
)


;(setq exp )

(defun compilation (exp env)

;(format T "JE SUIS UNE ICI :  
;~d
;" exp)


(cond
((eql (car exp) 'defun) (compilation-defun exp env))
((member (car exp) '(< > = <= >= )) (compilation_comp exp env))
((member (car exp) '( + - * /)) (compilation_op exp env))
((numberp (car exp)) (compilation_const  exp env))
((eql (car exp) 'if) (compilation_if exp env))
((not (eql (gethash (car exp) env) NIL)) (compilation-var exp env))
((not (eql (gethash (car exp) table) NIL) ) (compilation-call exp env))






)
)

(defun compilation-var (exps env)

(append 


    `((MOVE , (gethash (car exps) env) :R0))
   ;`((LABEL ,final));(concatenate 'string (write-to-string (car exp))"final")))
)

)

(defun compilation-call (exp env)



;(foreach n '(cdr exp) (print n))

(setq finalf (concatenate 'string (write-to-string (car exp)) "final"))
(append 
  (if (atom (cadr exp))
    (compilation `(,(cadr exp)) env)
    (compilation (cadr exp) env)
  )
  '((PUSH :R0))
 ; (compilation arg env)
  `((JMP ,(gethash (car exp) table)))

 ; `((JSR , (setf (gethash finalf table2) final)))
  `((LABEL ,(setf (gethash finalf table2) final)));(concatenate 'string (write-to-string (car exp))"final")))
)

)

(defun compilation-boucle2 (var r)


(if (not (atom var))
      (cond

      ((eql r 2) (append '((POP :R2)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 3) (append '((POP :R3)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 4) (append '((POP :R4)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 5) (append '((POP :R5)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 6) (append '((POP :R6)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 7) (append '((POP :R7)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 8) (append '((POP :R8)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 9) (append '((POP :R9)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 10) (append '((POP :R10)) (compilation-boucle2 (cdr var) (+ r 1))))
      ((eql r 11) (append '((POP :R11)) (compilation-boucle2 (cdr var) (+ r 1))))
      
      
      )

      
      
)
)

(defun compilation-defun (exp env)

;(setf (gethash (cadr exp)) '(Charlie Brown))
(setq table3 (make-hash-table)) 


(setq r 2) 

(setf (gethash (caaddr exp) table3) :R2)

(setq debutf (gensym "debutF"))
(setf (gethash (cadr exp) table) debutf)
(setq finf (gensym "FINF"))

(setq test (gensym "test"))


(setq test (gensym "test"))
(setq final (concatenate 'string (write-to-string (cadr exp)) "final"))
(setf (gethash (cadr exp) table2) final)
(append
  `((JMP ,finf))
  `((LABEL ,debutf))
  (compilation-boucle2 (caddr exp) 2)
  (compilation (cadddr exp) table3)
   `((JMP ,final));final))  ; '((RTN))`((JMP ,final));final))
  `((LABEL ,finf))
   ;`((LABEL ,final));(concatenate 'string (write-to-string (car exp))"final")))
)

)




(defun compilation-boucle (var)
(if (not (atom var))
      (append `((MOVE ,(car var), :R0)) '((PUSH :R0)) (compilation-boucle (cdr var)))
      
      )
)









(defun compilation_op (exp env)




(append

(if (atom (car (cdr exp)))
(compilation `(,(car (cdr exp))) env)
(compilation (car (cdr exp)) env)
)
'((PUSH :R0))


 
(if (atom (caddr exp))
(compilation `(,(caddr exp)) env)
(compilation (caddr  exp) env)
)
'((PUSH :R0))
'((POP :R1))
'((POP :R0))
(case (car exp)
		  ('+ '((ADD :R1 :R0)))
		  ('- '((SUB :R1 :R0)))
		  ('* '((MULT :R1 :R0)))
		  ('/ '((DIV :R1 :R0))))

)

)



(defun compilation_comp (exp env)
 
  				(setq op (car exp))
				  (setq fin (gensym "FINCOMP"))
				  (setq arg1 `(,(cadr exp)))
				   (setq arg2 (cddr exp))
                (append 

                    (compilation arg1 env)
                    '((PUSH :R0))
                    (compilation arg2 env)
                    '((PUSH :R0))

                    '((POP :R1))
                    '((POP :R0))
                    '((CMP :R0 :R1))

                    '((MOVE (:CONST 1) :R0))
                    (case op
                        ('= `((JEQ ,fin)))
                        ('< `((JLT ,fin)))
                        ('> `((JGT ,fin)))
                        ('<= `((JLE ,fin)))
                        ('>= `((JGE ,fin)))
                        )
                    '((MOVE (:CONST 0) :R0))

                    `((LABEL ,fin))
                )
                



)


(defun concat-lists (seq1 seq2)
  (if (null seq1)
      seq2
      (cons (car seq1) (concat-lists (cdr seq1) seq2))))


(defun compilation_const(exp env)

`((MOVE (:CONST ,(car exp)) :R0))


)


(defun compilation_if (exp env)

(setq finsi (gensym "FINSI"))

(setq sinon (gensym "SINON"))

(append 
  (compilation (cadr exp) env)
  '((CMP (:CONST 0) :R0))
  `((JEQ ,sinon))
  (compilation (caddr exp) env)
  `((JMP ,finSi))
  `((JEQ ,fin))
  `((LABEL ,sinon))

  (compilation (cadddr exp) env)
  `((LABEL ,finsi))


)
)




;DEFUN FIBO (N) (IF (< N 2) N (+ (FIBO (- N 1)) (FIBO (- N 2))))