;;; Marshall Bowers
;;; Dr. Richard Wyatt
;;; CSC345-80
;;; 17 October 2014
;;; integrate.lisp

;;;=================================================================
;;;    NAME: integrate
;;;  ARG(S): 
;;; RETURNS: 

(defun integrate (F V &optional lower upper)
    "Integrates F with respect to V, optionally integrating on the domain [LOWER, UPPER]."
    (def-integral (indef-integral F V) V lower upper))

;;;=================================================================
;;;    NAME: indef-integral
;;;  ARG(S): 
;;; RETURNS: 

(defun indef-integral (F V)
    "Indefinitely integrates F with respect to V."
    (labels (
        (indef-integral-aux (F V)
            (cond
                ((number-p F) (make-product F V))
                ((negative-p F) (make-negative (integrate (make-negative F) V)))
                ((variable-p F) (integrate (make-power F 1) V))
                ((sum-p F) (make-sum
                    (integrate (sum-first-operand F) V)
                    (integrate (sum-second-operand F) V)))
                ((difference-p F) (make-difference
                    (integrate (difference-first-operand F) V)
                    (integrate (difference-second-operand F) V)))
                ((and (power-p F) (not (eq (power-second-operand F) -1))) (make-quotient
                    (make-power V (make-sum (power-second-operand F) 1))
                    (make-sum (power-second-operand F) 1)))
                ((and (power-p F) (eq (power-second-operand F) -1) (make-log (power-first-operand F))))
                (t nil))))
        (cond
            ((mult-negative-p F) (indef-integral-aux (make-reduced-negative F) V))
            ((variable-p V) (indef-integral-aux F V))
            (t nil))))

;;;=================================================================
;;;    NAME: def-integral
;;;  ARG(S): 
;;; RETURNS: 

(defun def-integral (F V lower upper)
    "Definitely integrates F with respect to V, on the domain [LOWER, UPPER]."
    (cond
        ((not (and (number-p lower) (number-p upper))) F)
        (t (eval (make-difference
            (my-replace V upper F)
            (my-replace V lower F))))))

(defun my-replace (e1 e2 L)
    "Returns the list L with element E1 replaced with E2."
    (labels (
        (my-replace-aux (e1 e2 L)
            (cond
                ((endp L) nil)
                ((equal (first L) e1) (cons e2 (my-replace e1 e2 (rest L))))
                ((listp (first L)) (cons (my-replace e1 e2 (first L)) (my-replace e1 e2 (rest L))))
                (t (cons (first L) (my-replace e1 e2 (rest L)))))))
        (cond
            ((variable-p L) (first (my-replace e1 e2 (list L))))
            (t (my-replace-aux e1 e2 L)))))

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
    "Selects the negative symbol in a prefix expression."
    (first F))

(defun sum-operator (F)
    "Selects the sum symbol in a prefix expression."
    (first F))

(defun difference-operator (F)
    "Selects the difference symbol in a prefix expression."
    (first F))

(defun product-operator (F)
    "Selects the product symbol in a prefix expression."
    (first F))

(defun quotient-operator (F)
    "Selects the quotient symbol in a prefix expression."
    (first F))

(defun power-operator (F)
    "Selects the power symbol in a prefix expression."
    (first F))

;;; SELECTORS -- OPERANDS

(defun negative-operand (F)
    "Selects the operand of a negative operation in a prefix expression."
    (second F))

(defun sum-first-operand (F)
    "Selects the first operand of a sum operation in a prefix expression."
    (second F))

(defun sum-second-operand (F)
    "Selects the second operand of a sum operation in a prefix expression."
    (third F))

(defun difference-first-operand (F)
    "Selects the first operand of a difference operation in a prefix expression."
    (second F))

(defun difference-second-operand (F)
    "Selects the second operand of a difference operation in a prefix expression."
    (third F))

(defun product-first-operand (F)
    "Selects the first operand of a product operation in a prefix expression."
    (second F))

(defun product-second-operand (F)
    "Selects the second operand of a product operation in a prefix expression."
    (third F))

(defun quotient-first-operand (F)
    "Selects the first operand of a quotient operation in a prefix expression."
    (second F))

(defun quotient-second-operand (F)
    "Selects the second operand of a quotient operation in a prefix expression."
    (third F))

(defun power-first-operand (F)
    "Selects the first operand of a power operation in a prefix expression."
    (second F))

(defun power-second-operand (F)
    "Selects the second operand of a power operation in a prefix expression."
    (third F))

;;;=================================================================
;;; PREDICATES

(defun variable-p (F)
    "Returns T if F is a valid variable symbol."
    (member F *variable-symbols*))

(defun number-p (F)
    "Returns T if F is a number."
    (numberp F))

(defun negative-p (F)
    "Returns T if F is a negative expression."
    (cond
        ((and (number-p F) (< F 0)) t)
        ((number-p F) nil)
        ((variable-p F) nil)
        ((difference-p F) nil)
        ((and
            (eq (negative-operator F) *negative-symbol*)
            (not (eq (negative-operand F) *negative-symbol*))) t)))

(defun mult-negative-p (F)
    "Returns T if F is a negative expression with multiple negations."
    (labels (
        (mult-negative-p-aux (F L)
            (cond
                ((endp F) (eq (length L) 1))
                ((eq (first F) *negative-symbol*) (mult-negative-p-aux (rest F) L))
                (t (mult-negative-p-aux (rest F) (cons (first F) L))))))
    (cond
        ((number-p F) nil)
        ((variable-p F) nil)
        ((negative-p F) nil)
        ((difference-p F) nil)
        ((not (listp F)) nil)
        (t (mult-negative-p-aux F '())))))

(defun sum-p (F)
    "Returns T if F is a sum expression."
    (cond
        ((number-p F) nil)
        ((variable-p F) nil)
        ((and
            (eq (sum-operator F) *sum-symbol*)
            (sum-first-operand F)
            (sum-second-operand F)) t)))

(defun difference-p (F)
    "Returns T if F is a difference expression."
    (cond
        ((number-p F) nil)
        ((variable-p F) nil)
        ((and
            (eq (difference-operator F) *difference-symbol*)
            (not (eq (difference-first-operand F) *difference-symbol*))
            (difference-second-operand F)) t)))

(defun power-p (F)
    "Returns T if F is a power expression."
    (cond
        ((number-p F) nil)
        ((variable-p F) nil)
        ((and
            (eq (power-operator F) *power-symbol*)
            (variable-p (power-first-operand F))
            (number-p (power-second-operand F))) t)))

;;;=================================================================
;;; CONSTRUCTORS

(defun make-variable (V)
    "Constructs a variable expression."
    V)

(defun make-negative (F)
    "Constructs an expression which is the negation of F."
    (labels (
        (make-negative-aux (F)
            (cond
                ((number-p F) (* -1 F))
                ((negative-p F) (negative-operand F))
                (t (list *negative-symbol* F)))))
    (cond
        ((mult-negative-p F) (make-negative-aux (make-reduced-negative F)))
        (t (make-negative-aux F)))))

(defun make-reduced-negative (F)
    "Constructs an expression which is the reduced negation of F."
    (labels (
        (make-reduced-negative-aux (F)
            (cond
                ((eq (mod (length F) 2) 0) (list *negative-symbol* (first (last F))))
                (t (first (last F))))))
    (cond
        ((mult-negative-p F) (make-reduced-negative-aux F))
        ((negative-p F) F))))

(defun make-sum (F G)
    "Constructs an expression with is the sum of F and G."
    (cond
        ((eq F 0) G)
        ((eq G 0) F)
        ((eq F (make-negative G)) 0)
        ((eq G (make-negative F)) 0)
        ((and (number-p F) (number-p G)) (+ F G))
        (t (list *sum-symbol* F G))))

(defun make-difference (F G)
    "Constructs an expression which is the difference of F and G."
    (cond
        ((eq F 0) (make-negative G))
        ((eq G 0) F)
        ((and (number-p F) (number-p G)) (- F G))
        ((eq F (make-negative G)) (make-sum F G))
        (t (list *difference-symbol* F G))))

(defun make-product (F G)
    "Constructs an expression which is the product of F and G."
    (cond
        ((eq F 0) 0)
        ((eq G 0) 0)
        ((eq F 1) G)
        ((eq G 1) F)
        ((eq F -1) (make-negative G))
        ((eq G -1) (make-negative F))
        ((and (negative-p F) (negative-p G)) (make-product (make-negative F) (make-negative G)))
        ((and (number-p F) (number-p G)) (* F G))
        (t (list *product-symbol* F G))))

(defun make-quotient (F G)
    "Constructs an expression which is the quotient of F and G."
    (cond
        ((eq F 0) 0)
        ((eq G 0) nil)
        ((and (number-p F) (number-p G)) (/ F G))
        (t (list *quotient-symbol* F G))))

(defun make-power (V N)
    "Constructs an expression which is V raised to the Nth power."
    (cond
        ((and (number-p V) (numberp N)) (expt V N))
        (t (list *power-symbol* V N))))

(defun make-log (V)
    "Constructs an expression which is the mathematical log of V."
    (cond
        ((variable-p V) (list *log-symbol* V))))
