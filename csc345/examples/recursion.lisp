;;; Recursion needs two cases:
;;; 1+ base/termination case
;;; 1+ recursive case

;;; 1. Recursive argument                                           L
;;; 2. Termination case                                             nil
;;; 3. How do I detect 2?                                           endp
;;; 4. What to return in 3?                                         0
;;; 5. How do I move the argument towards the termination value?    rest
;;; 6. Grant recursive call on the arg "reduced" by 5               (len (rest L))
;;; 7. Manipulate value returned in 6 to give overall return value  (1+ ...)

(defun len (L)
    "Returns an integer that is the length of L."
    (cond
        ((endp L) 0)
        (t (1+ (len (rest L)))))) ; catch-all

(defun rev (L)
    "Returns a new sequence containing the same elements but in reverse order."
    (cond
        ((endp L) nil)
        (t (append (rev (rest L))
                   (list (first L))))))

(defun member-of (e L)
    "Returns if the element is contained in L."
    (cond
        ((endp L) nil)
        ((eql e (first L)) t)
        (t (member-of e (rest L)))))

(defun safe-len (L)
    "Documentation for safe-len."
    (if (listp L)
        (len L)
        "none"))

(defun length-tr (L)
    "Documentation for length-tr."
    (labels (
        (length-tr-aux (L Acc)
            (cond
            ((endp L) Acc)
            (t (length-tr-aux (rest L) (1+ Acc)))))))
    (length-tr-aux L 0))

; (defun rev-tr (L)
;     "Documentation for rev-tr."
;     (labels (
;         )))

; (defun rev-tr (L Acc)
;     (cond
;         ((endp L) Acc)
;         (t (rev (rest L) (cons (first L) Acc)))))

; (defun hanoi2 (n s a d)
;     (cond
;         ((= n 1) )
;         (t (hanoi2 (1- n) s d a)
;            (hanoi2 1 s ? d)
;            (hanoi2 (1- n) a s d))))

; (defun evens (L)
;     "Documentation for evens."
;     (cond
;         ((endp L) nil)
;         (t (odds (rest L)))))

; (defun odds (L)
;     "Documentation for odds."
;     (cond
;         ((endp L) nil))
;         (t (cons (first L) (evens (rest L)))))

