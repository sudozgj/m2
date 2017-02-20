package org.dao.imp;

import java.util.List;

import org.dao.FileioDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Fileio;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class FileioDaoImp implements FileioDao {

	@Override
	public boolean addFile(Fileio file) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.getTransaction();

			Fileio f = new Fileio();
			f.setUsername(file.getUsername());
			f.setFilename(file.getFilename());
			f.setTime(file.getTime());
			f.setDir(file.getDir());
			session.save(f);
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
	public List getFileList(Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.getTransaction();
			
			
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long getFileCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
