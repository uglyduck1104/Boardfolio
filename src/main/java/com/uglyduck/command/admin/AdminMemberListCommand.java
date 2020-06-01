package com.uglyduck.command.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.paging.Paging;
import com.uglyduck.webapp.dao.MemberDao;
import com.uglyduck.webapp.dto.MemberDto;

public class AdminMemberListCommand implements AdminCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String currentPage = request.getParameter("currentPage");
		String query = request.getParameter("query");
		String sort = request.getParameter("sort");
		if( sort == null ) {
			sort = "all";
		}
		int nowPage = 1;
		if( currentPage != null && currentPage.length() != 0 ) {
			nowPage = Integer.parseInt(currentPage);
		}
		int recordPerPage = 8;
		int begin = (nowPage - 1) * recordPerPage + 1; 
		int end = begin + recordPerPage - 1;
		
		int totalRecord = 0;
		String pagingView = null;
		List<MemberDto> list = null;
		if( query != null && query.length() != 0 ) {
			totalRecord = mDao.searchListSize(query);
			pagingView = Paging.getPaging("admin-member-list?query=" + query + "&sort=" + sort + "&", nowPage, recordPerPage, totalRecord);
			list = mDao.search(sort, query, begin, end);
		} else {
			totalRecord = mDao.memberListSize(sort);
			pagingView = Paging.getPaging("admin-member-list?sort=" + sort + "&", nowPage, recordPerPage, totalRecord);
			list = mDao.memberList(sort, begin, end);
		}
		model.addAttribute("sort", sort);
		model.addAttribute("query", query);
		model.addAttribute("list", list);
		model.addAttribute("pagingView", pagingView);
		model.addAttribute("currentPage", nowPage);

	}

}
