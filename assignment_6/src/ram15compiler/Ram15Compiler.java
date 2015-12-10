package ram15compiler;


import frontend.parser.generated.ParseException;
import frontend.parser.generated.RamParser;
import frontend.parser.generated.TokenMgrError;
import syntaxtree.Program;
import visitor.BuildSymbolTableVisitor;
import visitor.CodeGenerator;
import visitor.TypeCheckVisitor;

import java.io.*;

public class Ram15Compiler {

    static PrintWriter debug = new PrintWriter(System.out);

    public static void main(String[] args) throws ParseException, TokenMgrError, FileNotFoundException {

        if (args.length == 0) {
            RamParser parser = new RamParser(System.in);
            parser.Goal();
        } else {
            InputStream is = new FileInputStream(new File(args[0]));
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
            System.out.println(v.getSymTab());
            System.out.println("End print of symbol table");


            // perform type checking
            root.accept(new TypeCheckVisitor(v.getSymTab()));
            System.out.println("Semantic Analysis: Type Checking complete");

            if (v.getSymTab().anyErrors()) {
                System.out.println("Symbol table contained errors.");

                System.exit(-1);
            }

            System.out.println("Generating code:");
            root.accept(new CodeGenerator(new PrintStream(new File("codegen.s")), v.getSymTab()));
        }

    }
}
