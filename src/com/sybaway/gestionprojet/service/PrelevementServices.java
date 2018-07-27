package com.sybaway.gestionprojet.service;


import java.util.List;

import com.sybaway.gestionprojet.dao.entity.Prelevement_saisons;

public interface PrelevementServices {

	public void addProjet(Prelevement_saisons p);
	
	public Prelevement_saisons editProjet(Prelevement_saisons p);
	
	public void deleteProjet(Long id);
	
	public List<Prelevement_saisons> findAllPrelevement();
	
	public Prelevement_saisons findProjetById(Long id);
	
	public List<Object[]> attributionsBarChart();
	
	public List<Object[]> realisationsBarChart();
	
	public List<Object[]> realisationPersonnaliserDE(int departement,String espece);
	
	public List<Object[]> attributionPersonnaliserDE(int departement,String espece);
	
	public Object attributionMaxValue(int departement,String espece);
	
	public void importToDB(String cheminFichier);
}
