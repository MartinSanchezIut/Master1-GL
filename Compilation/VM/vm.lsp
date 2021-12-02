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


(defun make-machine (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :nom) nomVM)
    (setf (get nomVM :R0) 0)
    (setf (get nomVM :R1) 0)
    (setf (get nomVM :R2) 0)
    (setf (get nomVM :BP) 100)
    (setf (get nomVM :SP) (get nomVM :BP)) 
    (setf (get nomVM :FP) (get nomVM :BP))
    ;; maximum de la pile
    (setf (get nomVM :MAXPILE) (floor(* tailleMem 0.9)))

    (setf (get nomVM :FLT) 0)
    (setf (get nomVM :FEQ) 0)
    (setf (get nomVM :FGT) 0)

    ;; (setf (get nomVM :taille) tailleMem)
    ;; creer le tableau de la memoire
    (reset-memoire nomVM tailleMem)


    (setf (get nomVM :PC) 0)
    (setf (get nomVM :LC) 0)
)

(defun reset-memoire (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :taille) tailleMem)
    (setf (get nomVM :memoire) (make-array tailleMem))

    ;; Load counter et program counter 
    (setf (get nomVM :PC) tailleMem)
    (setf (get nomVM :LC) tailleMem) 
)

(defun chargerDuCode (vm code)


)



