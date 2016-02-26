;;; Marshall Bowers
;;; Dr. Richard Wyatt
;;; CSC345-80
;;; 25 September 2014
;;; homework.lisp

;;;=================================================================
;;;    NAME: sum
;;;  ARG(S): Integers N and M
;;; RETURNS: The sum of the two integers

(defun sum (n m)
    "Returns the sum of integers N and M."
    (cond
        ;; Ensure arguments are integers
        ((not (and (typep n 'integer) (typep m 'integer))) nil)
        ;; Always decrement the argument closer to 0
        ((and (< (abs n) (abs m)) (> n 0)) (sum (1- n) (1+ m)))
        ((and (< (abs n) (abs m)) (< n 0)) (sum (1- n) (1+ m)))
        ((and (> (abs n) (abs m)) (> n 0)) (sum (1- m) (1+ n)))
        ((and (> (abs n) (abs m)) (< n 0)) (sum (1- m) (1+ n)))
        ;; Arbitrarily decrement n if the arguments are equal
        ((eq (abs n) (abs m)) (sum (1- n) (1+ m)))
        ;; Return the value of m, which will be the sum
        (t m)))

;;;=================================================================
;;;    NAME: add-1-all
;;;  ARG(S): A list of integers L
;;; RETURNS: A list of integers with every element increased by one

(defun add-1-all (L)
    "Returns the list L of integers with every element increased by one."
    (cond
        ;; Ensure the argument is a list that only consists of integers
        ((not (listp L)) nil)
        ((not (every 'integerp L)) nil)
        ((endp L) L)
        ;; CDR down the list and increment each element
        (t (cons (1+ (first L)) (add-1-all (rest L))))))

;;;=================================================================
;;;    NAME: my-replace
;;;  ARG(S): The element E1 to replace with E2 in the list L
;;; RETURNS: The list with the specified elements replaced

(defun my-replace (e1 e2 L)
    "Returns the list L with element E1 replaced with E2."
    (cond
        ((endp L) L)
        ;; Perform replacement when the element is found
        ((equal (first L) e1) (cons e2 (my-replace e1 e2 (rest L))))
        ;; Go down a level if the element itself is a list
        ((listp (first L)) (cons (my-replace e1 e2 (first L)) (my-replace e1 e2 (rest L))))
        ;; Continue CDRing down the list
        (t (cons (first L) (my-replace e1 e2 (rest L))))))

;;;=================================================================
;;;    NAME: fibonacci
;;;  ARG(S): An integer N
;;; RETURNS: The Nth fibonacci number

(defun fibonacci (n)
    "Returns the Nth fibonacci number."
    (cond
        ;; Argument cannot be negative
        ((minusp n) 0)
        ;; Sequence starts with 0 and 1
        ((< n 2) n)
        ;; Perform calculation
        (t (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))

;;;=================================================================
;;;    NAME: fibonacci-tr
;;;  ARG(S): An integer N
;;; RETURNS: The Nth fibonacci number

(defun fibonacci-tr (n)
    "Returns the Nth fibonacci number."
    (labels (
        ;; Tail recursive helper function
        (fibonacci-tr-aux (n a b)
            (cond
                ((> n 0) (fibonacci-tr-aux (- n 1) b (+ a b)))
                (t a))))
        ;; Sequence starts with 0 and 1
        (fibonacci-tr-aux n 0 1)))
