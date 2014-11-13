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

fun piglatinize W =
    let
        fun doVowel W = W ^ "yay"

        fun doConsonant W = substring(W, 1, size(W) - 1) ^ substring(W, 0, 1) ^ "ay"
    in
        if beginsWithVowel W then doVowel(W) else doConsonant(W)
    end;

piglatinize "apple";
piglatinize "boy";
piglatinize "able";
piglatinize "stripe";
piglatinize "try";
