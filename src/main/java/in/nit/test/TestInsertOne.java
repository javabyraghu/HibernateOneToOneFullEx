package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.User;
import in.nit.model.UserDtl;
import in.nit.util.HibernateUtil;

public class TestInsertOne {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			UserDtl dtl1=new UserDtl(10, "AA", "BB", "a@gm.com");
			UserDtl dtl2=new UserDtl(11, "CC", "DD", "c@gm.com");
			UserDtl dtl3=new UserDtl(12, "EE", "FF", "e@gm.com");
			
			User usr1=new User(551, "ausr", "bpwd", dtl1);
			User usr2=new User(552, "cusr", "dpwd", dtl2);
			User usr3=new User(553, "eusr", "fpwd", dtl3);
			
			ses.save(usr1);
			ses.save(usr2);
			ses.save(usr3);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}


