package com.amc.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InsertDAO {
	
	private Logger logger = Logger.getLogger("DAO");
	private static InsertDAO instance = null;
		
	private SessionFactory mFactory = null;
	
	public InsertDAO(){
		try {
			mFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error in creating session factory.");
			throw new ExceptionInInitializerError(ex);
		}
	
	
}

	public boolean insertVendorDAO(String vendor, String vendorPurp) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
		
		
		String strQuery="INSERT INTO tbl_vendors("
				+ "vendorName,"
				+ "vendorPurpose,"
				+ "status"
				+ ") VALUES ("
				+ ":vendor,"
				+ ":vendorPurp,"
				+ ":vendorStatus"
				+ ")";

		System.out.println("check"+strQuery);
		
		SQLQuery query = session.createSQLQuery(strQuery);
		
		query.setParameter("vendor",vendor);
		query.setParameter("vendorPurp",vendorPurp);
		query.setParameter("vendorStatus","Y");

		if(query.executeUpdate()>0){
			 ret=true;
	           tx.commit();
	      } 
	
	}	
	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN INSERT OF VENDOR NAME  ");
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
	
		
public boolean insertAmcDetails(String vendorId, String amc_purpose,String amcStartDate,String amcEndDate) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
		
		
		String strQuery="INSERT INTO tbl_amcdates("
				+ "vendor_id,"
				+ "amc_purpose,"
				+ "amc_from,"
				+ "amc_to,"
				+ "amc_status,"
				+ "email_status"
				+ ") VALUES ("
				+ ":vendorId,"
				+ ":amc_purpose,"
				+ ":amcStartDate,"
				+ ":amcEndDate,"
				+ ":amcStatus,"
				+ ":emailStatus"
				+ ")";

		System.out.println("check"+strQuery);
		
		SQLQuery query = session.createSQLQuery(strQuery);
		
		query.setParameter("vendorId",vendorId);
		query.setParameter("amc_purpose",amc_purpose);
		query.setParameter("amcStartDate",amcStartDate);
		query.setParameter("amcEndDate",amcEndDate);
		query.setParameter("amcStatus","Y");
		query.setParameter("emailStatus","N");


		if(query.executeUpdate()>0){
			 ret=true;
	           tx.commit();
	      } 
	
	}	
	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN INSERT OF VENDOR NAME  ");
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
		
public boolean updateAmcDetail(String amcId, String amcPurpose,String amcStartDate, String amcEndDate) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
		
		System.out.println(" "+amcId +" "+amcPurpose+" "+amcStartDate+" "+amcEndDate);
		
		
		String strQuery="update tbl_amcdates set "
				+ "amc_purpose = :amcPurpose,"
				+ "amc_from = :amcStartDate,"
				+ "amc_to = :amcEndDate "
				+ "where id = :amcId";
		
		System.out.println("QUERY TEST UPDATE AMC TEST"+strQuery);

		SQLQuery query = session.createSQLQuery(strQuery);
		
		query.setParameter("amcPurpose",amcPurpose);
		query.setParameter("amcStartDate",amcStartDate);
		query.setParameter("amcEndDate",amcEndDate);
		query.setParameter("amcId",amcId);
		
		if(query.executeUpdate()>0){
			 ret=true;
	           tx.commit();
	      } 
	
	}	
	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN UPDATE OF USER ACCESSSS  ");
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
