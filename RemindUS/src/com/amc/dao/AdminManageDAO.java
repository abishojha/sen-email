package com.amc.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AdminManageDAO {
	
	private Logger logger = Logger.getLogger("DAO");
	private static AdminManageDAO instance = null;
	
	public static AdminManageDAO getInstance(){
		if (instance == null)
			instance = new AdminManageDAO();
		return instance;
		
	}
	
	private SessionFactory mFactory = null;
	
	private AdminManageDAO(){
		try {
			mFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error in creating session factory.");
			throw new ExceptionInInitializerError(ex);
		}
	
	
}

	public boolean insertCategory(String cat, String uname) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
		
		System.out.println("Categoy!!!"+cat+".... ADDED BY!!!"+uname);

		
		String strquery="insert into credit_category("
				+ "category"
				+ ",userAdd"				
				+ ") values ("
				+ ":CATEGORY"
				+ ",:USERADD"

				+ ")";

		System.out.println("check"+strquery);
		
		SQLQuery query = session.createSQLQuery(strquery);
		
		query.setParameter("CATEGORY",cat);
		query.setParameter("USERADD",uname);

		


		if(query.executeUpdate()>0){
			 ret=true;
	           tx.commit();
	      } 
	
	}	
	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN INSERT OF CATEGORY ");
		if (tx != null)
		tx.rollback();
		ret=false;
		e.printStackTrace();
	} finally {
		session.close();
		mFactory.close();
	}
	return ret;

	}
}
