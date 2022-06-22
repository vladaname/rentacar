package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnik;

	private String email;

	private String ime;

	private int jmbg;

	private int obrisan;

	private String pass;

	private String prezime;

	private String telefon;

	private String username;

	//bi-directional many-to-one association to Iznajmljivanje
	@OneToMany(mappedBy="korisnik")
	private List<Iznajmljivanje> iznajmljivanjes;

	//bi-directional many-to-one association to Uloga
	@OneToMany(mappedBy="korisnik")
	private List<Uloga> ulogas;

	public Korisnik() {
	}

	public int getIdkorisnik() {
		return this.idkorisnik;
	}

	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public int getObrisan() {
		return this.obrisan;
	}

	public void setObrisan(int obrisan) {
		this.obrisan = obrisan;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Iznajmljivanje> getIznajmljivanjes() {
		return this.iznajmljivanjes;
	}

	public void setIznajmljivanjes(List<Iznajmljivanje> iznajmljivanjes) {
		this.iznajmljivanjes = iznajmljivanjes;
	}

	public Iznajmljivanje addIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().add(iznajmljivanje);
		iznajmljivanje.setKorisnik(this);

		return iznajmljivanje;
	}

	public Iznajmljivanje removeIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().remove(iznajmljivanje);
		iznajmljivanje.setKorisnik(null);

		return iznajmljivanje;
	}

	public List<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}

	public Uloga addUloga(Uloga uloga) {
		getUlogas().add(uloga);
		uloga.setKorisnik(this);

		return uloga;
	}

	public Uloga removeUloga(Uloga uloga) {
		getUlogas().remove(uloga);
		uloga.setKorisnik(null);

		return uloga;
	}

}