(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 18 November 2014 *)
(* homework.sml *)

(* Problem 3.3.2 *)

fun flip nil = nil
| flip (x::y::xs) = y :: x :: flip xs
| flip (x::xs) = x :: flip xs;

flip [1, 2, 3, 4, 5];
flip [1, 2, 3, 4, 5, 6];
flip [1.0, 2.0, 3.0, 4.0, 5.0, 6.0];
flip [#"a", #"b", #"c", #"d", #"e"];

(* Problem 3.3.3 *)

(* Problem 3.3.9 *)

fun beginsWithVowel S =
    let
        fun isVowel #"a" = true
        | isVowel #"e" = true
        | isVowel #"i" = true
        | isVowel #"o" = true
        | isVowel #"u" = true
        | isVowel _ = false
    in
        isVowel(hd(explode S))
    end;

beginsWithVowel "apple";
beginsWithVowel "egg";
beginsWithVowel "igloo";
beginsWithVowel "oxen";
beginsWithVowel "ukelele";
beginsWithVowel "matt";

(* Problem 3.3.10 *)

fun piglatinize W =
    let
        fun doVowel L = implode(L) ^ "yay"

        fun doConsonant L = implode(tl(L) @ [hd(L)]) ^ "ay"
    in
        if beginsWithVowel W then doVowel(explode(W)) else doConsonant(explode(W))
    end;

piglatinize "apple";
piglatinize "boy";
piglatinize "able";
piglatinize "stripe";
piglatinize "try";
