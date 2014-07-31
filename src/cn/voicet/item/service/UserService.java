package cn.voicet.item.service;

import java.util.Map;

import cn.voicet.item.web.form.UserForm;
import cn.voicet.util.DotSession;

public interface UserService {
	public final static String SERVICE_NAME = "cn.voicet.item.service.impl.UserServiceImpl";
	Map<String, Object> userLogin(UserForm userForm);
	Integer updateUserPassword(DotSession ds, UserForm userForm);
}
