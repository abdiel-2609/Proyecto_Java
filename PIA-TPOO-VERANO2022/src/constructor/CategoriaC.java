package constructor;

public class CategoriaC {
	private int idCat;
	private String dscrCat;
	
	public CategoriaC(int idCat, String dscrCat) {
		super();
		this.idCat = idCat;
		this.dscrCat = dscrCat;
	}
	
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getDscrCat() {
		return dscrCat;
	}
	public void setDscrCat(String dscrCat) {
		this.dscrCat = dscrCat;
	}
	
	public CategoriaC() {
	}
}
