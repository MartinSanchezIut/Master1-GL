
(defun case (code inst)
  (eql (car code) inst)
)

(defun compiler (code env)
    (let  (param (if (atom code) () (cdr code) )) 
        
        (cond 
            ( (and (atom code) (constantp code))  ...)
            ((case code 'AND) (compiler-AND))
        

        )
    )
)
(defun analyse-cas (expr env)
    (cond ((and (atom expr) (constantp expr)) ...) ; littéraux

    ((symbolp expr) ; symboles
        (if (assoc expr env)
        ... ; variable
        (error "~s variable inconnue" expr)))


    ;; EXPR est maintenant une cellule
    ((and (consp (car expr))
    (eq 'lambda (caar expr))) ; λ-expressions
    ... ; ⇒ récursion sur arguments

    (map-case-analysis (cdr expr) env) ; ⇒ construction environnement
    (map-case-analysis (cddar expr) env)
    ...) ; ⇒ récursion sur corps de la λ-fonction
    
    
    ((not (symbolp (car expr)))
    (error "~s n'est pas un symbole" (car expr)))


    ;; (CAR EXPR) est maintenant un symbole
    ;; ici s’insère le cas des fonctions et macros méta-définies
    ((not (fboundp (car expr)))
    (error "~s fonction inconnue" (car expr)))


    ;; (CAR EXPR) est maintenant un symbole qui joue le rôle de fonction
    ((macro-function (car expr))
    (case-analysis (macroexpand-1 expr))) ; macros
    
    
    ((not (special-form-p (car expr))) ; fonctions normales
    ...
    (map-case-analysis (cdr expr) env) ; ⇒ récursion sur arguments
    ...) ; ⇒ éventuellement construction d’environnement
    ; ⇒ et analyse du corps de la fonction appelée
    ;; (CAR EXPR) est maintenant une forme spéciale
    ;; ⇒ récursion sur certains arguments
    
    
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
    
    (t ; pour rattraper ce qui n’est pas encore implémenté
        (error "forme spéciale NYI ~s" (car expr))
    )
)