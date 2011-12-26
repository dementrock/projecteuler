(defun p5 ()
  (reduce #'lcm (loop for i from 1 to 20 collect i)))

(print (p5))
