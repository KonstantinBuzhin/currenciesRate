package startingApp.model;

public class CurrenciesInDate {

	private String date;
	private double eur;
	private double usd;
	private double gbp;
	private double nzd;
	private double aud;
	private double jpy;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getEur() {
		return eur;
	}

	public void setEur(double eur) {
		this.eur = eur;
	}

	public double getUsd() {
		return usd;
	}

	public void setUsd(double usd) {
		this.usd = usd;
	}

	public double getGbp() {
		return gbp;
	}

	public void setGbp(double gbp) {
		this.gbp = gbp;
	}

	public double getNzd() {
		return nzd;
	}

	public void setNzd(double nzd) {
		this.nzd = nzd;
	}

	public double getAud() {
		return aud;
	}

	public void setAud(double aud) {
		this.aud = aud;
	}

	public double getJpy() {
		return jpy;
	}

	public void setJpy(double jpy) {
		this.jpy = jpy;
	}

	public CurrenciesInDate(String date, double eur, double usd, double gbp, double nzd, double aud, double jpy) {
		this.date = date;
		this.eur = eur;
		this.usd = usd;
		this.gbp = gbp;
		this.nzd = nzd;
		this.aud = aud;
		this.jpy = jpy;
	}

	public CurrenciesInDate() {
	}

}
