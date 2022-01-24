(require "../VM/vm.lsp")
(require "Compilateur.lsp")
(defun make-test (vm)



;(compilation '(+ 1 2))

 ;(format T "JE SUIS UNE OPERATION :  ~d" (compilation '(< 1 2 )))


(make-machine vm)
;(chargeur vm (compilation '(< 1 2 ))) 

(init )



;(write (getProp vm :memoire))
;(format T "
;JE SUIS UNE OPERATION :  ~d" (compilation '(< 1 2)))

(format T "
JE SUIS UNE OPERATION : 


 ~d



" (compilation-loop '((defun fibo(n5)(if (< n5 2) (1) (+ (fibo (- n5 1)) (fibo (- n5 2))) )) (fibo 5))))

;(format T "
;Je suis la
;"
(chargeur vm (compilation-loop '((defun fibo(n5)
            (if (< n5 2) 
            (1) 
            (+ (fibo (- n5 1)) (fibo (- n5 2))) )) 

            
            (fibo 5)
            )
            )
            )

(vm-execution vm)
;DEFUN FIBO (N) (IF (< N 2) N (+ (FIBO (- N 1)) (FIBO (- N 2))))

)

