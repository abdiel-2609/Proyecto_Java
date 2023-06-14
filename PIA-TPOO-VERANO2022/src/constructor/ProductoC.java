package constructor;

public class ProductoC {
	private int cveProd;
	private String dscrProd;
	private int provProd;
	private int catProd;
	private int sabProd;
	private float preProd;
	private float costProd;
	
	public ProductoC(int cveProd, String dscrProd, int provProd, int catProd, int sabProd, float preProd, float costProd) {
		this.cveProd = cveProd;
		this.dscrProd = dscrProd;
		this.provProd = provProd;
		this.catProd = catProd;
		this.sabProd = sabProd;
		this.preProd = preProd;
		this.costProd = costProd;
	}

	public int getCveProd() {
		return cveProd;
	}

	public void setCveProd(int cveProd) {
		this.cveProd = cveProd;
	}

	public String getDscrProd() {
		return dscrProd;
	}

	public void setDscrProd(String dscrProd) {
		this.dscrProd = dscrProd;
	}

	public int getProvProd() {
		return provProd;
	}

	public void setProvProd(int provProd) {
		this.provProd = provProd;
	}

	public int getCatProd() {
		return catProd;
	}

	public void setCatProd(int catProd) {
		this.catProd = catProd;
	}

	public int getSabProd() {
		return sabProd;
	}

	public void setSabProd(int sabProd) {
		this.sabProd = sabProd;
	}

	public float getPreProd() {
		return preProd;
	}

	public void setPreProd(float preProd) {
		this.preProd = preProd;
	}

	public float getCostProd() {
		return costProd;
	}

	public void setCostProd(float costProd) {
		this.costProd = costProd;
	}
	
	public ProductoC() {
		
	}
}
