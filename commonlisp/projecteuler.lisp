(defun problem-1 ()
  (loop for i from 1 to 999
	when 
	(or (eq (mod i 5) 0) 
	    (eq (mod i 3) 0))
	sum i))

(defun problem-2 ()
  (let (a b)
    (setf a 0)
    (setf b 1)
    (loop for c = (+ a b) while (< c 4000000) do 
	  (setf a b)
	  (setf b c)
	  when (zerop (mod b 2)) sum b
	  )))

(defun prime? (x)
    ( let (max_n)
      (setf max_n (floor (sqrt x)))
      (loop for i from 2 to max_n
	    do (when (zerop (mod x i)) (return-from prime? nil)))
      (return-from prime? t))
)

(defun problem-3 ()
  (defun largest-prime-factor (x)
    (let (n)
      (setf n (floor (sqrt x)))
      (loop for i from n downto 2
        do (when 
            (and 
             (prime? i)
             (zerop (mod x i)))
            (return-from largest-prime-factor i)))
    )
  )
  (return-from problem-3 (largest-prime-factor 600851475143))
)

(defun palindrome? (num)
 (let ((str (write-to-string num)))
  (return-from palindrome? (string= str (reverse str)))
  ))

(defun problem-4 ()
  (loop for i from 100 to 999
   maximizing (loop for j from 100 to 999 and k = (* i j)
    maximizing (if (palindrome? k) k 0))
))

(defun problem-5 ()
 (defun satisfy? (x)
    (loop for i from 2 to 20 do (when (not (zerop (mod x i))) (return-from satisfy? nil)))
    (return-from satisfy? t)
 )
 (loop for i from 1 when (satisfy? i) do (return-from problem-5 i)))

(defun problem-6 ()
  (let 
   ((x (loop for i from 1 to 100 sum i))
    (y (loop for i from 1 to 100 sum (* i i))))
   (setf x (* x x))
   (return-from problem-6 (- x y))
  )
)

(defun problem-7 ()
 (let ((cnt 0))
    (loop for i from 2 do 
     (when (prime? i) (incf cnt))
     (when (eq cnt 10001) (return-from problem-7 i))
    )
 )
)

(defun problem-8 ()
    (defun calc (str)
      (let ((ans 1))
       (loop for i from 0 to 4 do (setf ans (* ans (parse-integer (subseq str i (+ i 1))))))
       (return-from calc ans)
      )
    )

  (let ((str "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"))
  (loop for i from 0 to 995 maximizing (calc (subseq str i (+ i 5)))) 
  ))

;(print (problem-8))

(defun problem-9 ()
 (loop for a from 1 to 499 do
       (loop for b from (+ a 1) to (- 1000 a)
       do
       (let ((c (- 1000 (+ a b))))
       (when (and (> c b) (eq (+ (* a a) (* b b)) (* c c))) (return-from problem-9 (* a b c))))))
)

(defun problem-10 ()
 (loop for i from 2 to 2000000 when (prime? i) sum i))

(defun factorial (x &optional (acc 1))
 (if (<= x 1)
  acc
  (factorial (- x 1) (* acc x))))

(defun in? (x vector)
 (if (find x vector) t nil))

(print (in? 1 #(1 2 3)))
(print (in? 4 #(1 2 3)))

(defun get-permutation (x)
 (let ())
 (loop for i from 9 downto 0 do
  (setf cur-fact (factorial i))
  (setf num-at-pos 0)
  (loop
   (when (<  cur-fact) (return))
   (+ num-at-pos))
  (print i)))

(defun problem-24 ()
 (get-permutation 1000000))

;(print (problem-24))


(defun problem-27 ()
    (defun f (n a b)
        (abs (+ (* n n) (* a n) b))
    )
    (defun calc (i j)
        (loop for n from 0 do
            (when (not (prime? (f n i j)))
                (return-from calc n)
            )
        )
    )
    (let ((bound 999)(maxn 0) ans nown)
        (loop for i from (- 0 bound) to bound do
         (loop for j from (- 0 bound) to bound do 
            (setq nown (calc i j))
            (when (> nown maxn)
                (setq maxn nown)
                (setq ans (* i j))
            )
          )
        )
        (return-from problem-27 ans)
    )
 )

(defun problem-30 ()
    (defun satisfy? (num)
        (let ((str (write-to-string num)))
            (eq num (loop for x being the elements of str sum (expt (read-from-string (string x)) 5))))
    )
    (loop for i from 2 to 1000000
        when (satisfy? i) sum i
    ) 
)
