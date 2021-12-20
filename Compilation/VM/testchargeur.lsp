

(require "vm.lsp")

(require "instructions.lsp")
(require "getterSetter.lsp")
(defun make-test (vm)

;(chargeur vm '(add m)) 

(make-machine vm)


(setq liste '((ADD (:CONST 56) :R0) (MULT (:CONST 2) :R0) (LABEL caca) (MOVE :R0 :R1)))


(format T "resultat : 
 ~d
"  (car (car '((ADD '(:CONST 2) :R0) (MULT 5 6) (LABEL caca) (MOVE :RO :R1)))))


(format T "
------------------------------MA LSITE----------------------------
 ~d
"  liste)

(format T "resultat : 
 ~d
"  (car liste))

(format T "resultat : 
 ~d
"  (car (car liste)))

;(car x)
(chargeur vm liste) 


(write (getProp vm :memoire))

(format T "MEMOIRE 900: ~d
"  (aref (getProp vm :memoire) 900))


(format T "MEMOIRE LC: ~d
"  (aref (getProp vm :memoire) (getProp vm :LC)))

(vm_get_hashTab_etq_resolu vm 'caca)


(format T "
Valeur du label: ~d
"  (aref (getProp vm :memoire) (vm_get_hashTab_etq_resolu vm 'caca))


)

(vm-execution vm)


(format T "ca devrait être egale a 112 : ~d
"  (getProp vm :R0))

(vm-execution vm)
(format T "ca devrait être egale a 112 : ~d
"  (getProp vm :R1))





)