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
		LT=11, GT=12, LTEQ=13, GTEQ=14, EQ=15, NQ=16, ASGN=17, IF=18, TRUE=19, 
		FALSE=20, PRINT=21, BEGIN=22, END=23, NUM=24, VAR=25, WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ADD", "SUB", "MUL", "DIV", "MOD", "POW", "AND", "OR", "XOR", "NOT", "LT", 
		"GT", "LTEQ", "GTEQ", "EQ", "NQ", "ASGN", "IF", "TRUE", "FALSE", "PRINT", 
		"BEGIN", "END", "NUM", "VAR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'&&'", "'||'", "'^'", 
		"'!'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'='", "'if'", "'true'", 
		"'false'", "'print'", "'begin'", "'end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "AND", "OR", "XOR", "NOT", 
		"LT", "GT", "LTEQ", "GTEQ", "EQ", "NQ", "ASGN", "IF", "TRUE", "FALSE", 
		"PRINT", "BEGIN", "END", "NUM", "VAR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\31\5\31\u0080\n\31\3\31\3\31\7\31\u0084\n\31\f\31\16\31\u0087"+
		"\13\31\3\31\5\31\u008a\n\31\3\32\3\32\7\32\u008e\n\32\f\32\16\32\u0091"+
		"\13\32\3\33\3\33\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\3\2\5\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2"+
		"\u0099\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2"+
		"\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17D\3\2\2\2\21G\3\2\2"+
		"\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31P\3\2\2\2\33R\3\2\2\2\35U\3\2"+
		"\2\2\37X\3\2\2\2![\3\2\2\2#^\3\2\2\2%`\3\2\2\2\'c\3\2\2\2)h\3\2\2\2+n"+
		"\3\2\2\2-t\3\2\2\2/z\3\2\2\2\61\u0089\3\2\2\2\63\u008b\3\2\2\2\65\u0092"+
		"\3\2\2\2\678\7-\2\28\4\3\2\2\29:\7/\2\2:\6\3\2\2\2;<\7,\2\2<\b\3\2\2\2"+
		"=>\7\61\2\2>\n\3\2\2\2?@\7\'\2\2@\f\3\2\2\2AB\7,\2\2BC\7,\2\2C\16\3\2"+
		"\2\2DE\7(\2\2EF\7(\2\2F\20\3\2\2\2GH\7~\2\2HI\7~\2\2I\22\3\2\2\2JK\7`"+
		"\2\2K\24\3\2\2\2LM\7#\2\2M\26\3\2\2\2NO\7>\2\2O\30\3\2\2\2PQ\7@\2\2Q\32"+
		"\3\2\2\2RS\7>\2\2ST\7?\2\2T\34\3\2\2\2UV\7@\2\2VW\7?\2\2W\36\3\2\2\2X"+
		"Y\7?\2\2YZ\7?\2\2Z \3\2\2\2[\\\7#\2\2\\]\7?\2\2]\"\3\2\2\2^_\7?\2\2_$"+
		"\3\2\2\2`a\7k\2\2ab\7h\2\2b&\3\2\2\2cd\7v\2\2de\7t\2\2ef\7w\2\2fg\7g\2"+
		"\2g(\3\2\2\2hi\7h\2\2ij\7c\2\2jk\7n\2\2kl\7u\2\2lm\7g\2\2m*\3\2\2\2no"+
		"\7r\2\2op\7t\2\2pq\7k\2\2qr\7p\2\2rs\7v\2\2s,\3\2\2\2tu\7d\2\2uv\7g\2"+
		"\2vw\7i\2\2wx\7k\2\2xy\7p\2\2y.\3\2\2\2z{\7g\2\2{|\7p\2\2|}\7f\2\2}\60"+
		"\3\2\2\2~\u0080\7/\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2"+
		"\2\2\u0081\u0085\4\63;\2\u0082\u0084\4\62;\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008a\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u008a\7\62\2\2\u0089\177\3\2\2\2\u0089"+
		"\u0088\3\2\2\2\u008a\62\3\2\2\2\u008b\u008f\t\2\2\2\u008c\u008e\t\3\2"+
		"\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\64\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\t\4\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\b\33\2\2\u0095\66\3\2\2\2\7\2\177\u0085\u0089"+
		"\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}