/* RamParser.java */
/* Generated By:JavaCC: Do not edit this line. RamParser.java */
    package frontend.parser.generated;
    import java.io.FileNotFoundException;

    public class RamParser implements RamParserConstants {
        public static void main(String[] args)
        throws ParseException, TokenMgrError, FileNotFoundException
        {
            if (args.length == 0) {
                RamParser parser = new RamParser( System.in ) ;
                parser.Goal();
            } else {
                java.io.InputStream is = new java.io.FileInputStream(new java.io.File(args[0]));
                RamParser parser = new RamParser( is ) ;
                parser.Goal();
            }
        }

  final public void Goal() throws ParseException {
    Program();
    jj_consume_token(0);
  }

  final public void RamToken() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CLASS:{
      jj_consume_token(CLASS);
      break;
      }
    case IDENTIFIER:{
      jj_consume_token(IDENTIFIER);
      break;
      }
    case LBRACE:{
      jj_consume_token(LBRACE);
      break;
      }
    case PUBLIC:{
      jj_consume_token(PUBLIC);
      break;
      }
    case STATIC:{
      jj_consume_token(STATIC);
      break;
      }
    case VOID:{
      jj_consume_token(VOID);
      break;
      }
    case MAIN:{
      jj_consume_token(MAIN);
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
      break;
      }
    case STRING:{
      jj_consume_token(STRING);
      break;
      }
    case LSQPAREN:{
      jj_consume_token(LSQPAREN);
      break;
      }
    case RSQPAREN:{
      jj_consume_token(RSQPAREN);
      break;
      }
    case RPAREN:{
      jj_consume_token(RPAREN);
      break;
      }
    case RBRACE:{
      jj_consume_token(RBRACE);
      break;
      }
    case PLUSEQUALS:{
      jj_consume_token(PLUSEQUALS);
      break;
      }
    case MINUSEQUALS:{
      jj_consume_token(MINUSEQUALS);
      break;
      }
    case SEMICOLON:{
      jj_consume_token(SEMICOLON);
      break;
      }
    case RETURN:{
      jj_consume_token(RETURN);
      break;
      }
    case COMMA:{
      jj_consume_token(COMMA);
      break;
      }
    case INTEGER:{
      jj_consume_token(INTEGER);
      break;
      }
    case BOOLEAN:{
      jj_consume_token(BOOLEAN);
      break;
      }
    case ASSIGN:{
      jj_consume_token(ASSIGN);
      break;
      }
    case IF:{
      jj_consume_token(IF);
      break;
      }
    case ELSE:{
      jj_consume_token(ELSE);
      break;
      }
    case WHILE:{
      jj_consume_token(WHILE);
      break;
      }
    case COLON:{
      jj_consume_token(COLON);
      break;
      }
    case PRINT:{
      jj_consume_token(PRINT);
      break;
      }
    case PRINTLN:{
      jj_consume_token(PRINTLN);
      break;
      }
    case AND:{
      jj_consume_token(AND);
      break;
      }
    case OR:{
      jj_consume_token(OR);
      break;
      }
    case LESSTHAN:{
      jj_consume_token(LESSTHAN);
      break;
      }
    case EQUALITY:{
      jj_consume_token(EQUALITY);
      break;
      }
    case PLUS:{
      jj_consume_token(PLUS);
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
      break;
      }
    case TIMES:{
      jj_consume_token(TIMES);
      break;
      }
    case DOT:{
      jj_consume_token(DOT);
      break;
      }
    case LENGTH:{
      jj_consume_token(LENGTH);
      break;
      }
    case INTEGER_LITERAL:{
      jj_consume_token(INTEGER_LITERAL);
      break;
      }
    case TRUE:{
      jj_consume_token(TRUE);
      break;
      }
    case FALSE:{
      jj_consume_token(FALSE);
      break;
      }
    case THIS:{
      jj_consume_token(THIS);
      break;
      }
    case NEW:{
      jj_consume_token(NEW);
      break;
      }
    case EXCLAMATION:{
      jj_consume_token(EXCLAMATION);
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Program() throws ParseException {
    MainClass();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case CLASS:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      ClassDecl();
    }
  }

  final public void MainClass() throws ParseException {
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(LBRACE);
    jj_consume_token(PUBLIC);
    jj_consume_token(STATIC);
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LPAREN);
    jj_consume_token(STRING);
    jj_consume_token(LSQPAREN);
    jj_consume_token(RSQPAREN);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Statement();
    jj_consume_token(RBRACE);
    jj_consume_token(RBRACE);
  }

  final public void ClassDecl() throws ParseException {
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(RBRACE);
    Statement();
    jj_consume_token(RBRACE);
  }

  final public void Statement() throws ParseException {
    jj_consume_token(IDENTIFIER);
  }

  final public void Operator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AND:{
      jj_consume_token(AND);
      break;
      }
    case OR:{
      jj_consume_token(OR);
      break;
      }
    case EQUALITY:{
      jj_consume_token(EQUALITY);
      break;
      }
    case LESSTHAN:{
      jj_consume_token(LESSTHAN);
      break;
      }
    case PLUS:{
      jj_consume_token(PLUS);
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
      break;
      }
    case TIMES:{
      jj_consume_token(TIMES);
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public RamParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xfffffe00,0x80000000,0x1f300000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x7ffff,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public RamParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public RamParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new RamParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public RamParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new RamParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public RamParser(RamParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RamParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[53];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 53; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

    }
