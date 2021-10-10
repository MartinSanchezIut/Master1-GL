// Generated from grammaire.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammaireParser}.
 */
public interface grammaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammaireParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void enterEvaluableExpr(grammaireParser.EvaluableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#evaluableExpr}.
	 * @param ctx the parse tree
	 */
	void exitEvaluableExpr(grammaireParser.EvaluableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#funcParamsExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncParamsExpr(grammaireParser.FuncParamsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#funcParamsExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncParamsExpr(grammaireParser.FuncParamsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(grammaireParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(grammaireParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnOpExpr(grammaireParser.UnOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#unOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnOpExpr(grammaireParser.UnOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpr(grammaireParser.TypeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#typeExpr}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpr(grammaireParser.TypeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExpr(grammaireParser.BinOpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#binOpExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExpr(grammaireParser.BinOpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalleeExpr(grammaireParser.CalleeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#calleeExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalleeExpr(grammaireParser.CalleeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(grammaireParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#listExpr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(grammaireParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(grammaireParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#funCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(grammaireParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void enterInsExpr(grammaireParser.InsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#insExpr}.
	 * @param ctx the parse tree
	 */
	void exitInsExpr(grammaireParser.InsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairExpr(grammaireParser.PairExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#pairExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairExpr(grammaireParser.PairExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterPairArrayExpr(grammaireParser.PairArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#pairArrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitPairArrayExpr(grammaireParser.PairArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(grammaireParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(grammaireParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void enterListDefExpr(grammaireParser.ListDefExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#listDefExpr}.
	 * @param ctx the parse tree
	 */
	void exitListDefExpr(grammaireParser.ListDefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammaireParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void enterProgExpr(grammaireParser.ProgExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammaireParser#progExpr}.
	 * @param ctx the parse tree
	 */
	void exitProgExpr(grammaireParser.ProgExprContext ctx);
}