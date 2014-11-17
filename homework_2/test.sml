(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 18 November 2014 *)
(* test.sml *)

use "homework.sml";

(* Problem 3.3.2 *)

flip [1, 2, 3, 4, 5];
flip [1, 2, 3, 4, 5, 6];
flip [1.0, 2.0, 3.0, 4.0, 5.0, 6.0];
flip [#"a", #"b", #"c", #"d", #"e"];

(* Problem 3.3.3 *)

deleteIth([1, 2, 3], 0);
deleteIth([1, 2, 3], 1);
deleteIth([1, 2, 3], 2);
deleteIth([1, 2, 3], 3);

(* Problem 3.3.9 *)

beginsWithVowel "apple";
beginsWithVowel "egg";
beginsWithVowel "igloo";
beginsWithVowel "oxen";
beginsWithVowel "ukelele";
beginsWithVowel "matt";

(* Problem 3.3.10 *)

piglatinize "apple";
piglatinize "boy";
piglatinize "able";
piglatinize "stripe";
piglatinize "try";
