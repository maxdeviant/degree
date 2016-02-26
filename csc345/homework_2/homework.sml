(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 18 November 2014 *)
(* homework.sml *)

(* Problem 3.3.2 *)

(* Flip alternate elements of any given list *)
fun flip nil = nil
| flip (x::y::xs) = y :: x :: flip xs
| flip (x::xs) = x :: flip xs;

(* Problem 3.3.3 *)

(* Delete the ith element of a list, if it exists *)
fun deleteIth (L, i) =
    let
        (* Delete the element of a list at index i *)
        fun delete (nil, i, position) = nil
        | delete (x::xs, i, position) = if i = position then xs else x :: delete (xs, i, position + 1)
    in
        if i >= 0 andalso i < length L then delete (L, i, 0) else L
    end;

(* Problem 3.3.9 *)

(* Check if a given string begins with a vowel *)
fun beginsWithVowel "" = false
| beginsWithVowel S =
    let
        (* Check if given character is a vowel (excluding semi-vowel 'y') *)
        fun isVowel #"a" = true
        | isVowel #"e" = true
        | isVowel #"i" = true
        | isVowel #"o" = true
        | isVowel #"u" = true
        | isVowel _ = false
    in
        (* Extract the first character of the string and check if it is a vowel *)
        isVowel (hd (explode S))
    end;

(* Problem 3.3.10 *)

(* Convert string into piglatin *)
fun piglatinize "" = ""
| piglatinize W =
    let
        (* Split word into individual characters *)
        val w = explode W;

        (* Check if given character is a vowel (excluding semi-vowel 'y') *)
        fun isVowel #"a" = true
        | isVowel #"e" = true
        | isVowel #"i" = true
        | isVowel #"o" = true
        | isVowel #"u" = true
        | isVowel _ = false

        (* Check if given list of characters contains a vowel *)
        fun hasVowel nil = false
        | hasVowel (x::xs) = if isVowel x then true else hasVowel xs

        (* Convert a word beginning with a vowel to piglatin *)
        fun doVowel L = implode L ^ "yay"

        (* Convert a word beginning with a consonant to piglatin *)
        fun doConsonant nil = ""
        | doConsonant (x::xs) = if isVowel (hd xs) then implode (xs @ [x]) ^ "ay" else doConsonant (xs @ [x])
    in
        if isVowel (hd w) then doVowel w else if hasVowel w then doConsonant w else implode w
    end;
