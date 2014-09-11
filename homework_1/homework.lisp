(defun sum (n m)
    "Documentation for sum."
    ())

(defun add-1-all (L)
    "Returns the list L of integers with every element increased by one."
    (cond
        ((not (listp L)) nil)
        ((not (every 'integerp L)) nil)
        ((endp L) nil)
        (t (cons (1+ (first L)) (add-1-all (rest L))))
))

(defun my-replace (e1 e2 L)
    "Documentation for my-replace."
    ())

(defun fibonacci (n)
    "Documentation for fibonacci."
    ())