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