(defmacro cons-stream (a b)
 `(cons ,a (delay ,b)))

(defmacro delay (expr)
 `(memo-proc (lambda () ,expr)))

(defun memo-proc (proc)
 (let ((already-run? nil) (result nil))
  (lambda ()
   (if (not already-run?)
    (progn
     (setf result (funcall proc))
     (setf already-ruin? t)
     result)
    result))))

(defvar the-empty-stream '())

(defun stream-null? (s)
 (null s))

(defun force (delayed-object)
 (funcall delayed-object))

(defun stream-car (s)
 (car s))

(defun stream-cdr (s)
 (force (cdr s)))

(defun stream-ref (s n)
 (if (= n 0)
  (stream-car s)
  (stream-ref (stream-cdr s) (- n 1))))

(defun stream-enumerate-interval (low high)
 (if (> low high)
  the-empty-stream
  (cons-stream low (stream-enumerate-interval (+ low 1) high))))

(defun stream-filter (pred s)
 (cond ((stream-null? s) the-empty-stream)
       ((funcall pred (stream-car s))
        (cons-stream
         (stream-car s)
         (stream-filter pred (stream-cdr s))))
       (t (stream-filter pred (stream-cdr s)))))

(defun stream-map (pred s)
 (cond ((stream-null? s) the-empty-stream)
       (t
        (cons-stream
          (funcall pred (stream-car s))
          (stream-map pred (stream-cdr s))))))

(defun integers-from (n)
 (cons-stream n (integers-from (+ n 1))))

(defun integers ()
 (integers-from 1))

(defun not-divisible? (y)
  #'(lambda (x) (not (zerop (mod x y)))))

(defun no-sevens ()
 (stream-filter #'(lambda (x) (not (divisible? x 7))) (integers)))

(defun primes (s)
 (cons-stream
  (stream-car s)
  (primes (stream-filter (not-divisible? (stream-car s)) s))))

(defun stream-ref (s n)
 (cond ((eq n 1) (stream-car s))
       (t (stream-ref (stream-cdr s) (- n 1)))))

(defun test ()
 (defun prime? (x)
  (loop for i from 2 to (floor (sqrt x)) do
   (when (zerop (mod x i)) (return-from prime? nil)))
  t)
 (setf ss
  ;(stream-map #'(lambda (x) (* x x)) (stream-filter #'prime? (stream-enumerate-interval 10 100))))
  (primes (integers-from 2)))
 (print (stream-ref ss 10001)))

(test)
