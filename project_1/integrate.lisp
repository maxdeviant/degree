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

(defun variablep (F)
    "Returns T if F is a valid variable symbol"
    (member F *variable-symbols*))

(defun sump (F)
    "docstring"
    "pass")

(defun differencep (F)
    "docstring"
    "pass")

(defun sump (F)
    "docstring"
    "pass")

(defun productp (F)
    "docstring"
    "pass")

(defun quotientp (F)
    "docstring"
    "pass")

(defun powerp (F)
    "docstring"
    "pass")

;;;=================================================================
;;; CONSTRUCTORS

(defun make-variable (V)
    "docstring"
    V)

(defun make-negative (F)
    "docstring"
    "pass")

(defun make-sum (F G)
    "docstring"
    "pass")

(defun make-difference (F G)
    "docstring"
    "pass")

(defun make-product (F G)
    "docstring"
    "pass")

(defun make-quotient (F G)
    "docstring"
    "pass")

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