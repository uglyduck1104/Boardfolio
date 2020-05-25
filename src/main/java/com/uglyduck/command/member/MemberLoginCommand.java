package com.uglyduck.command.member;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class MemberLoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		String id = request.getParameter("id");
		String isChecked = request.getParameter("isChecked");
		if( isChecked != null && isChecked.length() != 0 ) {   // 아이디 저장 체크 유무 확인
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60 * 60 * 24 * 3);  // 쿠키 유효기간은 3일로 설정.
			response.addCookie(cookie); 
		} else {   					// 아이디 저장 체크 해제
			Cookie[] cookieBox = request.getCookies(); // session에 저장되어있는 id 쿠키 확인 후 삭제
			if( cookieBox != null && cookieBox.length > 0 ) {
				for( Cookie ck : cookieBox ) {
					if( ck.getName().equals("id") ) {
						Cookie bisket = new Cookie("id", "");
						bisket.setMaxAge(0);
						response.addCookie(bisket);
						break;
					}
				}
			}
		}
	}

}
