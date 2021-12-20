
(defun exec-inst (mv exp &optional (aff ()))
  (let ((inst (car exp))
	(param (cadr exp))
	(param-bis (caddr exp)))
    (if (null exp)
	(mv-nop mv)
      (case inst
	('MOVE (mv-move mv param param-bis))
	('ADD (mv-add mv param param-bis))
	('SUB (mv-sub mv param param-bis))
	('MULT (mv-mult mv param param-bis))
	('DIV (mv-div mv param param-bis))
	('INCR (mv-inc mv param))
	('DECR (mv-dec mv param))
	(otherwise (mv-err mv exp))
	)
      )
    (if (not (null aff)) (format t "~S~%" (get-mem-pc mv)))
    (dec-pc mv)
    )
  )




(defun vm_lecture (vm nomfichier &optional (co 100001))
	(let ((fichier (open nomfichier)))
		(if fichier
			(prog1 
				(vm_chargeur vm (read fichier nil) co)
				(close fichier)
			)
		)
	)
	"Chargement du code termine !"
)

; On regarde chaque instruction, on effectue modification si nécessaire
; et on charge le code en mémoire si ce n'est pas un label
(defun vm_chargeur (vm fichier )
	;(print fichier)
	(loop while (not (null fichier)) do
		(let ((instr (car fichier)))
			;(print instr)

			(if (null instr)
				nil
				(if (eql 'LABEL (car instr))
					(vm_charger_symb vm (cadr instr) co)
					(progn
						(setmemoire vm :PC (vm_resoudre_symb vm instr co))
						(mv-INCR mv :PC)
					)
				)
			)
		)
		(setf fichier (cdr fichier))
	)
)
; Traitement du symbole après le LABEL
(defun vm_charger_symb (vm symb co)
	(if (isSymboleSet vm symb)
		(error "vm_chargeur_symb symbole existe deja")
		(progn
			(setSymbole vm symb co)
			(vm_resoudre_refNR vm symb)
		)
	)
)
(defun getSymbole (vm symb)
	(gethash symb (get vm 'symboleR))
)
(defun isSymboleSet (vm symb)
	(if (getSymbole vm symb)
		t
		nil
	)
)

(defun vm_resoudre_symb (vm instr co)
	(if 
		(or 
			(eql 'JMP (car instr))
			(eql 'JSR (car instr))
			(eql 'JPG (car instr))
			(eql 'JEQ (car instr))
			(eql 'JPP (car instr))
			(eql 'JGE (car instr))
			(eql 'JPE (car instr))
		)

		(if (isLABEL (cadr instr))
			(if (isSymboleSet vm (cadadr instr))
				(cons (car instr) (list (getSymbole vm (cadadr instr)))) ; met l'adresse comme integer directement ex : JSR 100152
				(progn
					(setReferenceNR vm (cadadr instr) co)
					instr
				)
			)
			instr
		)
		instr
	)
)