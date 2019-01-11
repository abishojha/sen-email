package com.doa.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.doa.beans.MemberLogin;


public class LoginDAO {
	private Logger logger = Logger.getLogger("SelectDAO");
	private static LoginDAO instance = null;

	public static LoginDAO getInstance() {
		if (instance == null)
			instance = new LoginDAO();
		return instance;
	}

	private SessionFactory mFactory = null;

	private LoginDAO() {
		try {
			mFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error in creating session factory.");
			throw new ExceptionInInitializerError(ex);
		}
	}
	

	
	public MemberLogin searchDatabase(String username) {
		if (mFactory.isClosed()) {
			mFactory = new Configuration().configure().buildSessionFactory();
		}
		MemberLogin memberLoginBean = new MemberLogin();

		Session session = this.mFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("SELECT ID,USER_NAME,PASSWORD,USER_GRP,ROLE, UPDATE_TIME_STAMP,"
							+ "ACTIVE_STAT,INSERT_TIME_STAMP FROM `login_id` WHERE USER_NAME= :username AND ACTIVE_STAT='Y'");
			query.setParameter("username", username);
			

			for (Object[] row : (List<Object[]>) query.list()) {
				// memberLoginBean.setId((Integer) row[0]);
				memberLoginBean.setUsername((String) row[1]);
				memberLoginBean.setPassword((String) row[2]);
				memberLoginBean.setUsrGrp((String) row[3]);
				memberLoginBean.setRole((String) row[4]);
				// memberLoginBean.setUpdate_time_stamp((Date) row[5]);
				memberLoginBean.setActiveStat((Character) row[6]);
				// memberLoginBean.setInsert_time_stamp((Date) row[7]);
				logger.log(Level.WARNING, "username=" + (String) row[1]
						+ ",password=" + (String) row[2] + ", active_stat="
						+ (Character) row[6]);
			}
			
			System.out.println("In DAO........USERNAME"+memberLoginBean.getUsername()+"....."+"PASS...."+memberLoginBean.getPassword());

			tx.commit();
		} catch (Exception e) {
			logger.log(Level.WARNING, "ERROR IN DAO searchDatabase()");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			mFactory.close();
		}
		return memberLoginBean;
	}


}
