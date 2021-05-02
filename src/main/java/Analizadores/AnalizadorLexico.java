// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/main/jflex/lexer.jflex

package Analizadores;
import java_cup.runtime.*;

/* Directivas */

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
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
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\267\u0200\10\u0400\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
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
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\6\1\7\3\0\1\10\1\0\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\12\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\0\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\2\30\1\40\1\41"+
    "\1\42\1\43\2\30\1\44\1\45\1\46\1\30\1\47"+
    "\1\50\3\30\1\51\1\0\1\52\1\0\1\53\1\0"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\2\30\1\40\1\41\1\42\1\43\2\30\1\44"+
    "\1\45\1\46\1\30\1\47\1\50\3\30\1\54\1\55"+
    "\1\56\7\0\1\3\252\0\2\57\115\0\1\60\u01a8\0"+
    "\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
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
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\2\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\1\1\12\1\13\1\14\1\15"+
    "\1\16\1\1\1\17\11\20\1\21\1\22\1\23\1\1"+
    "\1\24\2\1\1\25\1\0\1\26\1\27\1\0\1\30"+
    "\1\31\1\32\1\33\1\34\2\20\1\0\3\20\1\35"+
    "\6\20\1\36\1\35\5\0\1\20\2\37\1\20\1\0"+
    "\4\20\1\40\3\20\1\0\1\20\6\0\1\2\1\20"+
    "\2\41\3\20\1\0\1\20\1\42\1\20\1\0\1\20"+
    "\1\0\1\20\4\0\1\2\4\0\2\20\1\43\1\20"+
    "\1\0\2\20\1\0\2\44\2\45\6\0\1\2\1\0"+
    "\1\46\1\47\2\50\1\20\2\51\2\0\1\2\1\0"+
    "\2\52\1\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[146];
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
    "\0\0\0\61\0\61\0\142\0\223\0\304\0\365\0\61"+
    "\0\61\0\61\0\61\0\61\0\u0126\0\u0157\0\61\0\u0188"+
    "\0\u01b9\0\61\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae\0\u02df"+
    "\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\u0405\0\61\0\61"+
    "\0\61\0\u0436\0\61\0\u0467\0\u0498\0\61\0\304\0\304"+
    "\0\61\0\u04c9\0\u0157\0\61\0\61\0\61\0\61\0\u04fa"+
    "\0\u052b\0\u055c\0\u058d\0\u05be\0\u05ef\0\u027d\0\u0620\0\u0651"+
    "\0\u0682\0\u06b3\0\u06e4\0\u0715\0\61\0\61\0\u0746\0\u0777"+
    "\0\u07a8\0\u07d9\0\u080a\0\u083b\0\u027d\0\61\0\u086c\0\u089d"+
    "\0\u08ce\0\u08ff\0\u0930\0\u0961\0\u027d\0\u0992\0\u09c3\0\u09f4"+
    "\0\u0a25\0\u0a56\0\u0a87\0\u0ab8\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c"+
    "\0\u0bad\0\u0bde\0\u027d\0\61\0\u0c0f\0\u0c40\0\u0c71\0\u0ca2"+
    "\0\u0cd3\0\u027d\0\u0d04\0\u0d35\0\u0d66\0\u0d97\0\u0dc8\0\u0df9"+
    "\0\u0e2a\0\u0e5b\0\u0e8c\0\u0ebd\0\u0eee\0\u0f1f\0\u0bad\0\u0f50"+
    "\0\u0f81\0\u0fb2\0\u027d\0\u0fe3\0\u1014\0\u1045\0\u1076\0\u10a7"+
    "\0\u027d\0\61\0\u027d\0\61\0\u10d8\0\u1109\0\u113a\0\u116b"+
    "\0\u0ebd\0\u119c\0\u07d9\0\u11cd\0\u027d\0\u027d\0\u027d\0\61"+
    "\0\u11fe\0\u027d\0\61\0\u122f\0\u1260\0\u07a8\0\u1291\0\u027d"+
    "\0\61\0\u1109";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[146];
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
    "\1\2\2\3\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\3\26\1\27"+
    "\1\30\1\31\2\26\1\32\1\26\1\33\2\26\1\34"+
    "\1\35\2\26\1\36\1\37\1\40\1\2\1\41\1\42"+
    "\1\43\1\44\1\45\63\0\1\3\103\0\1\46\33\0"+
    "\2\47\4\0\1\47\1\50\51\47\10\0\1\51\70\0"+
    "\1\52\61\0\1\53\56\0\1\53\1\0\1\20\64\0"+
    "\1\54\60\0\1\55\60\0\1\56\60\0\1\57\54\0"+
    "\1\26\5\0\22\26\2\0\1\26\26\0\1\26\5\0"+
    "\4\26\1\60\3\26\1\61\11\26\2\0\1\26\3\0"+
    "\1\62\22\0\1\26\5\0\11\26\1\63\1\26\1\64"+
    "\6\26\2\0\1\26\26\0\1\26\5\0\11\26\1\65"+
    "\10\26\2\0\1\26\26\0\1\26\5\0\5\26\1\66"+
    "\5\26\1\67\6\26\2\0\1\26\26\0\1\26\5\0"+
    "\14\26\1\70\5\26\2\0\1\26\26\0\1\26\5\0"+
    "\4\26\1\71\15\26\2\0\1\26\26\0\1\26\5\0"+
    "\17\26\1\72\2\26\2\0\1\26\26\0\1\26\5\0"+
    "\7\26\1\73\5\26\1\74\4\26\2\0\1\26\62\0"+
    "\1\75\37\0\1\76\5\0\1\77\64\0\1\100\12\0"+
    "\2\52\4\101\10\52\1\102\1\52\1\103\40\52\21\0"+
    "\1\26\5\0\2\26\1\104\17\26\2\0\1\26\26\0"+
    "\1\26\5\0\20\26\1\105\1\26\2\0\1\26\54\0"+
    "\1\106\32\0\1\26\5\0\16\26\1\107\3\26\2\0"+
    "\1\26\4\0\1\110\21\0\1\26\5\0\3\26\1\111"+
    "\16\26\2\0\1\26\26\0\1\26\5\0\14\26\1\112"+
    "\5\26\2\0\1\26\26\0\1\26\5\0\11\26\1\113"+
    "\5\26\1\114\2\26\2\0\1\26\26\0\1\26\5\0"+
    "\3\26\1\115\16\26\2\0\1\26\26\0\1\26\5\0"+
    "\1\116\21\26\2\0\1\26\26\0\1\26\5\0\15\26"+
    "\1\117\4\26\2\0\1\26\26\0\1\26\5\0\10\26"+
    "\1\120\11\26\2\0\1\26\3\0\1\121\22\0\1\26"+
    "\5\0\10\26\1\122\11\26\2\0\1\26\3\0\1\123"+
    "\41\0\1\124\5\0\1\125\56\0\1\126\14\0\20\101"+
    "\1\127\40\101\2\52\4\101\10\52\1\102\1\52\1\130"+
    "\42\52\4\101\10\52\1\131\1\52\1\103\40\52\21\0"+
    "\1\26\5\0\20\26\1\132\1\26\2\0\1\26\26\0"+
    "\1\26\5\0\4\26\1\133\15\26\2\0\1\26\40\0"+
    "\1\134\46\0\1\26\5\0\3\26\1\135\16\26\2\0"+
    "\1\26\26\0\1\26\5\0\1\136\21\26\2\0\1\26"+
    "\26\0\1\26\5\0\10\26\1\137\11\26\2\0\1\26"+
    "\3\0\1\140\22\0\1\26\5\0\4\26\1\141\15\26"+
    "\2\0\1\26\26\0\1\26\5\0\3\26\1\142\16\26"+
    "\2\0\1\26\26\0\1\26\5\0\10\26\1\143\11\26"+
    "\2\0\1\26\3\0\1\144\22\0\1\26\5\0\11\26"+
    "\1\145\10\26\2\0\1\26\45\0\1\146\41\0\1\26"+
    "\5\0\17\26\1\147\2\26\2\0\1\26\53\0\1\150"+
    "\51\0\1\140\17\0\1\140\34\0\1\151\64\0\1\144"+
    "\17\0\1\144\1\0\16\101\1\3\1\101\1\127\40\101"+
    "\2\152\4\153\10\152\1\154\1\152\1\155\40\152\2\156"+
    "\4\0\10\156\1\157\1\156\1\160\40\156\21\0\1\26"+
    "\5\0\1\161\21\26\2\0\1\26\26\0\1\26\5\0"+
    "\4\26\1\162\15\26\2\0\1\26\26\0\1\26\5\0"+
    "\17\26\1\163\2\26\2\0\1\26\26\0\1\26\5\0"+
    "\16\26\1\164\3\26\2\0\1\26\4\0\1\165\45\0"+
    "\1\165\12\0\1\165\21\0\1\26\5\0\6\26\1\166"+
    "\13\26\2\0\1\26\26\0\1\26\5\0\13\26\1\167"+
    "\6\26\2\0\1\26\47\0\1\170\37\0\1\26\5\0"+
    "\4\26\1\171\15\26\2\0\1\26\40\0\1\172\46\0"+
    "\1\26\5\0\4\26\1\173\15\26\2\0\1\26\40\0"+
    "\1\174\62\0\1\175\23\0\2\152\4\153\10\152\1\176"+
    "\1\152\1\155\40\152\20\153\1\177\40\153\2\160\4\200"+
    "\10\160\1\201\1\160\1\202\40\160\2\152\4\153\10\152"+
    "\1\203\1\152\1\155\40\152\2\156\4\0\10\156\1\157"+
    "\42\156\2\160\4\200\10\160\1\201\1\160\1\204\40\160"+
    "\21\0\1\26\5\0\15\26\1\205\4\26\2\0\1\26"+
    "\26\0\1\26\5\0\2\26\1\206\17\26\2\0\1\26"+
    "\26\0\1\26\5\0\17\26\1\207\2\26\2\0\1\26"+
    "\53\0\1\210\33\0\1\26\5\0\4\26\1\211\15\26"+
    "\2\0\1\26\26\0\1\26\5\0\6\26\1\212\13\26"+
    "\2\0\1\26\42\0\1\213\56\0\1\214\25\0\2\152"+
    "\4\153\10\152\1\176\1\152\1\215\40\152\16\153\1\216"+
    "\1\153\1\177\40\153\20\200\1\217\40\200\2\160\4\200"+
    "\10\160\1\176\1\160\1\204\42\160\4\200\10\160\1\102"+
    "\1\160\1\204\40\160\21\0\1\26\5\0\15\26\1\220"+
    "\4\26\2\0\1\26\51\0\1\221\14\0\2\152\4\153"+
    "\10\152\1\222\1\152\1\155\40\152\16\200\1\101\1\200"+
    "\1\217\40\200";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4802];
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


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\4\1\5\11\2\1\1\11\2\1\1\11"+
    "\14\1\3\11\1\1\1\11\2\1\1\11\1\0\1\1"+
    "\1\11\1\0\1\1\4\11\2\1\1\0\12\1\2\11"+
    "\5\0\2\1\1\11\1\1\1\0\10\1\1\0\1\1"+
    "\6\0\3\1\1\11\3\1\1\0\3\1\1\0\1\1"+
    "\1\0\1\1\4\0\1\1\4\0\4\1\1\0\2\1"+
    "\1\0\1\1\1\11\1\1\1\11\6\0\1\1\1\0"+
    "\3\1\1\11\2\1\1\11\2\0\1\1\1\0\1\1"+
    "\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[146];
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

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    int RANGO_ENTERO = (int) (Math.pow(2, 16)-1);
    float RANGO_FLOAT = (float) (Math.pow(2, 32)-1);
    int RANGO_STRING = 30;
    private Symbol symbol(int type) {
          // System.out.println("[LEX] TOKEN < " + Simbolos.terminalNames[type] + " > : " + yytext());
          return new Symbol(type, yyline, yycolumn, yytext());
    }
    private Symbol symbol(int type, Object value) {
          return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
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
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
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
            zzDoEOF();
              {
                return symbol(Simbolos.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Error Léxico: --> " + yytext() + " <-- Linea " + (yyline+1) + " Columna " + yycolumn);
            throw new Error("Error léxico");
            }
            // fall through
          case 43: break;
          case 2:
            { /* do nothing */
            }
            // fall through
          case 44: break;
          case 3:
            { return symbol(Simbolos.OP_NOT);
            }
            // fall through
          case 45: break;
          case 4:
            { return symbol(Simbolos.PAREN_OPEN);
            }
            // fall through
          case 46: break;
          case 5:
            { return symbol(Simbolos.PAREN_CLOSE);
            }
            // fall through
          case 47: break;
          case 6:
            { return symbol(Simbolos.OP_MULTI);
            }
            // fall through
          case 48: break;
          case 7:
            { return symbol(Simbolos.OP_PLUS);
            }
            // fall through
          case 49: break;
          case 8:
            { return symbol(Simbolos.COMA);
            }
            // fall through
          case 50: break;
          case 9:
            { return symbol(Simbolos.OP_MINUS);
            }
            // fall through
          case 51: break;
          case 10:
            { return symbol(Simbolos.OP_DIVISION);
            }
            // fall through
          case 52: break;
          case 11:
            { Integer constInt = Integer.parseInt(yytext());

                                    if(Math.abs(constInt) <= RANGO_ENTERO ){
                                          return symbol(Simbolos.CONSTANTE_ENTERA);
                                    }                                          
                                    else
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los enteros.");
            }
            // fall through
          case 53: break;
          case 12:
            { return symbol(Simbolos.OP_TYPE);
            }
            // fall through
          case 54: break;
          case 13:
            { return symbol(Simbolos.PUNTO_COMA);
            }
            // fall through
          case 55: break;
          case 14:
            { return symbol(Simbolos.OP_LT);
            }
            // fall through
          case 56: break;
          case 15:
            { return symbol(Simbolos.OP_GT);
            }
            // fall through
          case 57: break;
          case 16:
            { return symbol(Simbolos.IDENTIFICADOR);
            }
            // fall through
          case 58: break;
          case 17:
            { return symbol(Simbolos.CORCHETE_OPEN);
            }
            // fall through
          case 59: break;
          case 18:
            { return symbol(Simbolos.CORCHETE_CLOSE);
            }
            // fall through
          case 60: break;
          case 19:
            { return symbol(Simbolos.LLAVE_OPEN);
            }
            // fall through
          case 61: break;
          case 20:
            { return symbol(Simbolos.LLAVE_CLOSE);
            }
            // fall through
          case 62: break;
          case 21:
            { return symbol(Simbolos.OP_NE);
            }
            // fall through
          case 63: break;
          case 22:
            { String constString = new String(yytext());
                                    if (constString.length() <= RANGO_STRING)
                                          return symbol(Simbolos.CONSTANTE_STRING); 
                                    else 
                                          throw new Error("La constante [" + yytext() + "] excede el largo permitido para un string.");
            }
            // fall through
          case 64: break;
          case 23:
            { return symbol(Simbolos.OP_AND);
            }
            // fall through
          case 65: break;
          case 24:
            { Double constFloat = Double.parseDouble(yytext());
                                    if (Math.abs(constFloat) <= RANGO_FLOAT)
                                          return symbol(Simbolos.CONSTANTE_FLOAT);
                                    else
                                          throw new Error("La constante [" + yytext() + "] esta fuera del limite de los flotantes.");
            }
            // fall through
          case 66: break;
          case 25:
            { return symbol(Simbolos.OP_ASIG);
            }
            // fall through
          case 67: break;
          case 26:
            { return symbol(Simbolos.OP_LTE);
            }
            // fall through
          case 68: break;
          case 27:
            { return symbol(Simbolos.OP_EQ);
            }
            // fall through
          case 69: break;
          case 28:
            { return symbol(Simbolos.OP_GTE);
            }
            // fall through
          case 70: break;
          case 29:
            { return symbol(Simbolos.IF);
            }
            // fall through
          case 71: break;
          case 30:
            { return symbol(Simbolos.OP_OR);
            }
            // fall through
          case 72: break;
          case 31:
            { return symbol(Simbolos.DIV);
            }
            // fall through
          case 73: break;
          case 32:
            { return symbol(Simbolos.MOD);
            }
            // fall through
          case 74: break;
          case 33:
            { return symbol(Simbolos.ELSE);
            }
            // fall through
          case 75: break;
          case 34:
            { return symbol(Simbolos.READ);
            }
            // fall through
          case 76: break;
          case 35:
            { return symbol(Simbolos.FLOAT_TYPE);
            }
            // fall through
          case 77: break;
          case 36:
            { return symbol(Simbolos.WHILE);
            }
            // fall through
          case 78: break;
          case 37:
            { return symbol(Simbolos.WRITE);
            }
            // fall through
          case 79: break;
          case 38:
            { return symbol(Simbolos.DECVAR);
            }
            // fall through
          case 80: break;
          case 39:
            { return symbol(Simbolos.ENDDEC);
            }
            // fall through
          case 81: break;
          case 40:
            { return symbol(Simbolos.INLIST);
            }
            // fall through
          case 82: break;
          case 41:
            { return symbol(Simbolos.STRING_TYPE);
            }
            // fall through
          case 83: break;
          case 42:
            { return symbol(Simbolos.INTEGER_TYPE);
            }
            // fall through
          case 84: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
