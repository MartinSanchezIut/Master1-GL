
(require "vm.lsp")

;;(require "instructions.lsp")
;;(require "getterSetter.lsp")

(defun make-test (vm)
    (make-machine vm)

    (mv-MOVE vm '(:CONST 5) :R0)
    ;;(cdr '(:CONST 4))
    (format T "    ~%addition 7+5 :  ~d
    " (mv-ADD vm '(:CONST 7) :R0))


    (format T "soustraction 7-12 : ~d
    " (mv-SUB vm '(:CONST 7) :R0))


    (format T "multiplication 7*5 : ~d
    " (mv-MULT vm '(:CONST 7) :R0))


    (format T "division 35/7 : ~d
    " (mv-DIV vm '(:CONST 7) :R0))

    (format T "incre 5: ~d
    " (mv-INCR vm :R0))

    (format T "decr 6: ~d
    " (mv-DECR vm :R0))

    (format T "MOVE 69 dans le registre R2:
    ")
    (mv-MOVE vm '(:CONST 69) :R2)
    (format T "R2 =  ~d
    " (getProp vm :R2))

    (format T "StORE DANS LA MEMOIRE a la case 500 fournie a R1:
    ")

    (mv-MOVE vm '(:CONST 500) :R1)
    (format T "R1: ~d
    "  (getProp vm :R1))

    (mv-STORE vm :R1 :R2)

    (format T "MEMOIRE 500: ~d
    "  (aref (getProp vm :memoire) 500))

    ;;(write (get vm :memoire))


    (format T "Fait un Load de la case 500 dans R3
    ")
    (mv-LOAD vm :R1 :R3)


    (format T "R3 =  ~d
    " (getProp vm :R3))


)