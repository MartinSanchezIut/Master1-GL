// Generated from ExprArith.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprArithParser}.
 */
public interface ExprArithListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprArithParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprArithParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprArithParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpr(ExprArithParser.AdditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpr(ExprArithParser.AdditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithParser#multiplyExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpr(ExprArithParser.MultiplyExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithParser#multiplyExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpr(ExprArithParser.MultiplyExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprArithParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ExprArithParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprArithParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ExprArithParser.AtomExprContext ctx);
}