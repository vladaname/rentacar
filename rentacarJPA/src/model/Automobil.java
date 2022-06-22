package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the automobil database table.
 * 
 */
@Entity
@NamedQuery(name="Automobil.findAll", query="SELECT a FROM Automobil a")
public class Automobil implements Serializable {
	@Override
	public String toString() {
		return "Automobil [idautomobil=" + idautomobil + ", brojVrata=" + brojVrata + ", cenaPoDanu=" + cenaPoDanu
				+ ", gorivo=" + gorivo + ", kubikaza=" + kubikaza + ", marka=" + marka + ", model=" + model + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idautomobil;

	@Column(name="broj_vrata")
	private int brojVrata;

	@Column(name="cena_po_danu")
	private int cenaPoDanu;

	private String gorivo;

	private int kubikaza;

	private String marka;

	private String model;

	private int obrisan;

	//bi-directional many-to-one association to Iznajmljivanje
	@OneToMany(mappedBy="automobil")
	private List<Iznajmljivanje> iznajmljivanjes;

	public Automobil() {
	}

	public int getIdautomobil() {
		return this.idautomobil;
	}

	public void setIdautomobil(int idautomobil) {
		this.idautomobil = idautomobil;
	}

	public int getBrojVrata() {
		return this.brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public int getCenaPoDanu() {
		return this.cenaPoDanu;
	}

	public void setCenaPoDanu(int cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public String getGorivo() {
		return this.gorivo;
	}

	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}

	public int getKubikaza() {
		return this.kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getObrisan() {
		return this.obrisan;
	}

	public void setObrisan(int obrisan) {
		this.obrisan = obrisan;
	}

	public List<Iznajmljivanje> getIznajmljivanjes() {
		return this.iznajmljivanjes;
	}

	public void setIznajmljivanjes(List<Iznajmljivanje> iznajmljivanjes) {
		this.iznajmljivanjes = iznajmljivanjes;
	}

	public Iznajmljivanje addIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().add(iznajmljivanje);
		iznajmljivanje.setAutomobil(this);

		return iznajmljivanje;
	}

	public Iznajmljivanje removeIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().remove(iznajmljivanje);
		iznajmljivanje.setAutomobil(null);

		return iznajmljivanje;
	}
	

}