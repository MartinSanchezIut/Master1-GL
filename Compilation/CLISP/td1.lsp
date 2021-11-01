;;; TP 1:

;;; 1:
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
(car ()) ;;; NIL
(cdr ()) ;;; NIL

;;; (1 2 3 4)
(cons 1 (cons 2 (cons 3 (cons 4 ()))))
;;; (1 (2 3) 4)
(cons 1 (cons (cons 1 2) 4))
;;; (1 (2) (3) 4) 
(cons 1 (cons (cons 2 ()) (cons (cons 3 ()) 4 )))


;;; 4
(defun my_member (e l) 
    (if (equal (car l) e)
     l
     (if (not (equal (cdr l) ()))
      (my_member e (cdr l))
      (print "Not Found")
     )
    )
) ;;; (my_member 2 (cons 1 (cons 2 (cons 3 (cons 4 ())))))

(defun my_length  (l)
    (if (not (equal (cdr l) () ))
      (+ 1 (my_length (cdr l)))
      0
     )
) ;;; (my_length (cons 1 (cons 2 (cons 3 (cons 4 ())))))

(defun my_last (l) 
     (if (not (equal (cdr l) () ))
      (my_last (cdr l))
      (car l)
     )       
)

(defun makelist (n) 
    (if (> n 0) 
     (cons n (makelist (- n 1)))
     ()
    )
);;; (makelist 3)

(defun copylist (l)
    (if (not (equal (cdr l) () ))
      (cons (car l) (copylist (cdr l)))
      (car l)
     )   
) ;;;  (copylist (cons 1 (cons 2 (cons 3 (cons 4 ())))))

(defun my_remove (x l)
    (if (not (equal (cdr l) () ))
      (if (not (equal x (car l)))
        (cons (car l) (my_remove (cdr l)))
        (delete (car l))
      )
      (car l)
     )     
) ;;; (my_remove 2 (cons 1 (cons 2 (cons 3 (cons 4 ())))))

(defun append (seq1 seq2)
  (if (null seq1)
      seq2
      (cons (car seq1) (append (cdr seq1) seq2))
    )
);;; (append '(1 2 3) '(4 5 6))

(defun adjoin (a list)
   (if (null list) 
    (cons a nil) 
    (cons (car list)(adjoin a (cdr list)))
  )
) ;;; (adjoin 'a '(b c d))

;;; 5:
(defun size (tree)
    (if (not (equal (car tree) () ))
      (+ 1 (size (car tree)))
      (if (not (equal (cdr tree) () ))
        (+ 1 (size (cdr tree)))
        0
      ) 
    ) 
)

(defun copy (tree)
    (if (not (equal (car tree) () ))
      (if (not (equal (cdr tree) () ))
        (cons (copy (car tree)) (copy (cdr tree)))
        (cons (copy (car tree)) ())
      )
      (if (not (equal (cdr tree) () ))
        (cons () (copy (cdr tree)))
        ()
      )
    ) 
)

(defun subst (a x tree)
    (if (not (equal (car tree) () ))
      (if (equal (car tree) a ))
        (delete (car tree))
        (subst a x (car (car tree)))
      )
      (if (not (equal (cdr tree) () ))
        (if (equal (cdr tree) a ))
          (delete (cdr tree))
          (subst a x (cdr (cdr tree)))
        )
      )
    ) 
) ;;; Pas sur de comprendre les arbres :/

;;; 6:
;;; eq : comparaison d'adresses
;;; eql : pareil sauf que marche pour entiers et characteres
;;; equal : compare type ett contenu (SAIN)
;;; = : compare chiffres uniquement

;;; 7:
;;; Les fonctions qui modifient pas ont
;;; tendance a etre terminales

;;; Elle ne calculent rien car elles ont besoin
;;; de modifier la liste courante


;;; TP 2: