(load (merge-pathnames "integrate.lisp" *load-truename*))

(defun tests ()
    "Runs the tests for Project 1."
    (test-operators)
    (test-operands)
    (test-constructors)
    "Tests passed.")

(defun test-operators ()
    (test-negative-operator)
    (test-sum-operator)
    (test-difference-operator)
    (test-product-operator)
    (test-quotient-operator)
    (test-power-operator)
    "Operator tests passed.")

(defun test-negative-operator ()
    (assert (eq (negative-operator '(- x)) '-)
        ()
        "~S is not equal to ~S" (negative-operator '(- x)) '-))

(defun test-sum-operator ()
    (assert (eq (sum-operator '(+ x y)) '+)
        ()
        "~S is not equal to ~S" (sum-operator '(+ x y)) '+))

(defun test-difference-operator ()
    (assert (eq (difference-operator '(- x y)) '-)
        ()
        "~S is not equal to ~S" (difference-operator '(- x y)) '-))

(defun test-product-operator ()
    (assert (eq (product-operator '(* x y)) '*)
        ()
        "~S is not equal to ~S" (product-operator '(* x y)) '*))

(defun test-quotient-operator ()
    (assert (eq (quotient-operator '(/ x y)) '/)
        ()
        "~S is not equal to ~S" (quotient-operator '(/ x y)) '/))

(defun test-power-operator ()
    (assert (eq (power-operator '(expt x y)) 'expt)
        ()
        "~S is not equal to ~S" (power-operator '(expt x y)) 'expt))

(defun test-operands ()
    (test-negative-operand)
    (test-sum-first-operand)
    (test-sum-second-operand)
    (test-difference-first-operand)
    (test-difference-second-operand)
    (test-product-first-operand)
    (test-product-second-operand)
    (test-quotient-first-operand)
    (test-quotient-second-operand)
    (test-power-first-operand)
    (test-power-second-operand)
    "Operand tests passed.")

(defun test-negative-operand ()
    (assert (eq (negative-operand '(- x)) 'x)
        ()
        "~S is not equal to ~S" (negative-operand '(- x)) 'x))

(defun test-sum-first-operand ()
    (assert (eq (sum-first-operand '(+ x y)) 'x)
        ()
        "~S is not equal to ~S" (sum-first-operand '(+ x y)) 'x))

(defun test-sum-second-operand ()
    (assert (eq (sum-second-operand '(+ x y)) 'y)
        ()
        "~S is not equal to ~S" (sum-second-operand '(+ x y)) 'y))

(defun test-difference-first-operand ()
    (assert (eq (difference-first-operand '(- x y)) 'x)
        ()
        "~S is not equal to ~S" (difference-first-operand '(- x y)) 'x))

(defun test-difference-second-operand ()
    (assert (eq (difference-second-operand '(- x y)) 'y)
        ()
        "~S is not equal to ~S" (difference-second-operand '(- x y)) 'y))

(defun test-product-first-operand ()
    (assert (eq (product-first-operand '(* x y)) 'x)
        ()
        "~S is not equal to ~S" (product-first-operand '(- x y)) 'x))

(defun test-product-second-operand ()
    (assert (eq (product-second-operand '(* x y)) 'y)
        ()
        "~S is not equal to ~S" (product-second-operand '(* x y)) 'y))

(defun test-quotient-first-operand ()
    (assert (eq (quotient-first-operand '(/ x y)) 'x)
        ()
        "~S is not equal to ~S" (quotient-first-operand '(/ x y)) 'x))

(defun test-quotient-second-operand ()
    (assert (eq (quotient-second-operand '(/ x y)) 'y)
        ()
        "~S is not equal to ~S" (quotient-second-operand '(/ x y)) 'y))

(defun test-power-first-operand ()
    (assert (eq (power-first-operand '(expt x y)) 'x)
        ()
        "~S is not equal to ~S" (power-first-operand '(expt x y)) 'x))

(defun test-power-second-operand ()
    (assert (eq (power-second-operand '(expt x y)) 'y)
        ()
        "~S is not equal to ~S" (power-second-operand '(expt x y)) 'y))

(defun test-constructors ()
    (test-make-negative)
    (test-make-sum)
    (test-make-difference)
    (test-make-product)
    (test-make-quotient)
    "Constructor tests passed.")

(defun test-make-negative ()
    "pass")

(defun test-make-sum ()
    (assert (equal (make-sum 'F 0) 'F)
        ()
        "~S is not equal to ~S" (make-sum 'F '0) 'F)
    (assert (equal (make-sum 0 'G) 'G)
        ()
        "~S is not equal to ~S" (make-sum 0 'G) 'G)
    (assert (equal (make-sum 2 3) (+ 2 3))
        ()
        "~S is not equal to ~S" (make-sum 2 3) (+ 2 3))
    (assert (equal (make-sum 'F 'G) '(+ F G))
        ()
        "~S is not equal to ~S" (make-sum 'F 'G) '(+ F G))
    )

(defun test-make-difference ()
    "pass")

(defun test-make-product ()
    "pass")

(defun test-make-quotient ()
    "pass")

(defun runs ()
    "docstring"
    (print (do-run (test-run-1)))
    (print (do-run (test-run-2)))
    (print (do-run (test-run-3)))
    (print (do-run (test-run-4)))
    (print (do-run (test-run-5)))
    (print (do-run (test-run-6)))
    (print (do-run (test-run-7)))
    (print (do-run (test-run-8)))
    (print (do-run (test-run-9)))
    (print (do-run (test-run-10)))
    (print (do-run (test-run-11)))
    (print (do-run (test-run-12)))
    (print (do-run (test-run-13)))
    (print (do-run (test-run-14)))
    (print (do-run (test-run-15)))
    (print (do-run (test-run-16)))
    (print (do-run (test-run-17)))
    (print (do-run (test-run-18)))
    (print (do-run (test-run-19)))
    (print (do-run (test-run-20)))
    "DONE")

(defun do-run (F)
    "Performs a run, printing the function and returning its result."
    (print F)
    (eval F))

(defun test-run-1 ()
    `(integrate '1 'x))

(defun test-run-2 ()
    `(integrate '1 'y 1 4))

(defun test-run-3 ()
    `(integrate 'z 'z))

(defun test-run-4 ()
    `(integrate '(+ x 0) 'x))

(defun test-run-5 ()
    `(integrate '(- x) 'x 1 3))

(defun test-run-6 ()
    `(integrate '(- - x) 'x 1 4))

(defun test-run-7 ()
    `(integrate '(- x) 'x))

(defun test-run-8 ()
    `(integrate '(- - x) 'x))

(defun test-run-9 ()
    `(integrate '(- - - x) 'x))

(defun test-run-10 ()
    `(integrate '(+ x (- x)) 'x))

(defun test-run-11 ()
    `(integrate '(- (+ (- - x) x)) 'x 1 4))

(defun test-run-12 ()
    `(integrate '(+ (+ (- - x) (+ x 3)) 2) 'x 2 6))

(defun test-run-13 ()
    `(integrate '(- x (expt x 3)) 'x))

(defun test-run-14 ()
    `(integrate '(- x (expt x 3)) 'x 2 5))

(defun test-run-15 ()
    `(integrate '(+ (+ x (- - - x)) (expt x 3)) 'x))

(defun test-run-16 ()
    `(integrate '(+ (- x (- x)) (expt x 3)) 'x 2 3))

(defun test-run-17 ()
    `(integrate '(expt x -1) 'x))

(defun test-run-18 ()
    `(integrate '(expt x -1) 'x 3 45))

(defun test-run-19 ()
    `(integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x))

(defun test-run-20 ()
    `(integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x 5 217))
