package helper;

import java.util.Date;

public class ListaAutomobilaDatumOdDo {

	String marka;
	String model;
	String datum_od;
	String datum_do;
	
	public ListaAutomobilaDatumOdDo(String marka, String model, String datum_od, String datum_do) {
		super();
		this.marka = marka;
		this.model = model;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
	}
	
	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDatum_od() {
		return datum_od;
	}

	public void setDatum_od(String datum_od) {
		this.datum_od = datum_od;
	}

	public String getDatum_do() {
		return datum_do;
	}

	public void setDatum_do(String datum_do) {
		this.datum_do = datum_do;
	}

	@Override
	public String toString() {
		return "ListaAutomobilaDatumOdDo [marka=" + marka + ", model=" + model + ", datum_od=" + datum_od
				+ ", datum_do=" + datum_do + "]";
	}
	
	
	
	
}
