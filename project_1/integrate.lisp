;;; Marshall Bowers
;;; Dr. Richard Wyatt
;;; CSC345-80
;;; 17 October 2014
;;; integrate.lisp

;;;=================================================================
;;; SYMBOLS

(defconstant *variable-symbols* '(U V W X Y Z))
(defconstant *negative-symbol* '-)
(defconstant *sum-symbol* '+)
(defconstant *difference-symbol* '-)
(defconstant *product-symbol* '*)
(defconstant *quotient-symbol* '/)
(defconstant *power-symbol* 'expt)
(defconstant *log-symbol* 'log)

;;;=================================================================
;;; SELECTORS -- OPERATORS

(defun negative-operator (F)
    "docstring"
    (first F))

(defun sum-operator (F)
    "docstring"
    (first F))

(defun difference-operator (F)
    "docstring"
    (first F))

(defun product-operator (F)
    "docstring"
    (first F))

(defun quotient-operator (F)
    "docstring"
    (first F))

(defun power-operator (F)
    "docstring"
    (first F))

(defun log-operator (F)
    "docstring"
    (first F))

;;; SELECTORS -- OPERANDS

(defun negative-operand (F)
    "docstring"
    (second F))

(defun sum-first-operand (F)
    "docstring"
    (second F))

(defun sum-second-operand (F)
    "docstring"
    (third F))

(defun difference-first-operand (F)
    "docstring"
    (second F))

(defun difference-second-operand (F)
    "docstring"
    (third F))

(defun product-first-operand (F)
    "docstring"
    (second F))

(defun product-second-operand (F)
    "docstring"
    (third F))

(defun quotient-first-operand (F)
    "docstring"
    (second F))

(defun quotient-second-operand (F)
    "docstring"
    (third F))

(defun power-first-operand (F)
    "docstring"
    (second F))

(defun power-second-operand (F)
    "docstring"
    (third F))

;;;=================================================================
;;; PREDICATES

(defun variable-p (F)
    "Returns T if F is a valid variable symbol"
    (member F *variable-symbols*))

(defun number-p (F)
    "docstring"
    (numberp F))

(defun negative-p (F)
    "docstring"
    "pass")

(defun sum-p (F)
    "docstring"
    "pass")

(defun difference-p (F)
    "docstring"
    "pass")

(defun product-p (F)
    "docstring"
    "pass")

(defun quotient-p (F)
    "docstring"
    "pass")

(defun power-p (F)
    "docstring"
    "pass")

;;;=================================================================
;;; CONSTRUCTORS

(defun make-variable (V)
    "docstring"
    V)

(defun make-negative (F)
    "docstring"
    (list *negative-symbol* F))

(defun make-sum (F G)
    "docstring"
    (cond
        ((eq F 0) G)
        ((eq G 0) F)
        ((eq F (make-negative G)) 0)
        ((eq G (make-negative F)) 0)
        ((and (number-p F) (number-p G)) (+ F G))
        (t (list *sum-symbol* F G))))

(defun make-difference (F G)
    "docstring"
    (cond
        ((eq F 0) (make-negative G))
        ((eq G 0) F)
        ((and (number-p F) (number-p G)) (- F G))
        (t (list *difference-symbol* F G))))

(defun make-product (F G)
    "docstring"
    (cond
        ((eq F 0) 0)
        ((eq G 0) 0)
        ((eq F 1) G)
        ((eq G 1) F)
        ((eq F -1) (make-negative G))
        ((eq G -1) (make-negative F))
        ((and (number-p F) (number-p G)) (* F G))
        (t (list *product-symbol* F G))
    ))

(defun make-quotient (F G)
    "docstring"
    (cond
        ((eq F 0) 0)
        ((eq G 0) nil)
        ((and (number-p F) (number-p G)) (/ F G))
        (t (list *quotient-symbol* F G))
    ))

(defun make-power (V N)
    "docstring"
    "pass")

;;;=================================================================
;;;    NAME: integrate
;;;  ARG(S): 
;;; RETURNS: 

(defun integrate (F V &optional lower upper)
    "docstring"
    (def-integral (indef-integral F V) lower upper))

;;;=================================================================
;;;    NAME: indef-integral
;;;  ARG(S): 
;;; RETURNS: 

(defun indef-integral (F V)
    "docstring"
    "pass")

;;;=================================================================
;;;    NAME: def-integral
;;;  ARG(S): 
;;; RETURNS: 

(defun def-integral (F lower upper)
    "docstring"
    "pass")