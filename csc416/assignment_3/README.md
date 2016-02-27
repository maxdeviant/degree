# Programming Assignment 3: Parser

## Date Out: Thursday, October 1

## Due Date: Thursday, October 22 (by end of day)

* * *

This programming assignment extends our compiler's frontend to parsing!

In this assignment we will use the popular [Java Compiler Compiler (JavaCC)](http://javacc.java.net/) parser tool. JavaCC is a _top-down, recursive-descent parser_, meaning that grammars <u>must not have any left recursion, and "common prefixes" must be handled</u> (either by left factoring, or LOOKAHEAD). Of course, the grammars should also not be ambiguous. Our RAM grammar that we will supply to JavaCC will, for the most part, be LL(1). However, it is possible to specify in the grammar a `LOOKAHEAD` directive to instruct JavaCC to peek at more than the next token in order to decide which production is appropriate to use next in a parse. Thus, the grammar can be LL(2), LL(3), ... LL(k) at specific points.

In a compiler, the input to a Parser is the token stream output from a Scanner. However, JavaCC is a tool that generates both a scanner and parser in one. Rather then complicating the engineering of our compiler right now, in this assignment we're going to strictly use JavaCC to handle _both_ the scanning and parsing; that is, we won't be using JFlex or your Programming #2 lexical specification.

Like JFlex, JavaCC takes a specification file (`.jj` extension), which contains both a lexical specification and a grammar, and automatically generates several Java files. One of these files, `RamParser.java`, defines the LL(k) recursive-descent parser <u>with selective lookahead</u> based on a grammar!

Our next homework will extend the parser to additionally produce parse trees.

_(There are many other parser tools, and you may run into these in the future. Yacc and Bison are classical LALR parser generators for the C programming language; Bison is a modern extension to Yacc and is often used with lexical output from Flex. Both Yacc and Bison can also generate Java. CUP is a parser that is typically used to follow the JFlex scanner; however, it also is LALR, rather than LL. An LL parser that is gaining in popularity is ANTLR.)_

Like with the previous programming assignments, you may work with a classmate if you wish. However, you should be able to explain all code that you submit, if I ask you to. Utilize our Piazza message board for help.

Tasks:

1.  Familiarize yourself with JavaCC's parsing abilities. Some additional resources:

*   our class notes
*   [Theodore Norvell's JavaCC FAQ](http://www.engr.mun.ca/~theo/JavaCC-FAQ/javacc-faq-moz.htm) (Chapters 4.1 - 4.7, 4.13, 4.20)
*   [JavaCC LOOKAHEAD MiniTutorial](https://javacc.java.net/doc/lookahead.html) ("syntactic lookahead" and "semantic lookahead" will not be necessary for this assignment)
*   Other links that I found useful: [1](http://www.engr.mun.ca/~theo/JavaCC-Tutorial/javacc-tutorial.pdf) [2](http://cs.lmu.edu/~ray/notes/javacc/)
*   Note that there are many advanced parsing features built into JavaCC. You don't need to know these to complete the assignment, and it certainly is possible to write the grammar in JavaCC using just basic constructs. <u>**In short, do not use anything in this assignment that you don't understand. Copying complex grammars that you do not understand is considered cheating!**</u>

*   [The Java Language Specification, Java SE 8 Edition](http://docs.oracle.com/javase/specs/) (788 pages!)
*   [MiniJava Grammar](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments/MiniJava.html)
*   [Our Ram15 Language Specification](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments/Ram15Language.html)

4.  Download and import the [starter code](http://www.cs.wcupa.edu/rburns/Compilers/prog_assignments/prog3/hw3-startercode.zip). Familiarize yourself with the `build.xml`
5.  _[Specifying the Ram15 grammar:]_ Code in the `frontend/parser/RamGrammar.jj` file the complete grammar for Ram15\. Because JavaCC is a recursive-descent parser, left-recursion must be removed from the grammar. (JavaCC will output a warning if it detects left recursion.) Notice that some of the _Exp_ production rules in Ram15 are left recursive.

    Because JavaCC can perform LOOKAHEAD when specified (see the above JavaCC resources), this sometimes avoids the necessity to left-factor the grammar. (The downside to lookahead is performance cost, depending on how much lookahead is used; the upside is that the grammar can retain some of its simplicity by avoiding another rewriting step.)

    In general,

    1.  create a production for each non-terminal in the grammar
    2.  follow the grammar and utilize the token classes that I already defined in the lexical specification portion of `RamGrammar.jj` (lines 29-93)
    3.  eliminate left recursion (by rewriting and introducing new non-terminals)
    4.  is there any need to left factor?
    5.  include appropriate `LOOKAHEAD(k)` instructions
    6.  debug!

    To get you started, here are my first few productions:

    <pre>void Goal() :
    {}
    {
      /* ( RamToken() )*  <EOF> */
      Program() <EOF>
    }

    void RamToken():
    {}
    {
      <CLASS>  |  <IDENTIFIER> | <LBRACE> | <PUBLIC> | <STATIC> | <VOID> |
      <MAIN> | <LPAREN> | <STRING> | <LSQPAREN> | <RSQPAREN> | <RPAREN> | <RBRACE> |
      <PLUSEQUALS> | <MINUSEQUALS> | <SEMICOLON> | <RETURN> | <COMMA> | <INTEGER> | <BOOLEAN> | <ASSIGN> |
      <IF> | <ELSE> | <WHILE> | <COLON> | <PRINT> | <PRINTLN> | <AND> |
      <OR> | <LESSTHAN> | <EQUALITY> | <PLUS> | <MINUS> | <TIMES> |
      <DOT> | <LENGTH> | <INTEGER_LITERAL> | <TRUE> | <FALSE> | <THIS> | <NEW> |
      <EXCLAMATION>
    }

    void Program() :
    {}
    {
        MainClass() ( ClassDecl() )*
    }

    void MainClass() :
    {}
    {
        <CLASS> <IDENTIFIER> <LBRACE> <PUBLIC> <STATIC> <VOID> <MAIN> <LPAREN>
        <STRING> <LSQPAREN> <RSQPAREN> <IDENTIFIER> <RPAREN> <LBRACE>
        Statement()
        <RBRACE> <RBRACE>
    }
    </pre>

    Notice how these productions correspond exactly with the Ram15 grammar (see above link). `ClassDecl()`, and `Statement()` are other nonterminals whose productions rules will have to be defined by you.

6.  _[Generating the Parser:]_ Run JavaCC on your specification file, and instruct JavaCC to generate the parser in the package `frontend.parser.generated`. This is easy, because I already wrote an Ant target that does this: `generateParser`
    *   _Other notes to help you understand `RamGrammar.jj`_: The start production in the starter code grammar is `Goal --> Program <div(lines 97-102). (If you want to make JavaCC function <u>only</u> as a Scanner, simply switch the line that is commented out from line 100 to line 101\. Line 100 says that a valid program is any that contains zero or more RamTokens; the only way this grammar wouldn't successfully parse an input program would be if that program contains some token that it wasn't expecting.)
7.  _[Testing the Parser:]_ Use the Ant target `runParser`, which specifies a single input file that will be run through the parser. If the source program input file is not in the language of the grammar, the parser will say so by throwing an exception. Look at the stack trace to figure out which nonterminals have been expanded, and where the parser "got stuck".
8.  _[Create additional testcases:]_ Create an additional five programs written in Ram15\. Two should be valid programs, and three should have syntax errors. Each of the three fail tests should test a different possible error. Include these programs in the `test` directory in your submission. To be clear, your project directory probably looks like the following:
    `

    <pre>MyCompilerProject
      - build.xml                    (Ant build file)
      - src/frontend/                (front-end of our compiler)
      - src/frontend/scanner/ram15_lex_spec.jflex   (lexical specification for Ram)
      - src/frontend/parser/RamGrammar.jj   (grammar for Ram)
      - src/frontend/scanner/generated/      (holds generated .java Scanner files by JFlex)
      - src/frontend/parser/generated/       (holds generated .java Parser files by JavaCC)
      - build/                       (compiled class files, sometimes IDE call this directory "bin" instead)
      - lib/                         (any necessary external jar files -- JavaCC, JUnit, JFlex, ...)
      - tests/                       (JUnit test code, pass/fail programs to test each compiler component)
    </pre>

    `

## Submission instructions:

Submit a zip or tar of your project directory on D2L.
