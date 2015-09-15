# Programming Assignment 2: Scanner / Lexer

## Date Out: Tuesday, September 15

## Due Date: Tuesday, September 29 (by end of day)

* * *

This programming assignment creates the first module in our complier, the lexical analyzer!

We will use the popular [JFlex](http://jflex.de/) tool to facilitate the lexical analysis--and eventually the parsing-- of our source files.

JFlex takes a _lexical specification_ and automatically generates a Java file, `Yylex.java`, that defines a program which implements a state machine; this a custom-built scanner/lexer based on our lexical specification!

(There are many other scanning/lexer tools, and you may run into these in the future. Lex is a classical lexical analyzer that generates a scanner in the C programming language. Flex is a free version of Lex (which was originally proprietary). JavaCC and SableCC are also popular.)

Like with Programming Assignment #1, you may work with a classmate if you wish. However, you should be able to explain all code that submit, if I ask you to. Utilize our Piazza message board for help.

Tasks:

1.  Familiarize yourself with JFlex. You'll only be taking advantage of its basic functionality, but because there is so much here, sometimes you'll be reading about parts of JFlex which you don't need. Some additional resources:

*   Sections 3.5 and 3.6 in the _Crafting a Compiler_ text
*   [JFlex User Manual](http://jflex.de/manual.html) (There's a lot here that you don't need to know for this assignment. The "Running JFlex" and "JFlex Ant Task" sections might be helpful; the "Simple Example" is actually quite complicated, and maybe overwhelming, the first time you read it. As with all advanced technical areas, reading something over and over again is often necessary.)

3.  Open your compiler project in the IDE that you are using. Download the skeleton project files ([download link](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments/prog2/hw2-startercode.zip)). Note that the <samp>lib</samp> folder already contains a junit and jflex jar file. (So, you don't need to download JUnit or JFlex.)
4.  Look at and understand the <samp>build.xml</samp> file that I provided. You'll be generating your scanner, compiling it, and executing it via these Ant targets.
5.  Let's create our lexical specification! For our course project, we'll use a modification of the "MiniJava" language (simply a subset of Java) from the Appel compiler book (which I used for the course text in 2013). We'll call our language the **Ram** language.
    *   [The Java Language Specification, Java SE 8 Edition](http://docs.oracle.com/javase/specs/) (788 pages!)
    *   [Appel's MiniJava Grammar](http://www.cambridge.org/resources/052182060X/MCIIJ2e/grammar.htm)
    *   <del>[Our Ram Language Specification](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments//RamLanguage.html)</del>
    *   [Our Ram15 Language Specification](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments//Ram15Language.html) (modify the starter files as appropriate for any new tokens that were introduced)
6.  _[Creating the Lexical Specification:]_ Modify the skeleton `ram15_lex_spec.jflex` file according to the lexical specification for our Ram language.

    Notice where our Ram language differs from MiniJava, and where MiniJava differs from Java (e.g. block comments may not be nested, the print argument is an expression list, && is "and", etc.).

7.  _[Generating the Lexer:]_ Run the appropriate Ant target. Look at the created Java file in the <samp>frontend.scanner.generated</samp> package.
8.  _[Testing the Lexer:]_ Create a good sample of Ram15 programs and run your generated Lexer on them. How can you do this? Is the output of the Lexer what you expected? (More specifically, create an additional five programs written in Ram. Two should be valid programs, and three should have lexical errors.)
9.  To be clear, your project directory probably looks like the following:
    ```
    Ram15Compiler
      - build.xml                                  (Ant build file)
      - src/                                       (source code)
      - src/frontend/                              (package for our front end components)
      - src/frontend/scanner/ram15_lex_spec.jflex  (lexical specification for Ram)
      - src/frontend/scanner/generated/            (package to hold the automatically generated files)
      - build/classes/                             (compiled class files)
      - lib/                                       (holds junit, jflex, ...)
      - tests/                                     (sample Ram programs)
      - tests/pass/                                (Ram15 programs with no lexical errors)
      - tests/fail/                                (Ram15 programs that have lexical errors)
      - tests/junit/JFlexScannerTest.java          (a junit class for running all tests)
    ```

## Submission instructions:

Submit a zip or tar of your project directory on D2L.
