package com.sybaway.gestionprojet.util;




import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.sybaway.gestionprojet.service.PrelevementServices;
import com.sybaway.gestionprojet.service.PrelevementServicesImpl;


public class Test {

	
	static Session session = HibernateUtil.openSession();
	
	public static Logger log = Logger.getLogger(Test.class);
	
	private static PrelevementServices prelevServ = new PrelevementServicesImpl();
	
	public static void main(String[] args) {
	
		Object valueMax = prelevServ.attributionMaxValue(40, "CE");
		
		System.out.println("valeur max attrib est : "+valueMax);
		
	
	}

}
