/*
 * This library is distributed under a modified BSD license.  See the included
 * LICENSE file for details.
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;


/**
 * This class takes plain text and returns tokens representing 6502
 * assembler.<p>
 *
 * This implementation was created using
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1; however, the generated file
 * was modified for performance.  Memory allocation needs to be almost
 * completely removed to be competitive with the handwritten lexers (subclasses
 * of <code>AbstractTokenMaker</code>, so this class has been modified so that
 * Strings are never allocated (via yytext()), and the scanner never has to
 * worry about refilling its buffer (needlessly copying chars around).
 * We can achieve this because RText always scans exactly 1 line of tokens at a
 * time, and hands the scanner this line as an array of characters (a Segment
 * really).  Since tokens contain pointers to char arrays instead of Strings
 * holding their contents, there is no need for allocating new memory for
 * Strings.<p>
 *
 * The actual algorithm generated for scanning has, of course, not been
 * modified.<p>
 *
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 *   <li>The generated <code>Assembler6502TokenMaker.java</code> file will contain two
 *       definitions of both <code>zzRefill</code> and <code>yyreset</code>.
 *       You should hand-delete the second of each definition (the ones
 *       generated by the lexer), as these generated methods modify the input
 *       buffer, which we'll never have to do.</li>
 *   <li>You should also change the declaration/definition of zzBuffer to NOT
 *       be initialized.  This is a needless memory allocation for us since we
 *       will be pointing the array somewhere else anyway.</li>
 *   <li>You should NOT call <code>yylex()</code> on the generated scanner
 *       directly; rather, you should use <code>getTokenList</code> as you would
 *       with any other <code>TokenMaker</code> instance.</li>
 * </ul>
 *
 * @author Robert Futrell
 * @version 0.2
 *
 */
%%

%public
%class Assembler6502TokenMaker
%extends AbstractJFlexTokenMaker
%unicode
%ignorecase
%type org.fife.ui.rsyntaxtextarea.Token


%{


	/**
	 * Constructor.  We must have this here as JFLex does not generate a
	 * no parameter constructor.
	 */
	public Assembler6502TokenMaker() {
		super();
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addToken(int, int, int)
	 */
	private void addHyperlinkToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, true);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addHyperlinkToken(int, int, int)
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *                    occurs.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType, int startOffset) {
		super.addToken(array, start,end, tokenType, startOffset);
		zzStartRead = zzMarkedPos;
	}


	@Override
	public String[] getLineCommentStartAndEnd(int languageIndex) {
		return new String[] { ";", null };
	}


	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *                    <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {

		resetTokenList();
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = YYINITIAL;
		switch (initialTokenType) {
			default:
				state = YYINITIAL;
		}

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
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 */
	private boolean zzRefill() {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream
	 */
	public final void yyreset(Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtBOL  = true;
		zzAtEOF  = false;
	}


%}

Letter				= ([A-Za-z])
LetterOrUnderscore	= ({Letter}|"_")
Digit				= ([0-9])
IntegerNumber       = ({Digit}+)
HexNumber           = ("$"[0-9A-Fa-f]+|[0-9A-Fa-f]+"h")
BinaryNumber        = ("%"[0-1]+)
Number				= ({IntegerNumber} | {HexNumber} | {BinaryNumber})

Identifier			= (({LetterOrUnderscore}|{Digit})[^ \t\f\n\,\.\+\-\*\/\%\[\]]+)

UnclosedStringLiteral	= ([\"][^\"]*)
StringLiteral			= ({UnclosedStringLiteral}[\"])
UnclosedCharLiteral		= ([\'][^\']*)
CharLiteral			= ({UnclosedCharLiteral}[\'])

CommentBegin			= ([;])

LineTerminator			= (\n)
WhiteSpace			= ([ \t\f])

Label				= (({LetterOrUnderscore}|{Digit})+[\:])

Operator				= ("+"|"-"|"~"|".BITNOT"|".LOBYTE"|".HIBYTE"|"^"|".BANKBYTE"|"*"|"/"|".MOD"|"&"|
                           ".BITAND"|".BITXOR"|"<<"|".SHL"|">>"|".SHR"|"|"|".BITOR"|"="|"<>"|"<"|">"|"<="|">="|
                           "&&"|".AND"|".XOR"|"||"|".OR"|"!"|".NOT")

URLGenDelim				= ([:\/\?#\[\]@])
URLSubDelim				= ([\!\$&'\(\)\*\+,;=])
URLUnreserved			= ({LetterOrUnderscore}|{Digit}|[\-\.\~])
URLCharacter			= ({URLGenDelim}|{URLSubDelim}|{URLUnreserved}|[%])
URLCharacters			= ({URLCharacter}*)
URLEndCharacter			= ([\/\$]|{Letter}|{Digit})
URL						= (((https?|f(tp|ile))"://"|"www.")({URLCharacters}{URLEndCharacter})?)


%state EOL_COMMENT

%%

<YYINITIAL> {

	/* Keywords */
	"ADC" |
    "AND" |
    "ASL" |
    "BCC" |
    "BCS" |
    "BEQ" |
    "BIT" |
    "BMI" |
    "BNE" |
    "BPL" |
    "BRK" |
    "BVC" |
    "BVS" |
    "CLC" |
    "CLD" |
    "CLI" |
    "CLV" |
    "CMP" |
    "CPX" |
    "CPY" |
    "DEC" |
    "DEX" |
    "DEY" |
    "EOR" |
    "INC" |
    "INX" |
    "INY" |
    "JMP" |
    "JSR" |
    "LDA" |
    "LDX" |
    "LDY" |
    "LSR" |
    "NOP" |
    "ORA" |
    "PHA" |
    "PHP" |
    "PLA" |
    "PLP" |
    "ROL" |
    "ROR" |
    "RTI" |
    "RTS" |
    "SBC" |
    "SEC" |
    "SED" |
    "SEI" |
    "STA" |
    "STX" |
    "STY" |
    "TAX" |
    "TAY" |
    "TSX" |
    "TXA" |
    "TXS" |
    "TYA"       { addToken(Token.FUNCTION); }

	"DB" |
	"DW" |
	"DD" |
	"DF" |
	"DQ" |
	"DT" |
	"RESB" |
	"RESW" |
	"RESD" |
	"RESQ" |
	"REST" |
	"EQU" |
	"TEXTEQU" |
	"TIMES" |
	"DUP"		{ addToken(Token.FUNCTION); }

    /* 6502 illegal instructions */
    "LR" |
    "ANC" |
    "ARR" |
    "AXS" |
    "DCP" |
    "ISC" |
    "LAS" |
    "LAX" |
    "RLA" |
    "RRA" |
    "SAX" |
    "SLO" |
    "SRE"		{ addToken(Token.FUNCTION); }

    "@"{LetterOrUnderscore}+ |
    ("#"([^ \t]+ | {StringLiteral} | {UnclosedStringLiteral})) { addToken(Token.PREPROCESSOR); }

	{LineTerminator}				{ addNullToken(); return firstToken; }

	{WhiteSpace}+					{ addToken(Token.WHITESPACE); }

	/* String/Character Literals. */
	{CharLiteral}					{ addToken(Token.LITERAL_CHAR); }
	{UnclosedCharLiteral}			{ addToken(Token.ERROR_CHAR); /*addNullToken(); return firstToken;*/ }
	{StringLiteral}				{ addToken(Token.LITERAL_STRING_DOUBLE_QUOTE); }
	{UnclosedStringLiteral}			{ addToken(Token.ERROR_STRING_DOUBLE); addNullToken(); return firstToken; }

	/* Labels. */
	{Label}						{ addToken(Token.PREPROCESSOR); }

	^%{LetterOrUnderscore}({LetterOrUnderscore}|{Digit})*	{ addToken(Token.FUNCTION); }

	/* Comment Literals. */
	{CommentBegin}			    { start = zzMarkedPos-1; yybegin(EOL_COMMENT); }

	/* Operators. */
	{Operator}					{ addToken(Token.OPERATOR); }

    /* After "Operators" because of their overlap */
    "."{Identifier}  { addToken(Token.VARIABLE); }

	/* Numbers */
	{Number}						{ addToken(Token.LITERAL_NUMBER_DECIMAL_INT); }

	/* Ended with a line not in a string or comment. */
	<<EOF>>						{ addNullToken(); return firstToken; }

	/* Catch any other (unhandled) characters. */
	{Identifier}					{ addToken(Token.IDENTIFIER); }
	.							{ addToken(Token.IDENTIFIER); }

}


<EOL_COMMENT> {
	[^hwf\n]+				{}
	{URL}					{ int temp=zzStartRead; addToken(start,zzStartRead-1, Token.COMMENT_EOL); addHyperlinkToken(temp,zzMarkedPos-1, Token.COMMENT_EOL); start = zzMarkedPos; }
	[hwf]					{}
	\n						{ addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken; }
	<<EOF>>					{ addToken(start,zzStartRead-1, Token.COMMENT_EOL); addNullToken(); return firstToken; }

}
