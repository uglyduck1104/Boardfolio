package com.uglyduck.command.reply;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.ReplyDao;
import com.uglyduck.webapp.dto.ReplyDto;

public class MemberReplyListCommand implements ReplyCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		ReplyDao rDao = sqlSession.getMapper(ReplyDao.class); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		List<ReplyDto> list = rDao.memberReplyList(id);
		model.addAttribute("list", list);

	}

}
