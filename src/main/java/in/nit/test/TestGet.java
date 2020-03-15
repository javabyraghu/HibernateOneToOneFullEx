package in.nit.test;

import org.hibernate.Session;

import in.nit.model.User;
import in.nit.model.UserDtl;
import in.nit.util.HibernateUtil;

public class TestGet {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {

			User usr=ses.get(User.class, 551);
			//Do not print complete object > may result Stack Overflow Error
			System.out.println(usr.getUsername());
			System.out.println(usr.getUserDtl().getFirstName());
			
			//--result must be same from two sides.. then valid bi-directional
			
			UserDtl dtl=ses.get(UserDtl.class, 10);
			System.out.println(dtl.getUserOb().getUsername());
			System.out.println(dtl.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
