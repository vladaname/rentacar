package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the iznajmljivanje database table.
 * 
 */
@Entity
@NamedQuery(name="Iznajmljivanje.findAll", query="SELECT i FROM Iznajmljivanje i")
public class Iznajmljivanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idiznajmljivanje;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datum_do")
	private Date datumDo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datum_od")
	private Date datumOd;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Automobil
	@ManyToOne
	private Automobil automobil;

	public Iznajmljivanje() {
	}

	public int getIdiznajmljivanje() {
		return this.idiznajmljivanje;
	}

	public void setIdiznajmljivanje(int idiznajmljivanje) {
		this.idiznajmljivanje = idiznajmljivanje;
	}

	public Date getDatumDo() {
		return this.datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public Date getDatumOd() {
		return this.datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Automobil getAutomobil() {
		return this.automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

}