;; Fonctions structurelles de la machine virtuelle.

;; nom : Nom de la machine.
;; R0, R1, R2, R3 : Registres.
;; BP : Base Pointer initialisé à 100, pile montante.
;; SP : Stack Pointer, si pile vide SP = BP.
;; FP : Frame Pointer
;; DPP : Drapeau de comparaison "plus petit".
;; DE : Drapeau de comparaison "égalité".
;; DPG : Drapeau de comparaison "plus grand".
;; taille : Taille allouée à la mémoire (pile + tas + code).
;; memtab : Mémoire de la machine.
;; PC : Program Counter, compteur ordinal, position dans le code.
;; LC : Load Counter, position du chargement du code.
;; etiq : Table de hashage pour les étiquettes.
;; etiqNR : Table de hashage des étiquettes non résolues


(defun make-machine (&optional (nomVM 'maVM) (tailleMem 10000)))
    (setf (get nomVM :nom) nomVM)
    (setf (get nomVM :R0) 0)
    (setf (get nomVM :R1) 0)
    (setf (get nomVM :R2) 0)
    (setf (get nomVM :R3) 0)
    (setf (get nomVM :BP) 100) ;; Pas vraiment sur
    (setf (get nomVM :SP) (get nomVM :BP)) 
    (setf (get nomVM :FP) (get nomVM :BP))

    (setf (get nomVM :taille) tailleMem)
    (setf (get nomVM :PC) 0)
    (setf (get nomVM :LC) 0)
)





















  (set-prop nom :nom nom)
  (set-prop nom :R0 0)
  (set-prop nom :R1 0)
  (set-prop nom :R2 0)
  (set-prop nom :R3 0)
  (set-prop nom :BP 100)
  (set-prop nom :SP 100)
  (set-prop nom :VP 1)
  (set-prop nom :FP 0)
  (set-prop nom :DPP 0)
  (set-prop nom :DE 0)
  (set-prop nom :DPG 0)
  (reset-memoire nom tmem)
  (if (not (null aff)) (print-machine nom))
  )