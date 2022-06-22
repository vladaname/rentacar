package helper;

import java.util.Date;

public class UkupnaCenaPoAutomobilu {

	int cena;
	Date datumOd;
	Date datumDo;
	String marka;
	
	
	public UkupnaCenaPoAutomobilu(int cena, Date datumOd, Date datumDo, String marka) {
		super();
		this.cena = cena;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.marka = marka;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public Date getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}
	public Date getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	@Override
	public String toString() {
		return "UkupnaCenaPoAutomobilu [cena=" + cena + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", marka="
				+ marka + "]";
	}
	
	
	
}


