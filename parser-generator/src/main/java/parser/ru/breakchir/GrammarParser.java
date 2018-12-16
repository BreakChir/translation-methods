// Generated from ru\breakchir\Grammar.g4 by ANTLR 4.7.1

    package ru.breakchir;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TERM=12, NTERM=13, STRING=14, CODE=15, WS=16;
	public static final int
		RULE_start = 0, RULE_choose_roole = 1, RULE_prule = 2, RULE_args = 3, 
		RULE_rets = 4, RULE_arg = 5, RULE_type = 6, RULE_pattern = 7, RULE_partpat = 8, 
		RULE_param = 9;
	public static final String[] ruleNames = {
		"start", "choose_roole", "prule", "args", "rets", "arg", "type", "pattern", 
		"partpat", "param"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'='", "':'", "'WS'", "'->'", "'|'", "'('", "','", "')'", 
		"'[returns'", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"TERM", "NTERM", "STRING", "CODE", "WS"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ParsedGrammar v;
		public Token NTERM;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<Choose_rooleContext> choose_roole() {
			return getRuleContexts(Choose_rooleContext.class);
		}
		public Choose_rooleContext choose_roole(int i) {
			return getRuleContext(Choose_rooleContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			((StartContext)_localctx).NTERM = match(NTERM);
			 ((StartContext)_localctx).v =  new ParsedGrammar((((StartContext)_localctx).NTERM!=null?((StartContext)_localctx).NTERM.getText():null)); 
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				choose_roole(_localctx.v);
				setState(23);
				match(T__0);
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << TERM) | (1L << NTERM))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Choose_rooleContext extends ParserRuleContext {
		public ParsedGrammar gr;
		public Token TERM;
		public Token STRING;
		public PruleContext prule;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public PruleContext prule() {
			return getRuleContext(PruleContext.class,0);
		}
		public Choose_rooleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Choose_rooleContext(ParserRuleContext parent, int invokingState, ParsedGrammar gr) {
			super(parent, invokingState);
			this.gr = gr;
		}
		@Override public int getRuleIndex() { return RULE_choose_roole; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterChoose_roole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitChoose_roole(this);
		}
	}

	public final Choose_rooleContext choose_roole(ParsedGrammar gr) throws RecognitionException {
		Choose_rooleContext _localctx = new Choose_rooleContext(_ctx, getState(), gr);
		enterRule(_localctx, 2, RULE_choose_roole);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				((Choose_rooleContext)_localctx).TERM = match(TERM);
				setState(30);
				match(T__1);
				setState(31);
				((Choose_rooleContext)_localctx).STRING = match(STRING);
				 _localctx.gr.addTermRule(new TermRule(false, (((Choose_rooleContext)_localctx).TERM!=null?((Choose_rooleContext)_localctx).TERM.getText():null), (((Choose_rooleContext)_localctx).STRING!=null?((Choose_rooleContext)_localctx).STRING.getText():null))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((Choose_rooleContext)_localctx).TERM = match(TERM);
				setState(34);
				match(T__2);
				setState(35);
				((Choose_rooleContext)_localctx).STRING = match(STRING);
				 _localctx.gr.addTermRule(new TermRule(true, (((Choose_rooleContext)_localctx).TERM!=null?((Choose_rooleContext)_localctx).TERM.getText():null), (((Choose_rooleContext)_localctx).STRING!=null?((Choose_rooleContext)_localctx).STRING.getText():null))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(T__3);
				setState(38);
				match(T__4);
				setState(39);
				((Choose_rooleContext)_localctx).STRING = match(STRING);
				 _localctx.gr.addWS((((Choose_rooleContext)_localctx).STRING!=null?((Choose_rooleContext)_localctx).STRING.getText():null)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				((Choose_rooleContext)_localctx).prule = prule();
				 _localctx.gr.addNTermRule(((Choose_rooleContext)_localctx).prule.v); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PruleContext extends ParserRuleContext {
		public NTermRule v;
		public Token NTERM;
		public ArgsContext args;
		public RetsContext rets;
		public PatternContext pattern;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public RetsContext rets() {
			return getRuleContext(RetsContext.class,0);
		}
		public PruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPrule(this);
		}
	}

	public final PruleContext prule() throws RecognitionException {
		PruleContext _localctx = new PruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((PruleContext)_localctx).NTERM = match(NTERM);
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(47);
				((PruleContext)_localctx).args = args();
				}
				break;
			}
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(50);
				((PruleContext)_localctx).rets = rets();
				}
				break;
			}
			setState(53);
			match(T__1);
			 ((PruleContext)_localctx).v =  new NTermRule((((PruleContext)_localctx).NTERM!=null?((PruleContext)_localctx).NTERM.getText():null), ((PruleContext)_localctx).args.v, ((PruleContext)_localctx).rets.v); 
			setState(55);
			((PruleContext)_localctx).pattern = pattern();
			 _localctx.v.addRule(((PruleContext)_localctx).pattern.v); 
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(57);
				match(T__5);
				setState(58);
				((PruleContext)_localctx).pattern = pattern();
				 _localctx.v.addRule(((PruleContext)_localctx).pattern.v); 
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<Argument> v;
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_args);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(T__6);
				setState(67);
				((ArgsContext)_localctx).arg = arg();
				 ((ArgsContext)_localctx).v =  new ArrayList(); 
				 _localctx.v.add(((ArgsContext)_localctx).arg.v); 
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(70);
					match(T__7);
					setState(71);
					((ArgsContext)_localctx).arg = arg();
					 _localctx.v.add(((ArgsContext)_localctx).arg.v); 
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(T__8);
				}
				break;
			case T__1:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				 ((ArgsContext)_localctx).v =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetsContext extends ParserRuleContext {
		public List<Argument> v;
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public RetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRets(this);
		}
	}

	public final RetsContext rets() throws RecognitionException {
		RetsContext _localctx = new RetsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rets);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T__9);
				setState(85);
				((RetsContext)_localctx).arg = arg();
				 ((RetsContext)_localctx).v =  new ArrayList(); 
				 _localctx.v.add(((RetsContext)_localctx).arg.v); 
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(88);
					match(T__7);
					setState(89);
					((RetsContext)_localctx).arg = arg();
					 _localctx.v.add(((RetsContext)_localctx).arg.v); 
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(T__10);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 ((RetsContext)_localctx).v =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public Argument v;
		public Token NTERM;
		public TypeContext type;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((ArgContext)_localctx).NTERM = match(NTERM);
			setState(103);
			match(T__2);
			setState(104);
			((ArgContext)_localctx).type = type();
			 ((ArgContext)_localctx).v =  new Argument(((ArgContext)_localctx).type.v, (((ArgContext)_localctx).NTERM!=null?((ArgContext)_localctx).NTERM.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public String v;
		public Token NTERM;
		public Token TERM;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				((TypeContext)_localctx).NTERM = match(NTERM);
				 ((TypeContext)_localctx).v =  (((TypeContext)_localctx).NTERM!=null?((TypeContext)_localctx).NTERM.getText():null); 
				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((TypeContext)_localctx).TERM = match(TERM);
				 ((TypeContext)_localctx).v =  (((TypeContext)_localctx).TERM!=null?((TypeContext)_localctx).TERM.getText():null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public List<Production> v;
		public PartpatContext partpat;
		public List<PartpatContext> partpat() {
			return getRuleContexts(PartpatContext.class);
		}
		public PartpatContext partpat(int i) {
			return getRuleContext(PartpatContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PatternContext)_localctx).v =  new ArrayList<>(); 
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				((PatternContext)_localctx).partpat = partpat();
				 _localctx.v.add(((PatternContext)_localctx).partpat.v); 
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERM) | (1L << NTERM) | (1L << CODE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartpatContext extends ParserRuleContext {
		public Production v;
		public Token TERM;
		public Token NTERM;
		public ParamContext param;
		public Token CODE;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public PartpatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partpat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPartpat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPartpat(this);
		}
	}

	public final PartpatContext partpat() throws RecognitionException {
		PartpatContext _localctx = new PartpatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_partpat);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((PartpatContext)_localctx).TERM = match(TERM);
				 ((PartpatContext)_localctx).v =  new Term((((PartpatContext)_localctx).TERM!=null?((PartpatContext)_localctx).TERM.getText():null)); 
				}
				break;
			case NTERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				((PartpatContext)_localctx).NTERM = match(NTERM);
				 NTerm t = new NTerm((((PartpatContext)_localctx).NTERM!=null?((PartpatContext)_localctx).NTERM.getText():null)); 
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(125);
					match(T__6);
					setState(126);
					((PartpatContext)_localctx).param = param();
					 t.addParameter(((PartpatContext)_localctx).param.v); 
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(128);
						match(T__7);
						setState(129);
						((PartpatContext)_localctx).param = param();
						 t.addParameter(((PartpatContext)_localctx).param.v); 
						}
						}
						setState(136);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(137);
					match(T__8);
					}
				}

				 ((PartpatContext)_localctx).v =  t; 
				}
				break;
			case CODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				((PartpatContext)_localctx).CODE = match(CODE);
				 ((PartpatContext)_localctx).v =  new Code((((PartpatContext)_localctx).CODE!=null?((PartpatContext)_localctx).CODE.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public String v;
		public Token NTERM;
		public Token TERM;
		public Token CODE;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				((ParamContext)_localctx).NTERM = match(NTERM);
				 ((ParamContext)_localctx).v =  (((ParamContext)_localctx).NTERM!=null?((ParamContext)_localctx).NTERM.getText():null); 
				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((ParamContext)_localctx).TERM = match(TERM);
				 ((ParamContext)_localctx).v =  (((ParamContext)_localctx).TERM!=null?((ParamContext)_localctx).TERM.getText():null); 
				}
				break;
			case CODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				((ParamContext)_localctx).CODE = match(CODE);
				 ((ParamContext)_localctx).v =  (((ParamContext)_localctx).CODE!=null?((ParamContext)_localctx).CODE.getText():null).substring(1, (((ParamContext)_localctx).CODE!=null?((ParamContext)_localctx).CODE.getText():null).length() - 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\u009d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\5\4\63\n\4\3\4"+
		"\5\4\66\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\3\5\3\5\5\5"+
		"U\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6\3\6\3\6"+
		"\3\6\5\6g\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\br\n\b\3\t\3\t\3\t"+
		"\3\t\6\tx\n\t\r\t\16\ty\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u0087\n\n\f\n\16\n\u008a\13\n\3\n\3\n\5\n\u008e\n\n\3\n\3\n\3\n\5\n"+
		"\u0093\n\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009b\n\13\3\13\2\2\f\2"+
		"\4\6\b\n\f\16\20\22\24\2\2\2\u00a5\2\26\3\2\2\2\4.\3\2\2\2\6\60\3\2\2"+
		"\2\bT\3\2\2\2\nf\3\2\2\2\fh\3\2\2\2\16q\3\2\2\2\20s\3\2\2\2\22\u0092\3"+
		"\2\2\2\24\u009a\3\2\2\2\26\27\7\17\2\2\27\33\b\2\1\2\30\31\5\4\3\2\31"+
		"\32\7\3\2\2\32\34\3\2\2\2\33\30\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35"+
		"\36\3\2\2\2\36\3\3\2\2\2\37 \7\16\2\2 !\7\4\2\2!\"\7\20\2\2\"/\b\3\1\2"+
		"#$\7\16\2\2$%\7\5\2\2%&\7\20\2\2&/\b\3\1\2\'(\7\6\2\2()\7\7\2\2)*\7\20"+
		"\2\2*/\b\3\1\2+,\5\6\4\2,-\b\3\1\2-/\3\2\2\2.\37\3\2\2\2.#\3\2\2\2.\'"+
		"\3\2\2\2.+\3\2\2\2/\5\3\2\2\2\60\62\7\17\2\2\61\63\5\b\5\2\62\61\3\2\2"+
		"\2\62\63\3\2\2\2\63\65\3\2\2\2\64\66\5\n\6\2\65\64\3\2\2\2\65\66\3\2\2"+
		"\2\66\67\3\2\2\2\678\7\4\2\289\b\4\1\29:\5\20\t\2:A\b\4\1\2;<\7\b\2\2"+
		"<=\5\20\t\2=>\b\4\1\2>@\3\2\2\2?;\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2"+
		"\2B\7\3\2\2\2CA\3\2\2\2DE\7\t\2\2EF\5\f\7\2FG\b\5\1\2GN\b\5\1\2HI\7\n"+
		"\2\2IJ\5\f\7\2JK\b\5\1\2KM\3\2\2\2LH\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2"+
		"\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\13\2\2RU\3\2\2\2SU\b\5\1\2TD\3\2\2\2TS\3"+
		"\2\2\2U\t\3\2\2\2VW\7\f\2\2WX\5\f\7\2XY\b\6\1\2Y`\b\6\1\2Z[\7\n\2\2[\\"+
		"\5\f\7\2\\]\b\6\1\2]_\3\2\2\2^Z\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2"+
		"ac\3\2\2\2b`\3\2\2\2cd\7\r\2\2dg\3\2\2\2eg\b\6\1\2fV\3\2\2\2fe\3\2\2\2"+
		"g\13\3\2\2\2hi\7\17\2\2ij\7\5\2\2jk\5\16\b\2kl\b\7\1\2l\r\3\2\2\2mn\7"+
		"\17\2\2nr\b\b\1\2op\7\16\2\2pr\b\b\1\2qm\3\2\2\2qo\3\2\2\2r\17\3\2\2\2"+
		"sw\b\t\1\2tu\5\22\n\2uv\b\t\1\2vx\3\2\2\2wt\3\2\2\2xy\3\2\2\2yw\3\2\2"+
		"\2yz\3\2\2\2z\21\3\2\2\2{|\7\16\2\2|\u0093\b\n\1\2}~\7\17\2\2~\u008d\b"+
		"\n\1\2\177\u0080\7\t\2\2\u0080\u0081\5\24\13\2\u0081\u0088\b\n\1\2\u0082"+
		"\u0083\7\n\2\2\u0083\u0084\5\24\13\2\u0084\u0085\b\n\1\2\u0085\u0087\3"+
		"\2\2\2\u0086\u0082\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\13"+
		"\2\2\u008c\u008e\3\2\2\2\u008d\177\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0093\b\n\1\2\u0090\u0091\7\21\2\2\u0091\u0093\b\n\1\2"+
		"\u0092{\3\2\2\2\u0092}\3\2\2\2\u0092\u0090\3\2\2\2\u0093\23\3\2\2\2\u0094"+
		"\u0095\7\17\2\2\u0095\u009b\b\13\1\2\u0096\u0097\7\16\2\2\u0097\u009b"+
		"\b\13\1\2\u0098\u0099\7\21\2\2\u0099\u009b\b\13\1\2\u009a\u0094\3\2\2"+
		"\2\u009a\u0096\3\2\2\2\u009a\u0098\3\2\2\2\u009b\25\3\2\2\2\21\35.\62"+
		"\65ANT`fqy\u0088\u008d\u0092\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}