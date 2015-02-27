package com.ejunhai.qutihuo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ejunhai.qutihuo.utils.SessionManager;

public class AuthenticationInterceptor implements HandlerInterceptor {

	private String[] excludeUrls = { "/login.jhtml", "/authentication.jhtml", "/logout.jhtml", "/forbidden.jhtml" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		for (String url : excludeUrls) {
			if (request.getRequestURI().indexOf(url) > -1) {
				return true;
			}
		}

		// 若用户未登录，则跳转至登陆页
		if (SessionManager.get(request) == null) {
			response.sendRedirect("/login.jhtml");
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

}
