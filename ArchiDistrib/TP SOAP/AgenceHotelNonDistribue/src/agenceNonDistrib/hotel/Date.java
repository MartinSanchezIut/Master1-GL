package agenceNonDistrib.hotel;

public class Date implements Comparable<Date>{
	
	private String str;
	private int annee;
	private int mois;
	private int jour;
	
	public Date(String date) throws Exception{ // Date au format jj/mm/aaaa
		str = date;
		String[] d = str.split("/");
		if (d.length != 3) {
			throw new Exception("Date error: format jj/mm/aaa.");
		}else {
			
			annee = Integer.parseInt(str.split("/")[2]);
			mois = Integer.parseInt(str.split("/")[1]);
			if (mois > 12 || mois < 1) {
				throw new Exception("Date error: format jj/mm/aaa."); 
			}
			jour = Integer.parseInt(str.split("/")[0]);
			if (jour > 31 || jour < 1) {
				throw new Exception("Date error: format jj/mm/aaa."); 
			}
		}
		
	}

	@Override
	public int compareTo(Date d) {
		return 0;
	}
	
	public int getAnnee() {
		return annee;
	}
	public int getMois() {
		return mois;
	}
	public int getJour() {
		return jour;
	}
	@Override
	public String toString() {
		return str;
	}
}
