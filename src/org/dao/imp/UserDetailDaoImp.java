package org.dao.imp;

import java.util.List;

import org.dao.UserDetailDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.UserDetail;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class UserDetailDaoImp implements UserDetailDao {

	@Override
	public long addUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			UserDetail uDetail = new UserDetail(ud.getName(),ud.getEmail(),ud.getUserId());
			long id = (Long) session.save(uDetail);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getUserDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editUserDetail(UserDetail ud) {
		// TODO Auto-generated method stub
		return false;
	}

}
