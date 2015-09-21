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
%public       /* Makes the generated class public */
%standalone   /* Creates a main method in the generated class that expects an input file.
                 Also instructs Scanner to send any unmatched input to java.lang.System.out and resume scanning,
                 instead of aborting. */

/* Any following code in between the symbols %{  %}
 * is copied verbatim into the generated class. It can
 * report when something interesting is found.
 */
%{
    public static boolean error_flag = false;

    /*  Call me to say what you found */
    public void found(String tokenClass) {
       System.out.println("< " + tokenClass + " , \"" + yytext() + "\" >");
       System.out.flush();
    }

    /* When the catchall rule matches at the end, we have a problem */
    public void error() {
        error_flag = true;    // we have an error, set a flag to remember this
        System.out.println("ERROR! " + yytext());
        System.out.flush();
    }
%}

WhiteSpace = [ \t]

Operator = {ArithmeticOperator} | {BooleanOperator}

BooleanOperator = "and" | "or"
ArithmeticOperator = "+" | "-" | "*" | "/"

Comment = {TraditionalComment} | {DocumentationComment} | {LineComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*
LineComment = {WhiteSpace}* "//" .*

%%

/*
 * Lexical Rules Section
 *
 * Finally, patterns of interest and what to do upon finding them.
 */

{Comment}        { found("COMMENT"); }
{WhiteSpace}     {  }
{Operator}       { found("OPERATOR"); }
"("              { found("LEFT_PARENTHESIS"); }
")"              { found("RIGHT_PARENTHESIS"); }
"["              { found("LEFT_BRACKET"); }
"]"              { found("RIGHT_BRACKET"); }
"{"              { found("LEFT_BRACE"); }
"}"              { found("RIGHT_BRACE"); }
"class"         { found("CLASS"); }
"public"        { found("PUBLIC"); }
"static"        { found("STATIC"); }
"new"             { found("NEW"); }
[a-zA-Z][a-zA-Z0-9]* { found("IDENTIFIER"); }
.               { error(); }
