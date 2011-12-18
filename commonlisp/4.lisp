(defun p4 ()
 (defun palindrome? (x)
  (string= (write-to-string x) (reverse (write-to-string x))))
 (loop for i from 100 to 999
  maximizing (loop for j from 100 to 999 and k = (* i j)
    maximizing (if (and (> k 100000) (palindrome? k)) k 0))))

(print (p4))
