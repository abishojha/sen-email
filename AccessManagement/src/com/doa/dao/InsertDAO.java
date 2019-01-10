package com.doa.dao;

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

	public boolean insertAccessDAO(String selBranch, String userAccName,String cbsId, String seltitle, String grpAcc, String userRemarks) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
		
		System.out.println("Aaaa"+selBranch+"Bbbb"+userAccName+"Ccccc"+seltitle);
		System.out.println("DDDD"+grpAcc+"EEEE"+grpAcc);

		
		
		
		String strQuery="INSERT INTO useraccess("
				+ "branchCode,"
				+ "userName,"
				+ "cbsId,"
				+ "jobTitle,"
				+ "cbsAccess,"
				+ "remarks,"
				+ "status"
				+ ") VALUES ("
				+ ":SELECTBRANCH,"
				+ ":USERACCESSNAME,"
				+ ":CBSID,"
				+ ":SELECTTITLE,"
				+ ":GROUPACCOUNT,"
				+ ":REMARKS,"
				+ ":STATUS"
				+ ")";

		System.out.println("check"+strQuery);
		
		SQLQuery query = session.createSQLQuery(strQuery);
		
		query.setParameter("SELECTBRANCH",selBranch);
		query.setParameter("USERACCESSNAME",userAccName);
		query.setParameter("CBSID",cbsId);

		query.setParameter("SELECTTITLE",seltitle);
		query.setParameter("GROUPACCOUNT",grpAcc);
		query.setParameter("REMARKS",userRemarks);
		query.setParameter("STATUS","Active");




		if(query.executeUpdate()>0){
			 ret=true;
	           tx.commit();
	      } 
	
	}	
	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN INSERT OF USER ACCESSSS  ");
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
	
public boolean updateAccessDAO(String selBranch, String userAccName,String cbsId, String seltitle, String grpAcc, String userRemarks) {
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}
		
		boolean ret=false;
		Session session = this.mFactory.openSession();
		Transaction tx = null;

		
	try {
		tx = session.beginTransaction();
	/*	+ "branchCode,"
		+ "userName,"
		+ "cbsId,"
		+ "jobTitle,"
		+ "cbsAccess,"
		+ "remarks,"
		+ "status"*/
		
		String strQuery="update `useraccess` set "
				+ "`branchCode` = :SELECTBRANCH,"
				+ "`userName` = :USERACCESSNAME,"
				+ "`jobTitle` = :SELECTTITLE,"
				+ "`cbsAccess` = :GROUPACCOUNT,"
				+ "`remarks` = :REMARKS"
				+ " where `cbsId` = :CBSID";
		
		System.out.println("QUERY TEST"+strQuery);

		SQLQuery query = session.createSQLQuery(strQuery);
		
		query.setParameter("SELECTBRANCH",selBranch);
		query.setParameter("USERACCESSNAME",userAccName);
		query.setParameter("CBSID",cbsId);
		query.setParameter("SELECTTITLE",seltitle);
		query.setParameter("GROUPACCOUNT",grpAcc);
		query.setParameter("REMARKS",userRemarks);

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
