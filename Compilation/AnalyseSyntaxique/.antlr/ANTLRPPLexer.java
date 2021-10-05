// Generated from /home/martin/Desktop/Master1-GL/Compilation/AnalyseSyntaxique/ANTLRPP.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ANTLRPPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Integer=15, Bool=16, 
		Number=17, Alphabet=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "Integer", "Bool", "Number", 
			"Alphabet", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'AND'", "'OR'", "'not'", "'true'", 
			"'false'", "'('", "')'", "'read'", "'write'", "'array of'", "'integer'", 
			"'boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
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


	public ANTLRPPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ANTLRPP.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\6\22"+
		"q\n\22\r\22\16\22r\3\23\3\23\3\23\3\23\6\23y\n\23\r\23\16\23z\3\24\6\24"+
		"~\n\24\r\24\16\24\177\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\3\5\2"+
		"\13\f\17\17\"\"\2\u0085\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2"+
		"\2\7-\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\65\3\2\2\2\178\3\2\2\2\21<\3"+
		"\2\2\2\23A\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33P\3\2\2\2\35"+
		"V\3\2\2\2\37_\3\2\2\2!g\3\2\2\2#p\3\2\2\2%x\3\2\2\2\'}\3\2\2\2)*\7-\2"+
		"\2*\4\3\2\2\2+,\7/\2\2,\6\3\2\2\2-.\7,\2\2.\b\3\2\2\2/\60\7\61\2\2\60"+
		"\n\3\2\2\2\61\62\7C\2\2\62\63\7P\2\2\63\64\7F\2\2\64\f\3\2\2\2\65\66\7"+
		"Q\2\2\66\67\7T\2\2\67\16\3\2\2\289\7p\2\29:\7q\2\2:;\7v\2\2;\20\3\2\2"+
		"\2<=\7v\2\2=>\7t\2\2>?\7w\2\2?@\7g\2\2@\22\3\2\2\2AB\7h\2\2BC\7c\2\2C"+
		"D\7n\2\2DE\7u\2\2EF\7g\2\2F\24\3\2\2\2GH\7*\2\2H\26\3\2\2\2IJ\7+\2\2J"+
		"\30\3\2\2\2KL\7t\2\2LM\7g\2\2MN\7c\2\2NO\7f\2\2O\32\3\2\2\2PQ\7y\2\2Q"+
		"R\7t\2\2RS\7k\2\2ST\7v\2\2TU\7g\2\2U\34\3\2\2\2VW\7c\2\2WX\7t\2\2XY\7"+
		"t\2\2YZ\7c\2\2Z[\7{\2\2[\\\7\"\2\2\\]\7q\2\2]^\7h\2\2^\36\3\2\2\2_`\7"+
		"k\2\2`a\7p\2\2ab\7v\2\2bc\7g\2\2cd\7i\2\2de\7g\2\2ef\7t\2\2f \3\2\2\2"+
		"gh\7d\2\2hi\7q\2\2ij\7q\2\2jk\7n\2\2kl\7g\2\2lm\7c\2\2mn\7p\2\2n\"\3\2"+
		"\2\2oq\4\62;\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s$\3\2\2\2tu\7c"+
		"\2\2uv\7\60\2\2vw\7\60\2\2wy\7|\2\2xt\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3"+
		"\2\2\2{&\3\2\2\2|~\t\2\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\24\2\2\u0082(\3\2\2\2\6\2r"+
		"z\177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}