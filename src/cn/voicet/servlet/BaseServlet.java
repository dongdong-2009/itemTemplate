package cn.voicet.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 处理响应码
		response.setContentType("text/html;charset=UTF-8");
		
		// 1.获取method参数，它是用户想调用的方法 
		String methodName = request.getParameter("method");
		
		// 2.把方法名称变成Method类的实例对象
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法：" + methodName + "它不存在！", e);
		}
		
		//3.通过invoke()来调用这个方法
		try {
			String result = (String)method.invoke(this, request, response);
			//如果请求处理方法返回不为空
			if(null!=result && !result.trim().isEmpty())
			{
				//获取第一个冒号的位置
				int index = result.indexOf(":");
				//如果没有冒号，使用转发
				if(index == -1)
				{
					request.getRequestDispatcher(result).forward(request, response);
				}
				//如果存在冒号
				else
				{
					String start = result.substring(0, index);//分割出前缀
                    String path = result.substring(index + 1);//分割出路径
                    //前缀为f表示转发
                    if(start.equals("f"))
                    {
                        request.getRequestDispatcher(path).forward(request, response);
                    }
                    //前缀为r表示重定向
                    else if(start.equals("r")) 
                    {
                        response.sendRedirect(request.getContextPath() + path);
                    }
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
