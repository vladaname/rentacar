package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Korisnik;

public class KorisnikMenager {

	public static List<Korisnik> findAllKorisnik(int idKorisnik) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.createQuery("FROM Korisnik k").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static Korisnik findOneKorisnik(int idKorisnik) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Korisnik.class, idKorisnik);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static Korisnik findByJMBG(int jmbg) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return (Korisnik) em.createQuery("FROM Korisnik k WHERE k.jmbg =:jmbg").setParameter("jmbg", jmbg)
					.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static Korisnik findByEmail(String email) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return (Korisnik) em.createQuery("FROM Korisnik k WHERE k.email =:email")
					.setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static Korisnik logovanje(String username, String pass) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Korisnik k = (Korisnik) em.createQuery("FROM Korisnik k WHERE k.username =:username ")
					.setParameter("username", username).getSingleResult();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = k.getPass();

			if (passwordEncryptor.checkPassword(pass, encryptedPassword)) {
				return k;
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static boolean createKorisnik(String email, String ime, int jmbg, String pass, String prezime,
			String telefon, String username) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			Korisnik k = new Korisnik();
			k.setEmail(email);
			k.setIme(ime);
			k.setJmbg(jmbg);
			k.setPass(passwordEncryptor.encryptPassword(pass));
			k.setPrezime(prezime);
			k.setTelefon(telefon);
			k.setUsername(username);
			em.persist(k);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean updateKorisnik(int idKorisnik, String email, String ime, int jmbg, String pass,
			String prezime, String telefon, String username) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			Korisnik k = em.find(Korisnik.class, idKorisnik);
			if (k != null) {
				k.setEmail(email);
				k.setIme(ime);
				k.setJmbg(jmbg);
				k.setPass(passwordEncryptor.encryptPassword(pass));
				k.setPrezime(prezime);
				k.setTelefon(telefon);
				k.setUsername(username);
				em.persist(k);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean deletekorisnik(int idKorisnik) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Korisnik k = em.find(Korisnik.class, idKorisnik);
			if (k != null) {
				k.setObrisan(1);
				em.persist(k);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {

		boolean korisnik = createKorisnik("aaa@gmail.com", "Zile", 555034, "zile123", "Trivic", "09879456", "ziki");

	}
}
