// Generated from ANTLRPP.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ANTLRPPParser}.
 */
public interface ANTLRPPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#binExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr(ANTLRPPParser.BinExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#binExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr(ANTLRPPParser.BinExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ANTLRPPParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ANTLRPPParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void enterInsExpr(ANTLRPPParser.InsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void exitInsExpr(ANTLRPPParser.InsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(ANTLRPPParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(ANTLRPPParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalleeExpr(ANTLRPPParser.CalleeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalleeExpr(ANTLRPPParser.CalleeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ANTLRPPParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ANTLRPPParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(ANTLRPPParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(ANTLRPPParser.ArrayContext ctx);
}