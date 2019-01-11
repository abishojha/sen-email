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
				.createSQLQuery("SELECT id,vendorName,vendorPurpose,status from tbl_vendors order by id desc");	
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
	

	

	


	
}