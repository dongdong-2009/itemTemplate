package cn.voicet.item.dao;

import cn.voicet.item.web.form.SystemLogForm;
import cn.voicet.util.DotSession;

public interface SystemLogDao{
	public final static String SERVICE_NAME = "cn.voicet.item.dao.impl.SystemLogDaoImpl";
	int findLogTotalPage(DotSession ds, SystemLogForm systemLogForm);
	void findLogInfoList(DotSession ds, SystemLogForm systemLogForm);
}
