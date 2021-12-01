
public abstract class AbstractFactory {

	abstract public Lexer createLexer(ProgramText programText) ;
	abstract public Parser createParser(ProgramText programText) ;
	abstract public Generator createGenerator(ProgramText programText) ;

}
