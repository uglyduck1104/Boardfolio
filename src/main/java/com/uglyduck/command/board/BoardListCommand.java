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
 *
 */
public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String currentPage = request.getParameter("currentPage");
		int nowPage = 1;
		if( currentPage != null && !currentPage.isEmpty() ) {
			nowPage = Integer.parseInt(currentPage);
		}
		int recordPerPage = 8;
		int begin = (nowPage - 1) * recordPerPage + 1; 
		int end = begin + recordPerPage - 1;
		
		int totalRecord = bDao.getBoardListSize();
		
		String pagingView = Paging.getPaging("board-list", nowPage, recordPerPage, totalRecord);
		
		List<BoardDto> list = bDao.getBoardList(begin, end);
		model.addAttribute("list", list);
		model.addAttribute("pagingView", pagingView);
		model.addAttribute("currentPage", nowPage);

	}

}
