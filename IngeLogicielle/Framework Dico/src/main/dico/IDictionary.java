package main.dico;

public interface IDictionary {
	
	
	IDictionary put(Object key, Object value);
	Object get(Object key) throws Exception;
	boolean isEmpty();
	boolean containsKey(Object key);
	int size();

}
