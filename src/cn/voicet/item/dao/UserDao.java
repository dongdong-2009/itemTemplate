package cn.voicet.item.dao;

import java.util.Map;

import cn.voicet.item.web.form.UserForm;
import cn.voicet.util.DotSession;

public interface UserDao{
	public final static String SERVICE_NAME = "cn.voicet.item.dao.impl.UserDaoImpl";
	Map<String, Object> userLogin(UserForm userForm);
	Integer updateUserPassword(DotSession ds, UserForm userForm);
}
