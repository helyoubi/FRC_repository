package com.sybaway.gestionprojet.service;

import com.sybaway.gestionprojet.dao.ChasseurLoginDAO;
import com.sybaway.gestionprojet.dao.ChasseurLoginDAOImpl;

public class ChasseurLoginServicesImpl implements ChasseurLoginServices {
	

	ChasseurLoginDAO chasseurLogin = new ChasseurLoginDAOImpl();
	
	@Override
	public boolean checkuser(String loginChasseur, String mdpChasseur) {
		
		return chasseurLogin.checkuser(loginChasseur, mdpChasseur);
		
	}


	
	
}
