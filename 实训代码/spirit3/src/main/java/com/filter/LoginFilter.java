/*@Author:WangKai
  @Create Date:2021/7/16
  @Update Date:2021/7/19 17:30
*/

package com.filter;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Client.*;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@SuppressWarnings("unused")
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/user/*","/order/*"},initParams = {
		@WebInitParam(name = "encoding",value = "UTF-8"),	
		@WebInitParam(name = "loginPage",value = "/login.jsp")
	})

public class LoginFilter implements Filter {

	private FilterConfig filterConfig;
	
	private String encoding;
	
	private String loginPage;
	
    public LoginFilter() {

    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//设置请求和响应的属性
//		request.setCharacterEncoding(encoding);
//		response.setCharacterEncoding(encoding);
//		response.setContentType("text/html;charset="+encoding);
		
		//强转类型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//判断会话域中是否有用户对象
		if (req.getSession().getAttribute("loginUser")!=null) {
			chain.doFilter(request, response);
		}else {
			req.setAttribute("msg", "非法请求！");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	
		this.filterConfig = filterConfig;
		
		this.encoding = filterConfig.getInitParameter(encoding);
		this.loginPage = filterConfig.getInitParameter(loginPage);
		
	}

}
