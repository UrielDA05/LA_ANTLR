// Generated from /home/ur1el/Documentos/Lenguajes y automatas/Proyecto bazilio/Bazilio.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BazilioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INICIO=7, FIN=8, ASIGNA=9, 
		LEE=10, ESCRIBE=11, TOCA=12, AGREGA=13, CORTA=14, LONG=15, MAS=16, MENOS=17, 
		POR=18, ENTRE=19, MODULO=20, IGUAL=21, DISTINTO=22, MENOR=23, MAYOR=24, 
		MENORIGUAL=25, MAYORIGUAL=26, SI=27, SINO=28, MIENTRAS=29, TEXTO=30, ENTERO=31, 
		NOTA=32, PROC_ID=33, VAR=34, COMENTARIO=35, ESPACIOS=36;
	public static final int
		RULE_programa = 0, RULE_procedimiento = 1, RULE_bloque = 2, RULE_instruccion = 3, 
		RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "procedimiento", "bloque", "instruccion", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'('", "')'", "'{'", "'}'", "'|:'", "':|'", "'<-'", 
			"'<?>'", "'<w>'", null, "'<<'", "'8<'", "'#'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'='", "'/='", "'<'", "'>'", "'<='", "'>='", "'if'", "'else'", 
			"'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "INICIO", "FIN", "ASIGNA", 
			"LEE", "ESCRIBE", "TOCA", "AGREGA", "CORTA", "LONG", "MAS", "MENOS", 
			"POR", "ENTRE", "MODULO", "IGUAL", "DISTINTO", "MENOR", "MAYOR", "MENORIGUAL", 
			"MAYORIGUAL", "SI", "SINO", "MIENTRAS", "TEXTO", "ENTERO", "NOTA", "PROC_ID", 
			"VAR", "COMENTARIO", "ESPACIOS"
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
	public String getGrammarFileName() { return "Bazilio.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BazilioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BazilioParser.EOF, 0); }
		public List<ProcedimientoContext> procedimiento() {
			return getRuleContexts(ProcedimientoContext.class);
		}
		public ProcedimientoContext procedimiento(int i) {
			return getRuleContext(ProcedimientoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				procedimiento();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PROC_ID );
			setState(15);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedimientoContext extends ParserRuleContext {
		public TerminalNode PROC_ID() { return getToken(BazilioParser.PROC_ID, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public List<TerminalNode> VAR() { return getTokens(BazilioParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BazilioParser.VAR, i);
		}
		public ProcedimientoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimiento; }
	}

	public final ProcedimientoContext procedimiento() throws RecognitionException {
		ProcedimientoContext _localctx = new ProcedimientoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_procedimiento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(PROC_ID);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(18);
				match(VAR);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			bloque();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(BazilioParser.INICIO, 0); }
		public TerminalNode FIN() { return getToken(BazilioParser.FIN, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(INICIO);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26440915968L) != 0)) {
				{
				{
				setState(27);
				instruccion();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(FIN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IteracionContext extends InstruccionContext {
		public TerminalNode MIENTRAS() { return getToken(BazilioParser.MIENTRAS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public IteracionContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends InstruccionContext {
		public TerminalNode VAR() { return getToken(BazilioParser.VAR, 0); }
		public TerminalNode ASIGNA() { return getToken(BazilioParser.ASIGNA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsignacionContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CorteContext extends InstruccionContext {
		public TerminalNode CORTA() { return getToken(BazilioParser.CORTA, 0); }
		public TerminalNode VAR() { return getToken(BazilioParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CorteContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EscrituraContext extends InstruccionContext {
		public TerminalNode ESCRIBE() { return getToken(BazilioParser.ESCRIBE, 0); }
		public List<TerminalNode> TEXTO() { return getTokens(BazilioParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(BazilioParser.TEXTO, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EscrituraContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LecturaContext extends InstruccionContext {
		public TerminalNode LEE() { return getToken(BazilioParser.LEE, 0); }
		public TerminalNode VAR() { return getToken(BazilioParser.VAR, 0); }
		public LecturaContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AgregadoContext extends InstruccionContext {
		public TerminalNode VAR() { return getToken(BazilioParser.VAR, 0); }
		public TerminalNode AGREGA() { return getToken(BazilioParser.AGREGA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AgregadoContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReproduccionContext extends InstruccionContext {
		public TerminalNode TOCA() { return getToken(BazilioParser.TOCA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReproduccionContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvocacionContext extends InstruccionContext {
		public TerminalNode PROC_ID() { return getToken(BazilioParser.PROC_ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InvocacionContext(InstruccionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalContext extends InstruccionContext {
		public TerminalNode SI() { return getToken(BazilioParser.SI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode SINO() { return getToken(BazilioParser.SINO, 0); }
		public CondicionalContext(InstruccionContext ctx) { copyFrom(ctx); }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruccion);
		int _la;
		try {
			int _alt;
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(VAR);
				setState(36);
				match(ASIGNA);
				setState(37);
				expr(0);
				}
				break;
			case 2:
				_localctx = new LecturaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(LEE);
				setState(39);
				match(VAR);
				}
				break;
			case 3:
				_localctx = new EscrituraContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(ESCRIBE);
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(43);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case TEXTO:
							{
							setState(41);
							match(TEXTO);
							}
							break;
						case T__2:
						case T__4:
						case LONG:
						case ENTERO:
						case NOTA:
						case VAR:
							{
							setState(42);
							expr(0);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(47);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 4:
				_localctx = new ReproduccionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				match(TOCA);
				setState(49);
				expr(0);
				}
				break;
			case 5:
				_localctx = new InvocacionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				match(PROC_ID);
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(51);
						expr(0);
						}
						} 
					}
					setState(56);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				break;
			case 6:
				_localctx = new CondicionalContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
				match(SI);
				setState(58);
				expr(0);
				setState(59);
				bloque();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SINO) {
					{
					setState(60);
					match(SINO);
					setState(61);
					bloque();
					}
				}

				}
				break;
			case 7:
				_localctx = new IteracionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				match(MIENTRAS);
				setState(65);
				expr(0);
				setState(66);
				bloque();
				}
				break;
			case 8:
				_localctx = new AgregadoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(68);
				match(VAR);
				setState(69);
				match(AGREGA);
				setState(70);
				expr(0);
				}
				break;
			case 9:
				_localctx = new CorteContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(71);
				match(CORTA);
				setState(72);
				match(VAR);
				setState(73);
				match(T__0);
				setState(74);
				expr(0);
				setState(75);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndiceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndiceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListaContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExprContext {
		public TerminalNode VAR() { return getToken(BazilioParser.VAR, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelacionalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(BazilioParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(BazilioParser.MAYOR, 0); }
		public TerminalNode MENORIGUAL() { return getToken(BazilioParser.MENORIGUAL, 0); }
		public TerminalNode MAYORIGUAL() { return getToken(BazilioParser.MAYORIGUAL, 0); }
		public RelacionalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends ExprContext {
		public TerminalNode ENTERO() { return getToken(BazilioParser.ENTERO, 0); }
		public EnteroContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POR() { return getToken(BazilioParser.POR, 0); }
		public TerminalNode ENTRE() { return getToken(BazilioParser.ENTRE, 0); }
		public TerminalNode MODULO() { return getToken(BazilioParser.MODULO, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParentesisContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LongitudContext extends ExprContext {
		public TerminalNode LONG() { return getToken(BazilioParser.LONG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LongitudContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotaContext extends ExprContext {
		public TerminalNode NOTA() { return getToken(BazilioParser.NOTA, 0); }
		public NotaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IgualdadContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(BazilioParser.IGUAL, 0); }
		public TerminalNode DISTINTO() { return getToken(BazilioParser.DISTINTO, 0); }
		public IgualdadContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumaRestaContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAS() { return getToken(BazilioParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(BazilioParser.MENOS, 0); }
		public SumaRestaContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LONG:
				{
				_localctx = new LongitudContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80);
				match(LONG);
				setState(81);
				expr(10);
				}
				break;
			case T__2:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(T__2);
				setState(83);
				expr(0);
				setState(84);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new ListaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(T__4);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 23622352936L) != 0)) {
					{
					{
					setState(87);
					expr(0);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__5);
				}
				break;
			case ENTERO:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(ENTERO);
				}
				break;
			case NOTA:
				{
				_localctx = new NotaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(NOTA);
				}
				break;
			case VAR:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(100);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new SumaRestaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(103);
						((SumaRestaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
							((SumaRestaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(106);
						((RelacionalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((RelacionalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(107);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new IgualdadContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(109);
						((IgualdadContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==IGUAL || _la==DISTINTO) ) {
							((IgualdadContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(110);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new IndiceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(112);
						match(T__0);
						setState(113);
						expr(0);
						setState(114);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(120);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001\u0000"+
		"\u0004\u0000\f\b\u0000\u000b\u0000\f\u0000\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u0014\b\u0001\n\u0001\f\u0001\u0017\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002\u001d\b\u0002"+
		"\n\u0002\f\u0002 \t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003,\b\u0003\n\u0003\f\u0003/\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u00035\b\u0003\n\u0003\f\u00038\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"?\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004Y\b\u0004\n\u0004\f\u0004\\\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004b\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004u\b\u0004"+
		"\n\u0004\f\u0004x\t\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000\u0002"+
		"\u0004\u0006\b\u0000\u0004\u0001\u0000\u0012\u0014\u0001\u0000\u0010\u0011"+
		"\u0001\u0000\u0017\u001a\u0001\u0000\u0015\u0016\u008e\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0002\u0011\u0001\u0000\u0000\u0000\u0004\u001a\u0001"+
		"\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\ba\u0001\u0000\u0000"+
		"\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\r"+
		"\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0010\u0005"+
		"\u0000\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0015\u0005"+
		"!\u0000\u0000\u0012\u0014\u0005\"\u0000\u0000\u0013\u0012\u0001\u0000"+
		"\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000"+
		"\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u0019\u0003\u0004"+
		"\u0002\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001e\u0005\u0007"+
		"\u0000\u0000\u001b\u001d\u0003\u0006\u0003\u0000\u001c\u001b\u0001\u0000"+
		"\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000!\"\u0005\b\u0000\u0000\"\u0005\u0001\u0000"+
		"\u0000\u0000#$\u0005\"\u0000\u0000$%\u0005\t\u0000\u0000%N\u0003\b\u0004"+
		"\u0000&\'\u0005\n\u0000\u0000\'N\u0005\"\u0000\u0000(-\u0005\u000b\u0000"+
		"\u0000),\u0005\u001e\u0000\u0000*,\u0003\b\u0004\u0000+)\u0001\u0000\u0000"+
		"\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000.N\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u000001\u0005\f\u0000\u00001N\u0003\b\u0004\u000026\u0005"+
		"!\u0000\u000035\u0003\b\u0004\u000043\u0001\u0000\u0000\u000058\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"7N\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0005\u001b\u0000"+
		"\u0000:;\u0003\b\u0004\u0000;>\u0003\u0004\u0002\u0000<=\u0005\u001c\u0000"+
		"\u0000=?\u0003\u0004\u0002\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?N\u0001\u0000\u0000\u0000@A\u0005\u001d\u0000\u0000AB\u0003"+
		"\b\u0004\u0000BC\u0003\u0004\u0002\u0000CN\u0001\u0000\u0000\u0000DE\u0005"+
		"\"\u0000\u0000EF\u0005\r\u0000\u0000FN\u0003\b\u0004\u0000GH\u0005\u000e"+
		"\u0000\u0000HI\u0005\"\u0000\u0000IJ\u0005\u0001\u0000\u0000JK\u0003\b"+
		"\u0004\u0000KL\u0005\u0002\u0000\u0000LN\u0001\u0000\u0000\u0000M#\u0001"+
		"\u0000\u0000\u0000M&\u0001\u0000\u0000\u0000M(\u0001\u0000\u0000\u0000"+
		"M0\u0001\u0000\u0000\u0000M2\u0001\u0000\u0000\u0000M9\u0001\u0000\u0000"+
		"\u0000M@\u0001\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000MG\u0001\u0000"+
		"\u0000\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0006\u0004\uffff\uffff"+
		"\u0000PQ\u0005\u000f\u0000\u0000Qb\u0003\b\u0004\nRS\u0005\u0003\u0000"+
		"\u0000ST\u0003\b\u0004\u0000TU\u0005\u0004\u0000\u0000Ub\u0001\u0000\u0000"+
		"\u0000VZ\u0005\u0005\u0000\u0000WY\u0003\b\u0004\u0000XW\u0001\u0000\u0000"+
		"\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]b\u0005"+
		"\u0006\u0000\u0000^b\u0005\u001f\u0000\u0000_b\u0005 \u0000\u0000`b\u0005"+
		"\"\u0000\u0000aO\u0001\u0000\u0000\u0000aR\u0001\u0000\u0000\u0000aV\u0001"+
		"\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"a`\u0001\u0000\u0000\u0000bv\u0001\u0000\u0000\u0000cd\n\t\u0000\u0000"+
		"de\u0007\u0000\u0000\u0000eu\u0003\b\u0004\nfg\n\b\u0000\u0000gh\u0007"+
		"\u0001\u0000\u0000hu\u0003\b\u0004\tij\n\u0007\u0000\u0000jk\u0007\u0002"+
		"\u0000\u0000ku\u0003\b\u0004\blm\n\u0006\u0000\u0000mn\u0007\u0003\u0000"+
		"\u0000nu\u0003\b\u0004\u0007op\n\u000b\u0000\u0000pq\u0005\u0001\u0000"+
		"\u0000qr\u0003\b\u0004\u0000rs\u0005\u0002\u0000\u0000su\u0001\u0000\u0000"+
		"\u0000tc\u0001\u0000\u0000\u0000tf\u0001\u0000\u0000\u0000ti\u0001\u0000"+
		"\u0000\u0000tl\u0001\u0000\u0000\u0000to\u0001\u0000\u0000\u0000ux\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"w\t\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000\f\r\u0015\u001e"+
		"+-6>MZatv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}