
(defun case (code inst)
  (eql (car code) inst)
)

(defun compilation-and (exp etiqfin env)
  (if (null exp) 
      (append '(MOVE (:CONST 1) :R0) `(etiqfin) )

      (append (compilation (car exp) env ) 
	    '(CMP :R0 (:CONST 1))
	    '(JNE etiqfin)
	    (compilation-and (cdr exp) etiqfin env))
    )
  )

(defun compilation-or (exp etiqfin env)
  (if (null exp) 
      (append '(MOVE (:CONST 0) :R0) `(etiqfin) )
      
      (append (compilation (car exp) env)
	    '(CMP :R0 (:DIESE T))
	    '(JEQ etiqfin)
	    (compilation-or (cdr exp) etiqfin env))
    )
  )


(defun compiler (exp env)
    (let  (param (if (atom code) () (cdr code) )) 
        
        (cond 
            ( (and (atom code) (constantp code))  ...)
            ((case code 'AND) (compiler-AND))


            (eql (car exp) 'and) (
                (let  (param (if (atom code) () (cdr code) )))
                (compiler-and param (gensym "finAnd") env)
            )
            (eql (car exp) 'or) (
                (let  (param (if (atom code) () (cdr code) )))
                (compiler-or param (gensym "finOr") env)
            )

            ((member (car exp) '(< > = <= >= )) (

                (let 
                (op (car exp))
                (end (gensym "endTest"))
                (val1 (cadr exp))
                (val2 (caddr exp))

                (compiled 

                    (compiler val1 env)
                    '(PUSH :R0)
                    (compiler val2 env)
                    '(PUSH :R0)

                    '(POP :R0)
                    '(POP :R1)
                    '(CMP :R0 :R1)

                    '(MOVE (:CONST 1) :R0)
                    (case op
                        ('= `(JEQ fin))
                        ('< `(JL fin))
                        ('> `(JG fin))
                        ('<= `(JLE fin))
                        ('>= `(JGE fin))
                        )
                    '((MOVE (:CONST 0) :R0))
                    `(fin)
                ))))
        )
    )
)
(defun analyse-cas (expr env)
    (cond ((and (atom expr) (constantp expr)) ...) ; litt??raux

    ((symbolp expr) ; symboles
        (if (assoc expr env)
        ... ; variable
        (error "~s variable inconnue" expr)))


    ;; EXPR est maintenant une cellule
    ((and (consp (car expr))
    (eq 'lambda (caar expr))) ; ??-expressions
    ... ; ??? r??cursion sur arguments

    (map-case-analysis (cdr expr) env) ; ??? construction environnement
    (map-case-analysis (cddar expr) env)
    ...) ; ??? r??cursion sur corps de la ??-fonction
    
    
    ((not (symbolp (car expr)))
    (error "~s n'est pas un symbole" (car expr)))


    ;; (CAR EXPR) est maintenant un symbole
    ;; ici s???ins??re le cas des fonctions et macros m??ta-d??finies
    ((not (fboundp (car expr)))
    (error "~s fonction inconnue" (car expr)))


    ;; (CAR EXPR) est maintenant un symbole qui joue le r??le de fonction
    ((macro-function (car expr))
    (case-analysis (macroexpand-1 expr))) ; macros
    
    
    ((not (special-form-p (car expr))) ; fonctions normales
    ...
    (map-case-analysis (cdr expr) env) ; ??? r??cursion sur arguments
    ...) ; ??? ??ventuellement construction d???environnement
    ; ??? et analyse du corps de la fonction appel??e
    ;; (CAR EXPR) est maintenant une forme sp??ciale
    ;; ??? r??cursion sur certains arguments
    
    
    ((eq 'if (car expr))
    ...)
    ((eq 'quote (car expr))
    ...)
    ((eq 'setf (car expr))
    ...)
    ((eq 'function (car expr))
    ...)
    ((eq 'defun (car expr))
    ...)
    
    (t ; pour rattraper ce qui n???est pas encore impl??ment??
        (error "forme sp??ciale NYI ~s" (car expr))
    )
)