
(defun getProp (vm prop)
  (get vm prop)
  )


(defun setmemoire (vm index val)
  (setf (aref (getProp vm :memoire) index) val)
  )


(defun getmemoire (vm index)
   (aref (getProp vm :memoire) index)
  )



(defun setFlag (vm L E G)
  (set-prop vm :FLT L)
  (set-prop vm :FEQ E)
  (set-prop vm :FGT G)
)



(defun set-prop (vm prop val)
  (setf (get vm prop) val)
  )



(defun set-prop (vm prop val)
(setf (get vm prop) val)
)

(defun vm_get_hashTab_etq_resolu (vm label)
  (gethash label (get vm :etiq))
  )




(defun vm_set_hashTab_etq_resolu (vm etq valeur)
  (setf (gethash etq (get vm :etiq)) valeur)
)
