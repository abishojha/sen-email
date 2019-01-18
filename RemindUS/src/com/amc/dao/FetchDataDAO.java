package com.amc.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amc.beans.Access;
import com.amc.beans.AmcBeforeThirty;
import com.amc.beans.AmcDetail;
import com.amc.beans.MemberLogin;
import com.amc.beans.Users;
import com.amc.beans.Vendor;


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
	

	public List<AmcDetail> fetchAmcDetails() {		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<AmcDetail> listamcdetail=new ArrayList<AmcDetail>();

		Session session = this.mFactory.openSession();
		Transaction tx = null;		
	try {
	
		tx = session.beginTransaction();
		SQLQuery query = session
				.createSQLQuery("SELECT ven.vendorName,amcs.amc_purpose,amcs.amc_from,amcs.amc_to,"
						+ "DATEDIFF(amcs.amc_to,amcs.amc_from),amcs.amc_status,"
						+ "amcs.email_status from tbl_vendors ven inner join tbl_amcdates amcs on amcs.vendor_id = ven.id order by ven.id desc");	
		for (Object[] row : (List<Object[]>) query.list()) {
			
			AmcDetail amcdetail = new AmcDetail();		
			amcdetail.setVendorNm((String) row[0]);
			amcdetail.setAmcPurpose((String) row[1]);
			
			Timestamp startTime=(Timestamp) row[2];
			amcdetail.setAmcStartDate(new Date(startTime.getTime()));

			Timestamp endTime=(Timestamp) row[3];
			amcdetail.setAmcEndDate(new Date(endTime.getTime()));
			
			amcdetail.setDaysLeft((Integer) row[4]);
			amcdetail.setAmcStatus((String) row[5]);
			amcdetail.setEmailStatus((String) row[6]);


			listamcdetail.add(amcdetail);
		}		
		//System.out.println("In Fetch DAO........Branch ID"+listbranch.get(0)+"....."+"PASS...."+listbranch.get(1));
		tx.commit();
	}	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN DAO fetchAmcDetails()");
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
		mFactory.close();
	}
	return listamcdetail;
}
	
	public List<AmcBeforeThirty> fetchAmcDetailBeforeThirty(Timestamp tstmp) {	
		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<AmcBeforeThirty> listamcdetail=new ArrayList<AmcBeforeThirty>();

		Session session = this.mFactory.openSession();
		Transaction tx = null;		
	try {
	
		tx = session.beginTransaction();
		SQLQuery query = session
				.createSQLQuery("SELECT amcs.id,vendorName,amcs.amc_purpose,amcs.amc_from,amcs.amc_to,"
						+ "DATEDIFF(amcs.amc_to,'"+tstmp+"'),amcs.amc_status,"
						+ "amcs.email_status from tbl_vendors ven inner join tbl_amcdates amcs on amcs.vendor_id = ven.id where DATEDIFF(amcs.amc_to,'"+tstmp+"')<='30' order by ven.id desc");	
		for (Object[] row : (List<Object[]>) query.list()) {
			
			AmcBeforeThirty abt = new AmcBeforeThirty();
			abt.setVendorId((Integer) row[0]);

			abt.setVendorNm((String) row[1]);
			abt.setAmcPurpose((String) row[2]);
			
			Timestamp startTime=(Timestamp) row[3];
			abt.setAmcStartDate(new Date(startTime.getTime()));

			Timestamp endTime=(Timestamp) row[4];
			abt.setAmcEndDate(new Date(endTime.getTime()));
						
			abt.setDaysLeft((Integer) row[5]);
			abt.setAmcStatus((String) row[6]);
			abt.setEmailStatus((String) row[7]);


			listamcdetail.add(abt);
		}		
		//System.out.println("In Fetch DAO........Branch ID"+listbranch.get(0)+"....."+"PASS...."+listbranch.get(1));
		tx.commit();
	}	
	catch (Exception e) {
		logger.log(Level.WARNING, "ERROR IN DAO AMC Before Thirty()");
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
		mFactory.close();
	}
	return listamcdetail;
}
	
	
	public List<Users> fetchUsers() {		
		if (mFactory.isClosed()) {
		mFactory=new Configuration().configure().buildSessionFactory();
		}		
		List<Users> listvendors=new ArrayList<Users>();

		Session session = this.mFactory.openSession();
		Transaction tx = null;		
	try {
		tx = session.beginTransaction();
		SQLQuery query = session
				.createSQLQuery("SELECT ID,USER_NAME,ASSOCIATED_GRP,USER_GRP from login_id where ACTIVE_STAT='Y'");	
		for (Object[] row : (List<Object[]>) query.list()) {
			
			Users users = new Users();
			users.setId((Integer) row[0]);
			users.setUserName((String) row[1]);
			users.setUserGroup((String) row[2]);
			users.setUserRole((String) row[3]);

			listvendors.add(users);
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