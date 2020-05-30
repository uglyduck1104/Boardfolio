package com.uglyduck.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uglyduck.webapp.dto.MemberDto;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		MemberDto mDto = (MemberDto)session.getAttribute("mDto");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		if( mDto != null ) {
			if( !mDto.getRole().equals("admin")) {
				sb.append("<script>")
				.append("alert('잘못된 주소로의 접근입니다.');")
				.append("history.back();")
				.append("</script>");
				out.println(sb.toString());
				out.flush();
				return false;
			}
		} else {
			response.sendRedirect("login-form");
			return false;
		}
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
}
