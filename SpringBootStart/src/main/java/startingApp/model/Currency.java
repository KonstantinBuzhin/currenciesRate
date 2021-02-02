package startingApp.model;


public class Currency {

	private String nameCurrency;
	private double rate;

	public String getNameCurrency() {
		return nameCurrency;
	}

	public void setNameCurrency(String nameCurrency) {
		this.nameCurrency = nameCurrency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Currency(String nameCurrency, double rate) {
		this.nameCurrency = nameCurrency;
		this.rate = rate;
	}

	public Currency() {
	}

}
