// Generated from /home/martin/Desktop/Master1-GL/Compilation/AnalyseSyntaxique/ANTLRPP.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ANTLRPPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Integer=3, Bool=4, Number=5, Alphabet=6, WS=7;
	public static final int
		RULE_atomExpr = 0, RULE_type = 1, RULE_array = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"atomExpr", "type", "array"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'array of'", "'integer'", "'boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Integer", "Bool", "Number", "Alphabet", "WS"
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
	public String getGrammarFileName() { return "ANTLRPP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ANTLRPPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AtomExprContext extends ParserRuleContext {
		public PPExpre value;
		public Token c;
		public Token r1;
		public AtomExprContext r2;
		public TerminalNode Number() { return getToken(ANTLRPPParser.Number, 0); }
		public TerminalNode Alphabet() { return getToken(ANTLRPPParser.Alphabet, 0); }
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_atomExpr);
		try {
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				((AtomExprContext)_localctx).c = match(Number);
				 ((AtomExprContext)_localctx).value =  new PPcte(Integer.parseInt((((AtomExprContext)_localctx).c!=null?((AtomExprContext)_localctx).c.getText():null))); 
				}
				break;
			case Alphabet:
				enterOuterAlt(_localctx, 2);
				{
				setState(8);
				((AtomExprContext)_localctx).r1 = match(Alphabet);
				 ((AtomExprContext)_localctx).value =  new PPVar((((AtomExprContext)_localctx).r1!=null?((AtomExprContext)_localctx).r1.getText():null)); 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(10);
				match(T__0);
				setState(11);
				((AtomExprContext)_localctx).r2 = atomExpr();
				 ((AtomExprContext)_localctx).value =  new PPInv((((AtomExprContext)_localctx).r2!=null?_input.getText(((AtomExprContext)_localctx).r2.start,((AtomExprContext)_localctx).r2.stop):null)); 
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(ANTLRPPParser.Integer, 0); }
		public TerminalNode Bool() { return getToken(ANTLRPPParser.Bool, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(Integer);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(Bool);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
				array();
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

	public static class ArrayContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__1);
			setState(22);
			type();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t\33\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\3\3\3\3\3\5"+
		"\3\26\n\3\3\4\3\4\3\4\3\4\2\2\5\2\4\6\2\2\2\33\2\20\3\2\2\2\4\25\3\2\2"+
		"\2\6\27\3\2\2\2\b\t\7\7\2\2\t\21\b\2\1\2\n\13\7\b\2\2\13\21\b\2\1\2\f"+
		"\r\7\3\2\2\r\16\5\2\2\2\16\17\b\2\1\2\17\21\3\2\2\2\20\b\3\2\2\2\20\n"+
		"\3\2\2\2\20\f\3\2\2\2\21\3\3\2\2\2\22\26\7\5\2\2\23\26\7\6\2\2\24\26\5"+
		"\6\4\2\25\22\3\2\2\2\25\23\3\2\2\2\25\24\3\2\2\2\26\5\3\2\2\2\27\30\7"+
		"\4\2\2\30\31\5\4\3\2\31\7\3\2\2\2\4\20\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}