import java.io.File;

public class JavaCompiler extends AbstractFactory {

	class JavaLexer extends Lexer {
		public JavaLexer(ProgramText programText) {
			System.out.println("Lexing java program");
		}
		@Override
		public ScanedText scan(ProgramText t) {
			return null;
		}}
	class JavaParser extends Parser {
		public JavaParser(ProgramText programText) {
			System.out.println("Parsing java program");
		}
		@Override
		public AST parse(ScanedText t) {

			return null;
		}}
	class JavaGenerator extends Generator {
		public JavaGenerator(ProgramText programText) {
			System.out.println("Generating java program");
		}
		@Override
		public File generate(AST a) {

			return null;
		}}
	
	
	@Override
	public Lexer createLexer(ProgramText programText) {
		return new JavaLexer(programText);
	}
	@Override
	public Parser createParser(ProgramText programText) {
		return new JavaParser(programText);
	}
	@Override
	public Generator createGenerator(ProgramText programText) {
		return new JavaGenerator(programText);
	}
}
