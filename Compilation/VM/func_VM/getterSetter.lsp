(defun get-prop (mv prop)
  (get mv prop)
  )

(defun set-prop (mv prop val)
  (setf (get mv prop) val)
  )

(defun inc-prop (mv prop)
  (set-prop mv prop (+ (get-prop mv prop) 1))
  )

(defun dec-prop (mv prop)
  (set-prop mv prop (- (get-prop mv prop) 1))
  )

(defun set-tab (tab cle val)
  (setf (aref tab cle) val)
  )


;; ********** Gestion de la mémoire.

(defun get-taille (&optional (mv 'mv))
  (get-prop mv :taille)
  )

(defun set-taille (mv tmem)
  (set-prop mv :taille tmem)
  )

(defun get-mem (mv adr)
  (aref (get mv :memtab) adr)
  )

(defun set-mem (mv adr val)
  (set-tab (get mv :memtab) adr val)
  )


;; ********** Gestion des registres.

(defun get-reg (mv reg)
  (get-prop mv reg)
  )

(defun set-reg (mv reg val)
  (set-prop mv reg val)
  )