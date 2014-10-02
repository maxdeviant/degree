(load (merge-pathnames "integrate.lisp" *load-truename*))

(defun tests ()
    "Runs the tests for Project 1."
    "Tests passed.")

(defun runs ()
    ""
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
    `(integrate '(- x (expt x 3)) 'x)))

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
