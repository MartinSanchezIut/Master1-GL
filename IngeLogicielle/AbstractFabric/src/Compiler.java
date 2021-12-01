import java.util.HashMap;

public class Compiler {
	
	
	String lang;

	public Compiler(String lang) {
		super();
		this.lang = lang;
		
		
		fac = map.get(lang);
		if (fac != null) {
			System.out.println("Compiling " + lang + " program.");
		}
		else { 
			
			System.out.println("Trying to instropespsdoisdghiodfjiom");
			
			String classname = lang + "Compiler";
			Class classe;
			try {
				classe = Class.forName(classname);
			} catch (ClassNotFoundException e) {
				System.out.println("Unknown language");
				System.exit(1);
				e.printStackTrace();
			}
			
			fac = classe.getConstructor().newInstance(null) ;
			
	
		}
	}
	
	protected Lexer lexer; //analyse lexicale
	protected Parser parser; //analyse syntaxique
	protected Generator gen; //generation de code

	
	
	private static AbstractFactory fac;
	private static HashMap<String, AbstractFactory> map ;
	static {
		map = new HashMap<>();
		map.put("Java", new JavaCompiler());
		map.put("C++", new CppCompiler());
	}
	
	
	public void compile(ProgramText programText) {
		lexer = fac.createLexer(programText);
		parser = fac.createParser(programText);
		gen = fac.createGenerator(programText);
		
		
	}	
}
