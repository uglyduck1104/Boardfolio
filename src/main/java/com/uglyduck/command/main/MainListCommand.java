package com.uglyduck.command.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class MainListCommand implements MainCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		int nowPage = 1;
		int recordPerPage = 8;
		int begin = (nowPage - 1) * recordPerPage + 1;
		int end = begin + recordPerPage - 1;
		List<BoardDto> todayBestList = bDao.todayBestList(begin, end);
		List<BoardDto> weekBestList = bDao.weekBestList(begin, end);
		List<BoardDto> monthBestList = bDao.monthBestList(begin, end);
		List<BoardDto> yearBestList = bDao.yearBestList(begin, end);
		model.addAttribute("todayBestList", todayBestList);
		model.addAttribute("weekBestList", weekBestList);
		model.addAttribute("monthBestList", monthBestList);
		model.addAttribute("yearBestList", yearBestList);
		
	}

}
