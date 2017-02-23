package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dao.FileioDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Fileio;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VFile;

@Service
public class FileioDaoImp implements FileioDao {

	@Override
	public boolean addFile(Fileio file) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Fileio f = new Fileio();
			f.setUsername(file.getUsername());
			f.setFilename(file.getFilename());
			f.setTime(file.getTime());
			f.setDir(file.getDir());
			f.setUrl(file.getUrl());
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
			String sql = "select * from v_file";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(VFile.class);
			if (start == null) {
				start = 0;
			}
			if (limit == null) {
				limit = 15;
			}
			sqlQuery.setFirstResult(start);
			sqlQuery.setMaxResults(limit);
			List<VFile> li = sqlQuery.list();

			List list = new ArrayList<>();
			for (VFile b : li) {
				list.add(b.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Fileio getFile(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Fileio where id =?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Fileio f = (Fileio) query.uniqueResult();
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public long getFileCount() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("select count(id) from Fileio");
			query.setMaxResults(1);
			Long count = (Long) query.uniqueResult();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1L;
		}
	}

	@Override
	public boolean deleteFile(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Fileio f = (Fileio) session.load(Fileio.class, id);
			session.delete(f);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
