package ram15compiler;


import frontend.parser.generated.*;
import syntaxtree.Program;
import visitor.BuildSymbolTableVisitor;
import visitor.TypeCheckVisitor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ram15Compiler {

    static PrintWriter debug = new PrintWriter(System.out);

    public static void main(String[] args) throws ParseException, TokenMgrError, FileNotFoundException {

        if (args.length == 0) {
            RamParser parser = new RamParser(System.in);
            parser.Goal();
        } else {
            java.io.InputStream is = new java.io.FileInputStream(new java.io.File(args[0]));
            RamParser parser = new RamParser(is);
            // parser.Goal();
            Program root = parser.Goal();

            //root.accept(new ASTPrintVisitor());
            //root.accept(new JavaPrintVisitor());
            //root.accept(new RamPrintVisitor());
            //root.accept(new PythonPrintVisitor());

            System.out.println("Program lexed and parsed successfully");

            System.out.println("Abstract syntax tree built");


            // build symbol table
            BuildSymbolTableVisitor v = new BuildSymbolTableVisitor();  // note that this is necessary so we can access our table later
            root.accept(v); // build symbol table
            System.out.println("Symbol Table built");

            // print symbol table
            System.out.println("Begin print of symbol table");
            System.out.println(v.getSymbolTable());
            System.out.println("End print of symbol table");


            // perform type checking
            root.accept(new TypeCheckVisitor(v.getSymbolTable()));
            System.out.println("Semantic Analysis: Type Checking complete");


        }

    }
}
