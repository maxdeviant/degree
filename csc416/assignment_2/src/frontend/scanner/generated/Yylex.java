/* The following code was generated by JFlex 1.6.1 */

/*
 *    User Code Section
 *
 *    This section has code that will be copied to the top of the generated parser,
 *    used for package declarations, imports, etc.
 */
package frontend.scanner.generated;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>/Users/maxdeviant/projects/csc416/assignment_2/src/frontend/scanner/ram15_lex_spec.jflex</tt>
 */
public class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\13\1\1\1\34\1\34\1\34\1\34\16\13\4\0\1\1\1\51"+
    "\2\0\1\12\3\0\1\43\1\44\1\22\1\16\1\53\1\16\1\52"+
    "\1\23\1\26\11\27\1\47\1\50\1\24\1\15\1\24\2\0\32\12"+
    "\1\10\1\0\1\11\1\0\1\12\1\0\1\17\1\2\1\35\1\20"+
    "\1\31\1\32\1\25\1\42\1\5\2\12\1\4\1\40\1\6\1\3"+
    "\1\36\1\12\1\21\1\33\1\7\1\30\1\37\1\41\3\12\1\45"+
    "\1\0\1\46\1\0\6\13\1\14\32\13\1\1\1\0\4\12\4\0"+
    "\1\12\2\0\1\13\7\0\1\12\4\0\1\12\5\0\27\12\1\0"+
    "\37\12\1\0\u01ca\12\4\0\14\12\16\0\5\12\7\0\1\12\1\0"+
    "\1\12\21\0\160\13\5\12\1\0\2\12\2\0\4\12\10\0\1\12"+
    "\1\0\3\12\1\0\1\12\1\0\24\12\1\0\123\12\1\0\213\12"+
    "\1\0\5\13\2\0\236\12\11\0\46\12\2\0\1\12\7\0\47\12"+
    "\7\0\1\12\1\0\55\13\1\0\1\13\1\0\2\13\1\0\2\13"+
    "\1\0\1\13\10\0\33\12\5\0\3\12\15\0\5\13\6\0\1\12"+
    "\4\0\13\13\5\0\53\12\37\13\4\0\2\12\1\13\143\12\1\0"+
    "\1\12\10\13\1\0\6\13\2\12\2\13\1\0\4\13\2\12\12\13"+
    "\3\12\2\0\1\12\17\0\1\13\1\12\1\13\36\12\33\13\2\0"+
    "\131\12\13\13\1\12\16\0\12\13\41\12\11\13\2\12\4\0\1\12"+
    "\5\0\26\12\4\13\1\12\11\13\1\12\3\13\1\12\5\13\22\0"+
    "\31\12\3\13\104\0\1\12\1\0\13\12\67\0\33\13\1\0\4\13"+
    "\66\12\3\13\1\12\22\13\1\12\7\13\12\12\2\13\2\0\12\13"+
    "\1\0\7\12\1\0\7\12\1\0\3\13\1\0\10\12\2\0\2\12"+
    "\2\0\26\12\1\0\7\12\1\0\1\12\3\0\4\12\2\0\1\13"+
    "\1\12\7\13\2\0\2\13\2\0\3\13\1\12\10\0\1\13\4\0"+
    "\2\12\1\0\3\12\2\13\2\0\12\13\4\12\7\0\1\12\5\0"+
    "\3\13\1\0\6\12\4\0\2\12\2\0\26\12\1\0\7\12\1\0"+
    "\2\12\1\0\2\12\1\0\2\12\2\0\1\13\1\0\5\13\4\0"+
    "\2\13\2\0\3\13\3\0\1\13\7\0\4\12\1\0\1\12\7\0"+
    "\14\13\3\12\1\13\13\0\3\13\1\0\11\12\1\0\3\12\1\0"+
    "\26\12\1\0\7\12\1\0\2\12\1\0\5\12\2\0\1\13\1\12"+
    "\10\13\1\0\3\13\1\0\3\13\2\0\1\12\17\0\2\12\2\13"+
    "\2\0\12\13\1\0\1\12\17\0\3\13\1\0\10\12\2\0\2\12"+
    "\2\0\26\12\1\0\7\12\1\0\2\12\1\0\5\12\2\0\1\13"+
    "\1\12\7\13\2\0\2\13\2\0\3\13\10\0\2\13\4\0\2\12"+
    "\1\0\3\12\2\13\2\0\12\13\1\0\1\12\20\0\1\13\1\12"+
    "\1\0\6\12\3\0\3\12\1\0\4\12\3\0\2\12\1\0\1\12"+
    "\1\0\2\12\3\0\2\12\3\0\3\12\3\0\14\12\4\0\5\13"+
    "\3\0\3\13\1\0\4\13\2\0\1\12\6\0\1\13\16\0\12\13"+
    "\11\0\1\12\7\0\3\13\1\0\10\12\1\0\3\12\1\0\27\12"+
    "\1\0\12\12\1\0\5\12\3\0\1\12\7\13\1\0\3\13\1\0"+
    "\4\13\7\0\2\13\1\0\2\12\6\0\2\12\2\13\2\0\12\13"+
    "\22\0\2\13\1\0\10\12\1\0\3\12\1\0\27\12\1\0\12\12"+
    "\1\0\5\12\2\0\1\13\1\12\7\13\1\0\3\13\1\0\4\13"+
    "\7\0\2\13\7\0\1\12\1\0\2\12\2\13\2\0\12\13\1\0"+
    "\2\12\17\0\2\13\1\0\10\12\1\0\3\12\1\0\51\12\2\0"+
    "\1\12\7\13\1\0\3\13\1\0\4\13\1\12\10\0\1\13\10\0"+
    "\2\12\2\13\2\0\12\13\12\0\6\12\2\0\2\13\1\0\22\12"+
    "\3\0\30\12\1\0\11\12\1\0\1\12\2\0\7\12\3\0\1\13"+
    "\4\0\6\13\1\0\1\13\1\0\10\13\22\0\2\13\15\0\60\12"+
    "\1\13\2\12\7\13\4\0\10\12\10\13\1\0\12\13\47\0\2\12"+
    "\1\0\1\12\2\0\2\12\1\0\1\12\2\0\1\12\6\0\4\12"+
    "\1\0\7\12\1\0\3\12\1\0\1\12\1\0\1\12\2\0\2\12"+
    "\1\0\4\12\1\13\2\12\6\13\1\0\2\13\1\12\2\0\5\12"+
    "\1\0\1\12\1\0\6\13\2\0\12\13\2\0\4\12\40\0\1\12"+
    "\27\0\2\13\6\0\12\13\13\0\1\13\1\0\1\13\1\0\1\13"+
    "\4\0\2\13\10\12\1\0\44\12\4\0\24\13\1\0\2\13\5\12"+
    "\13\13\1\0\44\13\11\0\1\13\71\0\53\12\24\13\1\12\12\13"+
    "\6\0\6\12\4\13\4\12\3\13\1\12\3\13\2\12\7\13\3\12"+
    "\4\13\15\12\14\13\1\12\17\13\2\0\46\12\1\0\1\12\5\0"+
    "\1\12\2\0\53\12\1\0\u014d\12\1\0\4\12\2\0\7\12\1\0"+
    "\1\12\1\0\4\12\2\0\51\12\1\0\4\12\2\0\41\12\1\0"+
    "\4\12\2\0\7\12\1\0\1\12\1\0\4\12\2\0\17\12\1\0"+
    "\71\12\1\0\4\12\2\0\103\12\2\0\3\13\40\0\20\12\20\0"+
    "\125\12\14\0\u026c\12\2\0\21\12\1\1\32\12\5\0\113\12\3\0"+
    "\3\12\17\0\15\12\1\0\4\12\3\13\13\0\22\12\3\13\13\0"+
    "\22\12\2\13\14\0\15\12\1\0\3\12\1\0\2\13\14\0\64\12"+
    "\40\13\3\0\1\12\3\0\2\12\1\13\2\0\12\13\41\0\3\13"+
    "\2\0\12\13\6\0\130\12\10\0\51\12\1\13\1\12\5\0\106\12"+
    "\12\0\35\12\3\0\14\13\4\0\14\13\12\0\12\13\36\12\2\0"+
    "\5\12\13\0\54\12\4\0\21\13\7\12\2\13\6\0\12\13\46\0"+
    "\27\12\5\13\4\0\65\12\12\13\1\0\35\13\2\0\13\13\6\0"+
    "\12\13\15\0\1\12\130\0\5\13\57\12\21\13\7\12\4\0\12\13"+
    "\21\0\11\13\14\0\3\13\36\12\15\13\2\12\12\13\54\12\16\13"+
    "\14\0\44\12\24\13\10\0\12\13\3\0\3\12\12\13\44\12\122\0"+
    "\3\13\1\0\25\13\4\12\1\13\4\12\3\13\2\12\11\0\300\12"+
    "\47\13\25\0\4\13\u0116\12\2\0\6\12\2\0\46\12\2\0\6\12"+
    "\2\0\10\12\1\0\1\12\1\0\1\12\1\0\1\12\1\0\37\12"+
    "\2\0\65\12\1\0\7\12\1\0\1\12\3\0\3\12\1\0\7\12"+
    "\3\0\4\12\2\0\6\12\4\0\15\12\5\0\3\12\1\0\7\12"+
    "\3\0\13\1\5\13\30\0\1\34\1\34\5\13\1\1\17\0\2\12"+
    "\23\0\1\12\12\0\1\1\5\13\5\0\6\13\1\0\1\12\15\0"+
    "\1\12\20\0\15\12\3\0\33\12\25\0\15\13\4\0\1\13\3\0"+
    "\14\13\21\0\1\12\4\0\1\12\2\0\12\12\1\0\1\12\3\0"+
    "\5\12\6\0\1\12\1\0\1\12\1\0\1\12\1\0\4\12\1\0"+
    "\13\12\2\0\4\12\5\0\5\12\4\0\1\12\21\0\51\12\u0a77\0"+
    "\57\12\1\0\57\12\1\0\205\12\6\0\4\12\3\13\2\12\14\0"+
    "\46\12\1\0\1\12\5\0\1\12\2\0\70\12\7\0\1\12\17\0"+
    "\1\13\27\12\11\0\7\12\1\0\7\12\1\0\7\12\1\0\7\12"+
    "\1\0\7\12\1\0\7\12\1\0\7\12\1\0\7\12\1\0\40\13"+
    "\57\0\1\12\u01d0\0\1\1\4\0\3\12\31\0\11\12\6\13\1\0"+
    "\5\12\2\0\5\12\4\0\126\12\2\0\2\13\2\0\3\12\1\0"+
    "\132\12\1\0\4\12\5\0\51\12\3\0\136\12\21\0\33\12\65\0"+
    "\20\12\u0200\0\u19b6\12\112\0\u51cd\12\63\0\u048d\12\103\0\56\12\2\0"+
    "\u010d\12\3\0\20\12\12\13\2\12\24\0\57\12\1\13\4\0\12\13"+
    "\1\0\31\12\7\0\1\13\120\12\2\13\45\0\11\12\2\0\147\12"+
    "\2\0\4\12\1\0\4\12\14\0\13\12\115\0\12\12\1\13\3\12"+
    "\1\13\4\12\1\13\27\12\5\13\20\0\1\12\7\0\64\12\14\0"+
    "\2\13\62\12\21\13\13\0\12\13\6\0\22\13\6\12\3\0\1\12"+
    "\4\0\12\13\34\12\10\13\2\0\27\12\15\13\14\0\35\12\3\0"+
    "\4\13\57\12\16\13\16\0\1\12\12\13\46\0\51\12\16\13\11\0"+
    "\3\12\1\13\10\12\2\13\2\0\12\13\6\0\27\12\3\0\1\12"+
    "\1\13\4\0\60\12\1\13\1\12\3\13\2\12\2\13\5\12\2\13"+
    "\1\12\1\13\1\12\30\0\3\12\2\0\13\12\5\13\2\0\3\12"+
    "\2\13\12\0\6\12\2\0\6\12\2\0\6\12\11\0\7\12\1\0"+
    "\7\12\221\0\43\12\10\13\1\0\2\13\2\0\12\13\6\0\u2ba4\12"+
    "\14\0\27\12\4\0\61\12\u2104\0\u016e\12\2\0\152\12\46\0\7\12"+
    "\14\0\5\12\5\0\1\12\1\13\12\12\1\0\15\12\1\0\5\12"+
    "\1\0\1\12\1\0\2\12\1\0\2\12\1\0\154\12\41\0\u016b\12"+
    "\22\0\100\12\2\0\66\12\50\0\15\12\3\0\20\13\20\0\7\13"+
    "\14\0\2\12\30\0\3\12\31\0\1\12\6\0\5\12\1\0\207\12"+
    "\2\0\1\13\4\0\1\12\13\0\12\13\7\0\32\12\4\0\1\12"+
    "\1\0\32\12\13\0\131\12\3\0\6\12\2\0\6\12\2\0\6\12"+
    "\2\0\3\12\3\0\2\12\3\0\2\12\22\0\3\13\4\0\14\12"+
    "\1\0\32\12\1\0\23\12\1\0\2\12\1\0\17\12\2\0\16\12"+
    "\42\0\173\12\105\0\65\12\210\0\1\13\202\0\35\12\3\0\61\12"+
    "\57\0\37\12\21\0\33\12\65\0\36\12\2\0\44\12\4\0\10\12"+
    "\1\0\5\12\52\0\236\12\2\0\12\13\u0356\0\6\12\2\0\1\12"+
    "\1\0\54\12\1\0\2\12\3\0\1\12\2\0\27\12\252\0\26\12"+
    "\12\0\32\12\106\0\70\12\6\0\2\12\100\0\1\12\3\13\1\0"+
    "\2\13\5\0\4\13\4\12\1\0\3\12\1\0\33\12\4\0\3\13"+
    "\4\0\1\13\40\0\35\12\203\0\66\12\12\0\26\12\12\0\23\12"+
    "\215\0\111\12\u03b7\0\3\13\65\12\17\13\37\0\12\13\20\0\3\13"+
    "\55\12\13\13\2\0\1\13\22\0\31\12\7\0\12\13\6\0\3\13"+
    "\44\12\16\13\1\0\12\13\100\0\3\13\60\12\16\13\4\12\13\0"+
    "\12\13\u04a6\0\53\12\15\13\10\0\12\13\u0936\0\u036f\12\221\0\143\12"+
    "\u0b9d\0\u042f\12\u33d1\0\u0239\12\u04c7\0\105\12\13\0\1\12\56\13\20\0"+
    "\4\13\15\12\u4060\0\2\12\u2163\0\5\13\3\0\26\13\2\0\7\13"+
    "\36\0\4\13\224\0\3\13\u01bb\0\125\12\1\0\107\12\1\0\2\12"+
    "\2\0\1\12\2\0\2\12\2\0\4\12\1\0\14\12\1\0\1\12"+
    "\1\0\7\12\1\0\101\12\1\0\4\12\2\0\10\12\1\0\7\12"+
    "\1\0\34\12\1\0\4\12\1\0\5\12\1\0\1\12\3\0\7\12"+
    "\1\0\u0154\12\2\0\31\12\1\0\31\12\1\0\37\12\1\0\31\12"+
    "\1\0\37\12\1\0\31\12\1\0\37\12\1\0\31\12\1\0\37\12"+
    "\1\0\31\12\1\0\10\12\2\0\62\13\u1600\0\4\12\1\0\33\12"+
    "\1\0\2\12\1\0\1\12\2\0\1\12\1\0\12\12\1\0\4\12"+
    "\1\0\1\12\1\0\1\12\6\0\1\12\4\0\1\12\1\0\1\12"+
    "\1\0\1\12\1\0\3\12\1\0\2\12\1\0\1\12\2\0\1\12"+
    "\1\0\1\12\1\0\1\12\1\0\1\12\1\0\1\12\1\0\2\12"+
    "\1\0\1\12\2\0\4\12\1\0\7\12\1\0\4\12\1\0\4\12"+
    "\1\0\1\12\1\0\12\12\1\0\21\12\5\0\3\12\1\0\5\12"+
    "\1\0\21\12\u1144\0\ua6d7\12\51\0\u1035\12\13\0\336\12\u3fe2\0\u021e\12"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\13\36\0\140\13\200\0\360\13\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\6\3\1\4\1\5\1\3\1\6"+
    "\2\3\2\6\1\3\2\7\10\3\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\2\0\1\3"+
    "\1\6\2\3\1\21\5\3\1\0\1\22\13\3\1\23"+
    "\1\24\3\3\2\0\11\3\1\23\1\3\1\0\1\25"+
    "\1\26\1\3\1\0\1\22\1\27\4\3\1\30\1\31"+
    "\2\3\1\23\1\3\1\22\1\3\1\32\1\33\1\3"+
    "\1\34\1\35\1\36\1\37\1\3\1\40\1\41";

  private static int [] zzUnpackAction() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\130\0\204\0\260\0\334\0\u0108\0\u0134"+
    "\0\u0160\0\54\0\54\0\u018c\0\u01b8\0\u01e4\0\u0210\0\54"+
    "\0\u023c\0\u0268\0\54\0\u0294\0\u02c0\0\u02ec\0\u0318\0\u0344"+
    "\0\u0370\0\u039c\0\u03c8\0\u03f4\0\54\0\54\0\54\0\54"+
    "\0\54\0\54\0\54\0\54\0\54\0\130\0\u0420\0\u044c"+
    "\0\u018c\0\u0478\0\u04a4\0\u018c\0\u04d0\0\u04fc\0\u0528\0\u0554"+
    "\0\u0580\0\u05ac\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688\0\u06b4"+
    "\0\u06e0\0\u070c\0\u0738\0\u0764\0\u0790\0\u07bc\0\u07e8\0\u018c"+
    "\0\u0814\0\u0840\0\u086c\0\u0898\0\u08c4\0\u08f0\0\u091c\0\u0948"+
    "\0\u0974\0\u09a0\0\u09cc\0\u09f8\0\u0a24\0\u0a50\0\u018c\0\u0a7c"+
    "\0\u0aa8\0\u018c\0\u018c\0\u0ad4\0\u0b00\0\u0898\0\u018c\0\u0b2c"+
    "\0\u0b58\0\u0b84\0\u0bb0\0\u018c\0\u018c\0\u0bdc\0\u0c08\0\54"+
    "\0\u0c34\0\54\0\u0c60\0\u018c\0\u0c8c\0\u0cb8\0\u018c\0\u018c"+
    "\0\u018c\0\u018c\0\u0ce4\0\u018c\0\u018c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\2\1\3\2\15\1\16\1\14"+
    "\1\17\1\20\1\21\1\20\1\22\1\23\1\24\1\14"+
    "\1\25\1\26\1\27\1\3\1\30\1\31\1\32\1\33"+
    "\1\34\1\14\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\55\0\1\46\12\0\1\46\6\0"+
    "\1\47\10\0\1\46\21\0\1\14\1\50\4\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\6\14\2\0\3\14\2\0\2\14\1\51\3\0\7\14"+
    "\1\0\6\14\13\0\5\14\1\51\2\0\3\14\2\0"+
    "\3\14\3\0\4\14\1\52\2\14\1\0\6\14\13\0"+
    "\4\14\1\53\1\14\2\0\3\14\2\0\3\14\3\0"+
    "\5\14\1\54\1\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\4\14\1\55\2\14\1\0"+
    "\6\14\13\0\6\14\2\0\3\14\2\0\2\14\1\56"+
    "\3\0\7\14\1\0\5\14\1\57\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\26\0"+
    "\1\20\40\0\4\14\1\60\1\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\4\14\1\61\2\14\1\0"+
    "\6\14\33\0\1\62\1\63\32\0\5\14\1\51\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\37\0"+
    "\2\24\26\0\2\14\1\64\3\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\1\65\2\14\3\0\7\14\1\0\6\14"+
    "\13\0\5\14\1\66\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\2\14\1\67\3\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\6\14\2\0\3\14\2\0\2\14\1\70\3\0\3\14"+
    "\1\71\3\14\1\0\6\14\13\0\1\14\1\72\4\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\13\0\6\14\2\0\3\14\2\0\1\73\2\14\3\0"+
    "\7\14\1\0\6\14\13\0\6\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\5\14\1\74\34\0\1\63"+
    "\32\0\1\14\1\75\4\14\2\0\3\14\2\0\3\14"+
    "\3\0\7\14\1\0\6\14\13\0\4\14\1\76\1\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\13\0\5\14\1\77\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\6\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\4\14\1\100\1\14\13\0"+
    "\6\14\2\0\3\14\2\0\3\14\3\0\3\14\1\101"+
    "\3\14\1\0\6\14\13\0\3\14\1\102\2\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\6\14\2\0\3\14\2\0\1\14\1\51\1\14\3\0"+
    "\7\14\1\0\6\14\13\0\5\14\1\103\2\0\3\14"+
    "\2\0\3\14\3\0\7\14\1\0\6\14\11\0\22\104"+
    "\1\105\31\104\14\63\1\0\17\63\1\0\17\63\2\0"+
    "\6\14\2\0\3\14\2\0\3\14\3\0\6\14\1\106"+
    "\1\0\6\14\13\0\2\14\1\107\3\14\2\0\3\14"+
    "\2\0\3\14\3\0\7\14\1\0\6\14\13\0\6\14"+
    "\2\0\3\14\2\0\1\110\2\14\3\0\7\14\1\0"+
    "\6\14\13\0\6\14\2\0\3\14\2\0\1\111\2\14"+
    "\3\0\7\14\1\0\6\14\13\0\3\14\1\112\2\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\13\0\1\113\5\14\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\3\14\1\114\2\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\3\14\1\115\2\14\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\3\14\1\116\2\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\2\14\1\117\3\14\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\6\14\2\0\3\14\2\0"+
    "\3\14\3\0\1\120\6\14\1\0\6\14\13\0\6\14"+
    "\1\121\1\0\3\14\2\0\3\14\3\0\7\14\1\0"+
    "\6\14\13\0\6\14\2\0\3\14\2\0\3\14\3\0"+
    "\4\14\1\122\2\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\6\14\1\123\1\0\6\14"+
    "\13\0\6\14\2\0\3\14\2\0\3\14\3\0\3\14"+
    "\1\124\3\14\1\0\6\14\11\0\22\104\1\125\53\104"+
    "\1\125\1\126\30\104\2\0\6\14\2\0\3\14\2\0"+
    "\3\14\3\0\4\14\1\127\2\14\1\0\6\14\13\0"+
    "\6\14\2\0\3\14\2\0\3\14\3\0\6\14\1\101"+
    "\1\0\6\14\13\0\5\14\1\130\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\6\14\1\131\1\0\6\14"+
    "\13\0\4\14\1\132\1\14\2\0\3\14\2\0\3\14"+
    "\3\0\7\14\1\0\6\14\13\0\2\14\1\133\3\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\13\0\6\14\2\0\3\14\2\0\1\14\1\134\1\14"+
    "\3\0\7\14\1\0\6\14\13\0\4\14\1\135\1\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\13\0\2\14\1\136\3\14\2\0\3\14\2\0\3\14"+
    "\3\0\7\14\1\0\6\14\13\0\5\14\1\137\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\22\0"+
    "\1\140\44\0\6\14\2\0\3\14\2\0\2\14\1\141"+
    "\3\0\7\14\1\0\6\14\11\0\22\104\1\125\1\142"+
    "\30\104\2\0\3\14\1\143\2\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\6\14\13\0\6\14\2\0"+
    "\3\14\2\0\3\14\3\0\6\14\1\144\1\0\6\14"+
    "\13\0\5\14\1\145\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\6\14\13\0\3\14\1\146\2\14\2\0"+
    "\3\14\2\0\3\14\3\0\7\14\1\0\6\14\13\0"+
    "\6\14\2\0\3\14\2\0\3\14\3\0\4\14\1\147"+
    "\2\14\1\0\6\14\13\0\6\14\2\0\3\14\2\0"+
    "\3\14\3\0\7\14\1\0\5\14\1\150\13\0\4\14"+
    "\1\151\1\14\2\0\3\14\2\0\3\14\3\0\7\14"+
    "\1\0\6\14\13\0\6\14\2\0\3\14\2\0\3\14"+
    "\3\0\7\14\1\0\1\152\5\14\13\0\2\14\1\153"+
    "\3\14\2\0\3\14\2\0\3\14\3\0\7\14\1\0"+
    "\6\14\13\0\6\14\2\0\3\14\2\0\3\14\3\0"+
    "\7\14\1\0\1\154\5\14\13\0\4\14\1\155\1\14"+
    "\2\0\3\14\2\0\3\14\3\0\7\14\1\0\6\14"+
    "\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3344];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\7\1\2\11\4\1\1\11\2\1\1\11"+
    "\11\1\11\11\2\0\12\1\1\0\21\1\2\0\13\1"+
    "\1\0\3\1\1\0\12\1\1\11\1\1\1\11\13\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2860) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return YYEOF;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error();
            }
          case 34: break;
          case 2: 
            { 
            }
          case 35: break;
          case 3: 
            { found("IDENTIFIER");
            }
          case 36: break;
          case 4: 
            { found("LEFT_BRACKET");
            }
          case 37: break;
          case 5: 
            { found("RIGHT_BRACKET");
            }
          case 38: break;
          case 6: 
            { found("OPERATOR");
            }
          case 39: break;
          case 7: 
            { found("INTEGER_LITERAL");
            }
          case 40: break;
          case 8: 
            { found("LEFT_PARENTHESIS");
            }
          case 41: break;
          case 9: 
            { found("RIGHT_PARENTHESIS");
            }
          case 42: break;
          case 10: 
            { found("LEFT_BRACE");
            }
          case 43: break;
          case 11: 
            { found("RIGHT_BRACE");
            }
          case 44: break;
          case 12: 
            { found("COLON");
            }
          case 45: break;
          case 13: 
            { found("SEMICOLON");
            }
          case 46: break;
          case 14: 
            { found("EXCLAMATION_MARK");
            }
          case 47: break;
          case 15: 
            { found("PERIOD");
            }
          case 48: break;
          case 16: 
            { found("COMMA");
            }
          case 49: break;
          case 17: 
            { found("IF");
            }
          case 50: break;
          case 18: 
            { found("COMMENT");
            }
          case 51: break;
          case 19: 
            { found("TYPE_DECLARATION");
            }
          case 52: break;
          case 20: 
            { found("NEW");
            }
          case 53: break;
          case 21: 
            { found("BOOLEAN_LITERAL");
            }
          case 54: break;
          case 22: 
            { found("THIS");
            }
          case 55: break;
          case 23: 
            { found("ELSE");
            }
          case 56: break;
          case 24: 
            { found("VOID");
            }
          case 57: break;
          case 25: 
            { found("MAIN");
            }
          case 58: break;
          case 26: 
            { found("CLASS");
            }
          case 59: break;
          case 27: 
            { found("PRINT");
            }
          case 60: break;
          case 28: 
            { found("WHILE");
            }
          case 61: break;
          case 29: 
            { found("LENGTH");
            }
          case 62: break;
          case 30: 
            { found("RETURN");
            }
          case 63: break;
          case 31: 
            { found("STATIC");
            }
          case 64: break;
          case 32: 
            { found("PUBLIC");
            }
          case 65: break;
          case 33: 
            { found("PRINTLN");
            }
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Yylex [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Yylex scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Yylex(reader);
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
