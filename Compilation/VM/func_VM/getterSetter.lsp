(defun getProp (vm prop)
  (get vm prop)
  )

(defun setFlag (vm L E G)
  (setf (getProp vm :FLT) L)
  (setf (getProp vm :FEQ) E)
  (setf (getProp vm :FGT) G)
)
