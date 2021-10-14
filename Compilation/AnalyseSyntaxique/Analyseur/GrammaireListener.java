// Generated from Grammaire.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammaireParser}.
 */
public interface GrammaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void enterEvaluableExpr(GrammaireParser.EvaluableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void exitEvaluableExpr(GrammaireParser.EvaluableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#funcParamsExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncParamsExpr(GrammaireParser.FuncParamsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#funcParamsExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncParamsExpr(GrammaireParser.FuncParamsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(GrammaireParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(GrammaireParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnOpExpr(GrammaireParser.UnOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnOpExpr(GrammaireParser.UnOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpr(GrammaireParser.TypeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpr(GrammaireParser.TypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExpr(GrammaireParser.BinOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExpr(GrammaireParser.BinOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalleeExpr(GrammaireParser.CalleeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalleeExpr(GrammaireParser.CalleeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(GrammaireParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(GrammaireParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(GrammaireParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(GrammaireParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void enterInsExpr(GrammaireParser.InsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void exitInsExpr(GrammaireParser.InsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairExpr(GrammaireParser.PairExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairExpr(GrammaireParser.PairExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairArrayExpr(GrammaireParser.PairArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairArrayExpr(GrammaireParser.PairArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(GrammaireParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(GrammaireParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void enterListDefExpr(GrammaireParser.ListDefExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void exitListDefExpr(GrammaireParser.ListDefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammaireParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void enterProgExpr(GrammaireParser.ProgExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammaireParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void exitProgExpr(GrammaireParser.ProgExprContext ctx);
}