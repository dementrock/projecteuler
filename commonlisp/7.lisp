(defun p7 ()
 (defun prime? (x)
  (loop for i from 2 to (floor (sqrt x)) do
   (when (zerop (mod x i)) (return-from prime? nil)))
  t)
 (defun calc-nth (n fn)
  (let ((cnt 0))
   (loop for i from 2 do
    (when (funcall fn i) (incf cnt))
    (when (eq cnt n) (return-from calc-nth i)))))
 (calc-nth 10001 #'prime?))

(print (p7))
