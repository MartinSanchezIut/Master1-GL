// Generated from ANTLRPP.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ANTLRPPParser}.
 */
public interface ANTLRPPListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link ANTLRPPParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(ANTLRPPParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(ANTLRPPParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#unOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnOperation(ANTLRPPParser.UnOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#unOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnOperation(ANTLRPPParser.UnOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ANTLRPPParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ANTLRPPParser.VarContext ctx);
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
	 * Enter a parse tree produced by {@link ANTLRPPParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(ANTLRPPParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(ANTLRPPParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ANTLRPPParser#bincond}.
	 * @param ctx the parse tree
	 */
	void enterBincond(ANTLRPPParser.BincondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#bincond}.
	 * @param ctx the parse tree
	 */
	void exitBincond(ANTLRPPParser.BincondContext ctx);
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
	 * Enter a parse tree produced by {@link ANTLRPPParser#funproc}.
	 * @param ctx the parse tree
	 */
	void enterFunproc(ANTLRPPParser.FunprocContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#funproc}.
	 * @param ctx the parse tree
	 */
	void exitFunproc(ANTLRPPParser.FunprocContext ctx);
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
	 * Enter a parse tree produced by {@link ANTLRPPParser#entier}.
	 * @param ctx the parse tree
	 */
	void enterEntier(ANTLRPPParser.EntierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ANTLRPPParser#entier}.
	 * @param ctx the parse tree
	 */
	void exitEntier(ANTLRPPParser.EntierContext ctx);
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
}