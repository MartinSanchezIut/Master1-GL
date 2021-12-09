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
  (setf (getProp vm :FLT) L)
  (setf (getProp vm :FEQ) E)
  (setf (getProp vm :FGT) G)
)

(defun set-prop (vm prop val)
  (setf (get vm prop) val)
  )