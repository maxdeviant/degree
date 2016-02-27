/*
 *    User Code Section
 *
 *    This section has code that will be copied to the top of the generated parser,
 *    used for package declarations, imports, etc.
 */

package frontend.scanner.generated;

%%

/*
 * Options and Declarations Section
 *
 * This section is for any jflex declarations and options settings.
 *
 */
%public
%standalone

/* Any following code in between the symbols %{  %}
 * is copied verbatim into the generated class. It can
 * report when something interesting is found.
 */
%{
    public static boolean error_flag = false;

    public void found(String tokenClass) {
       // System.out.println("\nFound |" + str + "| from text -->" + yytext() + "<--");
       System.out.println("< " + tokenClass + " , \"" + yytext() + "\" >");
       System.out.flush();
    }

    public void error() {
        error_flag = true;    // we have an error, set a flag to remember this
        System.out.println("ERROR! " + yytext());
        System.out.flush();
    }
%}

DIGIT        = [0-9]
INTEGER      = 0 | [1-9]{DIGIT}*
LETTER       = [a-zA-Z]
WHITESPACE   = \s
NEWLINE      = \r|\n|\r\n

IDENTIFIER   = {LETTER}({LETTER}|{DIGIT}|_)*

COMMENT      = {MULTICOMMENT} | {LINECOMMENT}
MULTICOMMENT = "/*" ~"*/"
LINECOMMENT  = "//" [^\n\r]* {NEWLINE}?

%%

"class"         { found("CLASS"); }
"public"        { found("PUBLIC"); }
"static"        { found("STATIC"); }
"void"          { found("VOID"); }
"main"          { found("MAIN"); }
"return"        { found("RETURN"); }
"bool"          { found("BOOL"); }
"and"           { found("AND"); }
"or"            { found("OR"); }
"length"        { found("LENGTH"); }
"new"           { found("NEW"); }
"print"         { found("PRINT"); }
"println"       { found("PRINTLN"); }
"while"         { found("WHILE"); }
"if"            { found("IF"); }
"else"          { found("ELSE"); }
"this"          { found("THIS"); }
"String"        { found("STRING"); }
"int"           { found("INT"); }
"true"          { found("TRUE"); }
"false"         { found("FALSE"); }

"=="            { found("EQUALS"); }

"+="            { found("ADDCOMB"); }
"-="            { found("SUBCOMB"); }

","             { found("COMMA"); }
"!"             { found("NOT"); }
"<"             { found("LT"); }
">"             { found("GT"); }
"+"             { found("PLUS"); }
"-"             { found("MINUS"); }
"="             { found("ASSIGN"); }
"*"             { found("MULTIPLY"); }
"("             { found("LPAREN"); }
")"             { found("RPAREN"); }
"["             { found("LSQBRACE"); }
"]"             { found("RSQBRACE"); }
"{"             { found("LCURLY"); }
"}"             { found("RCURLY"); }
":"             { found("COLON"); }
";"             { found("SEMICOLON"); }
"."             { found("DOT"); }

{INTEGER}       { found("INTEGER"); }
{IDENTIFIER}    { found("IDENTIFIER"); }
{COMMENT}       {}
{WHITESPACE}    {}

.               { error(); }
