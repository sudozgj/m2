package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Update;
import org.model.User;
import org.model.UserDetail;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VUser;
import org.view.VUserId;

@Service
public class UserDaoImp implements UserDao {

	@Override
	public User getUser(String username) {
		try {
			Session session = HibernateSessionFactory.getSession();

			Query query = session.createQuery("from User where username=?");
			query.setParameter(0, username);
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return new User();
		}
	}

	@Override
	public User getUser(String username, String password) {
		try {
			Session session = HibernateSessionFactory.getSession();

			Query query = session
					.createQuery("from User where username=? and password=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.setMaxResults(1);
			User user = (User) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long addUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			User user = new User(u.getUsername(), u.getPassword(),
					u.getCreateTime());
			long id = (Long) session.save(user);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long addUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			UserDetail uDetail = new UserDetail(ud.getName(), ud.getEmail(),
					ud.getUserId());
			long id = (Long) session.save(uDetail);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteUser(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			SQLQuery sqlQuery = session
					.createSQLQuery("delete from user where id=?");
			sqlQuery.setParameter(0, id);
			sqlQuery.executeUpdate();

			SQLQuery sqlQuery2 = session
					.createSQLQuery("delete from user_detail where user_id=?");
			sqlQuery2.setParameter(0, id);
			sqlQuery2.executeUpdate();

			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateUserPassword(long id, String password) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("update User u set u.password=? where u.id=?");
			query.setParameter(0, password);
			query.setParameter(1, id);
			query.executeUpdate();
			ts.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("update UserDetail u set u.name=?,email=? where u.userId=?");
			query.setParameter(0, u.getName());
			query.setParameter(1, u.getEmail());
			query.setParameter(2, u.getUserId());
			query.executeUpdate();
			ts.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getUserList() {
		try {
			Session session = HibernateSessionFactory.getSession();

			SQLQuery sqlQuery = session
					.createSQLQuery("select * from v_user order by id desc");
			sqlQuery.addEntity(VUser.class);
			List<VUser> list = sqlQuery.list();
			List<VUserId> li = new ArrayList<>();
			for (VUser v : list)
				li.add(v.getId());

			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
