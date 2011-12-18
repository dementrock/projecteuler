(defun p6 ()
 (-
  (expt (loop for i from 1 to 100 sum i) 2)
  (loop for i from 1 to 100 sum (* i i))))

(print (p6))
