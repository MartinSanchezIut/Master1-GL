package main.dico;


public abstract class AbstractDictionary<T> implements IDictionary<T>{
	
	T[] keys; 
	Object[] values;
	
	public IDictionary<T> put(T key, Object value) {
		int i = this.indexOf(key);
		if (i != -1) {
			values[i] = value;
		}else {

			int a = this.newIndexOf(key);
			values[a] = value;			
		}
		return this;
	}
	
	public Object get(T key) throws Exception {
		int i = this.indexOf(key);
		if (i != -1) {
			return values[i];
		}else {
			throw new Exception("Cette clé n'est pas dans le dico: " + key);
		}
	}

	public boolean isEmpty() {
		return this.size() > 0;
		//return keys.length == 0;
	}
	
	public boolean containsKey(T key) {
		return this.indexOf(key) >= 0;
	}

	public int size() {
		return keys.length;
	}
	
	public abstract int indexOf(T key) ;
	public abstract int newIndexOf(T key) ;
}
