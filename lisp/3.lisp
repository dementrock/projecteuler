(defun p3 ()
 (defun largest-factor (x)
  (loop for i from 2 to (floor (sqrt x)) do
   (when (zerop (mod x i)) (return-from largest-factor (max i (largest-factor (/ x i))))))
  (return-from largest-factor x))
 (largest-factor 600851475143)
)

(print (p3))
