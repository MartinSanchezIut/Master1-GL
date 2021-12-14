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


(require "func_VM/getterSetter.lsp")
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

    ;; (setf (get nomVM :taille) tailleMem)
    ;; creer le tableau de la memoire
    (reset-memoire nomVM tailleMem)

    (setf (get nomVM :PC) 0)
    (setf (get nomVM :LC) 0)

    (printVM nomVM)
)

(defun reset-memoire (&optional (nomVM 'maVM) (tailleMem 10000))
    (setf (get nomVM :taille) tailleMem)
    (setf (get nomVM :memoire) (make-array tailleMem))

    ;; Load counter et program counter 
    (setf (get nomVM :PC) tailleMem)
    (setf (get nomVM :LC) tailleMem) 
)

(defun chargerDuCode (vm code)
  (let 
    (etiquetes (make-hash-table :size (getProp mv :taille)))
    (etiquetesIndef (make-hash-table :size (getProp mv :taille)))
    (expression asm)
    (next (car asm))
  )

  (loop (while expression) 




    (do (setf expression (cdr expression)))
    (do (setf next (car expression)))
  )  
)

;; CE TRUC EST PAS A NOUS !!!
(defun load-machine (mv asm)
  (let ((exp asm)
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