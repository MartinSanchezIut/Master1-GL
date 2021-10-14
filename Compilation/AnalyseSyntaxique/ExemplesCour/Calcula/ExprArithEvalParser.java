// Generated from ExprArithEval.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprArithEvalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Number=7, WS=8;
	public static final int
		RULE_expr = 0, RULE_additionExpr = 1, RULE_multiplyExpr = 2, RULE_atomExpr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "additionExpr", "multiplyExpr", "atomExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Number", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "ExprArithEval.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprArithEvalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public int value;
		public AdditionExprContext e;
		public AdditionExprContext additionExpr() {
			return getRuleContext(AdditionExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			((ExprContext)_localctx).e = additionExpr();
			((ExprContext)_localctx).value =  ((ExprContext)_localctx).e.value;
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

	public static class AdditionExprContext extends ParserRuleContext {
		public int value;
		public MultiplyExprContext e1;
		public MultiplyExprContext e2;
		public List<MultiplyExprContext> multiplyExpr() {
			return getRuleContexts(MultiplyExprContext.class);
		}
		public MultiplyExprContext multiplyExpr(int i) {
			return getRuleContext(MultiplyExprContext.class,i);
		}
		public AdditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).enterAdditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).exitAdditionExpr(this);
		}
	}

	public final AdditionExprContext additionExpr() throws RecognitionException {
		AdditionExprContext _localctx = new AdditionExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_additionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			((AdditionExprContext)_localctx).e1 = multiplyExpr();
			((AdditionExprContext)_localctx).value =  ((AdditionExprContext)_localctx).e1.value;
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				setState(21);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(13);
					match(T__0);
					setState(14);
					((AdditionExprContext)_localctx).e2 = multiplyExpr();
					_localctx.value += ((AdditionExprContext)_localctx).e2.value;
					}
					break;
				case T__1:
					{
					setState(17);
					match(T__1);
					setState(18);
					((AdditionExprContext)_localctx).e2 = multiplyExpr();
					_localctx.value -= ((AdditionExprContext)_localctx).e2.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(25);
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

	public static class MultiplyExprContext extends ParserRuleContext {
		public int value;
		public AtomExprContext e1;
		public AtomExprContext e2;
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public MultiplyExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).enterMultiplyExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).exitMultiplyExpr(this);
		}
	}

	public final MultiplyExprContext multiplyExpr() throws RecognitionException {
		MultiplyExprContext _localctx = new MultiplyExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiplyExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((MultiplyExprContext)_localctx).e1 = atomExpr();
			((MultiplyExprContext)_localctx).value =  ((MultiplyExprContext)_localctx).e1.value;
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(28);
					match(T__2);
					setState(29);
					((MultiplyExprContext)_localctx).e2 = atomExpr();
					_localctx.value *= ((MultiplyExprContext)_localctx).e2.value;
					}
					break;
				case T__3:
					{
					setState(32);
					match(T__3);
					setState(33);
					((MultiplyExprContext)_localctx).e2 = atomExpr();
					_localctx.value /= ((MultiplyExprContext)_localctx).e2.value; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
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

	public static class AtomExprContext extends ParserRuleContext {
		public int value;
		public Token c;
		public AdditionExprContext e1;
		public AtomExprContext e2;
		public TerminalNode Number() { return getToken(ExprArithEvalParser.Number, 0); }
		public AdditionExprContext additionExpr() {
			return getRuleContext(AdditionExprContext.class,0);
		}
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprArithEvalListener ) ((ExprArithEvalListener)listener).exitAtomExpr(this);
		}
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atomExpr);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				((AtomExprContext)_localctx).c = match(Number);
				((AtomExprContext)_localctx).value =  Integer.parseInt((((AtomExprContext)_localctx).c!=null?((AtomExprContext)_localctx).c.getText():null));
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__4);
				setState(44);
				((AtomExprContext)_localctx).e1 = additionExpr();
				setState(45);
				match(T__5);
				((AtomExprContext)_localctx).value =  ((AtomExprContext)_localctx).e1.value;
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(T__1);
				setState(49);
				((AtomExprContext)_localctx).e2 = atomExpr();
				((AtomExprContext)_localctx).value =  -((AtomExprContext)_localctx).e2.value;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n9\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\30\n\3\f\3\16\3\33\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\'\n\4\f\4\16\4*\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\67\n\5\3\5\2\2\6\2\4\6\b\2\2\2:\2\n\3\2\2\2\4\r\3\2\2\2\6\34\3\2\2"+
		"\2\b\66\3\2\2\2\n\13\5\4\3\2\13\f\b\2\1\2\f\3\3\2\2\2\r\16\5\6\4\2\16"+
		"\31\b\3\1\2\17\20\7\3\2\2\20\21\5\6\4\2\21\22\b\3\1\2\22\30\3\2\2\2\23"+
		"\24\7\4\2\2\24\25\5\6\4\2\25\26\b\3\1\2\26\30\3\2\2\2\27\17\3\2\2\2\27"+
		"\23\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33"+
		"\31\3\2\2\2\34\35\5\b\5\2\35(\b\4\1\2\36\37\7\5\2\2\37 \5\b\5\2 !\b\4"+
		"\1\2!\'\3\2\2\2\"#\7\6\2\2#$\5\b\5\2$%\b\4\1\2%\'\3\2\2\2&\36\3\2\2\2"+
		"&\"\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\7\3\2\2\2*(\3\2\2\2+,\7\t"+
		"\2\2,\67\b\5\1\2-.\7\7\2\2./\5\4\3\2/\60\7\b\2\2\60\61\b\5\1\2\61\67\3"+
		"\2\2\2\62\63\7\4\2\2\63\64\5\b\5\2\64\65\b\5\1\2\65\67\3\2\2\2\66+\3\2"+
		"\2\2\66-\3\2\2\2\66\62\3\2\2\2\67\t\3\2\2\2\7\27\31&(\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}