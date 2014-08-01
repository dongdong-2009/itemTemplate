package cn.voicet.item.service;

import cn.voicet.item.web.form.SystemLogForm;
import cn.voicet.util.DotSession;

public interface SystemLogService {
	public final static String SERVICE_NAME = "cn.voicet.item.service.impl.SystemLogServiceImpl";
	int findLogTotalPage(DotSession ds, SystemLogForm systemLogForm);
	void findLogInfoList(DotSession ds, SystemLogForm systemLogForm);
}
