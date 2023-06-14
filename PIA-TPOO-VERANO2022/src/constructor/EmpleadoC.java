package constructor;

public class EmpleadoC {
	private int idEmp;
	private String nomEmp;
	private int idpuestoEmp;
	private String telEmp;
	private String emailEmp;
	private String genEmp;
	private int passEmp;
	
	public EmpleadoC(int idEmp, String nomEmp, int idpuestoEmp, String telEmp, String emailEmp, String genEmp, int passEmp) {
		this.idEmp = idEmp;
		this.nomEmp = nomEmp;
		this.idpuestoEmp = idpuestoEmp;
		this.telEmp = telEmp;
		this.emailEmp = emailEmp;
		this.genEmp = genEmp;
		this.passEmp = passEmp;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public int getIdpuestoEmp() {
		return idpuestoEmp;
	}

	public void setIdpuestoEmp(int idpuestoEmp) {
		this.idpuestoEmp = idpuestoEmp;
	}

	public String getTelEmp() {
		return telEmp;
	}

	public void setTelEmp(String telEmp) {
		this.telEmp = telEmp;
	}

	public String getEmailEmp() {
		return emailEmp;
	}

	public void setEmailEmp(String emailEmp) {
		this.emailEmp = emailEmp;
	}

	public String getGenEmp() {
		return genEmp;
	}

	public void setGenEmp(String genEmp) {
		this.genEmp = genEmp;
	}

	public int getPassEmp() {
		return passEmp;
	}

	public void setPassEmp(int passEmp) {
		this.passEmp = passEmp;
	}
	
	public EmpleadoC() {
		
	}
}
