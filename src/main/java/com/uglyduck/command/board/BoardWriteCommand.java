package com.uglyduck.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class BoardWriteCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		RedirectAttributes rtts = (RedirectAttributes)map.get("rtts");
		BoardDto bDto = (BoardDto) map.get("bDto");
		bDto.setBoard_ip(request.getRemoteAddr());
		bDto.setMember_id(request.getParameter("id"));
		int result = bDao.boardWrite(bDto);
		if( result > 0 ) {
			rtts.addFlashAttribute("result", "success");
		} else {
			rtts.addFlashAttribute("result", "fail");
		}

	}

}
