package com.doa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.doa.beans.Access;
import com.doa.beans.Vendor;
import com.doa.beans.MemberLogin;
import com.doa.beans.UserAccess;


public class FetchDataDAO {
	
	private Logger logger = Logger.getLogger("DAO");
	private static FetchDataDAO instance = null;
	
	/*public static FetchDataDAO getInstance(){
		if (instance == null)
			instance = new FetchDataDAO();
		return instance;
		
	}*/
	
	private SessionFactory mFactory = null;
	
	public FetchDataDAO(){
		try {
			mFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error in creating session factory.");
			throw new ExceptionInInitializerError(ex);
		}
	
	
}

	public List<Vendor> fetchVendor() {		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<Vendor> listvendors=new ArrayList<Vendor>();

		Session session = this.mFactory.openSession();
		Transaction tx = null;		
	try {
		tx = session.beginTransaction();
		SQLQuery query = session
				.createSQLQuery("SELECT id,vendorName,vendorPurpose,status from tbl_vendors");	
		for (Object[] row : (List<Object[]>) query.list()) {
			
			Vendor vendors = new Vendor();		
			vendors.setId((Integer) row[0]);
			vendors.setVendor((String) row[1]);
			vendors.setVendorPurpose((String) row[2]);
			vendors.setStatus((String) row[3]);

			listvendors.add(vendors);
		}		
		//System.out.println("In Fetch DAO........Branch ID"+listbranch.get(0)+"....."+"PASS...."+listbranch.get(1));
		tx.commit();
	}	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN DAO fetchVendorLists()");
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
		mFactory.close();
	}
	return listvendors;
}
	

	

	public List<Access> fetchAccess() {		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<Access> listaccess=new ArrayList<Access>();

		Session session = this.mFactory.openSession();
		Transaction tx = null;		
			try {
				tx = session.beginTransaction();
				SQLQuery query = session
						.createSQLQuery("SELECT id, groupAcc, title, post FROM accesses");	
				for (Object[] row : (List<Object[]>) query.list()) {					
					Access accss = new Access();		
					accss.setId((String) row[0]);
					accss.setGroup((String) row[1]);
					accss.setTitle((String) row[2]);
					accss.setPost((String) row[3]);
					listaccess.add(accss);
				}		
				tx.commit();
			}	
				catch (Exception e) {
					logger.log(Level.WARNING, "ERROR IN DAO fetchAccess()");
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
					mFactory.close();
				}
				return listaccess;
}
	


	public List<UserAccess> fetchUserAccess() {		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<UserAccess> listaccess=new ArrayList<UserAccess>();
		Session session = this.mFactory.openSession();
		Transaction tx = null;		
			try {
				tx = session.beginTransaction();
				SQLQuery query = session
						.createSQLQuery("SELECT b.branchName,a.userName,a.cbsId,a.jobTitle,a.cbsAccess,a.remarks,a.status FROM useraccess a inner join branch b ON a.branchCode=b.branchId");	
				for (Object[] row : (List<Object[]>) query.list()) {					
					UserAccess accss = new UserAccess();		
					accss.setBranchName((String) row[0]);
					accss.setUserName((String) row[1]);
					accss.setCbsId((String) row[2]);
					accss.setJobTitle((String) row[3]);
					accss.setCbsAccess((String) row[4]);
					accss.setRemarks((String) row[5]);
					accss.setStatus((String) row[6]);	
					listaccess.add(accss);
				}		
				tx.commit();
			}	
				catch (Exception e) {
					logger.log(Level.WARNING, "ERROR IN  fetchUserAccess()");
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
					mFactory.close();
				}
				return listaccess;
    }
}