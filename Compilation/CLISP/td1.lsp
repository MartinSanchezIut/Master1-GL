;;; TP 1:
(print ((lambda (x) (+ (* 2 x) 3)) 4))
(print ((lambda (x y) (* (+ x 2) (+ y 6))) 7 8))
(print ((lambda (v) ((lambda (x) (* 3 x)) (+ v 2))) 8))
(print ((lambda (v) ((lambda (x) (* v x)) (+ v 2))) 8))
(print ((lambda (v) ((lambda (v) (* 3 v)) (+ v 2))) 8))
(print ((lambda (x y z) (+ (* x y) (* y z))) 2 3 4))
(print ((lambda (x y) (* x x y y)) 4 5))
(print ((lambda (x) (* x x 2)) 4))
(print (lambda (x) (* x x 2) 1))

;;; 2:
(defun f (x) (+ 3 x))
(defun g (v) (* 5 (f (+ v 2))))

(defun fact(x) (if(= x 0) 1 (* x (fact (- x 1)))))
;;; (if cond vrai faux)

(defun fibo(x) 
    (if(= x 0) 0 
    (if(< x 3) 1 (+ (fibo (- x 1)) (fibo (- x 2)))))
)

;;; 3

;;; 4
(defun member (x l) 
	




















