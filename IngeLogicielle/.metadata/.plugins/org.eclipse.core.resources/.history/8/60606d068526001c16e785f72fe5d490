package main.dico;

public class UtilisationDictionaire {

	public static void main(String[] args) {

		IDictionary dic = new OrderedDictionary();
		
		System.out.println("main: " + dic.isEmpty());
		System.out.println("main: " + dic.size());
		
		dic.put(new String("a"), new String("b"));
		dic.put(new String("c"), new String("d"));
		
		System.out.println("main: " + dic.isEmpty());
		System.out.println("main: " + dic.size());
		
		try {
			System.out.println("main: " + dic.get("a"));
			System.out.println("main: " + dic.get("zpoj"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main: " + dic.containsKey("c"));
		System.out.println("main: " + dic.containsKey("z"));
		
	}

}
