package cn.voicet.item.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.voicet.item.dao.SystemLogDao;
import cn.voicet.item.service.SystemLogService;
import cn.voicet.item.web.form.SystemLogForm;
import cn.voicet.util.DotSession;

@Transactional(readOnly=true)
@Service(SystemLogService.SERVICE_NAME)
public class SystemLogServiceImpl implements SystemLogService{
	
	@Resource(name=SystemLogDao.SERVICE_NAME)
	private SystemLogDao systemLogDao;
	public int findLogTotalPage(DotSession ds, SystemLogForm systemLogForm) {
		return systemLogDao.findLogTotalPage(ds, systemLogForm);
	}
	public void findLogInfoList(DotSession ds, SystemLogForm systemLogForm) {
		systemLogDao.findLogInfoList(ds, systemLogForm);
	}

}
