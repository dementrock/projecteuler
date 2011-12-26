(defun p1 ()
 (loop for i from 1 to 999
  when (or
   (zerop (mod i 3))
   (zerop (mod i 5))) sum i))

(print (p1))
