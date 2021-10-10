// Generated from /home/martin/Desktop/Master1-GL/Compilation/AnalyseSyntaxique/newTest/newTest.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class newTestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, VarFormat=36, Alphabet=37, Number=38, 
		WS=39;
	public static final int
		RULE_evaluableExpr = 0, RULE_atomExpr = 1, RULE_unOpExpr = 2, RULE_typeExpr = 3, 
		RULE_binOpExpr = 4, RULE_calleeExpr = 5, RULE_listExpr = 6, RULE_funCallExpr = 7, 
		RULE_insExpr = 8, RULE_pairExpr = 9, RULE_pairArrayExpr = 10, RULE_funcExpr = 11, 
		RULE_listDefExpr = 12, RULE_progExpr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"evaluableExpr", "atomExpr", "unOpExpr", "typeExpr", "binOpExpr", "calleeExpr", 
			"listExpr", "funCallExpr", "insExpr", "pairExpr", "pairArrayExpr", "funcExpr", 
			"listDefExpr", "progExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'-'", "'not'", "'integer'", "'bool'", "'array of '", 
			"'+'", "'*'", "'/'", "'AND'", "'OR'", "'<'", "'<='", "'='", "'!='", "'>='", 
			"'>'", "'Read'", "'Write'", "'('", "')'", "'['", "']'", "'new array of '", 
			"':='", "'if'", "'then'", "'else'", "'While'", "'do'", "'skip'", "';'", 
			"':'", "'var'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"VarFormat", "Alphabet", "Number", "WS"
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
	public String getGrammarFileName() { return "newTest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public newTestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class EvaluableExprContext extends ParserRuleContext {
		public PPExpr value;
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public BinOpExprContext binOpExpr() {
			return getRuleContext(BinOpExprContext.class,0);
		}
		public EvaluableExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluableExpr; }
	}

	public final EvaluableExprContext evaluableExpr() throws RecognitionException {
		EvaluableExprContext _localctx = new EvaluableExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_evaluableExpr);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				atomExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				binOpExpr();
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

	public static class AtomExprContext extends ParserRuleContext {
		public PPExpr value;
		public Token x;
		public TerminalNode Number() { return getToken(newTestParser.Number, 0); }
		public TerminalNode VarFormat() { return getToken(newTestParser.VarFormat, 0); }
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atomExpr);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				((AtomExprContext)_localctx).x = match(Number);
				 ((AtomExprContext)_localctx).value =  new PPCte(Integer.parseInt((((AtomExprContext)_localctx).x!=null?((AtomExprContext)_localctx).x.getText():null)));
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(T__0);
				 ((AtomExprContext)_localctx).value =  new PPTrue(); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				match(T__1);
				 ((AtomExprContext)_localctx).value =  new PPFalse(); 
				}
				break;
			case VarFormat:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				((AtomExprContext)_localctx).x = match(VarFormat);
				 ((AtomExprContext)_localctx).value =  new PPVar((((AtomExprContext)_localctx).x!=null?((AtomExprContext)_localctx).x.getText():null));
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

	public static class UnOpExprContext extends ParserRuleContext {
		public PPUnOp value;
		public AtomExprContext a;
		public AtomExprContext c;
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public UnOpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOpExpr; }
	}

	public final UnOpExprContext unOpExpr() throws RecognitionException {
		UnOpExprContext _localctx = new UnOpExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unOpExpr);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__2);
				setState(44);
				((UnOpExprContext)_localctx).a = atomExpr();
				 ((UnOpExprContext)_localctx).value =  new PPInv(((UnOpExprContext)_localctx).a.value); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(T__3);
				setState(48);
				((UnOpExprContext)_localctx).c = atomExpr();
				 ((UnOpExprContext)_localctx).value =  new PPNot(((UnOpExprContext)_localctx).c.value); 
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

	public static class TypeExprContext extends ParserRuleContext {
		public Type value;
		public TypeExprContext z;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TypeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeExpr; }
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeExpr);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__4);
				 ((TypeExprContext)_localctx).value =  new Int(); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(T__5);
				 ((TypeExprContext)_localctx).value =  new Bool(); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(T__6);
				setState(58);
				((TypeExprContext)_localctx).z = typeExpr();
				 ((TypeExprContext)_localctx).value =  new Array(((TypeExprContext)_localctx).z.value); 
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

	public static class BinOpExprContext extends ParserRuleContext {
		public PPBinOp value;
		public AtomExprContext e1;
		public AtomExprContext e2;
		public AtomExprContext e3;
		public AtomExprContext e4;
		public AtomExprContext e5;
		public AtomExprContext e6;
		public AtomExprContext e7;
		public AtomExprContext e8;
		public AtomExprContext e9;
		public AtomExprContext e10;
		public AtomExprContext e11;
		public AtomExprContext e12;
		public AtomExprContext e13;
		public AtomExprContext e14;
		public AtomExprContext e15;
		public AtomExprContext e16;
		public AtomExprContext e17;
		public AtomExprContext e18;
		public AtomExprContext e19;
		public AtomExprContext e20;
		public AtomExprContext e21;
		public AtomExprContext e22;
		public AtomExprContext e23;
		public AtomExprContext e24;
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public BinOpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOpExpr; }
	}

	public final BinOpExprContext binOpExpr() throws RecognitionException {
		BinOpExprContext _localctx = new BinOpExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_binOpExpr);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				((BinOpExprContext)_localctx).e1 = atomExpr();
				setState(64);
				match(T__7);
				setState(65);
				((BinOpExprContext)_localctx).e2 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPAdd(((BinOpExprContext)_localctx).e1.value, ((BinOpExprContext)_localctx).e2.value); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((BinOpExprContext)_localctx).e3 = atomExpr();
				setState(69);
				match(T__2);
				setState(70);
				((BinOpExprContext)_localctx).e4 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPSub(((BinOpExprContext)_localctx).e3.value, ((BinOpExprContext)_localctx).e4.value); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				((BinOpExprContext)_localctx).e5 = atomExpr();
				setState(74);
				match(T__8);
				setState(75);
				((BinOpExprContext)_localctx).e6 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPMul(((BinOpExprContext)_localctx).e5.value, ((BinOpExprContext)_localctx).e6.value); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				((BinOpExprContext)_localctx).e7 = atomExpr();
				setState(79);
				match(T__9);
				setState(80);
				((BinOpExprContext)_localctx).e8 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPDiv(((BinOpExprContext)_localctx).e7.value, ((BinOpExprContext)_localctx).e8.value); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				((BinOpExprContext)_localctx).e9 = atomExpr();
				setState(84);
				match(T__10);
				setState(85);
				((BinOpExprContext)_localctx).e10 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPAnd(((BinOpExprContext)_localctx).e9.value, ((BinOpExprContext)_localctx).e10.value); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				((BinOpExprContext)_localctx).e11 = atomExpr();
				setState(89);
				match(T__11);
				setState(90);
				((BinOpExprContext)_localctx).e12 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPOr(((BinOpExprContext)_localctx).e11.value, ((BinOpExprContext)_localctx).e12.value); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				((BinOpExprContext)_localctx).e13 = atomExpr();
				setState(94);
				match(T__12);
				setState(95);
				((BinOpExprContext)_localctx).e14 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPLt(((BinOpExprContext)_localctx).e13.value, ((BinOpExprContext)_localctx).e14.value); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(98);
				((BinOpExprContext)_localctx).e15 = atomExpr();
				setState(99);
				match(T__13);
				setState(100);
				((BinOpExprContext)_localctx).e16 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPLe(((BinOpExprContext)_localctx).e15.value, ((BinOpExprContext)_localctx).e16.value); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(103);
				((BinOpExprContext)_localctx).e17 = atomExpr();
				setState(104);
				match(T__14);
				setState(105);
				((BinOpExprContext)_localctx).e18 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPEq(((BinOpExprContext)_localctx).e17.value, ((BinOpExprContext)_localctx).e18.value); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(108);
				((BinOpExprContext)_localctx).e19 = atomExpr();
				setState(109);
				match(T__15);
				setState(110);
				((BinOpExprContext)_localctx).e20 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPNe(((BinOpExprContext)_localctx).e19.value, ((BinOpExprContext)_localctx).e20.value); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(113);
				((BinOpExprContext)_localctx).e21 = atomExpr();
				setState(114);
				match(T__16);
				setState(115);
				((BinOpExprContext)_localctx).e22 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPGe(((BinOpExprContext)_localctx).e21.value, ((BinOpExprContext)_localctx).e22.value); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(118);
				((BinOpExprContext)_localctx).e23 = atomExpr();
				setState(119);
				match(T__17);
				setState(120);
				((BinOpExprContext)_localctx).e24 = atomExpr();
				 ((BinOpExprContext)_localctx).value =  new PPGt(((BinOpExprContext)_localctx).e23.value, ((BinOpExprContext)_localctx).e24.value); 
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

	public static class CalleeExprContext extends ParserRuleContext {
		public Callee value;
		public Token x;
		public TerminalNode VarFormat() { return getToken(newTestParser.VarFormat, 0); }
		public CalleeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calleeExpr; }
	}

	public final CalleeExprContext calleeExpr() throws RecognitionException {
		CalleeExprContext _localctx = new CalleeExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_calleeExpr);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(T__18);
				 ((CalleeExprContext)_localctx).value =  new Read(); 
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(T__19);
				 ((CalleeExprContext)_localctx).value =  new Write(); 
				}
				break;
			case VarFormat:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				((CalleeExprContext)_localctx).x = match(VarFormat);
				 ((CalleeExprContext)_localctx).value =  new User((((CalleeExprContext)_localctx).x!=null?((CalleeExprContext)_localctx).x.getText():null)); 
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

	public static class ListExprContext extends ParserRuleContext {
		public ArrayList<PPExpr> value;
		public AtomExprContext e;
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public ListExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpr; }
	}

	public final ListExprContext listExpr() throws RecognitionException {
		ListExprContext _localctx = new ListExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listExpr);
		((ListExprContext)_localctx).value =  new ArrayList<PPExpr>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				((ListExprContext)_localctx).e = atomExpr();
				_localctx.value.add(((ListExprContext)_localctx).e.value);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << VarFormat) | (1L << Number))) != 0) );
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

	public static class FunCallExprContext extends ParserRuleContext {
		public PPExpr value;
		public CalleeExprContext a;
		public ListExprContext b;
		public AtomExprContext x;
		public AtomExprContext y;
		public TypeExprContext t8;
		public AtomExprContext t9;
		public CalleeExprContext calleeExpr() {
			return getRuleContext(CalleeExprContext.class,0);
		}
		public ListExprContext listExpr() {
			return getRuleContext(ListExprContext.class,0);
		}
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public FunCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCallExpr; }
	}

	public final FunCallExprContext funCallExpr() throws RecognitionException {
		FunCallExprContext _localctx = new FunCallExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funCallExpr);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				((FunCallExprContext)_localctx).a = calleeExpr();
				setState(141);
				match(T__20);
				setState(142);
				((FunCallExprContext)_localctx).b = listExpr();
				setState(143);
				match(T__21);
				 ((FunCallExprContext)_localctx).value =  new PPFunCall(((FunCallExprContext)_localctx).a.value,((FunCallExprContext)_localctx).b.value);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				((FunCallExprContext)_localctx).x = atomExpr();
				setState(147);
				match(T__22);
				setState(148);
				((FunCallExprContext)_localctx).y = atomExpr();
				setState(149);
				match(T__23);
				 ((FunCallExprContext)_localctx).value =  new PPArrayGet(((FunCallExprContext)_localctx).x.value,((FunCallExprContext)_localctx).y.value);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(T__24);
				setState(153);
				((FunCallExprContext)_localctx).t8 = typeExpr();
				setState(154);
				match(T__22);
				setState(155);
				((FunCallExprContext)_localctx).t9 = atomExpr();
				setState(156);
				match(T__23);
				 ((FunCallExprContext)_localctx).value =  new PPArrayAlloc(((FunCallExprContext)_localctx).t8.value, ((FunCallExprContext)_localctx).t9.value );
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

	public static class InsExprContext extends ParserRuleContext {
		public PPInst value;
		public InsExprContext e16;
		public Token e1;
		public AtomExprContext e2;
		public AtomExprContext e11;
		public AtomExprContext e12;
		public AtomExprContext e13;
		public EvaluableExprContext e6;
		public InsExprContext e7;
		public InsExprContext e8;
		public EvaluableExprContext e9;
		public InsExprContext e10;
		public CalleeExprContext e14;
		public ListExprContext e15;
		public InsExprContext e17;
		public TerminalNode VarFormat() { return getToken(newTestParser.VarFormat, 0); }
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public EvaluableExprContext evaluableExpr() {
			return getRuleContext(EvaluableExprContext.class,0);
		}
		public List<InsExprContext> insExpr() {
			return getRuleContexts(InsExprContext.class);
		}
		public InsExprContext insExpr(int i) {
			return getRuleContext(InsExprContext.class,i);
		}
		public CalleeExprContext calleeExpr() {
			return getRuleContext(CalleeExprContext.class,0);
		}
		public ListExprContext listExpr() {
			return getRuleContext(ListExprContext.class,0);
		}
		public InsExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insExpr; }
	}

	public final InsExprContext insExpr() throws RecognitionException {
		return insExpr(0);
	}

	private InsExprContext insExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InsExprContext _localctx = new InsExprContext(_ctx, _parentState);
		InsExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_insExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(162);
				((InsExprContext)_localctx).e1 = match(VarFormat);
				setState(163);
				match(T__25);
				setState(164);
				((InsExprContext)_localctx).e2 = atomExpr();
				 ((InsExprContext)_localctx).value =  new PPAssign((((InsExprContext)_localctx).e1!=null?((InsExprContext)_localctx).e1.getText():null), ((InsExprContext)_localctx).e2.value); 
				}
				break;
			case 2:
				{
				setState(167);
				((InsExprContext)_localctx).e11 = atomExpr();
				setState(168);
				match(T__22);
				setState(169);
				((InsExprContext)_localctx).e12 = atomExpr();
				setState(170);
				match(T__23);
				setState(171);
				match(T__25);
				setState(172);
				((InsExprContext)_localctx).e13 = atomExpr();
				 ((InsExprContext)_localctx).value =  new PPArraySet(((InsExprContext)_localctx).e11.value, ((InsExprContext)_localctx).e12.value ,((InsExprContext)_localctx).e13.value);
				}
				break;
			case 3:
				{
				setState(175);
				match(T__26);
				setState(176);
				((InsExprContext)_localctx).e6 = evaluableExpr();
				setState(177);
				match(T__27);
				setState(178);
				((InsExprContext)_localctx).e7 = insExpr(0);
				setState(179);
				match(T__28);
				setState(180);
				((InsExprContext)_localctx).e8 = insExpr(5);
				 ((InsExprContext)_localctx).value =  new PPCond(((InsExprContext)_localctx).e6.value, ((InsExprContext)_localctx).e7.value, ((InsExprContext)_localctx).e8.value); 
				}
				break;
			case 4:
				{
				setState(183);
				match(T__29);
				setState(184);
				((InsExprContext)_localctx).e9 = evaluableExpr();
				setState(185);
				match(T__30);
				setState(186);
				((InsExprContext)_localctx).e10 = insExpr(4);
				 ((InsExprContext)_localctx).value =  new PPWhile(((InsExprContext)_localctx).e9.value, ((InsExprContext)_localctx).e10.value); 
				}
				break;
			case 5:
				{
				setState(189);
				((InsExprContext)_localctx).e14 = calleeExpr();
				setState(190);
				match(T__20);
				setState(191);
				((InsExprContext)_localctx).e15 = listExpr();
				setState(192);
				match(T__21);
				((InsExprContext)_localctx).value =  new PPProcCall(((InsExprContext)_localctx).e14.value, ((InsExprContext)_localctx).e15.value );
				}
				break;
			case 6:
				{
				setState(195);
				match(T__31);
				new PPSkip();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InsExprContext(_parentctx, _parentState);
					_localctx.e16 = _prevctx;
					_localctx.e16 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_insExpr);
					setState(199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(200);
					match(T__32);
					setState(201);
					((InsExprContext)_localctx).e17 = insExpr(2);
					((InsExprContext)_localctx).value =  new PPSeq(((InsExprContext)_localctx).e16.value, ((InsExprContext)_localctx).e17.value );
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PairExprContext extends ParserRuleContext {
		public Pair<String,Type> value;
		public Token c;
		public TypeExprContext d;
		public TerminalNode VarFormat() { return getToken(newTestParser.VarFormat, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public PairExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairExpr; }
	}

	public final PairExprContext pairExpr() throws RecognitionException {
		PairExprContext _localctx = new PairExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pairExpr);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VarFormat:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				((PairExprContext)_localctx).c = match(VarFormat);
				setState(210);
				match(T__33);
				setState(211);
				((PairExprContext)_localctx).d = typeExpr();
				 ((PairExprContext)_localctx).value =  new Pair((((PairExprContext)_localctx).c!=null?((PairExprContext)_localctx).c.getText():null), ((PairExprContext)_localctx).d.value); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__34);
				setState(215);
				((PairExprContext)_localctx).c = match(VarFormat);
				setState(216);
				match(T__33);
				setState(217);
				((PairExprContext)_localctx).d = typeExpr();
				 ((PairExprContext)_localctx).value =  new Pair((((PairExprContext)_localctx).c!=null?((PairExprContext)_localctx).c.getText():null), ((PairExprContext)_localctx).d.value); 
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

	public static class PairArrayExprContext extends ParserRuleContext {
		public ArrayList <Pair<String,Type>> value;
		public PairExprContext e;
		public List<PairExprContext> pairExpr() {
			return getRuleContexts(PairExprContext.class);
		}
		public PairExprContext pairExpr(int i) {
			return getRuleContext(PairExprContext.class,i);
		}
		public PairArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairArrayExpr; }
	}

	public final PairArrayExprContext pairArrayExpr() throws RecognitionException {
		PairArrayExprContext _localctx = new PairArrayExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pairArrayExpr);
		 ((PairArrayExprContext)_localctx).value =  new ArrayList<Pair<String,Type>>() ;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(222);
					((PairArrayExprContext)_localctx).e = pairExpr();
					_localctx.value.add(((PairArrayExprContext)_localctx).e.value);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class FuncExprContext extends ParserRuleContext {
		public PPDef value;
		public Token e1;
		public PairArrayExprContext e2;
		public TypeExprContext e5;
		public PairArrayExprContext e3;
		public InsExprContext e4;
		public List<TerminalNode> VarFormat() { return getTokens(newTestParser.VarFormat); }
		public TerminalNode VarFormat(int i) {
			return getToken(newTestParser.VarFormat, i);
		}
		public List<PairArrayExprContext> pairArrayExpr() {
			return getRuleContexts(PairArrayExprContext.class);
		}
		public PairArrayExprContext pairArrayExpr(int i) {
			return getRuleContext(PairArrayExprContext.class,i);
		}
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<InsExprContext> insExpr() {
			return getRuleContexts(InsExprContext.class);
		}
		public InsExprContext insExpr(int i) {
			return getRuleContext(InsExprContext.class,i);
		}
		public FuncExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcExpr; }
	}

	public final FuncExprContext funcExpr() throws RecognitionException {
		FuncExprContext _localctx = new FuncExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((FuncExprContext)_localctx).e1 = match(VarFormat);
			setState(231);
			match(T__20);
			setState(232);
			((FuncExprContext)_localctx).e2 = pairArrayExpr();
			setState(233);
			match(T__21);
			setState(234);
			match(T__33);
			setState(235);
			((FuncExprContext)_localctx).e5 = typeExpr();
			setState(236);
			((FuncExprContext)_localctx).e3 = pairArrayExpr();
			setState(237);
			((FuncExprContext)_localctx).e4 = insExpr(0);
			 ((FuncExprContext)_localctx).value =  new PPFun((((FuncExprContext)_localctx).e1!=null?((FuncExprContext)_localctx).e1.getText():null), ((FuncExprContext)_localctx).e2.value ,((FuncExprContext)_localctx).e3.value , ((FuncExprContext)_localctx).e4.value, ((FuncExprContext)_localctx).e5.value ); 
			setState(239);
			((FuncExprContext)_localctx).e1 = match(VarFormat);
			setState(240);
			match(T__20);
			setState(241);
			((FuncExprContext)_localctx).e2 = pairArrayExpr();
			setState(242);
			match(T__21);
			setState(243);
			((FuncExprContext)_localctx).e3 = pairArrayExpr();
			setState(244);
			((FuncExprContext)_localctx).e4 = insExpr(0);
			 ((FuncExprContext)_localctx).value =  new PPProc((((FuncExprContext)_localctx).e1!=null?((FuncExprContext)_localctx).e1.getText():null), ((FuncExprContext)_localctx).e2.value ,((FuncExprContext)_localctx).e3.value ,((FuncExprContext)_localctx).e4.value ); 
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

	public static class ListDefExprContext extends ParserRuleContext {
		public ArrayList <PPDef> value;
		public FuncExprContext e;
		public List<FuncExprContext> funcExpr() {
			return getRuleContexts(FuncExprContext.class);
		}
		public FuncExprContext funcExpr(int i) {
			return getRuleContext(FuncExprContext.class,i);
		}
		public ListDefExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDefExpr; }
	}

	public final ListDefExprContext listDefExpr() throws RecognitionException {
		ListDefExprContext _localctx = new ListDefExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listDefExpr);
		 ((ListDefExprContext)_localctx).value =  new ArrayList<PPDef>() ;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(247);
					((ListDefExprContext)_localctx).e = funcExpr();
					_localctx.value.add(((ListDefExprContext)_localctx).e.value);
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class ProgExprContext extends ParserRuleContext {
		public PPProg value;
		public PairArrayExprContext e1;
		public ListDefExprContext e2;
		public InsExprContext e3;
		public PairArrayExprContext pairArrayExpr() {
			return getRuleContext(PairArrayExprContext.class,0);
		}
		public ListDefExprContext listDefExpr() {
			return getRuleContext(ListDefExprContext.class,0);
		}
		public InsExprContext insExpr() {
			return getRuleContext(InsExprContext.class,0);
		}
		public ProgExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progExpr; }
	}

	public final ProgExprContext progExpr() throws RecognitionException {
		ProgExprContext _localctx = new ProgExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_progExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			((ProgExprContext)_localctx).e1 = pairArrayExpr();
			setState(256);
			((ProgExprContext)_localctx).e2 = listDefExpr();
			setState(257);
			((ProgExprContext)_localctx).e3 = insExpr(0);
			 ((ProgExprContext)_localctx).value =  new PPProg(((ProgExprContext)_localctx).e1.value, ((ProgExprContext)_localctx).e2.value, ((ProgExprContext)_localctx).e3.value); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return insExpr_sempred((InsExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean insExpr_sempred(InsExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0107\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\5\2!\n\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\66"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6~\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0086\n\7\3\b\3\b\3\b\6\b"+
		"\u008b\n\b\r\b\16\b\u008c\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a2\n\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c8\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00cf\n\n\f\n\16\n\u00d2\13\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00df\n\13\3\f\3\f\3\f\7\f\u00e4"+
		"\n\f\f\f\16\f\u00e7\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u00fd\n\16\f\16\16\16\u0100"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\2\3\22\20\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\2\2\2\u0119\2 \3\2\2\2\4*\3\2\2\2\6\65\3\2\2\2\b?\3\2\2\2"+
		"\n}\3\2\2\2\f\u0085\3\2\2\2\16\u008a\3\2\2\2\20\u00a1\3\2\2\2\22\u00c7"+
		"\3\2\2\2\24\u00de\3\2\2\2\26\u00e5\3\2\2\2\30\u00e8\3\2\2\2\32\u00fe\3"+
		"\2\2\2\34\u0101\3\2\2\2\36!\5\4\3\2\37!\5\n\6\2 \36\3\2\2\2 \37\3\2\2"+
		"\2!\3\3\2\2\2\"#\7(\2\2#+\b\3\1\2$%\7\3\2\2%+\b\3\1\2&\'\7\4\2\2\'+\b"+
		"\3\1\2()\7&\2\2)+\b\3\1\2*\"\3\2\2\2*$\3\2\2\2*&\3\2\2\2*(\3\2\2\2+\5"+
		"\3\2\2\2,\66\3\2\2\2-.\7\5\2\2./\5\4\3\2/\60\b\4\1\2\60\66\3\2\2\2\61"+
		"\62\7\6\2\2\62\63\5\4\3\2\63\64\b\4\1\2\64\66\3\2\2\2\65,\3\2\2\2\65-"+
		"\3\2\2\2\65\61\3\2\2\2\66\7\3\2\2\2\678\7\7\2\28@\b\5\1\29:\7\b\2\2:@"+
		"\b\5\1\2;<\7\t\2\2<=\5\b\5\2=>\b\5\1\2>@\3\2\2\2?\67\3\2\2\2?9\3\2\2\2"+
		"?;\3\2\2\2@\t\3\2\2\2AB\5\4\3\2BC\7\n\2\2CD\5\4\3\2DE\b\6\1\2E~\3\2\2"+
		"\2FG\5\4\3\2GH\7\5\2\2HI\5\4\3\2IJ\b\6\1\2J~\3\2\2\2KL\5\4\3\2LM\7\13"+
		"\2\2MN\5\4\3\2NO\b\6\1\2O~\3\2\2\2PQ\5\4\3\2QR\7\f\2\2RS\5\4\3\2ST\b\6"+
		"\1\2T~\3\2\2\2UV\5\4\3\2VW\7\r\2\2WX\5\4\3\2XY\b\6\1\2Y~\3\2\2\2Z[\5\4"+
		"\3\2[\\\7\16\2\2\\]\5\4\3\2]^\b\6\1\2^~\3\2\2\2_`\5\4\3\2`a\7\17\2\2a"+
		"b\5\4\3\2bc\b\6\1\2c~\3\2\2\2de\5\4\3\2ef\7\20\2\2fg\5\4\3\2gh\b\6\1\2"+
		"h~\3\2\2\2ij\5\4\3\2jk\7\21\2\2kl\5\4\3\2lm\b\6\1\2m~\3\2\2\2no\5\4\3"+
		"\2op\7\22\2\2pq\5\4\3\2qr\b\6\1\2r~\3\2\2\2st\5\4\3\2tu\7\23\2\2uv\5\4"+
		"\3\2vw\b\6\1\2w~\3\2\2\2xy\5\4\3\2yz\7\24\2\2z{\5\4\3\2{|\b\6\1\2|~\3"+
		"\2\2\2}A\3\2\2\2}F\3\2\2\2}K\3\2\2\2}P\3\2\2\2}U\3\2\2\2}Z\3\2\2\2}_\3"+
		"\2\2\2}d\3\2\2\2}i\3\2\2\2}n\3\2\2\2}s\3\2\2\2}x\3\2\2\2~\13\3\2\2\2\177"+
		"\u0080\7\25\2\2\u0080\u0086\b\7\1\2\u0081\u0082\7\26\2\2\u0082\u0086\b"+
		"\7\1\2\u0083\u0084\7&\2\2\u0084\u0086\b\7\1\2\u0085\177\3\2\2\2\u0085"+
		"\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086\r\3\2\2\2\u0087\u0088\5\4\3\2"+
		"\u0088\u0089\b\b\1\2\u0089\u008b\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\17\3\2\2\2\u008e"+
		"\u008f\5\f\7\2\u008f\u0090\7\27\2\2\u0090\u0091\5\16\b\2\u0091\u0092\7"+
		"\30\2\2\u0092\u0093\b\t\1\2\u0093\u00a2\3\2\2\2\u0094\u0095\5\4\3\2\u0095"+
		"\u0096\7\31\2\2\u0096\u0097\5\4\3\2\u0097\u0098\7\32\2\2\u0098\u0099\b"+
		"\t\1\2\u0099\u00a2\3\2\2\2\u009a\u009b\7\33\2\2\u009b\u009c\5\b\5\2\u009c"+
		"\u009d\7\31\2\2\u009d\u009e\5\4\3\2\u009e\u009f\7\32\2\2\u009f\u00a0\b"+
		"\t\1\2\u00a0\u00a2\3\2\2\2\u00a1\u008e\3\2\2\2\u00a1\u0094\3\2\2\2\u00a1"+
		"\u009a\3\2\2\2\u00a2\21\3\2\2\2\u00a3\u00a4\b\n\1\2\u00a4\u00a5\7&\2\2"+
		"\u00a5\u00a6\7\34\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8\b\n\1\2\u00a8\u00c8"+
		"\3\2\2\2\u00a9\u00aa\5\4\3\2\u00aa\u00ab\7\31\2\2\u00ab\u00ac\5\4\3\2"+
		"\u00ac\u00ad\7\32\2\2\u00ad\u00ae\7\34\2\2\u00ae\u00af\5\4\3\2\u00af\u00b0"+
		"\b\n\1\2\u00b0\u00c8\3\2\2\2\u00b1\u00b2\7\35\2\2\u00b2\u00b3\5\2\2\2"+
		"\u00b3\u00b4\7\36\2\2\u00b4\u00b5\5\22\n\2\u00b5\u00b6\7\37\2\2\u00b6"+
		"\u00b7\5\22\n\7\u00b7\u00b8\b\n\1\2\u00b8\u00c8\3\2\2\2\u00b9\u00ba\7"+
		" \2\2\u00ba\u00bb\5\2\2\2\u00bb\u00bc\7!\2\2\u00bc\u00bd\5\22\n\6\u00bd"+
		"\u00be\b\n\1\2\u00be\u00c8\3\2\2\2\u00bf\u00c0\5\f\7\2\u00c0\u00c1\7\27"+
		"\2\2\u00c1\u00c2\5\16\b\2\u00c2\u00c3\7\30\2\2\u00c3\u00c4\b\n\1\2\u00c4"+
		"\u00c8\3\2\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c8\b\n\1\2\u00c7\u00a3\3\2"+
		"\2\2\u00c7\u00a9\3\2\2\2\u00c7\u00b1\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7"+
		"\u00bf\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00d0\3\2\2\2\u00c9\u00ca\f\3"+
		"\2\2\u00ca\u00cb\7#\2\2\u00cb\u00cc\5\22\n\4\u00cc\u00cd\b\n\1\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00c9\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1\23\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4"+
		"\7&\2\2\u00d4\u00d5\7$\2\2\u00d5\u00d6\5\b\5\2\u00d6\u00d7\b\13\1\2\u00d7"+
		"\u00df\3\2\2\2\u00d8\u00d9\7%\2\2\u00d9\u00da\7&\2\2\u00da\u00db\7$\2"+
		"\2\u00db\u00dc\5\b\5\2\u00dc\u00dd\b\13\1\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00d3\3\2\2\2\u00de\u00d8\3\2\2\2\u00df\25\3\2\2\2\u00e0\u00e1\5\24\13"+
		"\2\u00e1\u00e2\b\f\1\2\u00e2\u00e4\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\27\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00e9\7&\2\2\u00e9\u00ea\7\27\2\2\u00ea\u00eb\5\26"+
		"\f\2\u00eb\u00ec\7\30\2\2\u00ec\u00ed\7$\2\2\u00ed\u00ee\5\b\5\2\u00ee"+
		"\u00ef\5\26\f\2\u00ef\u00f0\5\22\n\2\u00f0\u00f1\b\r\1\2\u00f1\u00f2\7"+
		"&\2\2\u00f2\u00f3\7\27\2\2\u00f3\u00f4\5\26\f\2\u00f4\u00f5\7\30\2\2\u00f5"+
		"\u00f6\5\26\f\2\u00f6\u00f7\5\22\n\2\u00f7\u00f8\b\r\1\2\u00f8\31\3\2"+
		"\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fb\b\16\1\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00f9\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\33\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\5\26\f\2\u0102\u0103"+
		"\5\32\16\2\u0103\u0104\5\22\n\2\u0104\u0105\b\17\1\2\u0105\35\3\2\2\2"+
		"\17 *\65?}\u0085\u008c\u00a1\u00c7\u00d0\u00de\u00e5\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}