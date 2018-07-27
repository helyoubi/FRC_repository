package com.sybaway.gestionprojet.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sybaway.gestionprojet.dao.entity.Prelevement_saisons;
import com.sybaway.gestionprojet.util.HibernateUtil;


public class PrelevementDAOImpl implements PrelevementDAO{

	Session session = HibernateUtil.openSession();
	
	
	@Override
	public void addPrelevement(Prelevement_saisons p) {
		
		
		session.beginTransaction();
		
		session.save(p);

		session.getTransaction().commit();
		
	}

	@Override
	public Prelevement_saisons editPrelevement(Prelevement_saisons p) {
		
		session.beginTransaction();
		
		Prelevement_saisons projet = (Prelevement_saisons) session.merge(p);

		session.getTransaction().commit();
		
		return projet;
	}

	@Override
	public void deletePrelevement(Long id) {
		
		session.beginTransaction();
		
		Prelevement_saisons projet = findPrelevementById(id);

		session.delete(projet);
		
		session.getTransaction().commit();
		
	}

	@Override
	public List<Prelevement_saisons> findAllPrelevement() {
		
		return session.createQuery("select p from Prelevement_saisons p").list();
	}

	@Override
	public Prelevement_saisons findPrelevementById(Long id) {
		
		return (Prelevement_saisons) session.get(Prelevement_saisons.class, id);
	}

	@Override
	public List<Object[]> attributionsBarChart() {
		
		return session.createQuery("SELECT a.saison,sum(a.attributions) FROM Prelevement_saisons a GROUP BY a.saison").list();
	}
	
	@Override
	public List<Object[]> realisationsBarChart() {
		
		return session.createQuery("SELECT a.saison,sum(a.realisations) FROM Prelevement_saisons a GROUP BY a.saison").list();
	}
	
	@Override
	public List<Object[]> realisationPersonnaliserDE(int departement,String espece) {
		
		return session.createQuery("SELECT a.saison,sum(a.realisations) FROM Prelevement_saisons a where departement = "+departement+" and espece = '"+espece+"' GROUP BY a.saison").list();
	}
	
	@Override
	public List<Object[]> attributionPersonnaliserDE(int departement,String espece) {
		
		return session.createQuery("SELECT a.saison,sum(a.attributions) FROM Prelevement_saisons a where departement = "+departement+" and espece = '"+espece+"' GROUP BY a.saison").list();
	}
	
	
	@Override
	public Object attributionMaxValue(int departement,String espece) {
		Query q = session.createQuery("SELECT SUM(a.attributions+2) AS total FROM Prelevement_saisons a where a.departement  = "+departement+" and a.espece = '"+espece+"' GROUP BY a.saison ORDER BY total DESC").setMaxResults(1);
	    Long count = (Long) q.uniqueResult();
	    
	    return count;
	}
	
	
	@Override
	public void importToDB(String cheminFichier) {
		
		session.beginTransaction();
		
		//session.createQuery("LOAD DATA INFILE '"+cheminFichier+"' INTO TABLE Prelevement_saisons FIELDS TERMINATED BY ',' ENCLOSED BY '\"'(espece,saison,departement,commune,code,attributions,realisations)").executeUpdate();

		session.createSQLQuery("LOAD DATA LOCAL INFILE :filename INTO TABLE Prelevement_saisons FIELDS TERMINATED BY ';' (espece,saison,departement,commune,code,attributions,realisations)").setString("filename", cheminFichier).executeUpdate();
		
		session.getTransaction().commit();
		
	}
	
	
}
