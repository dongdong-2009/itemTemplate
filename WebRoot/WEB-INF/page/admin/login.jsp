<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link type="text/css" href="<c:url value='/style/common_cn.css'/>" rel="stylesheet" />
	<link type="text/css" href="<c:url value='/style/layout.css'/>" rel="stylesheet" />
	<script type="text/javascript" src="<c:url value='/script/jquery-1.11.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/script/cookie.js'/>"></script>
 	<script type="text/javascript" src="<c:url value='/script/login.js'/>"></script>
 	<script type="text/javascript">
 	$(document).ready(function() {
 		document.all.account.focus();
		try {
			var account = Cookie.getCookie("accountybh");
			var password =  Cookie.getCookie("passwordybh");
			if(account!="" && account!=null){
				$("#account").val(account);
				$("#password").val(password);
				$("#rememberPass").attr("checked", true); 
			}
		} catch(e) {
			
		}
 	});
 	document.onkeydown = function(e) {   
		var theEvent = e || window.event;   
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode; 
		if (code == 13) {   
    		login();
    		return false;   
		}   
		return true;
	}
 	</script>
 	<title>扶贫观察点管理系统</title>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<meta http-equiv="cache-control" content="no-cache"/>
 	<meta http-equiv="expires" content="0"/>
</head>
<body>
<div class="login_wrap">
   	<div class="login_main">
       	<div class="login_main_up">
           	<div class="login_product"><s:property value="#application.vta.product"/></div>
            <div class="login_company"><strong><s:property value="#application.vta.customer"/></strong></div>
		</div>
		<div class="login_main_down">
           	<div class="login_content">
               	<table class="table_l" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr height="24px">
							<th class="login_label">账号&nbsp;</th>
							<td><input type="text" id="account" name="account"  autocomplete="off" value="" placeholder="输入账号" tabindex="1" class="ipt155"/></td>
						</tr>
						<tr height="24px">
							<th class="login_label">密码&nbsp;</th>
							<td><input type="password" id="password" name="password"  autocomplete="off" value="" placeholder="输入密码" tabindex="2" class="ipt155"/></td>
						</tr>
						<tr height="24px">
							<th class="login_label">验证码&nbsp;</th>
							<td align="left">
								<input type="text" id="vercode" name="vercode" placeholder="输入验证码" class="ipt70" maxlength="4"/>
								<input type="hidden" id="bpath" value="${pageContext.request.contextPath }"/>
								<img src="${pageContext.request.contextPath }/verCode" id="verImg" onclick="changeVerCode()" class="cursor_p" height="20" width="60"/>
							</td>
						</tr>
						<tr height="24px">
							<th></th>
							<td>
								<input type="checkbox" id="rememberPass" name="rememberPass" value="yes"/><label for="rememberPass">记住密码</label>
							</td>
						</tr>
						<tr height="24px">
							<th></th>
							<td>
								<input type="button" onclick="login()" value="登&nbsp;&nbsp;录" class="btn4"/>
							</td>
						</tr>
					</tbody>
				</table>
            </div>
        </div>
    </div>
</div>
</body>
</html>