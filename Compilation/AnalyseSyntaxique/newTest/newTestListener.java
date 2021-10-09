// Generated from newTest.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link newTestParser}.
 */
public interface newTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link newTestParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void enterEvaluableExpr(newTestParser.EvaluableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void exitEvaluableExpr(newTestParser.EvaluableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(newTestParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(newTestParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnOpExpr(newTestParser.UnOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnOpExpr(newTestParser.UnOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpr(newTestParser.TypeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpr(newTestParser.TypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExpr(newTestParser.BinOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExpr(newTestParser.BinOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalleeExpr(newTestParser.CalleeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalleeExpr(newTestParser.CalleeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(newTestParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(newTestParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(newTestParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(newTestParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void enterInsExpr(newTestParser.InsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void exitInsExpr(newTestParser.InsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairExpr(newTestParser.PairExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairExpr(newTestParser.PairExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairArrayExpr(newTestParser.PairArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairArrayExpr(newTestParser.PairArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(newTestParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(newTestParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void enterListDefExpr(newTestParser.ListDefExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void exitListDefExpr(newTestParser.ListDefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link newTestParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void enterProgExpr(newTestParser.ProgExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link newTestParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void exitProgExpr(newTestParser.ProgExprContext ctx);
}