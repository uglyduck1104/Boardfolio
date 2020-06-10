package com.uglyduck.command.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.paging.Paging;
import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

public class AdminBoardListCommand implements AdminCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String currentPage = request.getParameter("currentPage");
		String query = request.getParameter("query");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		int nowPage = 1;
		if( currentPage != null && currentPage.length() != 0 ) {
			nowPage = Integer.parseInt(currentPage);
		}
		int recordPerPage = 8;
		int begin = (nowPage - 1) * recordPerPage + 1; 
		int end = begin + recordPerPage - 1;
		
		int totalRecord = 0;
		String pagingView = null;
		List<BoardDto> list = null;
		if( (query == null || query.length() == 0) == true && 
			(beginDate == null || beginDate.length() == 0) == true && 
			(endDate == null || endDate.length() == 0) == true ) {
			totalRecord = bDao.getBoardListSize();
			pagingView = Paging.getPaging("admin-board-list?", nowPage, recordPerPage, totalRecord);
			list = bDao.adminBoardList(begin, end);
		} else {
			totalRecord = bDao.adminBoardSearchSize(query, beginDate, endDate);
			pagingView = Paging.getPaging("admin-board-list?query=" + query + 
										  "&beginDate=" + beginDate + 
										  "&endDate=" + endDate + "&", 
										  nowPage, recordPerPage, totalRecord);
			list = bDao.adminBoardSearch(query, beginDate, endDate, begin, end);
		}
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("query", query);
		model.addAttribute("list", list);
		model.addAttribute("pagingView", pagingView);
		model.addAttribute("currentPage", nowPage);

	}

}
