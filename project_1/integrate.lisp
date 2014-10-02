;;; Marshall Bowers
;;; Dr. Richard Wyatt
;;; CSC345-80
;;; 17 October 2014
;;; integrate.lisp

;;;=================================================================
;;; SYMBOLS

(defconstant *variable-symbols* '(U V W X Y Z))
(defconstant *negative-symbol* '-)

;;;=================================================================
;;; SELECTORS -- OPERATORS

;;; SELECTORS -- OPERANDS

;;;=================================================================
;;; PREDICATES

(defun variablep (F)
    "Returns T if F is a valid variable symbol"
    (member F *variable-symbols*))

;;;=================================================================
;;; CONSTRUCTORS

(defun make-variable (V)
    "docstring"
    V)

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