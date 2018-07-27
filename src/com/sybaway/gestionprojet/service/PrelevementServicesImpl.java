package com.sybaway.gestionprojet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sybaway.gestionprojet.dao.PrelevementDAO;
import com.sybaway.gestionprojet.dao.PrelevementDAOImpl;
import com.sybaway.gestionprojet.dao.entity.Prelevement_saisons;

public class PrelevementServicesImpl implements PrelevementServices {

	//ON ne doit pas appeler l'objet session de session factory , sinn il y aura une communication directe entre la couche m�tier qui est service et la couche de la bd ce qui est faux
	
	PrelevementDAO progdao = new PrelevementDAOImpl();
	
	@Override
	public void addProjet(Prelevement_saisons p) {
		
		progdao.addPrelevement(p);
	}

	@Override
	public Prelevement_saisons editProjet(Prelevement_saisons p) {
		
		//Ici par exemple : on implemente le code pour un traitement métier du client , avant de modifier les attribut de la classe Projet comme exemple :
	    //Faire une copier avant de modifier la tablea Projet ou envoyer une notification avant de modifier ..
		
		return progdao.editPrelevement(p);
	}

	@Override
	public void deleteProjet(Long id) {
		
		progdao.deletePrelevement(id);

	}

	@Override
	public List<Prelevement_saisons> findAllPrelevement() {
		
		return progdao.findAllPrelevement();
	}

	@Override
	public Prelevement_saisons findProjetById(Long id) {
		
		return progdao.findPrelevementById(id);
	}

	@Override
	public List<Object[]> attributionsBarChart() {
		
		return progdao.attributionsBarChart();
	}
	
	@Override
	public List<Object[]> realisationsBarChart() {
		
		return progdao.realisationsBarChart();
	}

	@Override
	public List<Object[]> realisationPersonnaliserDE(int departement, String espece) {
		
		return progdao.realisationPersonnaliserDE(departement, espece);
	}

	@Override
	public List<Object[]> attributionPersonnaliserDE(int departement, String espece) {
		
		return progdao.attributionPersonnaliserDE(departement, espece);
	}

	@Override
	public Object attributionMaxValue(int departement, String espece) {
		
		return progdao.attributionMaxValue(departement, espece);
	}

	@Override
	public void importToDB(String cheminFichier) {
		
		progdao.importToDB(cheminFichier);
		
	}

}
