/* The following code was generated by JFlex 1.4.1 on 11/25/15 12:02 AM */

/*
 * 11/24/2015
 *
 * This library is distributed under a modified BSD license.  See the included
 * LICENSE file for details.
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.IOException;
import java.io.Reader;

import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.AbstractJFlexTokenMaker;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenImpl;
import org.fife.ui.rsyntaxtextarea.TokenTypes;

/**
 * Scanner for Dockerfiles.
 * <p>
 *
 * This implementation was created using
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1; however, the generated file
 * was modified for performance. Memory allocation needs to be almost completely
 * removed to be competitive with the handwritten lexers (subclasses of
 * <code>AbstractTokenMaker</code>, so this class has been modified so that
 * Strings are never allocated (via yytext()), and the scanner never has to
 * worry about refilling its buffer (needlessly copying chars around). We can
 * achieve this because RText always scans exactly 1 line of tokens at a time,
 * and hands the scanner this line as an array of characters (a Segment really).
 * Since tokens contain pointers to char arrays instead of Strings holding their
 * contents, there is no need for allocating new memory for Strings.
 * <p>
 *
 * The actual algorithm generated for scanning has, of course, not been
 * modified.
 * <p>
 *
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 * <li>The generated <code>DockerTokenMaker.java</code> file will contain two
 * definitions of both <code>zzRefill</code> and <code>yyreset</code>. You
 * should hand-delete the second of each definition (the ones generated by the
 * lexer), as these generated methods modify the input buffer, which we'll never
 * have to do.</li>
 * <li>You should also change the declaration/definition of zzBuffer to NOT be
 * initialized. This is a needless memory allocation for us since we will be
 * pointing the array somewhere else anyway.</li>
 * <li>You should NOT call <code>yylex()</code> on the generated scanner
 * directly; rather, you should use <code>getTokenList</code> as you would with
 * any other <code>TokenMaker</code> instance.</li>
 * </ul>
 *
 * @author Robert Futrell
 * @version 0.5
 *
 */

public class DockerTokenMaker extends AbstractJFlexTokenMaker {

	/** This character denotes the end of file */
	public static final int YYEOF = -1;

	/** lexical states */
	public static final int STRING = 1;
	public static final int CHAR_LITERAL = 2;
	public static final int YYINITIAL = 0;

	/**
	 * Translates characters to character classes
	 */
	private static final String ZZ_CMAP_PACKED = "\11\0\1\2\1\37\1\0\1\2\23\0\1\2\1\0\1\34\1\36"
			+ "\3\0\1\35\5\0\2\1\1\0\12\1\4\0\1\33\2\0\1\4" + "\1\14\1\24\1\17\1\10\1\12\1\30\1\1\1\5\1\1\1\27"
			+ "\1\16\1\3\1\6\1\13\1\21\1\1\1\11\1\22\1\7\1\15" + "\1\23\1\26\1\20\1\25\1\1\1\31\1\40\1\31\1\0\1\1"
			+ "\1\0\1\4\1\14\1\24\1\17\1\10\1\12\1\30\1\1\1\5" + "\1\1\1\27\1\16\1\3\1\6\1\13\1\21\1\1\1\11\1\22"
			+ "\1\7\1\15\1\23\1\26\1\20\1\25\1\1\1\0\1\32\uff83\0";

	/**
	 * Translates characters to character classes
	 */
	private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

	/**
	 * Translates DFA states to action switch labels.
	 */
	private static final int[] ZZ_ACTION = zzUnpackAction();

	private static final String ZZ_ACTION_PACKED_0 = "\1\1\2\0\2\1\1\2\14\1\1\3\2\4\1\5"
			+ "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\11" + "\1\15\1\16\1\17\16\1\1\14\1\17\1\1\1\20" + "\41\1";

	private static int[] zzUnpackAction() {
		int[] result = new int[84];
		int offset = 0;
		offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackAction(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/**
	 * Translates a state to a row index in the transition table
	 */
	private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

	private static final String ZZ_ROWMAP_PACKED_0 = "\0\0\0\41\0\102\0\143\0\204\0\245\0\306\0\347"
			+ "\0\u0108\0\u0129\0\u014a\0\u016b\0\u018c\0\u01ad\0\u01ce\0\u01ef"
			+ "\0\u0210\0\u0231\0\143\0\143\0\u0252\0\143\0\143\0\u0273"
			+ "\0\143\0\u0294\0\143\0\143\0\u02b5\0\u02d6\0\143\0\143"
			+ "\0\u02f7\0\u0318\0\u0339\0\u035a\0\u037b\0\u039c\0\u03bd\0\u03de"
			+ "\0\u03ff\0\u0420\0\u0441\0\u0462\0\u0483\0\u04a4\0\u04c5\0\143"
			+ "\0\143\0\u04e6\0\204\0\u0507\0\u0528\0\u0549\0\u056a\0\u058b"
			+ "\0\u05ac\0\u05cd\0\u05ee\0\u060f\0\u0630\0\u0651\0\u0672\0\u0693"
			+ "\0\u06b4\0\u06d5\0\u06f6\0\u0717\0\u0738\0\u0759\0\u077a\0\u079b"
			+ "\0\u07bc\0\u07dd\0\u07fe\0\u081f\0\u0840\0\u0861\0\u0882\0\u08a3" + "\0\u08c4\0\u08e5\0\u0906\0\u0927";

	private static int[] zzUnpackRowMap() {
		int[] result = new int[84];
		int offset = 0;
		offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackRowMap(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
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
	private static final int[] ZZ_TRANS = zzUnpackTrans();

	private static final String ZZ_TRANS_PACKED_0 = "\1\4\1\5\1\6\1\7\1\10\3\5\1\11\1\12"
			+ "\1\13\1\14\1\5\1\15\1\16\3\5\1\17\1\20" + "\1\21\1\5\1\22\2\5\1\23\1\24\1\25\1\26"
			+ "\1\27\1\30\1\31\1\4\34\32\1\33\2\32\1\34" + "\1\35\35\36\1\37\1\36\1\40\1\41\42\0\1\5"
			+ "\1\0\26\5\12\0\1\6\37\0\1\5\1\0\1\5" + "\1\42\24\5\11\0\1\5\1\0\6\5\1\43\5\5"
			+ "\1\44\11\5\11\0\1\5\1\0\3\5\1\45\11\5" + "\1\46\10\5\11\0\1\5\1\0\12\5\1\47\13\5"
			+ "\11\0\1\5\1\0\6\5\1\50\17\5\11\0\1\5" + "\1\0\3\5\1\51\22\5\11\0\1\5\1\0\17\5"
			+ "\1\52\6\5\11\0\1\5\1\0\1\5\1\53\24\5" + "\11\0\1\5\1\0\4\5\1\54\21\5\11\0\1\5"
			+ "\1\0\10\5\1\55\15\5\11\0\1\5\1\0\1\44" + "\7\5\1\56\15\5\11\0\1\5\1\0\10\5\1\57"
			+ "\15\5\43\0\1\24\5\0\37\30\1\0\1\30\34\32" + "\1\0\2\32\2\0\37\60\1\0\1\60\35\36\1\0"
			+ "\1\36\2\0\37\61\1\0\1\61\1\0\1\5\1\0" + "\2\5\1\62\23\5\11\0\1\5\1\0\25\5\1\63"
			+ "\11\0\1\5\1\0\14\5\1\63\11\5\11\0\1\5" + "\1\0\4\5\1\64\13\5\1\63\5\5\11\0\1\5"
			+ "\1\0\16\5\1\65\7\5\11\0\1\5\1\0\3\5" + "\1\63\22\5\11\0\1\5\1\0\10\5\1\66\15\5"
			+ "\11\0\1\5\1\0\11\5\1\67\14\5\11\0\1\5" + "\1\0\5\5\1\70\20\5\11\0\1\5\1\0\11\5"
			+ "\1\71\14\5\11\0\1\5\1\0\10\5\1\72\15\5" + "\11\0\1\5\1\0\13\5\1\73\12\5\11\0\1\5"
			+ "\1\0\16\5\1\74\7\5\11\0\1\5\1\0\6\5" + "\1\75\17\5\11\0\1\5\1\0\3\5\1\76\22\5"
			+ "\11\0\1\5\1\0\6\5\1\77\17\5\11\0\1\5" + "\1\0\10\5\1\100\15\5\11\0\1\5\1\0\1\63"
			+ "\25\5\11\0\1\5\1\0\12\5\1\101\13\5\11\0" + "\1\5\1\0\6\5\1\63\17\5\11\0\1\5\1\0"
			+ "\5\5\1\102\20\5\11\0\1\5\1\0\16\5\1\103" + "\7\5\11\0\1\5\1\0\12\5\1\104\13\5\11\0"
			+ "\1\5\1\0\22\5\1\63\3\5\11\0\1\5\1\0" + "\24\5\1\105\1\5\11\0\1\5\1\0\4\5\1\106"
			+ "\21\5\11\0\1\5\1\0\22\5\1\107\3\5\11\0" + "\1\5\1\0\17\5\1\110\6\5\11\0\1\5\1\0"
			+ "\2\5\1\111\23\5\11\0\1\5\1\0\13\5\1\63" + "\12\5\11\0\1\5\1\0\17\5\1\112\6\5\11\0"
			+ "\1\5\1\0\1\110\25\5\11\0\1\5\1\0\14\5" + "\1\113\11\5\11\0\1\5\1\0\1\5\1\114\24\5"
			+ "\11\0\1\5\1\0\16\5\1\115\7\5\11\0\1\5" + "\1\0\5\5\1\63\20\5\11\0\1\5\1\0\13\5"
			+ "\1\44\12\5\11\0\1\5\1\0\2\5\1\116\23\5" + "\11\0\1\5\1\0\2\5\1\70\23\5\11\0\1\5"
			+ "\1\0\2\5\1\117\23\5\11\0\1\5\1\0\10\5" + "\1\120\15\5\11\0\1\5\1\0\25\5\1\121\11\0"
			+ "\1\5\1\0\3\5\1\52\22\5\11\0\1\5\1\0" + "\2\5\1\122\23\5\11\0\1\5\1\0\3\5\1\123"
			+ "\22\5\11\0\1\5\1\0\3\5\1\124\22\5\11\0" + "\1\5\1\0\1\5\1\102\24\5\11\0\1\5\1\0" + "\4\5\1\63\21\5\10\0";

	private static int[] zzUnpackTrans() {
		int[] result = new int[2376];
		int offset = 0;
		offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackTrans(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			value--;
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/* error codes */
	private static final int ZZ_UNKNOWN_ERROR = 0;
	private static final int ZZ_NO_MATCH = 1;
	private static final int ZZ_PUSHBACK_2BIG = 2;

	/* error messages for the codes above */
	private static final String ZZ_ERROR_MSG[] = { "Unkown internal scanner error", "Error: could not match input",
			"Error: pushback value was too large" };

	/**
	 * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
	 */
	private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

	private static final String ZZ_ATTRIBUTE_PACKED_0 = "\1\1\2\0\1\11\16\1\2\11\1\1\2\11\1\1"
			+ "\1\11\1\1\2\11\2\1\2\11\17\1\2\11\43\1";

	private static int[] zzUnpackAttribute() {
		int[] result = new int[84];
		int offset = 0;
		offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
		return result;
	}

	private static int zzUnpackAttribute(String packed, int offset, int[] result) {
		int i = 0; /* index in packed string */
		int j = offset; /* index in unpacked array */
		int l = packed.length();
		while (i < l) {
			int count = packed.charAt(i++);
			int value = packed.charAt(i++);
			do
				result[j++] = value;
			while (--count > 0);
		}
		return j;
	}

	/** the input device */
	private java.io.Reader zzReader;

	/** the current state of the DFA */
	private int zzState;

	/** the current lexical state */
	private int zzLexicalState = YYINITIAL;

	/**
	 * this buffer contains the current text to be matched and is the source of the
	 * yytext() string
	 */
	private char zzBuffer[];

	/** the textposition at the last accepting state */
	private int zzMarkedPos;

	/** the current text position in the buffer */
	private int zzCurrentPos;

	/** startRead marks the beginning of the yytext() string in the buffer */
	private int zzStartRead;

	/**
	 * endRead marks the last character in the buffer, that has been read from input
	 */
	private int zzEndRead;

	/** zzAtEOF == true <=> the scanner is at the EOF */
	private boolean zzAtEOF;

	/* user code: */

	/**
	 * Constructor. This must be here because JFlex does not generate a no-parameter
	 * constructor.
	 */
	public DockerTokenMaker() {
	}

	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos - 1, tokenType);
	}

	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start, end, tokenType, so);
	}

	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array       The character array.
	 * @param start       The starting offset in the array.
	 * @param end         The ending offset in the array.
	 * @param tokenType   The token's type.
	 * @param startOffset The offset in the document at which this token occurs.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType, int startOffset) {
		super.addToken(array, start, end, tokenType, startOffset);
		zzStartRead = zzMarkedPos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getLineCommentStartAndEnd(int languageIndex) {
		return new String[] { "#", null };
	}

	/**
	 * Returns whether tokens of the specified type should have "mark occurrences"
	 * enabled for the current programming language.
	 *
	 * @param type The token type.
	 * @return Whether tokens of this type should have "mark occurrences" enabled.
	 */
	@Override
	public boolean getMarkOccurrencesOfTokenType(int type) {
		return type == TokenTypes.IDENTIFIER || type == TokenTypes.RESERVED_WORD;
	}

	/**
	 * Returns the first token in the linked list of tokens generated from
	 * <code>text</code>. This method must be implemented by subclasses so they can
	 * correctly implement syntax highlighting.
	 *
	 * @param text             The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset      The offset into the document at which
	 *                         <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing the syntax
	 *         highlighted text.
	 */
	@Override
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = TokenTypes.NULL;

		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new TokenImpl();
		}

	}

	/**
	 * Refills the input buffer.
	 *
	 * @return <code>true</code> if EOF was reached, otherwise <code>false</code>.
	 */
	private boolean zzRefill() {
		return zzCurrentPos >= s.offset + s.count;
	}

	/**
	 * Resets the scanner to read from a new input stream. Does not close the old
	 * reader.
	 *
	 * All internal variables are reset, the old input stream <b>cannot</b> be
	 * reused (internal buffer is discarded and lost). Lexical state is set to
	 * <tt>YY_INITIAL</tt>.
	 *
	 * @param reader the new input stream
	 */
	public final void yyreset(Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill no longer
		 * "refills" the buffer (since the way we do it, it's always "full" the first
		 * time through, since it points to the segment's array). So, we assign
		 * zzEndRead here.
		 */
		// zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtEOF = false;
	}

	/**
	 * Creates a new scanner There is also a java.io.InputStream version of this
	 * constructor.
	 *
	 * @param in the java.io.Reader to read input from.
	 */
	public DockerTokenMaker(java.io.Reader in) {
		this.zzReader = in;
	}

	/**
	 * Creates a new scanner. There is also java.io.Reader version of this
	 * constructor.
	 *
	 * @param in the java.io.Inputstream to read input from.
	 */
	public DockerTokenMaker(java.io.InputStream in) {
		this(new java.io.InputStreamReader(in));
	}

	/**
	 * Unpacks the compressed character translation table.
	 *
	 * @param packed the packed character translation table
	 * @return the unpacked character translation table
	 */
	private static char[] zzUnpackCMap(String packed) {
		char[] map = new char[0x10000];
		int i = 0; /* index in packed string */
		int j = 0; /* index in unpacked array */
		while (i < 160) {
			int count = packed.charAt(i++);
			char value = packed.charAt(i++);
			do
				map[j++] = value;
			while (--count > 0);
		}
		return map;
	}

	/**
	 * Closes the input stream.
	 */
	public final void yyclose() throws java.io.IOException {
		zzAtEOF = true; /* indicate end of file */
		zzEndRead = zzStartRead; /* invalidate buffer */

		if (zzReader != null)
			zzReader.close();
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
	@Override
	public final void yybegin(int newState) {
		zzLexicalState = newState;
	}

	/**
	 * Returns the text matched by the current regular expression.
	 */
	public final String yytext() {
		return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
	}

	/**
	 * Returns the character at position <tt>pos</tt> from the matched text.
	 *
	 * It is equivalent to yytext().charAt(pos), but faster
	 *
	 * @param pos the position of the character to fetch. A value from 0 to
	 *            yylength()-1.
	 *
	 * @return the character at position pos
	 */
	public final char yycharat(int pos) {
		return zzBuffer[zzStartRead + pos];
	}

	/**
	 * Returns the length of the matched text region.
	 */
	public final int yylength() {
		return zzMarkedPos - zzStartRead;
	}

	/**
	 * Reports an error that occured while scanning.
	 *
	 * In a wellformed scanner (no or only correct usage of yypushback(int) and a
	 * match-all fallback rule) this method will only be called with things that
	 * "Can't Possibly Happen". If this method is called, something is seriously
	 * wrong (e.g. a JFlex bug producing a faulty scanner etc.).
	 *
	 * Usual syntax/scanner level error handling should be done in error fallback
	 * rules.
	 *
	 * @param errorCode the code of the errormessage to display
	 */
	private void zzScanError(int errorCode) {
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
	 * They will be read again by then next call of the scanning method
	 *
	 * @param number the number of characters to be read again. This number must not
	 *               be greater than yylength()!
	 */
	public void yypushback(int number) {
		if (number > yylength())
			zzScanError(ZZ_PUSHBACK_2BIG);

		zzMarkedPos -= number;
	}

	/**
	 * Resumes scanning until the next regular expression is matched, the end of
	 * input is encountered or an I/O-Error occurs.
	 *
	 * @return the next token
	 * @exception java.io.IOException if any I/O-Error occurs
	 */
	public org.fife.ui.rsyntaxtextarea.Token yylex() throws java.io.IOException {
		int zzInput;
		int zzAction;

		// cached fields:
		int zzCurrentPosL;
		int zzMarkedPosL;
		int zzEndReadL = zzEndRead;
		char[] zzBufferL = zzBuffer;
		char[] zzCMapL = ZZ_CMAP;

		int[] zzTransL = ZZ_TRANS;
		int[] zzRowMapL = ZZ_ROWMAP;
		int[] zzAttrL = ZZ_ATTRIBUTE;

		while (true) {
			zzMarkedPosL = zzMarkedPos;

			zzAction = -1;

			zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

			zzState = zzLexicalState;

			zzForAction: {
				while (true) {

					if (zzCurrentPosL < zzEndReadL)
						zzInput = zzBufferL[zzCurrentPosL++];
					else if (zzAtEOF) {
						zzInput = YYEOF;
						break zzForAction;
					} else {
						// store back cached positions
						zzCurrentPos = zzCurrentPosL;
						zzMarkedPos = zzMarkedPosL;
						boolean eof = zzRefill();
						// get translated positions and possibly new buffer
						zzCurrentPosL = zzCurrentPos;
						zzMarkedPosL = zzMarkedPos;
						zzBufferL = zzBuffer;
						zzEndReadL = zzEndRead;
						if (eof) {
							zzInput = YYEOF;
							break zzForAction;
						} else {
							zzInput = zzBufferL[zzCurrentPosL++];
						}
					}
					int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
					if (zzNext == -1)
						break zzForAction;
					zzState = zzNext;

					int zzAttributes = zzAttrL[zzState];
					if ((zzAttributes & 1) == 1) {
						zzAction = zzState;
						zzMarkedPosL = zzCurrentPosL;
						if ((zzAttributes & 8) == 8)
							break zzForAction;
					}

				}
			}

			// store back cached position
			zzMarkedPos = zzMarkedPosL;

			switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
			case 16: {
				addToken(TokenTypes.RESERVED_WORD);
			}
			case 17:
				break;
			case 1: {
				addToken(TokenTypes.IDENTIFIER);
			}
			case 18:
				break;
			case 7: {
				addToken(TokenTypes.COMMENT_EOL);
				addNullToken();
				return firstToken;
			}
			case 19:
				break;
			case 2: {
				addToken(TokenTypes.WHITESPACE);
			}
			case 20:
				break;
			case 11: {
				addToken(start, zzStartRead - 1, TokenTypes.LITERAL_STRING_DOUBLE_QUOTE);
				return firstToken;
			}
			case 21:
				break;
			case 14: {
				addToken(start, zzStartRead - 1, TokenTypes.LITERAL_CHAR);
				return firstToken;
			}
			case 22:
				break;
			case 12: { /* Skip escaped chars. */
			}
			case 23:
				break;
			case 4: {
				addToken(TokenTypes.OPERATOR);
			}
			case 24:
				break;
			case 15: { /* Skip escaped single quotes only, but this should still work. */
			}
			case 25:
				break;
			case 5: {
				start = zzMarkedPos - 1;
				yybegin(STRING);
			}
			case 26:
				break;
			case 13: {
				yybegin(YYINITIAL);
				addToken(start, zzStartRead, TokenTypes.LITERAL_CHAR);
			}
			case 27:
				break;
			case 10: {
				yybegin(YYINITIAL);
				addToken(start, zzStartRead, TokenTypes.LITERAL_STRING_DOUBLE_QUOTE);
			}
			case 28:
				break;
			case 8: {
				addNullToken();
				return firstToken;
			}
			case 29:
				break;
			case 9: {
			}
			case 30:
				break;
			case 3: {
				addToken(TokenTypes.SEPARATOR);
			}
			case 31:
				break;
			case 6: {
				start = zzMarkedPos - 1;
				yybegin(CHAR_LITERAL);
			}
			case 32:
				break;
			default:
				if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
					zzAtEOF = true;
					switch (zzLexicalState) {
					case STRING: {
						addToken(start, zzStartRead - 1, TokenTypes.LITERAL_STRING_DOUBLE_QUOTE);
						return firstToken;
					}
					case 85:
						break;
					case CHAR_LITERAL: {
						addToken(start, zzStartRead - 1, TokenTypes.LITERAL_CHAR);
						return firstToken;
					}
					case 86:
						break;
					case YYINITIAL: {
						addNullToken();
						return firstToken;
					}
					case 87:
						break;
					default:
						return null;
					}
				} else {
					zzScanError(ZZ_NO_MATCH);
				}
			}
		}
	}

}
