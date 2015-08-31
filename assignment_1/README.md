# Programming Assignment 1: Straight Line Program Interpreter

## Date Out: Thursday, August 27

## Due Date: Tuesday, September 15 (by end of day)

* * *

This introductory programming assignment is designed as a "warm-up" assignment involving tree data structures and encapsulation. Don't allow the expression "warm-up" to be misleading: this assignment contain several layers of complexity!

The assignment follow the Ch 1 introductory programming exercise in [Appel's compiler textbook](http://www.cs.wcupa.edu/rburns/Compilers//handouts/appel-ch1.pdf) -- I used this book in Fall 2013, the last time I taught this course. We're using a different textbook this time around, and this assignment is the only one I anticipate referencing Appel.

The wording and description in the Appel book is very, very dense. Anticipate reading the few pages in Ch. 1 many times before getting comforable enough to start coding. This is okay!

1.  This is potentially challenging <del><u>individual</u></del> programming assignment. You may work with a classmate if you wish. However, you should be able to explain all code that submit, if I ask you to. Utilize our Piazza message board for help. Start now. Start now. Start now.
2.  Our programming projects will involve a substantial number of files, and a full-featured IDE will facilitate working with them. I recommend using NetBeans or Eclipse.
3.  Create a new project. Download the project [starter files](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments/prog1/SLPInterpreterStudent.zip). Import them into your working project.
4.  Understand the starter code. Note the use of three different packages in the code: `slpinterpreter`, `slpinterpreter.grammar`, and `slpinternpreter.test`.
    *   `slpinterpreter` - any code that you write, you'll likely want to place here within this package.
    *   `slpinterpreter.grammar` - these Java classes implement Appel Grammar 1.3, and directly follow the Straight Line Program language from class.
    *   `slpinterpreter.test` - contains test cases to be used for testing your project. The file `TestPrograms.java` contains a number of already instantiated Straight Line programs (`prog0` thru `prog4`).
5.  This project write-up is intended to supplement Appel's description. Read and understand `Section 1.3` (pp. 7-11) of the Appel text, and especially the grammar in `Grammar 1.3` and the grammar's representation in `Program 1.5`. Then read the programming assignment (pp. 11-14). Re-read it; it is very dense.
6.  Where to begin? Look at `slpinterpreter/Driver.java`. Code `maxargs` either functionally, or with an object-oriented approach _(uncomment either line 18 or 19)_.
7.  As demoed in class, we'll be using [Ant](http://ant.apache.org/) to compile, run, and test our code. (Ant should already be configured in NetBeans and Eclipse, so there is noting additional you need to install.) I've already created an Ant file for you named `build.xml`, which contains "targets" that we'll be executing.
    *   build - compiles the project's source code
    *   runDriver - runs the generated `Driver.class`
    *   testSingle - doesn't run the driver, but instead calls everything from the specified JUnit test _(see line 46 in `build.xml`)_
    *   testAll - runs all of the JUnit tests, so you can very quickly see which tests pass and which ones fail
    *   init - creates a `build/classes` directory (This was necessary for me to run once on my machine given my NetBeans configuration.)
8.  We'll be using [JUnit](http://junit.org) to automatically test our code. (Similar to Ant, this should already be included in your NetBeans or Eclipse.) The tests are in the files `slpinterpreter/test/ProgXSingleTest.java`. You don't need to have a complete and thorough understanding of how JUnit works in order to create and run the tests (_though that certainly doesn't hurt for job interviews!_) -- just copy my structure to create additional tests that can be automatically run. Note that `slpinterpreter/test/Prog0SingleTest.java` contains the answers for the `prog0` program in `TestPrograms.java`, and so forth.
9.  In the JUnit tests, I am using the method `assertEquals` to see if the output of the program is correct. There are two JUnit tests in each `ProgXSingleTest.java` file.
10.  Don't change the test cases (`ProgXSingleTest.java`) except for uncommenting `evalutatesMaxArgs()` and `evalutatesInterpreter()`. (For `Prog0SingleTest.java`, depending if you're coding functionally or OO, the method call should be either line 22 or 23, and either line 46 or 47.)
11.  Also implement `interp`.
12.  Test your code using additional test cases. Of course, in addition to the five tests that I've already provided, I'll be testing your code on other heldout tests (by inserting additional test files into the `slpinterpreter.test` package, and then using the `testAll` Ant target).

In summary, here is the directory structure for the assignment:

    SLPInterpreter
      - build.xml                       (Ant build file)
      - src/                            (source code)
      - src/slpinterpreter/
      - src/slpinterpreter/Driver.java  (driver file, no testing, no JUnit)
      - src/slpinterpreter/grammar/*    (implementation of Appel grammar 1.3)
      - src/slpinterpreter/test         (package for test cases)
      - src/slpinterpreter/test/TestPrograms.java  (definitions of some Striaght Line Programs)
      - src/slpinterpreter/test/ProgXSingleTest.java (JUnit tests corresponding to defined programs in TestPrograms.java)
      - build/classes                   (compiled files are generated here)
      - lib/                            (JUnit libraries)

## Submission instructions:

Submit a zip or tar of your project directory on D2L. Double-check that everything is contained in your submission file, and that your code should compile/run on my machine via the Ant targets.
