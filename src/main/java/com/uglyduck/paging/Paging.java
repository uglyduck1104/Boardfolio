package com.uglyduck.paging;
/**
 * 
 * @author UglyDuck
 * 
 * --- 인자로 받는 값(path, nowPage, recordPerPage, totalRecord) ---
 * path: a태그에서 이동할 contextPath 값
 * nowPage: 블록 내 현재 페이지를 알려주거나, 블록에 표시할 시작 페이지 번호와 끝 페이지 번호 계산하기 위해서 인자로 받음
 * recordPerPage: 전체 페이지의 개수 연산을 위해 인자로 받음 (한 페이지내에 보여줄 게시물의 수)
 * totalRecord: 전체 페이지의 개수 연산을 위해 인자로 받음 (등록된 게시물의 총 개수)
 * 
 * --- 계산되는 값 ---
 * totalPage: 전체 페이지 개수 (totalRecord / recordPerPage) 전체 게시물 수 / 한 페이지에 보여질 게시물 수 
 * beginPageOfBlock: 블록의 첫 페이지 번호
 * endPageOfBlock: 블록의 끝 페이지 번호
 * pagePerBlock: 한 블록의 개수
 *
 */
public class Paging {
	
	public static String getPaging(String path, int nowPage, int recordPerPage, int totalRecord) {
		
		StringBuffer sb = new StringBuffer();
		
		int totalPage = 0;
		int beginPageOfBlock = 0;
		int endPageOfBlock = 0;
		int pagePerBlock = 5;
		
		totalPage = (int)(totalRecord / recordPerPage);
		
		// 한 페이지에 나누어 떨어지지 않은 여분의 게시물은 페이지를 한 개 늘려서 처리 
		if ( totalRecord % recordPerPage != 0 ) {
			totalPage++;
		}
		
		// 전체 페이지 개수 조정 (잘못된 연산/이동 대비용)
		if ( nowPage > totalPage ) {
			totalPage = nowPage;
		}
		
		// 블록에 표시할 시작 페이지 번호와 끝 페이지 번호 계산
		beginPageOfBlock = (int)(((nowPage - 1) / pagePerBlock) * pagePerBlock) + 1;
		endPageOfBlock = beginPageOfBlock + pagePerBlock - 1;
		
		// 블록의 끝 페이지 번호 조정 (자주 발생)
		if ( endPageOfBlock > totalPage ) {
			endPageOfBlock = totalPage;
		}
		
		// 이전 버튼 표시
		// 1. 이전 버튼의 링크가 필요 없는 경우 : 블록의 첫 페이지 번호가 한 블록의 개수
		// 2. 이전 버튼의 링크가 필요한 경우
		if ( beginPageOfBlock < pagePerBlock ) {
			sb.append("<span class='prevBtnNone'></span>");
		} else {
			sb.append("<a class='prevBtn' href='" + path + "currentPage=" + (beginPageOfBlock - 1) + "'></a>");
		}
		
		// 페이지 번호 표시
		// 1. 페이지 번호의 링크가 필요 없는 경우 : 블록의 첫 페이지 번호가 현재 페이지와 같을 때 
		// 2. 페이지 번호의 링크가 필요한 경우
		for ( int page = beginPageOfBlock; page <= endPageOfBlock; page++ ) {
			if ( page == nowPage ) {
				sb.append("<span class='ptPtxt'>" + page + "</span>");
			} else {
				sb.append("<a href='" + path + "currentPage=" + (page) + "'>" + page + "</a>");
			}
		}
		
		// 다음 버튼 표시
		// 1. 다음 버튼의 링크가 필요 없는 경우 : 블록의 끝 페이지 번호가 전체 페이지 개수보다 적을 때
		// 2. 다음 버튼의 링크가 필요한 경우
		if ( endPageOfBlock == totalPage ) {
			sb.append("<span class='nextBtnNone'></span>");
		} else {
			sb.append("<a class='nextBtn' href='" + path + "currentPage=" + (endPageOfBlock + 1) + "'></a>");
		}
		
		return sb.toString();	
	}
}
