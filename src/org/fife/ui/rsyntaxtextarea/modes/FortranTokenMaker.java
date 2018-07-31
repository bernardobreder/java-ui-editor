/* The following code was generated by JFlex 1.4.1 on 10/16/06 10:31 AM */

/*
 * 03/23/2005 FortranTokenMaker.java - Scanner for the Fortran programming language. This library is
 * distributed under a modified BSD license. See the included RSyntaxTextArea.License.txt file for
 * details.
 */
package org.fife.ui.rsyntaxtextarea.modes;

import java.io.IOException;

import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.AbstractJFlexTokenMaker;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenImpl;

/**
 * Scanner for the Fortran programming language. This implementation was created using <a
 * href="http://www.jflex.de/">JFlex</a> 1.4.1; however, the generated file was modified for
 * performance. Memory allocation needs to be almost completely removed to be competitive with the
 * handwritten lexers (subclasses of <code>AbstractTokenMaker</code>, so this class has been
 * modified so that Strings are never allocated (via yytext()), and the scanner never has to worry
 * about refilling its buffer (needlessly copying chars around). We can achieve this because RText
 * always scans exactly 1 line of tokens at a time, and hands the scanner this line as an array of
 * characters (a Segment really). Since tokens contain pointers to char arrays instead of Strings
 * holding their contents, there is no need for allocating new memory for Strings.
 * <p>
 * The actual algorithm generated for scanning has, of course, not been modified.
 * <p>
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 * <li>The generated FortranTokenMaker.java</code> file will contain two definitions of both
 * <code>zzRefill</code> and <code>yyreset</code>. You should hand-delete the second of each
 * definition (the ones generated by the lexer), as these generated methods modify the input buffer,
 * which we'll never have to do.</li>
 * <li>You should also change the declaration/definition of zzBuffer to NOT be initialized. This is
 * a needless memory allocation for us since we will be pointing the array somewhere else anyway.</li>
 * <li>You should NOT call <code>yylex()</code> on the generated scanner directly; rather, you
 * should use <code>getTokenList</code> as you would with any other <code>TokenMaker</code>
 * instance.</li>
 * </ul>
 *
 * @author Robert Futrell
 * @version 0.4
 */

public class FortranTokenMaker extends AbstractJFlexTokenMaker {
	
	/** This character denotes the end of file */
	public static final int YYEOF = -1;
	
	/** lexical states */
	public static final int STRING = 1;
	
	public static final int YYINITIAL = 0;
	
	public static final int CHAR = 2;
	
	/**
	 * Translates characters to character classes
	 */
	private static final String ZZ_CMAP_PACKED = "\11\0\1\2\1\1\1\0\1\2\23\0\1\2\1\5\1\10\1\0" + "\1\6\1\0\1\14\1\11\2\0\1\3\3\0\1\16\1\15\1\45" + "\1\50\1\51\7\6\2\0\1\12\1\13\1\12\2\0\1\25\1\37" + "\1\7\1\4\1\22\1\31\1\21\1\41\1\33\1\46\1\42\1\17" + "\1\36\1\24\1\26\1\35\1\23\1\27\1\32\1\20\1\30\1\6" + "\1\44\1\40\1\43\1\47\4\0\1\6\1\0\1\25\1\37\1\34" + "\1\4\1\22\1\31\1\21\1\41\1\33\1\46\1\42\1\17\1\36" + "\1\24\1\26\1\35\1\23\1\27\1\32\1\20\1\30\1\6\1\44" + "\1\40\1\43\1\47\uff85\0";
	
	/**
	 * Translates characters to character classes
	 */
	private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
	
	/**
	 * Translates DFA states to action switch labels.
	 */
	private static final int[] ZZ_ACTION = zzUnpackAction();
	
	private static final String ZZ_ACTION_PACKED_0 = "\1\0\2\1\1\2\1\3\1\4\1\5\1\6\1\7" + "\1\2\1\5\1\10\1\11\1\12\1\2\1\12\24\2" + "\1\1\1\13\1\14\1\1\1\15\1\16\7\2\1\17" + "\20\2\7\0\41\2\1\17\27\2\1\17\10\2\1\17" + "\3\2\4\0\2\17\3\2\2\17\20\2\1\17\10\2" + "\2\17\3\2\1\17\2\2\1\17\6\2\1\17\2\0" + "\3\2\1\17\4\2\1\17\26\2\1\0\20\2\1\20" + "\12\2\1\17";
	
	private static int[] zzUnpackAction() {
		int[] result = new int[257];
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
			do {
				result[j++] = value;
			} while (--count > 0);
		}
		return j;
	}
	
	/**
	 * Translates a state to a row index in the transition table
	 */
	private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
	
	private static final String ZZ_ROWMAP_PACKED_0 = "\0\0\0\52\0\124\0\176\0\176\0\250\0\176\0\322" + "\0\176\0\374\0\u0126\0\176\0\176\0\u0150\0\u0150\0\176" + "\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\u0222\0\u024c\0\u0276\0\u02a0" + "\0\u02ca\0\u02f4\0\u031e\0\u0348\0\u0372\0\u0126\0\u039c\0\u03c6" + "\0\u03f0\0\u041a\0\u0444\0\u046e\0\u0498\0\176\0\176\0\u04c2" + "\0\176\0\176\0\u04ec\0\u0516\0\u0540\0\u056a\0\u0594\0\u05be" + "\0\u05e8\0\u0612\0\u063c\0\u0666\0\u0690\0\u06ba\0\u06e4\0\u070e" + "\0\u0738\0\u0762\0\u078c\0\u07b6\0\u07e0\0\u080a\0\u0834\0\u085e" + "\0\u0888\0\u08b2\0\u08dc\0\u0906\0\u0930\0\u095a\0\u0984\0\u09ae" + "\0\u09d8\0\u0a02\0\u0a2c\0\u0a56\0\u0a80\0\u0aaa\0\u0ad4\0\u0afe" + "\0\u0b28\0\u0b52\0\u0b7c\0\u0ba6\0\u0bd0\0\u0bfa\0\u0c24\0\u0c4e" + "\0\u0c78\0\u0ca2\0\u0ccc\0\u0cf6\0\u0d20\0\u0d4a\0\u0d74\0\u0d9e" + "\0\u0dc8\0\u0df2\0\u0e1c\0\u0e46\0\u0e70\0\u0e9a\0\u0ec4\0\u0eee" + "\0\u0f18\0\u0f42\0\u0f6c\0\u0f96\0\u0fc0\0\u0fea\0\u1014\0\u103e" + "\0\u1068\0\u1092\0\u10bc\0\u10e6\0\u1110\0\u113a\0\u1164\0\u118e" + "\0\u11b8\0\u11e2\0\u120c\0\u1236\0\u1260\0\u128a\0\u12b4\0\u12de" + "\0\u1308\0\u1332\0\u135c\0\u1386\0\u13b0\0\u13da\0\u1404\0\u142e" + "\0\u1458\0\u1482\0\u14ac\0\u14d6\0\u1500\0\u152a\0\u1554\0\u157e" + "\0\u15a8\0\u15d2\0\u15fc\0\374\0\u1626\0\u1650\0\u167a\0\u16a4" + "\0\u16ce\0\u16f8\0\u1722\0\u174c\0\u1776\0\u17a0\0\u17ca\0\u17f4" + "\0\u181e\0\u1848\0\u1872\0\u189c\0\u18c6\0\u18f0\0\u191a\0\u1944" + "\0\u196e\0\u1998\0\u19c2\0\u19ec\0\u1a16\0\u1a40\0\u1a6a\0\u16f8" + "\0\u1a94\0\u1abe\0\u1ae8\0\u1b12\0\u1b3c\0\u1b66\0\u1b90\0\u1bba" + "\0\u1be4\0\u1c0e\0\u1c38\0\u174c\0\u1c62\0\u1c8c\0\u1cb6\0\u1ce0" + "\0\u1d0a\0\u1d34\0\u1d5e\0\u1d88\0\u1db2\0\u1ddc\0\u1e06\0\u1e30" + "\0\u1e5a\0\u1e84\0\u1eae\0\u1ed8\0\u1f02\0\u1f2c\0\u1b12\0\u1f56" + "\0\u1f80\0\u1faa\0\u1fd4\0\u1ffe\0\u2028\0\u2052\0\u207c\0\u20a6" + "\0\u20d0\0\u20fa\0\u2124\0\u214e\0\u2178\0\u21a2\0\u21cc\0\u21f6" + "\0\u2220\0\u224a\0\u2274\0\u229e\0\u22c8\0\u22f2\0\u231c\0\u2346" + "\0\u2370\0\u239a\0\u23c4\0\u23ee\0\u2418\0\u2442\0\u246c\0\u2496" + "\0\u24c0\0\u24ea\0\u2514\0\u253e\0\u2568\0\176\0\u2592\0\u25bc" + "\0\u25e6\0\u2610\0\u263a\0\u2664\0\u268e\0\u26b8\0\u26e2\0\u270c" + "\0\u13da";
	
	private static int[] zzUnpackRowMap() {
		int[] result = new int[257];
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
	
	private static final String ZZ_TRANS_PACKED_0 = "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13" + "\1\14\1\15\1\16\1\17\1\20\1\17\1\21\1\22" + "\1\23\1\24\1\25\1\12\1\26\1\27\1\30\1\31" + "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41" + "\2\12\1\42\1\12\1\43\2\12\1\44\2\12\1\45" + "\1\46\6\45\1\47\41\45\1\50\1\51\7\50\1\52" + "\40\50\54\0\1\6\53\0\1\53\1\0\1\12\1\54" + "\7\0\1\55\1\56\1\12\1\57\1\12\1\60\1\61" + "\1\62\1\63\1\12\1\64\1\65\1\66\1\54\1\67" + "\1\70\1\71\12\12\4\0\1\12\1\0\2\12\7\0" + "\33\12\4\0\1\12\1\0\1\12\1\72\7\0\1\73" + "\2\12\1\74\2\12\1\75\1\76\3\12\1\77\1\12" + "\1\72\1\12\1\100\2\12\1\101\1\12\1\102\6\12" + "\13\0\1\20\55\0\1\103\1\104\1\103\1\105\1\0" + "\1\106\1\107\1\110\2\0\1\111\24\0\1\12\1\0" + "\2\12\7\0\1\112\1\12\1\112\1\113\3\12\1\114" + "\23\12\4\0\1\12\1\0\2\12\7\0\6\12\1\115" + "\1\12\1\116\11\12\1\117\10\12\4\0\1\12\1\0" + "\2\12\7\0\7\12\1\120\23\12\4\0\1\12\1\0" + "\2\12\7\0\1\121\4\12\1\122\13\12\1\123\11\12" + "\4\0\1\12\1\0\2\12\7\0\7\12\1\124\4\12" + "\1\125\16\12\4\0\1\12\1\0\1\12\1\72\7\0" + "\1\126\1\127\3\12\1\60\5\12\1\130\1\131\1\72" + "\1\12\1\132\1\133\12\12\4\0\1\12\1\0\2\12" + "\7\0\16\12\1\117\14\12\4\0\1\12\1\0\2\12" + "\7\0\3\12\1\134\27\12\4\0\1\12\1\0\2\12" + "\7\0\13\12\1\135\17\12\4\0\1\12\1\0\2\12" + "\7\0\1\136\6\12\1\137\1\12\1\140\21\12\4\0" + "\1\12\1\0\2\12\7\0\1\12\1\141\1\12\1\142" + "\1\143\1\144\3\12\1\145\2\12\1\146\16\12\4\0" + "\1\147\1\0\1\12\1\150\7\0\5\12\1\151\1\152" + "\3\12\1\153\1\154\1\12\1\150\1\12\1\155\13\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\156\1\12" + "\1\157\22\12\4\0\1\12\1\0\2\12\7\0\6\12" + "\1\160\1\161\4\12\1\162\16\12\4\0\1\12\1\0" + "\2\12\7\0\6\12\1\163\24\12\4\0\1\12\1\0" + "\2\12\7\0\14\12\1\164\16\12\4\0\1\12\1\0" + "\2\12\7\0\10\12\1\165\11\12\1\166\10\12\4\0" + "\1\12\1\0\2\12\7\0\3\12\1\167\27\12\1\45" + "\1\0\6\45\1\0\41\45\1\50\1\0\7\50\1\0" + "\40\50\4\0\1\12\1\0\2\12\7\0\14\12\1\170" + "\16\12\4\0\1\12\1\0\2\12\7\0\7\12\1\171" + "\7\12\1\100\13\12\4\0\1\12\1\0\2\12\7\0" + "\7\12\1\172\23\12\4\0\1\12\1\0\2\12\7\0" + "\6\12\1\115\24\12\4\0\1\12\1\0\2\12\7\0" + "\6\12\1\173\3\12\1\174\6\12\1\175\11\12\4\0" + "\1\12\1\0\2\12\7\0\14\12\1\125\16\12\4\0" + "\1\12\1\0\1\12\1\72\7\0\1\12\1\176\11\12" + "\1\130\1\12\1\72\2\12\1\133\12\12\4\0\1\12" + "\1\0\2\12\7\0\11\12\1\177\21\12\4\0\1\12" + "\1\0\2\12\7\0\3\12\1\200\27\12\4\0\1\12" + "\1\0\2\12\7\0\1\201\32\12\4\0\1\12\1\0" + "\2\12\7\0\4\12\1\143\7\12\1\146\16\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\202\11\12\1\203" + "\13\12\4\0\1\12\1\0\2\12\7\0\10\12\1\204" + "\22\12\4\0\1\12\1\0\2\12\7\0\6\12\1\205" + "\1\206\4\12\1\207\16\12\4\0\1\12\1\0\2\12" + "\7\0\1\135\32\12\4\0\1\12\1\0\2\12\7\0" + "\7\12\1\133\23\12\4\0\1\12\1\0\2\12\7\0" + "\7\12\1\210\23\12\4\0\1\12\1\0\2\12\7\0" + "\14\12\1\211\16\12\4\0\1\12\1\0\2\12\7\0" + "\1\212\12\12\1\135\4\12\1\133\12\12\4\0\1\12" + "\1\0\2\12\7\0\5\12\1\213\5\12\1\214\3\12" + "\1\215\13\12\4\0\1\12\1\0\2\12\7\0\4\12" + "\1\143\7\12\1\113\16\12\4\0\1\12\1\0\2\12" + "\7\0\16\12\1\216\14\12\4\0\1\12\1\0\2\12" + "\7\0\6\12\1\217\24\12\4\0\1\12\1\0\1\12" + "\1\71\7\0\15\12\1\71\15\12\20\0\1\220\1\0" + "\1\220\56\0\1\221\45\0\1\220\50\0\1\220\53\0" + "\1\222\54\0\1\220\47\0\1\223\30\0\1\12\1\0" + "\2\12\7\0\1\12\1\224\1\12\1\224\27\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\224\25\12\4\0" + "\1\12\1\0\2\12\7\0\2\12\1\225\30\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\214\25\12\4\0" + "\1\12\1\0\2\12\7\0\6\12\1\226\24\12\4\0" + "\1\12\1\0\2\12\7\0\3\12\1\113\27\12\4\0" + "\1\12\1\0\2\12\7\0\1\12\1\227\31\12\4\0" + "\1\12\1\0\2\12\7\0\13\12\1\230\17\12\4\0" + "\1\231\1\0\2\12\7\0\33\12\4\0\1\12\1\0" + "\2\12\7\0\14\12\1\202\1\12\1\232\14\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\135\25\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\202\25\12\4\0" + "\1\12\1\0\2\12\7\0\1\233\6\12\1\172\23\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\234\24\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\113\16\12" + "\4\0\1\12\1\0\2\12\7\0\5\12\1\202\11\12" + "\1\235\13\12\4\0\1\12\1\0\2\12\7\0\6\12" + "\1\236\1\206\4\12\1\237\16\12\4\0\1\12\1\0" + "\2\12\7\0\13\12\1\224\17\12\4\0\1\12\1\0" + "\2\12\7\0\1\12\1\240\4\12\1\241\16\12\1\42" + "\5\12\4\0\1\12\1\0\2\12\7\0\3\12\1\224" + "\27\12\4\0\1\12\1\0\2\12\7\0\7\12\1\242" + "\23\12\4\0\1\12\1\0\2\12\7\0\10\12\1\243" + "\22\12\4\0\1\12\1\0\2\12\7\0\5\12\1\244" + "\25\12\4\0\1\12\1\0\2\12\7\0\7\12\1\175" + "\23\12\4\0\1\12\1\0\2\12\7\0\1\245\32\12" + "\4\0\1\12\1\0\2\12\7\0\10\12\1\202\22\12" + "\4\0\1\12\1\0\2\12\7\0\2\12\1\212\30\12" + "\4\0\1\12\1\0\2\12\7\0\20\12\1\246\12\12" + "\4\0\1\12\1\0\2\12\7\0\2\12\1\113\2\12" + "\1\214\25\12\4\0\1\12\1\0\2\12\7\0\5\12" + "\1\60\6\12\1\247\16\12\4\0\1\12\1\0\2\12" + "\7\0\22\12\1\250\10\12\4\0\1\251\1\0\1\12" + "\1\252\7\0\1\12\1\253\2\12\1\254\10\12\1\252" + "\15\12\4\0\1\12\1\0\2\12\7\0\20\12\1\133" + "\12\12\4\0\1\12\1\0\2\12\7\0\14\12\1\255" + "\16\12\4\0\1\12\1\0\2\12\7\0\14\12\1\256" + "\16\12\4\0\1\12\1\0\2\12\7\0\6\12\1\257" + "\7\12\1\260\14\12\4\0\1\12\1\0\2\12\7\0" + "\10\12\1\261\1\32\21\12\4\0\1\12\1\0\2\12" + "\7\0\3\12\1\262\3\12\1\263\4\12\1\125\16\12" + "\4\0\1\12\1\0\2\12\7\0\21\12\1\264\11\12" + "\4\0\1\265\1\0\2\12\7\0\33\12\4\0\1\12" + "\1\0\2\12\7\0\5\12\1\264\25\12\4\0\1\12" + "\1\0\1\12\1\266\7\0\15\12\1\266\15\12\4\0" + "\1\12\1\0\2\12\7\0\5\12\1\206\25\12\4\0" + "\1\12\1\0\2\12\7\0\14\12\1\267\16\12\4\0" + "\1\12\1\0\2\12\7\0\3\12\1\270\10\12\1\71" + "\16\12\4\0\1\12\1\0\2\12\7\0\21\12\1\202" + "\11\12\4\0\1\12\1\0\2\12\7\0\17\12\1\224" + "\13\12\4\0\1\12\1\0\2\12\7\0\13\12\1\214" + "\17\12\4\0\1\12\1\0\2\12\7\0\2\12\1\271" + "\30\12\4\0\1\12\1\0\2\12\7\0\1\272\32\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\273\24\12" + "\4\0\1\12\1\0\2\12\7\0\16\12\1\224\14\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\274\24\12" + "\4\0\1\12\1\0\2\12\7\0\20\12\1\71\12\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\212\24\12" + "\4\0\1\12\1\0\2\12\7\0\7\12\1\275\23\12" + "\4\0\1\12\1\0\2\12\7\0\1\12\1\224\31\12" + "\4\0\1\12\1\0\2\12\7\0\3\12\1\276\27\12" + "\4\0\1\12\1\0\2\12\7\0\7\12\1\206\23\12" + "\4\0\1\12\1\0\2\12\7\0\21\12\1\277\11\12" + "\4\0\1\224\1\0\2\12\7\0\33\12\4\0\1\12" + "\1\0\2\12\7\0\5\12\1\277\25\12\4\0\1\12" + "\1\0\2\12\7\0\2\12\1\224\10\12\1\135\17\12" + "\4\0\1\12\1\0\2\12\7\0\1\300\32\12\4\0" + "\1\12\1\0\2\12\7\0\1\224\32\12\4\0\1\12" + "\1\0\2\12\7\0\1\12\1\301\25\12\1\257\3\12" + "\4\0\1\12\1\0\2\12\7\0\22\12\1\224\10\12" + "\4\0\1\12\1\0\2\12\7\0\16\12\1\302\14\12" + "\4\0\1\12\1\0\2\12\7\0\1\255\32\12\4\0" + "\1\12\1\0\2\12\7\0\10\12\1\303\22\12\16\0" + "\1\20\63\0\1\304\25\0\1\220\64\0\1\305\36\0" + "\1\12\1\0\2\12\7\0\14\12\1\306\14\12\1\307" + "\1\12\4\0\1\12\1\0\2\12\7\0\5\12\1\310" + "\25\12\4\0\1\12\1\0\2\12\7\0\7\12\1\224" + "\23\12\4\0\1\12\1\0\2\12\7\0\3\12\1\311" + "\27\12\4\0\1\227\1\0\2\12\7\0\12\12\1\312" + "\1\12\1\313\16\12\4\0\1\12\1\0\2\12\7\0" + "\1\314\32\12\4\0\1\12\1\0\2\12\7\0\7\12" + "\1\315\23\12\4\0\1\12\1\0\2\12\7\0\5\12" + "\1\316\25\12\4\0\1\12\1\0\2\12\7\0\6\12" + "\1\257\24\12\4\0\1\12\1\0\2\12\7\0\21\12" + "\1\317\11\12\4\0\1\12\1\0\2\12\7\0\5\12" + "\1\317\25\12\4\0\1\12\1\0\2\12\7\0\11\12" + "\1\320\21\12\4\0\1\224\1\0\2\12\7\0\1\224" + "\32\12\4\0\1\12\1\0\2\12\7\0\6\12\1\202" + "\1\321\23\12\4\0\1\12\1\0\2\12\7\0\6\12" + "\1\322\10\12\1\275\13\12\4\0\1\12\1\0\1\12" + "\1\323\7\0\15\12\1\323\15\12\4\0\1\12\1\0" + "\2\12\7\0\3\12\1\324\27\12\4\0\1\12\1\0" + "\2\12\7\0\10\12\1\325\22\12\4\0\1\12\1\0" + "\2\12\7\0\5\12\1\202\11\12\1\224\13\12\4\0" + "\1\12\1\0\2\12\7\0\6\12\1\321\24\12\4\0" + "\1\12\1\0\2\12\7\0\3\12\1\255\27\12\4\0" + "\1\12\1\0\2\12\7\0\1\326\32\12\4\0\1\12" + "\1\0\2\12\7\0\3\12\1\327\27\12\4\0\1\12" + "\1\0\2\12\7\0\11\12\1\330\21\12\4\0\1\12" + "\1\0\2\12\7\0\21\12\1\224\11\12\4\0\1\12" + "\1\0\2\12\7\0\2\12\1\113\30\12\4\0\1\12" + "\1\0\2\12\7\0\2\12\1\224\30\12\4\0\1\12" + "\1\0\2\12\7\0\6\12\1\331\24\12\4\0\1\12" + "\1\0\1\12\1\332\7\0\15\12\1\332\15\12\4\0" + "\1\12\1\0\2\12\7\0\2\12\1\333\30\12\4\0" + "\1\12\1\0\2\12\7\0\26\12\1\224\2\12\1\224" + "\1\12\4\0\1\12\1\0\2\12\7\0\11\12\1\334" + "\21\12\4\0\1\12\1\0\2\12\7\0\23\12\1\335" + "\7\12\4\0\1\12\1\0\2\12\7\0\1\12\1\135" + "\31\12\4\0\1\12\1\0\2\12\7\0\10\12\1\135" + "\22\12\4\0\1\12\1\0\2\12\7\0\31\12\1\307" + "\1\12\4\0\1\12\1\0\2\12\7\0\1\336\32\12" + "\4\0\1\12\1\0\2\12\7\0\11\12\1\337\21\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\202\24\12" + "\4\0\1\12\1\0\2\12\7\0\5\12\1\340\25\12" + "\4\0\1\12\1\0\2\12\7\0\31\12\1\224\1\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\341\16\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\342\5\12" + "\1\343\16\12\4\0\1\12\1\0\2\12\7\0\1\251" + "\32\12\4\0\1\12\1\0\2\12\7\0\6\12\1\344" + "\24\12\22\0\1\345\61\0\1\304\23\0\1\12\1\0" + "\1\12\1\200\7\0\15\12\1\200\15\12\4\0\1\12" + "\1\0\2\12\7\0\26\12\1\224\4\12\4\0\1\12" + "\1\0\2\12\7\0\13\12\1\346\17\12\4\0\1\12" + "\1\0\2\12\7\0\14\12\1\313\10\12\1\347\5\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\71\16\12" + "\4\0\1\12\1\0\2\12\7\0\12\12\1\224\20\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\350\16\12" + "\4\0\1\12\1\0\1\12\1\351\7\0\15\12\1\351" + "\15\12\4\0\1\12\1\0\2\12\7\0\32\12\1\224" + "\4\0\1\12\1\0\2\12\7\0\10\12\1\113\22\12" + "\4\0\1\12\1\0\2\12\7\0\10\12\1\224\22\12" + "\4\0\1\12\1\0\2\12\7\0\1\212\32\12\4\0" + "\1\12\1\0\2\12\7\0\1\12\1\352\31\12\4\0" + "\1\12\1\0\1\12\1\202\7\0\15\12\1\202\15\12" + "\4\0\1\12\1\0\2\12\7\0\7\12\1\353\23\12" + "\4\0\1\12\1\0\2\12\7\0\11\12\1\354\21\12" + "\4\0\1\12\1\0\2\12\7\0\2\12\1\355\30\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\270\16\12" + "\4\0\1\12\1\0\2\12\7\0\17\12\1\356\13\12" + "\4\0\1\12\1\0\2\12\7\0\14\12\1\340\16\12" + "\4\0\1\12\1\0\2\12\7\0\10\12\1\357\22\12" + "\4\0\1\12\1\0\2\12\7\0\1\360\32\12\4\0" + "\1\12\1\0\2\12\7\0\13\12\1\361\17\12\4\0" + "\1\12\1\0\2\12\7\0\7\12\1\362\23\12\4\0" + "\1\12\1\0\2\12\7\0\1\202\32\12\4\0\1\12" + "\1\0\2\12\7\0\13\12\1\352\17\12\4\0\1\12" + "\1\0\2\12\7\0\5\12\1\257\25\12\4\0\1\12" + "\1\0\2\12\7\0\14\12\1\363\16\12\4\0\1\12" + "\1\0\2\12\7\0\5\12\1\364\25\12\4\0\1\12" + "\1\0\1\12\1\365\7\0\15\12\1\365\15\12\16\0" + "\1\366\37\0\1\12\1\0\2\12\7\0\12\12\1\355" + "\20\12\4\0\1\12\1\0\2\12\7\0\22\12\1\367" + "\10\12\4\0\1\12\1\0\1\12\1\370\7\0\15\12" + "\1\370\15\12\4\0\1\12\1\0\2\12\7\0\6\12" + "\1\371\24\12\4\0\1\12\1\0\2\12\7\0\14\12" + "\1\372\16\12\4\0\1\12\1\0\2\12\7\0\11\12" + "\1\373\21\12\4\0\1\135\1\0\2\12\7\0\33\12" + "\4\0\1\12\1\0\2\12\7\0\3\12\1\321\27\12" + "\4\0\1\12\1\0\2\12\7\0\3\12\1\365\27\12" + "\4\0\1\12\1\0\2\12\7\0\6\12\1\170\24\12" + "\4\0\1\12\1\0\2\12\7\0\3\12\1\224\3\12" + "\1\224\23\12\4\0\1\12\1\0\2\12\7\0\16\12" + "\1\374\14\12\4\0\1\12\1\0\1\12\1\375\7\0" + "\15\12\1\375\15\12\4\0\1\12\1\0\2\12\7\0" + "\5\12\1\133\25\12\4\0\1\12\1\0\2\12\7\0" + "\11\12\1\135\21\12\4\0\1\12\1\0\2\12\7\0" + "\1\12\1\355\31\12\4\0\1\12\1\0\2\12\7\0" + "\3\12\1\270\27\12\4\0\1\12\1\0\2\12\7\0" + "\14\12\1\202\16\12\4\0\1\12\1\0\2\12\7\0" + "\1\12\1\376\31\12\4\0\1\12\1\0\2\12\7\0" + "\7\12\1\113\23\12\4\0\1\12\1\0\2\12\7\0" + "\1\12\1\377\31\12\4\0\1\12\1\0\2\12\7\0" + "\6\12\1\u0100\24\12\4\0\1\12\1\0\2\12\7\0" + "\6\12\1\267\24\12\4\0\1\12\1\0\2\12\7\0" + "\3\12\1\u0101\2\12\1\177\24\12\4\0\1\12\1\0" + "\2\12\7\0\14\12\1\124\16\12\4\0\1\12\1\0" + "\1\12\1\135\7\0\15\12\1\135\15\12";
	
	private static int[] zzUnpackTrans() {
		int[] result = new int[10038];
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
			do {
				result[j++] = value;
			} while (--count > 0);
		}
		return j;
	}
	
	/* error codes */
	private static final int ZZ_UNKNOWN_ERROR = 0;
	
	private static final int ZZ_NO_MATCH = 1;
	
	private static final int ZZ_PUSHBACK_2BIG = 2;
	
	/* error messages for the codes above */
	private static final String ZZ_ERROR_MSG[] = { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
	
	/**
	 * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
	 */
	private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
	
	private static final String ZZ_ATTRIBUTE_PACKED_0 = "\1\0\2\1\2\11\1\1\1\11\1\1\1\11\2\1" + "\2\11\2\1\1\11\25\1\2\11\1\1\2\11\30\1" + "\7\0\106\1\4\0\60\1\2\0\37\1\1\0\20\1" + "\1\11\13\1";
	
	private static int[] zzUnpackAttribute() {
		int[] result = new int[257];
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
			do {
				result[j++] = value;
			} while (--count > 0);
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
	 * this buffer contains the current text to be matched and is the source of the yytext() string
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
	 * Constructor. We must have this here as there is no default, no-parameter constructor
	 * generated by JFlex.
	 */
	public FortranTokenMaker() {
		super();
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
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
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
		return new String[] { "!", null };
	}
	
	/**
	 * Returns the first token in the linked list of tokens generated from <code>text</code>. This
	 * method must be implemented by subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing the syntax highlighted
	 *         text.
	 */
	@Override
	public Token getTokenList(Segment text, int initialTokenType, int startOffset) {
		
		resetTokenList();
		this.offsetShift = -text.offset + startOffset;
		
		// Start off in the proper state.
		int state = Token.NULL;
		switch (initialTokenType) {
		case Token.LITERAL_STRING_DOUBLE_QUOTE:
			state = STRING;
			start = text.offset;
			break;
		case Token.LITERAL_CHAR:
			state = CHAR;
			start = text.offset;
			break;
		default:
			state = Token.NULL;
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
	 * @return <code>true</code> if EOF was reached, otherwise <code>false</code>.
	 * @exception IOException if any I/O-Error occurs.
	 */
	private boolean zzRefill() throws java.io.IOException {
		return zzCurrentPos >= s.offset + s.count;
	}
	
	/**
	 * Resets the scanner to read from a new input stream. Does not close the old reader. All
	 * internal variables are reset, the old input stream <b>cannot</b> be reused (internal buffer
	 * is discarded and lost). Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader the new input stream
	 */
	public final void yyreset(java.io.Reader reader) throws java.io.IOException {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill no longer "refills" the
		 * buffer (since the way we do it, it's always "full" the first time through, since it
		 * points to the segment's array). So, we assign zzEndRead here.
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
	 * Creates a new scanner There is also a java.io.InputStream version of this constructor.
	 *
	 * @param in the java.io.Reader to read input from.
	 */
	public FortranTokenMaker(java.io.Reader in) {
		this.zzReader = in;
	}
	
	/**
	 * Creates a new scanner. There is also java.io.Reader version of this constructor.
	 *
	 * @param in the java.io.Inputstream to read input from.
	 */
	public FortranTokenMaker(java.io.InputStream in) {
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
		while (i < 168) {
			int count = packed.charAt(i++);
			char value = packed.charAt(i++);
			do {
				map[j++] = value;
			} while (--count > 0);
		}
		return map;
	}
	
	/**
	 * Closes the input stream.
	 */
	public final void yyclose() throws java.io.IOException {
		zzAtEOF = true; /* indicate end of file */
		zzEndRead = zzStartRead; /* invalidate buffer */
		
		if (zzReader != null) {
			zzReader.close();
		}
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
	 * Returns the character at position <tt>pos</tt> from the matched text. It is equivalent to
	 * yytext().charAt(pos), but faster
	 *
	 * @param pos the position of the character to fetch. A value from 0 to yylength()-1.
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
	 * Reports an error that occured while scanning. In a wellformed scanner (no or only correct
	 * usage of yypushback(int) and a match-all fallback rule) this method will only be called with
	 * things that "Can't Possibly Happen". If this method is called, something is seriously wrong
	 * (e.g. a JFlex bug producing a faulty scanner etc.). Usual syntax/scanner level error handling
	 * should be done in error fallback rules.
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
	 * Pushes the specified amount of characters back into the input stream. They will be read again
	 * by then next call of the scanning method
	 *
	 * @param number the number of characters to be read again. This number must not be greater than
	 *            yylength()!
	 */
	public void yypushback(int number) {
		if (number > yylength()) {
			zzScanError(ZZ_PUSHBACK_2BIG);
		}
		
		zzMarkedPos -= number;
	}
	
	/**
	 * Resumes scanning until the next regular expression is matched, the end of input is
	 * encountered or an I/O-Error occurs.
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
			
			zzForAction:
			{
				while (true) {
					
					if (zzCurrentPosL < zzEndReadL) {
						zzInput = zzBufferL[zzCurrentPosL++];
					} else if (zzAtEOF) {
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
					if (zzNext == -1) {
						break zzForAction;
					}
					zzState = zzNext;
					
					int zzAttributes = zzAttrL[zzState];
					if ((zzAttributes & 1) == 1) {
						zzAction = zzState;
						zzMarkedPosL = zzCurrentPosL;
						if ((zzAttributes & 8) == 8) {
							break zzForAction;
						}
					}
					
				}
			}
			
			// store back cached position
			zzMarkedPos = zzMarkedPosL;
			
			switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
			case 15: {
				addToken(Token.RESERVED_WORD);
			}
			case 17:
				break;
			case 2: {
				addToken(Token.IDENTIFIER);
			}
			case 18:
				break;
			case 4: {
				addToken(Token.WHITESPACE);
			}
			case 19:
				break;
			case 11: {
				addToken(start, zzStartRead - 1, Token.LITERAL_STRING_DOUBLE_QUOTE);
				return firstToken;
			}
			case 20:
				break;
			case 13: {
				addToken(start, zzStartRead - 1, Token.LITERAL_CHAR);
				return firstToken;
			}
			case 21:
				break;
			case 10: {
				addToken(Token.OPERATOR);
			}
			case 22:
				break;
			case 5: { // Since we change zzStartRead, we have the unfortunate
				// side-effect of not being able to use the '^' operator.
				// So we must check whether we're really at the beginning
				// of the line ourselves...
				if (zzStartRead == s.offset) {
					addToken(zzStartRead, zzEndRead, Token.COMMENT_EOL);
					addNullToken();
					return firstToken;
				} else {
					addToken(Token.IDENTIFIER);
				}
			}
			case 23:
				break;
			case 16: {
				addToken(Token.LITERAL_BOOLEAN);
			}
			case 24:
				break;
			case 8: {
				start = zzMarkedPos - 1;
				yybegin(STRING);
			}
			case 25:
				break;
			case 7: {
				addToken(zzStartRead, zzEndRead, Token.COMMENT_EOL);
				addNullToken();
				return firstToken;
			}
			case 26:
				break;
			case 6: { // Since we change zzStartRead, we have the unfortunate
				// side-effect of not being able to use the '^' operator.
				// So we must check whether we're really at the beginning
				// of the line ourselves...
				if (zzStartRead == s.offset) {
					addToken(zzStartRead, zzEndRead, Token.COMMENT_DOCUMENTATION);
					addNullToken();
					return firstToken;
				} else {
					addToken(Token.IDENTIFIER);
				}
			}
			case 27:
				break;
			case 9: {
				start = zzMarkedPos - 1;
				yybegin(CHAR);
			}
			case 28:
				break;
			case 14: {
				yybegin(YYINITIAL);
				addToken(start, zzStartRead, Token.LITERAL_CHAR);
			}
			case 29:
				break;
			case 12: {
				yybegin(YYINITIAL);
				addToken(start, zzStartRead, Token.LITERAL_STRING_DOUBLE_QUOTE);
			}
			case 30:
				break;
			case 3: {
				addNullToken();
				return firstToken;
			}
			case 31:
				break;
			case 1: {
			}
			case 32:
				break;
			default:
				if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
					zzAtEOF = true;
					switch (zzLexicalState) {
					case STRING: {
						addToken(start, zzStartRead - 1, Token.LITERAL_STRING_DOUBLE_QUOTE);
						return firstToken;
					}
					case 258:
						break;
					case YYINITIAL: {
						addNullToken();
						return firstToken;
					}
					case 259:
						break;
					case CHAR: {
						addToken(start, zzStartRead - 1, Token.LITERAL_CHAR);
						return firstToken;
					}
					case 260:
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
