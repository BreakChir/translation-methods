// Generated from ru\breakchir\Code.g4 by ANTLR 4.7.1

    package ru.breakchir;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, MOD=5, POW=6, AND=7, OR=8, XOR=9, NOT=10, 
		LT=11, GT=12, LTEQ=13, GTEQ=14, EQ=15, NQ=16, ASGN=17, IF=18, ELSE=19, 
		TRUE=20, FALSE=21, PRINT=22, OPEN=23, CLOSE=24, BEGIN=25, END=26, NUM=27, 
		VAR=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ADD", "SUB", "MUL", "DIV", "MOD", "POW", "AND", "OR", "XOR", "NOT", "LT", 
		"GT", "LTEQ", "GTEQ", "EQ", "NQ", "ASGN", "IF", "ELSE", "TRUE", "FALSE", 
		"PRINT", "OPEN", "CLOSE", "BEGIN", "END", "NUM", "VAR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'&&'", "'||'", "'^'", 
		"'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'='", "'if'", "'else'", 
		"'true'", "'false'", "'print'", "'('", "')'", "'begin'", "'end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "AND", "OR", "XOR", "NOT", 
		"LT", "GT", "LTEQ", "GTEQ", "EQ", "NQ", "ASGN", "IF", "ELSE", "TRUE", 
		"FALSE", "PRINT", "OPEN", "CLOSE", "BEGIN", "END", "NUM", "VAR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Code.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\5\34\u008f\n\34\3\34\3\34\7\34\u0093\n\34\f\34\16\34\u0096"+
		"\13\34\3\34\5\34\u0099\n\34\3\35\3\35\7\35\u009d\n\35\f\35\16\35\u00a0"+
		"\13\35\3\36\3\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37\3\2\5\4\2C\\c|\5\2\62;C\\c|\5\2\13\f"+
		"\17\17\"\"\2\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13"+
		"E\3\2\2\2\rG\3\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27"+
		"T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35[\3\2\2\2\37^\3\2\2\2!a\3\2\2\2#d"+
		"\3\2\2\2%f\3\2\2\2\'i\3\2\2\2)n\3\2\2\2+s\3\2\2\2-y\3\2\2\2/\177\3\2\2"+
		"\2\61\u0081\3\2\2\2\63\u0083\3\2\2\2\65\u0089\3\2\2\2\67\u0098\3\2\2\2"+
		"9\u009a\3\2\2\2;\u00a1\3\2\2\2=>\7-\2\2>\4\3\2\2\2?@\7/\2\2@\6\3\2\2\2"+
		"AB\7,\2\2B\b\3\2\2\2CD\7\61\2\2D\n\3\2\2\2EF\7\'\2\2F\f\3\2\2\2GH\7,\2"+
		"\2HI\7,\2\2I\16\3\2\2\2JK\7(\2\2KL\7(\2\2L\20\3\2\2\2MN\7~\2\2NO\7~\2"+
		"\2O\22\3\2\2\2PQ\7`\2\2Q\24\3\2\2\2RS\7#\2\2S\26\3\2\2\2TU\7>\2\2U\30"+
		"\3\2\2\2VW\7@\2\2W\32\3\2\2\2XY\7>\2\2YZ\7?\2\2Z\34\3\2\2\2[\\\7@\2\2"+
		"\\]\7?\2\2]\36\3\2\2\2^_\7?\2\2_`\7?\2\2` \3\2\2\2ab\7#\2\2bc\7?\2\2c"+
		"\"\3\2\2\2de\7?\2\2e$\3\2\2\2fg\7k\2\2gh\7h\2\2h&\3\2\2\2ij\7g\2\2jk\7"+
		"n\2\2kl\7u\2\2lm\7g\2\2m(\3\2\2\2no\7v\2\2op\7t\2\2pq\7w\2\2qr\7g\2\2"+
		"r*\3\2\2\2st\7h\2\2tu\7c\2\2uv\7n\2\2vw\7u\2\2wx\7g\2\2x,\3\2\2\2yz\7"+
		"r\2\2z{\7t\2\2{|\7k\2\2|}\7p\2\2}~\7v\2\2~.\3\2\2\2\177\u0080\7*\2\2\u0080"+
		"\60\3\2\2\2\u0081\u0082\7+\2\2\u0082\62\3\2\2\2\u0083\u0084\7d\2\2\u0084"+
		"\u0085\7g\2\2\u0085\u0086\7i\2\2\u0086\u0087\7k\2\2\u0087\u0088\7p\2\2"+
		"\u0088\64\3\2\2\2\u0089\u008a\7g\2\2\u008a\u008b\7p\2\2\u008b\u008c\7"+
		"f\2\2\u008c\66\3\2\2\2\u008d\u008f\7/\2\2\u008e\u008d\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0094\4\63;\2\u0091\u0093\4\62;\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0099\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\7\62\2\2\u0098"+
		"\u008e\3\2\2\2\u0098\u0097\3\2\2\2\u00998\3\2\2\2\u009a\u009e\t\2\2\2"+
		"\u009b\u009d\t\3\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f:\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\t\4\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\b\36\2\2\u00a4<\3\2\2\2"+
		"\7\2\u008e\u0094\u0098\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}