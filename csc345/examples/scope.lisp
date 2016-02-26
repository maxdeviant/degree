;;; Static scoping
(setf x 'a)
(defun F (x y)
    (G y))

(defun G (y)
    x)

;;; Dynamic scoping
(setf x 'a)
(defun F (x y)
    (declare (special x))
    (G y))

(defun G (y)
    x)