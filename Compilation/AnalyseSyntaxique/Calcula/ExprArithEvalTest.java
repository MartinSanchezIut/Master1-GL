import org.antlr.v4.runtime .*;
public class ExprArithEvalTest {
public static void main(String [] argv) {
ANTLRInputStream stream =
new ANTLRInputStream(argv [0]);
ExprArithEvalLexer lexer =
new ExprArithEvalLexer(stream );
CommonTokenStream tokens =
new CommonTokenStream(lexer );
ExprArithEvalParser parser =
new ExprArithEvalParser(tokens );
System.out.println(parser.expr (). value);
}
}
