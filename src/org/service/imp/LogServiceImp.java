package org.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dao.LogDao;
import org.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;

@Service
public class LogServiceImp implements LogService {
	@Autowired
	private LogDao lDao;
	
	@Override
	public Object getLogList(Integer start,Integer limit) {
		Map<String, Object> map = new HashMap<>();
		long count = lDao.getLogCount();
		List list = lDao.getLogList(start,limit);
		map.put("count", count);
		map.put("list", list);
		return JsonObject.getResult(1, "获取日志列表", map);
	}

}
