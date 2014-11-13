(* Problem 3.3.2 *)

(* Problem 3.3.3 *)

(* Problem 3.3.9 *)

fun beginsWithVowel S =
    let
        fun isVowel "a" = true
        | isVowel "e" = true
        | isVowel "i" = true
        | isVowel "o" = true
        | isVowel "u" = true
        | isVowel _ = false
    in
        isVowel(substring(S, 0, 1))
    end;

beginsWithVowel "apple";
beginsWithVowel "egg";
beginsWithVowel "igloo";
beginsWithVowel "oxen";
beginsWithVowel "ukelele";
beginsWithVowel "matt";

(* Problem 3.3.10 *)
