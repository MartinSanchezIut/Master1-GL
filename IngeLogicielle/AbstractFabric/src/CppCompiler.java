import java.io.File;

public class CppCompiler extends AbstractFactory {

	class CppLexer extends Lexer {
		public CppLexer(ProgramText programText) {
			System.out.println("Lexing c++ program");
		}
		@Override
		public ScanedText scan(ProgramText t) {
			return null;
		}}
	class CppParser extends Parser {
		public CppParser(ProgramText programText) {
			System.out.println("Parsing c++ program");
		}
		@Override
		public AST parse(ScanedText t) {

			return null;
		}}
	class CppGenerator extends Generator {
		public CppGenerator(ProgramText programText) {
			System.out.println("Generating c++ program");
		}
		@Override
		public File generate(AST a) {

			return null;
		}}
	
	
	@Override
	public Lexer createLexer(ProgramText programText) {
		// TODO Auto-generated method stub
		return new CppLexer(programText);
	}

	@Override
	public Parser createParser(ProgramText programText) {
		// TODO Auto-generated method stub
		return new CppParser(programText);
	}

	@Override
	public Generator createGenerator(ProgramText programText) {
		// TODO Auto-generated method stub
		return new CppGenerator(programText);
	}

}
