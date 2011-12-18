(defun p2 ()
 (let ((a 0)
       (b 1))
  (defun fib ()
   (prog1 a (psetf a b b (+ a b)))))
 (reduce #'+
   (remove-if-not #'(lambda (x) (zerop (mod x 2)))
     (loop for x from 1
           for y = (fib)
           while (< y 4000000) collect y))))

(print (p2))
