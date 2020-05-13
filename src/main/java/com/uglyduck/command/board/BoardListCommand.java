package com.uglyduck.command.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.uglyduck.paging.Paging;
import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;
/**
 * 
 * @author UglyDuck
 * currntPage: 현재 페이지(nowPage)를 처리하기 위한 파라미터
 * nowPage: 현재 페이지의 정보를 나타냄 (1로 초기화)
 * recordPerPage: 한 페이지에서 보여줄 게시물의 수
 * begin, end: Oracle ROWNUM(가상 컬럼)을 이용해서 가상의 순번, 시작 값과 끝 값을 지정하기 위함
 * totalRecord: 등록된 게시물의 총 개수로써 Paging클래스에서 전체 페이지의 총 개수를 계산하기 위함
 * query: 사용자로부터 입력받은 검색어 파라미터
 * sort: 사용자가 원하는 게시물 정렬 기준이며, 기본값은 최신순으로 지정 
 *
 */
public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String currentPage = request.getParameter("currentPage");
		String query = request.getParameter("query");
		String sort = request.getParameter("sort");
		if( sort == null ) {
			sort = "latest";
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
		List<BoardDto> list = null;
		if( query != null && query.length() != 0 ) {
			totalRecord = bDao.searchListSize(query);
			pagingView = Paging.getPaging("board-list?query=" + query + "&sort=" + sort + "&", nowPage, recordPerPage, totalRecord);
			list = bDao.search(query, sort, begin, end);
		} else {
			totalRecord = bDao.getBoardListSize();
			pagingView = Paging.getPaging("board-list?sort=" + sort + "&", nowPage, recordPerPage, totalRecord);
			list = bDao.getBoardList(sort, begin, end);
		}
		
		model.addAttribute("query", query);
		model.addAttribute("list", list);
		model.addAttribute("pagingView", pagingView);
		model.addAttribute("currentPage", nowPage);

	}

}
