// Generated from ExprArithEval.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprArithEvalParser}.
 */
public interface ExprArithEvalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprArithEvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprArithEvalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithEvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprArithEvalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithEvalParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpr(ExprArithEvalParser.AdditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithEvalParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpr(ExprArithEvalParser.AdditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithEvalParser#multiplyExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpr(ExprArithEvalParser.MultiplyExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithEvalParser#multiplyExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpr(ExprArithEvalParser.MultiplyExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithEvalParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ExprArithEvalParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithEvalParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ExprArithEvalParser.AtomExprContext ctx);
}