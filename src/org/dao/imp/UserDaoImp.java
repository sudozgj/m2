package org.dao.imp;


import java.util.ArrayList;
import java.util.List;

import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.User;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VUser;
import org.view.VUserId;

@Service
public class UserDaoImp implements UserDao{
	@Override
	public User login(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from User where username=? and password=?");
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			query.setMaxResults(1);
			User user = (User) query.uniqueResult();
			if(user!=null)
				return user;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long addUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			User user = new User(u.getUsername(),u.getPassword(),u.getCreateTime());
			long id = (Long) session.save(user);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally{
			HibernateSessionFactory.closeSession();
		}
	}

//	@Override
//	public List getUserList() {
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction ts = session.beginTransaction();
//			
//			Query query = session.createQuery("from User");
//			List<User> uList = query.list();
//			
//			return uList;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally{
//			HibernateSessionFactory.closeSession();
//		}
//	}
	
	@Override
	public List getUserList(){
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery("select * from v_user order by id desc");
			sqlQuery.addEntity(VUser.class);
			List<VUser> list = sqlQuery.list();
			List<VUserId> li = new ArrayList<>();
			for(VUser v:list){
				li.add(v.getId());
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
}
