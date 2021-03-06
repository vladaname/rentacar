package managers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import helper.ListaAutomobilaDatumOdDo;
import model.Automobil;
import model.Iznajmljivanje;
import model.Korisnik;
import sun.security.action.GetBooleanAction;

public class IznajmljivanjeManager {

	// public static List<UkupnaCenaPoAutomobilu> sumZaradaPoAutomobilima() {
	// EntityManager em = JPAUtil.getEntityManager();
	// List<UkupnaCenaPoAutomobilu> finadAllVetByAuto = new ArrayList();
	// Query q = em.createNativeQuery("select sum(a.cena_po_danu) as cena, a.marka,
	// i.datum_od, " +
	// "i.datum_do from iznajmljivanje as i " +
	// "inner join automobil as a on i.automobil_idautomobil = a.idautomobil " +
	// "group by model;");
	// List<Object[]> sumAuto = q.getResultList();
	// for (Object[] o : sumAuto) {
	// UkupnaCenaPoAutomobilu a = new UkupnaCenaPoAutomobilu(o[0].toString(),
	// o[1].toString(), );
	// sumZaradaPoAutomobilima.add(a);
	// }
	// return sumZaradaPoAutomobilima;
	// }
	//
	// }

	public static List<ListaAutomobilaDatumOdDo> findAllByDateOdDo(Date datum_od, Date datum_do) {
		EntityManager em = JPAUtil.getEntityManager();
		List<ListaAutomobilaDatumOdDo> listaAutomobila = new ArrayList();
		Query q = em.createNativeQuery("select a.marka, a.model, i.datum_od, i.datum_do from iznajmljivanje as i "
						+ "inner join automobil as a on i.automobil_idautomobil = a.idautomobil "
						+ "where i.datum_od >=:datum_od and i.datum_do <=:datum_do and a.obrisan = 0 ")
				.setParameter("datum_od", datum_od).setParameter("datum_do", datum_do);
		List<Object[]> autoL = q.getResultList();
		for (Object[] o : autoL) {
			ListaAutomobilaDatumOdDo al = new ListaAutomobilaDatumOdDo(o[0].toString(), o[1].toString(),
					o[2].toString(), o[3].toString());
			listaAutomobila.add(al);
		}
		return listaAutomobila;

		// public static List<Pregled> findAllByVremeOdAndIdUsluga(Date vremeOd, int
		// idUsluga) {
		// EntityManager em = JPAUtil.getEntityManager();
		// return (List<Pregled>) em.createQuery("FROM Pregled p WHERE p.vremeOd >=
		// :vremeOd and p.zauzet = 0 "
		// + "and p.usluga.idUsluga =:idUsluga ")
		// .setParameter("idUsluga", idUsluga).setParameter("vremeOd",
		// vremeOd).getResultList();
		// }

	}

	public static String rezervacija(int idautomobil) {
		EntityManager em = JPAUtil.getEntityManager();
		String Rezervacija1 = new String();
		Query q = em.createNativeQuery("select a.idautomobil, a.marka, a.model, a.gorivo, "
						+ " i.cenaPoDanu as cena from iznajmljivanje as i "
						+ " inner join automobil as a on i.automobil_idautomobil = a.idautomobil "
						+ " where a.idautomobil = idautomobil ");
		q.setParameter("idautomobil", idautomobil);
		Object[] rez = (Object[]) q.getSingleResult();
		return rez[1].toString() + " " + rez[2].toString() + " " + rez[3].toString() + " " + rez[4].toString() + " "
				+ rez[5].toString();

	}

	public static boolean createReservation(int idautomobil, Date datumOd, Date datumDo, int idkorisnik) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Iznajmljivanje iz = new Iznajmljivanje();
			if (datumOd != null && datumDo != null) {
				iz.setDatumOd(datumOd);
				iz.setDatumDo(datumDo);
				
				Korisnik k = em.find(Korisnik.class, idkorisnik);
				if (k != null) {
					iz.setKorisnik(k);
				}

				Automobil a = em.find(Automobil.class, idautomobil);
				if (a != null) {
					iz.setAutomobil(a);
					a.setObrisan(1);
					em.persist(a);
					
				}

				em.persist(iz);
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
		// String a = rezervacija(2);
		// System.out.println(a);

		String oo = "2018-11-07 10:00:00";
		String dd = "2018-11-24 11:00:00";

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateS = null;
		Date dateSd = null;
		try {
			dateS = sd.parse(oo);
			dateSd = sd.parse(dd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean i = createReservation(8, dateS, dateSd, 1);

		if (i) {
			System.out.println("kreirano");
		} else {
			System.out.println("ne");
		}

		// String datum_od = "2018-10-07 10:00:00";
		// String datum_do = "2018-10-24 11:00:00";
		// SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date dateSdp = null;
		// Date dateSdp1 = null;
		// try {
		// dateSdp = sdp.parse(datum_od);
		// dateSdp1 = sdp.parse(datum_do);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// List<ListaAutomobilaDatumOdDo> g = findAllByDateOdDo(dateSdp, dateSdp1);
		// for (ListaAutomobilaDatumOdDo listaAutomobilaDatumOdDo : g) {
		// System.out.println(listaAutomobilaDatumOdDo);
		// }
		//
	}

}
