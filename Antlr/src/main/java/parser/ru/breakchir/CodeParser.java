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
		RULE_start = 0, RULE_set_expr = 1, RULE_expr = 2, RULE_exprElse = 3, RULE_arg = 4, 
		RULE_bool_cond = 5, RULE_num = 6, RULE_bool_cmp = 7, RULE_int_cmp = 8, 
		RULE_int_op = 9;
	public static final String[] ruleNames = {
		"start", "set_expr", "expr", "exprElse", "arg", "bool_cond", "num", "bool_cmp", 
		"int_cmp", "int_op"
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
		public Program v;
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
			setState(20);
			((StartContext)_localctx).set_expr = set_expr();
			 ((StartContext)_localctx).v =  new Program(((StartContext)_localctx).set_expr.v); 
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
		public ExpressionList v;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Set_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final Set_exprContext set_expr() throws RecognitionException {
		Set_exprContext _localctx = new Set_exprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_set_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((Set_exprContext)_localctx).expr = expr();
			 List<Expression> list = new ArrayList<>(); 
			 list.add(((Set_exprContext)_localctx).expr.v); 
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					((Set_exprContext)_localctx).expr = expr();
					 list.add(((Set_exprContext)_localctx).expr.v); 
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 ((Set_exprContext)_localctx).v =  new ExpressionList(list); 
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
		public Expression v;
		public Set_exprContext set_expr;
		public ArgContext arg;
		public Token VAR;
		public Bool_condContext b1;
		public ExprContext e1;
		public ExprElseContext e2;
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprElseContext exprElse() {
			return getRuleContext(ExprElseContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
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

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(BEGIN);
				setState(37);
				((ExprContext)_localctx).set_expr = set_expr();
				 ((ExprContext)_localctx).v =  new BeginStatement(((ExprContext)_localctx).set_expr.v); 
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(PRINT);
				setState(41);
				((ExprContext)_localctx).arg = arg();
				 ((ExprContext)_localctx).v =  new Print(((ExprContext)_localctx).arg.v); 
				}
				break;
			case ASGN:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				match(ASGN);
				setState(45);
				((ExprContext)_localctx).VAR = match(VAR);
				setState(46);
				((ExprContext)_localctx).arg = arg();
				 ((ExprContext)_localctx).v =  new Assignment((((ExprContext)_localctx).VAR!=null?((ExprContext)_localctx).VAR.getText():null), ((ExprContext)_localctx).arg.v); 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(IF);
				setState(50);
				((ExprContext)_localctx).b1 = bool_cond();
				setState(51);
				((ExprContext)_localctx).e1 = expr();
				setState(52);
				((ExprContext)_localctx).e2 = exprElse();
				 ((ExprContext)_localctx).v =  ((ExprContext)_localctx).e2.v == null ? new StatementIf(((ExprContext)_localctx).b1.v, ((ExprContext)_localctx).e1.v)
				                : new StatementIfElse(((ExprContext)_localctx).b1.v, ((ExprContext)_localctx).e1.v, ((ExprContext)_localctx).e2.v); 
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

	public static class ExprElseContext extends ParserRuleContext {
		public Expression v;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).enterExprElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeListener ) ((CodeListener)listener).exitExprElse(this);
		}
	}

	public final ExprElseContext exprElse() throws RecognitionException {
		ExprElseContext _localctx = new ExprElseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exprElse);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((ExprElseContext)_localctx).expr = expr();
				 ((ExprElseContext)_localctx).v =  ((ExprElseContext)_localctx).expr.v; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExprElseContext)_localctx).v =  null; 
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
		public Argument v;
		public Bool_condContext bool_cond;
		public NumContext num;
		public Bool_condContext bool_cond() {
			return getRuleContext(Bool_condContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_arg);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
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
		public BooleanExpression v;
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
		enterRule(_localctx, 10, RULE_bool_cond);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
			case OR:
			case XOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((Bool_condContext)_localctx).bool_cmp = bool_cmp();
				setState(72);
				((Bool_condContext)_localctx).b1 = bool_cond();
				setState(73);
				((Bool_condContext)_localctx).b2 = bool_cond();
				 ((Bool_condContext)_localctx).v =  new TwoBoolExpression(((Bool_condContext)_localctx).bool_cmp.v, ((Bool_condContext)_localctx).b1.v, ((Bool_condContext)_localctx).b2.v); 
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(NOT);
				setState(77);
				((Bool_condContext)_localctx).bool_cond = bool_cond();
				 ((Bool_condContext)_localctx).v =  new Negate(((Bool_condContext)_localctx).bool_cond.v); 
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(TRUE);
				 ((Bool_condContext)_localctx).v =  new BoolValue("true"); 
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				match(FALSE);
				 ((Bool_condContext)_localctx).v =  new BoolValue("false"); 
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				((Bool_condContext)_localctx).VAR = match(VAR);
				 ((Bool_condContext)_localctx).v =  new Variable((((Bool_condContext)_localctx).VAR!=null?((Bool_condContext)_localctx).VAR.getText():null)); 
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
				setState(86);
				((Bool_condContext)_localctx).int_cmp = int_cmp();
				setState(87);
				((Bool_condContext)_localctx).n1 = num();
				setState(88);
				((Bool_condContext)_localctx).n2 = num();
				 ((Bool_condContext)_localctx).v =  new TwoCmpArExpression(((Bool_condContext)_localctx).int_cmp.v, ((Bool_condContext)_localctx).n1.v, ((Bool_condContext)_localctx).n2.v); 
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
		public ArithmeticExpression v;
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
		enterRule(_localctx, 12, RULE_num);
		try {
			setState(102);
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
				setState(93);
				((NumContext)_localctx).int_op = int_op();
				setState(94);
				((NumContext)_localctx).m1 = num();
				setState(95);
				((NumContext)_localctx).m2 = num();
				 ((NumContext)_localctx).v =  new TwoArExpression(((NumContext)_localctx).int_op.v, ((NumContext)_localctx).m1.v, ((NumContext)_localctx).m2.v); 
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((NumContext)_localctx).NUM = match(NUM);
				 ((NumContext)_localctx).v =  new Number((((NumContext)_localctx).NUM!=null?((NumContext)_localctx).NUM.getText():null)); 
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				((NumContext)_localctx).VAR = match(VAR);
				 ((NumContext)_localctx).v =  new Variable((((NumContext)_localctx).VAR!=null?((NumContext)_localctx).VAR.getText():null)); 
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
		public ExprToken v;
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
		enterRule(_localctx, 14, RULE_bool_cmp);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(AND);
				 ((Bool_cmpContext)_localctx).v =  ExprToken.AND; 
				}
				break;
			case XOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(XOR);
				 ((Bool_cmpContext)_localctx).v =  ExprToken.XOR; 
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(OR);
				 ((Bool_cmpContext)_localctx).v =  ExprToken.OR;  
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
		public ExprToken v;
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
		enterRule(_localctx, 16, RULE_int_cmp);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(LT);
				 ((Int_cmpContext)_localctx).v =  ExprToken.LT;   
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(GT);
				 ((Int_cmpContext)_localctx).v =  ExprToken.GT;   
				}
				break;
			case LTEQ:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(LTEQ);
				 ((Int_cmpContext)_localctx).v =  ExprToken.LTEQ; 
				}
				break;
			case GTEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(GTEQ);
				 ((Int_cmpContext)_localctx).v =  ExprToken.GTEQ; 
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(EQ);
				 ((Int_cmpContext)_localctx).v =  ExprToken.EQ;   
				}
				break;
			case NQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(NQ);
				 ((Int_cmpContext)_localctx).v =  ExprToken.NQ;   
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
		public ExprToken v;
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
		enterRule(_localctx, 18, RULE_int_op);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ADD);
				 ((Int_opContext)_localctx).v =  ExprToken.ADD; 
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(SUB);
				 ((Int_opContext)_localctx).v =  ExprToken.SUB; 
				}
				break;
			case MUL:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(MUL);
				 ((Int_opContext)_localctx).v =  ExprToken.MUL; 
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(DIV);
				 ((Int_opContext)_localctx).v =  ExprToken.DIV; 
				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				match(MOD);
				 ((Int_opContext)_localctx).v =  ExprToken.MOD; 
				}
				break;
			case POW:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				match(POW);
				 ((Int_opContext)_localctx).v =  ExprToken.POW; 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u008f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6H\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bi\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\177\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u008d\n\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2"+
		"\2\u009d\2\26\3\2\2\2\4\31\3\2\2\2\69\3\2\2\2\b?\3\2\2\2\nG\3\2\2\2\f"+
		"]\3\2\2\2\16h\3\2\2\2\20p\3\2\2\2\22~\3\2\2\2\24\u008c\3\2\2\2\26\27\5"+
		"\4\3\2\27\30\b\2\1\2\30\3\3\2\2\2\31\32\5\6\4\2\32\33\b\3\1\2\33!\b\3"+
		"\1\2\34\35\5\6\4\2\35\36\b\3\1\2\36 \3\2\2\2\37\34\3\2\2\2 #\3\2\2\2!"+
		"\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\b\3\1\2%\5\3\2\2\2&\'\7"+
		"\30\2\2\'(\5\4\3\2()\b\4\1\2):\3\2\2\2*+\7\27\2\2+,\5\n\6\2,-\b\4\1\2"+
		"-:\3\2\2\2./\7\23\2\2/\60\7\33\2\2\60\61\5\n\6\2\61\62\b\4\1\2\62:\3\2"+
		"\2\2\63\64\7\24\2\2\64\65\5\f\7\2\65\66\5\6\4\2\66\67\5\b\5\2\678\b\4"+
		"\1\28:\3\2\2\29&\3\2\2\29*\3\2\2\29.\3\2\2\29\63\3\2\2\2:\7\3\2\2\2;<"+
		"\5\6\4\2<=\b\5\1\2=@\3\2\2\2>@\b\5\1\2?;\3\2\2\2?>\3\2\2\2@\t\3\2\2\2"+
		"AB\5\f\7\2BC\b\6\1\2CH\3\2\2\2DE\5\16\b\2EF\b\6\1\2FH\3\2\2\2GA\3\2\2"+
		"\2GD\3\2\2\2H\13\3\2\2\2IJ\5\20\t\2JK\5\f\7\2KL\5\f\7\2LM\b\7\1\2M^\3"+
		"\2\2\2NO\7\f\2\2OP\5\f\7\2PQ\b\7\1\2Q^\3\2\2\2RS\7\25\2\2S^\b\7\1\2TU"+
		"\7\26\2\2U^\b\7\1\2VW\7\33\2\2W^\b\7\1\2XY\5\22\n\2YZ\5\16\b\2Z[\5\16"+
		"\b\2[\\\b\7\1\2\\^\3\2\2\2]I\3\2\2\2]N\3\2\2\2]R\3\2\2\2]T\3\2\2\2]V\3"+
		"\2\2\2]X\3\2\2\2^\r\3\2\2\2_`\5\24\13\2`a\5\16\b\2ab\5\16\b\2bc\b\b\1"+
		"\2ci\3\2\2\2de\7\32\2\2ei\b\b\1\2fg\7\33\2\2gi\b\b\1\2h_\3\2\2\2hd\3\2"+
		"\2\2hf\3\2\2\2i\17\3\2\2\2jk\7\t\2\2kq\b\t\1\2lm\7\13\2\2mq\b\t\1\2no"+
		"\7\n\2\2oq\b\t\1\2pj\3\2\2\2pl\3\2\2\2pn\3\2\2\2q\21\3\2\2\2rs\7\r\2\2"+
		"s\177\b\n\1\2tu\7\16\2\2u\177\b\n\1\2vw\7\17\2\2w\177\b\n\1\2xy\7\20\2"+
		"\2y\177\b\n\1\2z{\7\21\2\2{\177\b\n\1\2|}\7\22\2\2}\177\b\n\1\2~r\3\2"+
		"\2\2~t\3\2\2\2~v\3\2\2\2~x\3\2\2\2~z\3\2\2\2~|\3\2\2\2\177\23\3\2\2\2"+
		"\u0080\u0081\7\3\2\2\u0081\u008d\b\13\1\2\u0082\u0083\7\4\2\2\u0083\u008d"+
		"\b\13\1\2\u0084\u0085\7\5\2\2\u0085\u008d\b\13\1\2\u0086\u0087\7\6\2\2"+
		"\u0087\u008d\b\13\1\2\u0088\u0089\7\7\2\2\u0089\u008d\b\13\1\2\u008a\u008b"+
		"\7\b\2\2\u008b\u008d\b\13\1\2\u008c\u0080\3\2\2\2\u008c\u0082\3\2\2\2"+
		"\u008c\u0084\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\25\3\2\2\2\13!9?G]hp~\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}