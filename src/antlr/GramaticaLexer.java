// Generated from Gramatica.g4 by ANTLR 4.10.1

    package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TIPO=5, ID=6, WS=7, NUM=8, STRING=9, OPERADOR=10, 
		COMPARADOR=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "TIPO", "ID", "WS", "NUM", "STRING", 
			"OPERADOR", "COMPARADOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':DECLARACAO'", "':ALGORITMO'", "'ATRIBUIR'", "'A'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "TIPO", "ID", "WS", "NUM", "STRING", "OPERADOR", 
			"COMPARADOR"
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


	public GramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

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
		"\u0004\u0000\u000b\u0084\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004L\b\u0004\u0001"+
		"\u0005\u0004\u0005O\b\u0005\u000b\u0005\f\u0005P\u0001\u0005\u0005\u0005"+
		"T\b\u0005\n\u0005\f\u0005W\t\u0005\u0001\u0006\u0005\u0006Z\b\u0006\n"+
		"\u0006\f\u0006]\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007"+
		"b\b\u0007\u000b\u0007\f\u0007c\u0001\u0007\u0001\u0007\u0004\u0007h\b"+
		"\u0007\u000b\u0007\f\u0007i\u0003\u0007l\b\u0007\u0001\b\u0001\b\u0005"+
		"\bp\b\b\n\b\f\bs\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0083"+
		"\b\n\u0000\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001"+
		"\u0000\u0006\u0002\u0000AZaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  \u0001"+
		"\u000009\u0001\u0000\"\"\u0003\u0000*+--//\u0092\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0001\u0017\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005"+
		".\u0001\u0000\u0000\u0000\u00077\u0001\u0000\u0000\u0000\tK\u0001\u0000"+
		"\u0000\u0000\u000bN\u0001\u0000\u0000\u0000\r[\u0001\u0000\u0000\u0000"+
		"\u000fa\u0001\u0000\u0000\u0000\u0011m\u0001\u0000\u0000\u0000\u0013v"+
		"\u0001\u0000\u0000\u0000\u0015\u0082\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0005:\u0000\u0000\u0018\u0019\u0005D\u0000\u0000\u0019\u001a\u0005E"+
		"\u0000\u0000\u001a\u001b\u0005C\u0000\u0000\u001b\u001c\u0005L\u0000\u0000"+
		"\u001c\u001d\u0005A\u0000\u0000\u001d\u001e\u0005R\u0000\u0000\u001e\u001f"+
		"\u0005A\u0000\u0000\u001f \u0005C\u0000\u0000 !\u0005A\u0000\u0000!\""+
		"\u0005O\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005:\u0000\u0000"+
		"$%\u0005A\u0000\u0000%&\u0005L\u0000\u0000&\'\u0005G\u0000\u0000\'(\u0005"+
		"O\u0000\u0000()\u0005R\u0000\u0000)*\u0005I\u0000\u0000*+\u0005T\u0000"+
		"\u0000+,\u0005M\u0000\u0000,-\u0005O\u0000\u0000-\u0004\u0001\u0000\u0000"+
		"\u0000./\u0005A\u0000\u0000/0\u0005T\u0000\u000001\u0005R\u0000\u0000"+
		"12\u0005I\u0000\u000023\u0005B\u0000\u000034\u0005U\u0000\u000045\u0005"+
		"I\u0000\u000056\u0005R\u0000\u00006\u0006\u0001\u0000\u0000\u000078\u0005"+
		"A\u0000\u00008\b\u0001\u0000\u0000\u00009:\u0005i\u0000\u0000:;\u0005"+
		"n\u0000\u0000;L\u0005t\u0000\u0000<=\u0005f\u0000\u0000=>\u0005l\u0000"+
		"\u0000>?\u0005o\u0000\u0000?@\u0005a\u0000\u0000@L\u0005t\u0000\u0000"+
		"AB\u0005s\u0000\u0000BC\u0005t\u0000\u0000CD\u0005r\u0000\u0000DE\u0005"+
		"i\u0000\u0000EF\u0005n\u0000\u0000FL\u0005g\u0000\u0000GH\u0005B\u0000"+
		"\u0000HI\u0005o\u0000\u0000IJ\u0005o\u0000\u0000JL\u0005l\u0000\u0000"+
		"K9\u0001\u0000\u0000\u0000K<\u0001\u0000\u0000\u0000KA\u0001\u0000\u0000"+
		"\u0000KG\u0001\u0000\u0000\u0000L\n\u0001\u0000\u0000\u0000MO\u0007\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QU\u0001\u0000\u0000\u0000"+
		"RT\u0007\u0001\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\f\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000XZ\u0007\u0002\u0000\u0000YX\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^_\u0006\u0006\u0000\u0000_\u000e\u0001\u0000\u0000\u0000`b\u0007"+
		"\u0003\u0000\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000dk\u0001\u0000\u0000"+
		"\u0000eg\u0005,\u0000\u0000fh\u0007\u0003\u0000\u0000gf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jl\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000l\u0010\u0001\u0000\u0000\u0000mq\u0005\"\u0000\u0000"+
		"np\b\u0004\u0000\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tu\u0005\"\u0000\u0000u\u0012\u0001\u0000"+
		"\u0000\u0000vw\u0007\u0005\u0000\u0000w\u0014\u0001\u0000\u0000\u0000"+
		"x\u0083\u0005>\u0000\u0000yz\u0005>\u0000\u0000z\u0083\u0005=\u0000\u0000"+
		"{\u0083\u0005<\u0000\u0000|}\u0005<\u0000\u0000}\u0083\u0005=\u0000\u0000"+
		"~\u007f\u0005=\u0000\u0000\u007f\u0083\u0005=\u0000\u0000\u0080\u0081"+
		"\u0005!\u0000\u0000\u0081\u0083\u0005=\u0000\u0000\u0082x\u0001\u0000"+
		"\u0000\u0000\u0082y\u0001\u0000\u0000\u0000\u0082{\u0001\u0000\u0000\u0000"+
		"\u0082|\u0001\u0000\u0000\u0000\u0082~\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0083\u0016\u0001\u0000\u0000\u0000\f\u0000K"+
		"NPSU[cikq\u0082\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}