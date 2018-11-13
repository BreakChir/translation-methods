// Generated from ru\breakchir\Code.g4 by ANTLR 4.7.1

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
public class CodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, SUB=2, MUL=3, DIV=4, MOD=5, POW=6, AND=7, OR=8, XOR=9, NOT=10, 
		LT=11, GT=12, LTEQ=13, GTEQ=14, EQ=15, NQ=16, ASGN=17, IF=18, TRUE=19, 
		FALSE=20, PRINT=21, BEGIN=22, END=23, NUM=24, VAR=25, WS=26;
	public static final int
		RULE_start = 0, RULE_set_expr = 1, RULE_expr = 2, RULE_arg = 3, RULE_bool_cond = 4, 
		RULE_num = 5, RULE_bool_cmp = 6, RULE_int_cmp = 7, RULE_int_op = 8;
	public static final String[] ruleNames = {
		"start", "set_expr", "expr", "arg", "bool_cond", "num", "bool_cmp", "int_cmp", 
		"int_op"
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

	@Override
	public String getGrammarFileName() { return "Code.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public String v;
		public Set_exprContext set_expr;
		public Set_exprContext set_expr() {
			return getRuleContext(Set_exprContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			((StartContext)_localctx).set_expr = set_expr("");
			 ((StartContext)_localctx).v =  "begin\n" + ((StartContext)_localctx).set_expr.v + "end."; 
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

	public static class Set_exprContext extends ParserRuleContext {
		public String space;
		public String v;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Set_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Set_exprContext(ParserRuleContext parent, int invokingState, String space) {
			super(parent, invokingState);
			this.space = space;
		}
		@Override public int getRuleIndex() { return RULE_set_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterSet_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitSet_expr(this);
		}
	}

	public final Set_exprContext set_expr(String space) throws RecognitionException {
		Set_exprContext _localctx = new Set_exprContext(_ctx, getState(), space);
		enterRule(_localctx, 2, RULE_set_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			((Set_exprContext)_localctx).expr = expr(space + "  ", 0);
			 ((Set_exprContext)_localctx).v =  ((Set_exprContext)_localctx).expr.v; 
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(23);
					((Set_exprContext)_localctx).expr = expr(space + "  ", 0);
					 _localctx.v += ((Set_exprContext)_localctx).expr.v; 
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public String space;
		public int els;
		public String v;
		public Set_exprContext set_expr;
		public ArgContext arg;
		public Token VAR;
		public Bool_condContext b1;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode BEGIN() { return getToken(CodeParser.BEGIN, 0); }
		public Set_exprContext set_expr() {
			return getRuleContext(Set_exprContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(CodeParser.PRINT, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public TerminalNode ASGN() { return getToken(CodeParser.ASGN, 0); }
		public TerminalNode VAR() { return getToken(CodeParser.VAR, 0); }
		public TerminalNode IF() { return getToken(CodeParser.IF, 0); }
		public Bool_condContext bool_cond() {
			return getRuleContext(Bool_condContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, String space, int els) {
			super(parent, invokingState);
			this.space = space;
			this.els = els;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(String space,int els) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), space, els);
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(BEGIN);
				setState(32);
				((ExprContext)_localctx).set_expr = set_expr(els == 1 ? space + "  " : space);
				 ((ExprContext)_localctx).v =  els == 1 ? "\n  " : ""; 
				 _localctx.v += space + "begin\n" + ((ExprContext)_localctx).set_expr.v + space + (els == 1 ? "  " : "") + (els == 2 ? "end\n" : "end;\n"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(PRINT);
				setState(37);
				((ExprContext)_localctx).arg = arg();
				 ((ExprContext)_localctx).v =  els == 1 ? "\n  " : ""; 
				 _localctx.v += space + "writeln(" + ((ExprContext)_localctx).arg.v + ")" + (els == 2 ? "\n" : ";\n"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(ASGN);
				setState(42);
				((ExprContext)_localctx).VAR = match(VAR);
				setState(43);
				((ExprContext)_localctx).arg = arg();
				 ((ExprContext)_localctx).v =  els == 1 ? "\n  " : ""; 
				 _localctx.v += space + (((ExprContext)_localctx).VAR!=null?((ExprContext)_localctx).VAR.getText():null) + " = " + ((ExprContext)_localctx).arg.v + (els == 2 ? "\n" : ";\n"); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(IF);
				setState(48);
				((ExprContext)_localctx).b1 = bool_cond();
				setState(49);
				((ExprContext)_localctx).e1 = expr(space + "  ", 2);
				setState(50);
				((ExprContext)_localctx).e2 = expr(space, 1);
				 ((ExprContext)_localctx).v =  els == 1 ? " " : space; 
				 _localctx.v += "if " + ((ExprContext)_localctx).b1.v + " then\n" + ((ExprContext)_localctx).e1.v; 
				 _localctx.v += space + "else" + ((ExprContext)_localctx).e2.v; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(IF);
				setState(56);
				((ExprContext)_localctx).b1 = bool_cond();
				setState(57);
				((ExprContext)_localctx).e1 = expr(space + "  ", 0);
				 ((ExprContext)_localctx).v =  els == 1 ? " " : space; 
				 _localctx.v += "if " + ((ExprContext)_localctx).b1.v + " then\n" + ((ExprContext)_localctx).e1.v; 
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

	public static class ArgContext extends ParserRuleContext {
		public String v;
		public Bool_condContext bool_cond;
		public NumContext num;
		public Token VAR;
		public Bool_condContext bool_cond() {
			return getRuleContext(Bool_condContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode VAR() { return getToken(CodeParser.VAR, 0); }
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arg);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				((ArgContext)_localctx).bool_cond = bool_cond();
				 ((ArgContext)_localctx).v =  ((ArgContext)_localctx).bool_cond.v; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				((ArgContext)_localctx).num = num();
				 ((ArgContext)_localctx).v =  ((ArgContext)_localctx).num.v; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				((ArgContext)_localctx).VAR = match(VAR);
				 ((ArgContext)_localctx).v =  (((ArgContext)_localctx).VAR!=null?((ArgContext)_localctx).VAR.getText():null); 
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

	public static class Bool_condContext extends ParserRuleContext {
		public String v;
		public Bool_cmpContext bool_cmp;
		public Bool_condContext b1;
		public Bool_condContext b2;
		public Bool_condContext bool_cond;
		public Token VAR;
		public Int_cmpContext int_cmp;
		public NumContext n1;
		public NumContext n2;
		public Bool_cmpContext bool_cmp() {
			return getRuleContext(Bool_cmpContext.class,0);
		}
		public List<Bool_condContext> bool_cond() {
			return getRuleContexts(Bool_condContext.class);
		}
		public Bool_condContext bool_cond(int i) {
			return getRuleContext(Bool_condContext.class,i);
		}
		public TerminalNode NOT() { return getToken(CodeParser.NOT, 0); }
		public TerminalNode TRUE() { return getToken(CodeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CodeParser.FALSE, 0); }
		public TerminalNode VAR() { return getToken(CodeParser.VAR, 0); }
		public Int_cmpContext int_cmp() {
			return getRuleContext(Int_cmpContext.class,0);
		}
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public Bool_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterBool_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitBool_cond(this);
		}
	}

	public final Bool_condContext bool_cond() throws RecognitionException {
		Bool_condContext _localctx = new Bool_condContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bool_cond);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
			case OR:
			case XOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				((Bool_condContext)_localctx).bool_cmp = bool_cmp();
				setState(74);
				((Bool_condContext)_localctx).b1 = bool_cond();
				setState(75);
				((Bool_condContext)_localctx).b2 = bool_cond();
				 ((Bool_condContext)_localctx).v =  "(" + ((Bool_condContext)_localctx).b1.v + ((Bool_condContext)_localctx).bool_cmp.v + ((Bool_condContext)_localctx).b2.v + ")"; 
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(NOT);
				setState(79);
				((Bool_condContext)_localctx).bool_cond = bool_cond();
				 ((Bool_condContext)_localctx).v =  "!" + ((Bool_condContext)_localctx).bool_cond.v; 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(TRUE);
				 ((Bool_condContext)_localctx).v =  "true"; 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				match(FALSE);
				 ((Bool_condContext)_localctx).v =  "false"; 
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				((Bool_condContext)_localctx).VAR = match(VAR);
				 ((Bool_condContext)_localctx).v =  (((Bool_condContext)_localctx).VAR!=null?((Bool_condContext)_localctx).VAR.getText():null); 
				}
				break;
			case LT:
			case GT:
			case LTEQ:
			case GTEQ:
			case EQ:
			case NQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				((Bool_condContext)_localctx).int_cmp = int_cmp();
				setState(89);
				((Bool_condContext)_localctx).n1 = num();
				setState(90);
				((Bool_condContext)_localctx).n2 = num();
				 ((Bool_condContext)_localctx).v =  "(" + ((Bool_condContext)_localctx).n1.v + ((Bool_condContext)_localctx).int_cmp.v + ((Bool_condContext)_localctx).n2.v + ")"; 
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

	public static class NumContext extends ParserRuleContext {
		public String v;
		public Int_opContext int_op;
		public NumContext m1;
		public NumContext m2;
		public Token NUM;
		public Token VAR;
		public Int_opContext int_op() {
			return getRuleContext(Int_opContext.class,0);
		}
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public TerminalNode NUM() { return getToken(CodeParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(CodeParser.VAR, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_num);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case MUL:
			case DIV:
			case MOD:
			case POW:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				((NumContext)_localctx).int_op = int_op();
				setState(96);
				((NumContext)_localctx).m1 = num();
				setState(97);
				((NumContext)_localctx).m2 = num();
				 ((NumContext)_localctx).v =  "(" + ((NumContext)_localctx).m1.v + ((NumContext)_localctx).int_op.v + ((NumContext)_localctx).m2.v + ")"; 
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((NumContext)_localctx).NUM = match(NUM);
				 ((NumContext)_localctx).v =  (((NumContext)_localctx).NUM!=null?((NumContext)_localctx).NUM.getText():null); 
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				((NumContext)_localctx).VAR = match(VAR);
				 ((NumContext)_localctx).v =  (((NumContext)_localctx).VAR!=null?((NumContext)_localctx).VAR.getText():null); 
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

	public static class Bool_cmpContext extends ParserRuleContext {
		public String v;
		public TerminalNode AND() { return getToken(CodeParser.AND, 0); }
		public TerminalNode XOR() { return getToken(CodeParser.XOR, 0); }
		public TerminalNode OR() { return getToken(CodeParser.OR, 0); }
		public Bool_cmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_cmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterBool_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitBool_cmp(this);
		}
	}

	public final Bool_cmpContext bool_cmp() throws RecognitionException {
		Bool_cmpContext _localctx = new Bool_cmpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bool_cmp);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(AND);
				 ((Bool_cmpContext)_localctx).v =  " && "; 
				}
				break;
			case XOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(XOR);
				 ((Bool_cmpContext)_localctx).v =  " ^ "; 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(OR);
				 ((Bool_cmpContext)_localctx).v =  " || "; 
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

	public static class Int_cmpContext extends ParserRuleContext {
		public String v;
		public TerminalNode LT() { return getToken(CodeParser.LT, 0); }
		public TerminalNode GT() { return getToken(CodeParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(CodeParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(CodeParser.GTEQ, 0); }
		public TerminalNode EQ() { return getToken(CodeParser.EQ, 0); }
		public TerminalNode NQ() { return getToken(CodeParser.NQ, 0); }
		public Int_cmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_cmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterInt_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitInt_cmp(this);
		}
	}

	public final Int_cmpContext int_cmp() throws RecognitionException {
		Int_cmpContext _localctx = new Int_cmpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_int_cmp);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(LT);
				 ((Int_cmpContext)_localctx).v =  " < "; 
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(GT);
				 ((Int_cmpContext)_localctx).v =  " > "; 
				}
				break;
			case LTEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(LTEQ);
				 ((Int_cmpContext)_localctx).v =  " <= "; 
				}
				break;
			case GTEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(GTEQ);
				 ((Int_cmpContext)_localctx).v =  " >= "; 
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				match(EQ);
				 ((Int_cmpContext)_localctx).v =  " == "; 
				}
				break;
			case NQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(NQ);
				 ((Int_cmpContext)_localctx).v =  " != "; 
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

	public static class Int_opContext extends ParserRuleContext {
		public String v;
		public TerminalNode ADD() { return getToken(CodeParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(CodeParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(CodeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CodeParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CodeParser.MOD, 0); }
		public TerminalNode POW() { return getToken(CodeParser.POW, 0); }
		public Int_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterInt_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitInt_op(this);
		}
	}

	public final Int_opContext int_op() throws RecognitionException {
		Int_opContext _localctx = new Int_opContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_int_op);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(ADD);
				 ((Int_opContext)_localctx).v =  " + "; 
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(SUB);
				 ((Int_opContext)_localctx).v =  " - "; 
				}
				break;
			case MUL:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(MUL);
				 ((Int_opContext)_localctx).v =  " * "; 
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(DIV);
				 ((Int_opContext)_localctx).v =  " / "; 
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				match(MOD);
				 ((Int_opContext)_localctx).v =  " % "; 
				}
				break;
			case POW:
				enterOuterAlt(_localctx, 6);
				{
				setState(138);
				match(POW);
				 ((Int_opContext)_localctx).v =  " ** "; 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6`\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7k\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u0081\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u008f\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2\2\u00a1"+
		"\2\24\3\2\2\2\4\27\3\2\2\2\6?\3\2\2\2\bI\3\2\2\2\n_\3\2\2\2\fj\3\2\2\2"+
		"\16r\3\2\2\2\20\u0080\3\2\2\2\22\u008e\3\2\2\2\24\25\5\4\3\2\25\26\b\2"+
		"\1\2\26\3\3\2\2\2\27\30\5\6\4\2\30\36\b\3\1\2\31\32\5\6\4\2\32\33\b\3"+
		"\1\2\33\35\3\2\2\2\34\31\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37\5\3\2\2\2 \36\3\2\2\2!\"\7\30\2\2\"#\5\4\3\2#$\b\4\1\2$%\b\4\1\2"+
		"%@\3\2\2\2&\'\7\27\2\2\'(\5\b\5\2()\b\4\1\2)*\b\4\1\2*@\3\2\2\2+,\7\23"+
		"\2\2,-\7\33\2\2-.\5\b\5\2./\b\4\1\2/\60\b\4\1\2\60@\3\2\2\2\61\62\7\24"+
		"\2\2\62\63\5\n\6\2\63\64\5\6\4\2\64\65\5\6\4\2\65\66\b\4\1\2\66\67\b\4"+
		"\1\2\678\b\4\1\28@\3\2\2\29:\7\24\2\2:;\5\n\6\2;<\5\6\4\2<=\b\4\1\2=>"+
		"\b\4\1\2>@\3\2\2\2?!\3\2\2\2?&\3\2\2\2?+\3\2\2\2?\61\3\2\2\2?9\3\2\2\2"+
		"@\7\3\2\2\2AB\5\n\6\2BC\b\5\1\2CJ\3\2\2\2DE\5\f\7\2EF\b\5\1\2FJ\3\2\2"+
		"\2GH\7\33\2\2HJ\b\5\1\2IA\3\2\2\2ID\3\2\2\2IG\3\2\2\2J\t\3\2\2\2KL\5\16"+
		"\b\2LM\5\n\6\2MN\5\n\6\2NO\b\6\1\2O`\3\2\2\2PQ\7\f\2\2QR\5\n\6\2RS\b\6"+
		"\1\2S`\3\2\2\2TU\7\25\2\2U`\b\6\1\2VW\7\26\2\2W`\b\6\1\2XY\7\33\2\2Y`"+
		"\b\6\1\2Z[\5\20\t\2[\\\5\f\7\2\\]\5\f\7\2]^\b\6\1\2^`\3\2\2\2_K\3\2\2"+
		"\2_P\3\2\2\2_T\3\2\2\2_V\3\2\2\2_X\3\2\2\2_Z\3\2\2\2`\13\3\2\2\2ab\5\22"+
		"\n\2bc\5\f\7\2cd\5\f\7\2de\b\7\1\2ek\3\2\2\2fg\7\32\2\2gk\b\7\1\2hi\7"+
		"\33\2\2ik\b\7\1\2ja\3\2\2\2jf\3\2\2\2jh\3\2\2\2k\r\3\2\2\2lm\7\t\2\2m"+
		"s\b\b\1\2no\7\13\2\2os\b\b\1\2pq\7\n\2\2qs\b\b\1\2rl\3\2\2\2rn\3\2\2\2"+
		"rp\3\2\2\2s\17\3\2\2\2tu\7\r\2\2u\u0081\b\t\1\2vw\7\16\2\2w\u0081\b\t"+
		"\1\2xy\7\17\2\2y\u0081\b\t\1\2z{\7\20\2\2{\u0081\b\t\1\2|}\7\21\2\2}\u0081"+
		"\b\t\1\2~\177\7\22\2\2\177\u0081\b\t\1\2\u0080t\3\2\2\2\u0080v\3\2\2\2"+
		"\u0080x\3\2\2\2\u0080z\3\2\2\2\u0080|\3\2\2\2\u0080~\3\2\2\2\u0081\21"+
		"\3\2\2\2\u0082\u0083\7\3\2\2\u0083\u008f\b\n\1\2\u0084\u0085\7\4\2\2\u0085"+
		"\u008f\b\n\1\2\u0086\u0087\7\5\2\2\u0087\u008f\b\n\1\2\u0088\u0089\7\6"+
		"\2\2\u0089\u008f\b\n\1\2\u008a\u008b\7\7\2\2\u008b\u008f\b\n\1\2\u008c"+
		"\u008d\7\b\2\2\u008d\u008f\b\n\1\2\u008e\u0082\3\2\2\2\u008e\u0084\3\2"+
		"\2\2\u008e\u0086\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u008a\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\23\3\2\2\2\n\36?I_jr\u0080\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}