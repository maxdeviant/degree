;;; Marshall Bowers
;;; Dr. Richard Wyatt
;;; CSC345-80
;;; 25 September 2014
;;; homework.lisp

;;;=================================================================
;;;    NAME: 
;;;  ARG(S): 
;;; RETURNS: 

(defun sum (n m)
    "Returns the sum of integers n and m."
    (cond
        ((not (and (typep n 'integer) (typep m 'integer))) nil)
        ((and (< (abs n) (abs m)) (> n 0)) (sum (1- n) (1+ m)))
        ((and (< (abs n) (abs m)) (< n 0)) (sum (1- n) (1+ m)))
        ((and (> (abs n) (abs m)) (> n 0)) (sum (1- m) (1+ n)))
        ((and (> (abs n) (abs m)) (< n 0)) (sum (1- m) (1+ n)))
        ((eq (abs n) (abs m)) (sum (1- n) (1+ m)))
        (t m)))

;;;=================================================================
;;;    NAME: 
;;;  ARG(S): 
;;; RETURNS: 

(defun add-1-all (L)
    "Returns the list L of integers with every element increased by one."
    (cond
        ((not (listp L)) nil)
        ((not (every 'integerp L)) nil)
        ((endp L) nil)
        (t (cons (1+ (first L)) (add-1-all (rest L))))))

;;;=================================================================
;;;    NAME: 
;;;  ARG(S): 
;;; RETURNS: 

(defun my-replace (e1 e2 L)
    "Documentation for my-replace."
    ())

;;;=================================================================
;;;    NAME: 
;;;  ARG(S): 
;;; RETURNS: 

(defun fibonacci (n)
    "Documentation for fibonacci."
    ())