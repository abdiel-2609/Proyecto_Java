package constructor;

public class ProveedorC {
	private int idProv;
	private String nomProv;
	private String contacProv;
	private String telProv;
	private String emailProv;
	private String rfcProv;
	public ProveedorC(int idProv, String nomProv, String contacProv, String telProv, String emailProv, String rfcProv) {
		super();
		this.idProv = idProv;
		this.nomProv = nomProv;
		this.contacProv = contacProv;
		this.telProv = telProv;
		this.emailProv = emailProv;
		this.rfcProv = rfcProv;
	}
	public int getIdProv() {
		return idProv;
	}
	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}
	public String getNomProv() {
		return nomProv;
	}
	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}
	public String getContacProv() {
		return contacProv;
	}
	public void setContacProv(String contacProv) {
		this.contacProv = contacProv;
	}
	public String getTelProv() {
		return telProv;
	}
	public void setTelProv(String telProv) {
		this.telProv = telProv;
	}
	public String getEmailProv() {
		return emailProv;
	}
	public void setEmailProv(String emailProv) {
		this.emailProv = emailProv;
	}
	public String getRfcProv() {
		return rfcProv;
	}
	public void setRfcProv(String rfcProv) {
		this.rfcProv = rfcProv;
	}
	
	public ProveedorC() {
		
	}
}
