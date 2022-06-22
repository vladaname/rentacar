package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Automobil;

public class AutomobilManager {
	
	public static List<Automobil> listAllAutomobil(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("FROM Automobil a").getResultList();
	}
	
	public static Automobil getOneAutomobil(int idAutomobil) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Automobil.class, idAutomobil);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Automobil> findAllByMarka(String marka){
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.createQuery("FROM Automobil a WHERE a.marka =:marka")
					.setParameter("marka", marka).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Automobil> findAllByModel(String model){
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.createQuery("FROM Automobil a WHERE a.model =:model")
					.setParameter("model", model).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static List<Automobil> findAllByKubikaza(int kubikaza){
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.createQuery("FROM Automobil a WHERE a.kubikaza =:kubikaza")
					.setParameter("kubikaza", kubikaza).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static boolean ceateAutomobil(int brojVrata, int cenaPoDanu, String gorivo, 
			int kubikaza, String marka, String model) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Automobil a = new Automobil();
			a.setBrojVrata(brojVrata);
			a.setCenaPoDanu(cenaPoDanu);
			a.setGorivo(gorivo);
			a.setKubikaza(kubikaza);
			a.setMarka(marka);
			a.setModel(model);
			em.persist(a);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
}
	
	public static boolean updateAutomobil(int idAutomobil, int brojVrata, int cenaPoDanu, String gorivo, int kubikaza, String marka, String model) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Automobil auto = em.find(Automobil.class, idAutomobil);
			if(auto != null) {
				auto.setBrojVrata(brojVrata);
				auto.setCenaPoDanu(cenaPoDanu);
				auto.setGorivo(gorivo);
				auto.setKubikaza(kubikaza);
				auto.setMarka(marka);
				auto.setModel(model);
				em.persist(auto);
				em.getTransaction().commit();
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	
	public static boolean zauzeto(int idautomobil) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Automobil a = em.find(Automobil.class, idautomobil);
			if (a != null) { 
				a.setObrisan(1);
				em.persist(a);
				em.getTransaction().commit();
				return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	
	public static boolean deleteAutomobilLog(int idAutomobil) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Automobil auto = em.find(Automobil.class, idAutomobil);
			if(auto != null) {
				auto.setObrisan(1);
				em.persist(auto);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	
	
	public static List<Automobil> listZauzeto(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("FROM Automobil a WHERE a.obrisan = 1").getResultList();

	}
	
	public static boolean razduzi(int idautomobil) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Automobil auto = em.find(Automobil.class, idautomobil);
			if(auto != null) {
				auto.setObrisan(0);
				em.persist(auto);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
		
	}
	
	
	public static void main(String[] args) {
		
//		List<Automobil> all = listAllAutomobil();
//		for (Automobil automobil : all) {
//			System.out.println(automobil.toString());
//		}
//		
//		Automobil auto = getOneAutomobil(1);
//		System.out.println(auto);
		
//		List<Automobil> listaOb = listZauzeto();
//		
//		for (Automobil automobil : listaOb) {
//			System.out.println(automobil);
//			
//		}
		
		boolean razduziAuto = razduzi(2);
		
		if(razduziAuto) {
			System.out.println("ok");
		}
		else {
			System.out.println("/");
		}
	
//		List<Automobil> allMarka = findAllByMarka("opel");
//		for (Automobil automobil : allMarka) {
//			System.out.println(automobil.toString());
//		}	
//		
		
	}

}
