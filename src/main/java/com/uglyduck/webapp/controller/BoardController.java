package com.uglyduck.webapp.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uglyduck.command.board.BoardCommand;
import com.uglyduck.command.board.BoardDeleteCommand;
import com.uglyduck.command.board.BoardListCommand;
import com.uglyduck.command.board.BoardUpdateCommand;
import com.uglyduck.command.board.BoardViewCommand;
import com.uglyduck.command.board.BoardWriteCommand;
import com.uglyduck.command.board.MemberWriteListCommand;
import com.uglyduck.webapp.dao.BoardDao;
import com.uglyduck.webapp.dto.BoardDto;

@Controller
public class BoardController {
	// Field
	@Autowired
	SqlSession sqlSession;
	BoardCommand boardCommand;
	
	// Method
	@RequestMapping("write-page")
	public String boardWrite() {
		return "board/writePage";
	}
	
	@RequestMapping("board-list")
	public String getBoardList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		boardCommand = new BoardListCommand();
		boardCommand.execute(sqlSession, model);
		return "board/boardList";
	}
	
	@RequestMapping("board-write")
	public String boardWrite(Model model, HttpServletRequest request, RedirectAttributes rtts, 
							@ModelAttribute BoardDto bDto) {
		model.addAttribute("request", request);
		model.addAttribute("rtts", rtts);
		model.addAttribute("bDto", bDto);
		boardCommand = new BoardWriteCommand();
		boardCommand.execute(sqlSession, model);
		
		return "redirect:board-list";
	}
	
	@RequestMapping("board-view")
	public String boardView(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		boardCommand = new BoardViewCommand();
		boardCommand.execute(sqlSession, model);
		return "board/boardView";
	}
	
	@RequestMapping("update-page")
	public String updatePage(Model model, HttpServletRequest request, @RequestParam int board_no) {
		BoardDao bDao = sqlSession.getMapper(BoardDao.class);
		model.addAttribute("bDto", bDao.boardView(board_no));
		return "board/updatePage";
	}
	
	@RequestMapping("board-update")
	public String boardUpdate(Model model, HttpServletRequest request, RedirectAttributes rtts) {
		model.addAttribute("request", request);
		model.addAttribute("rtts", rtts);
		boardCommand = new BoardUpdateCommand();
		boardCommand.execute(sqlSession, model);
		return "redirect:board-list";
	}
	
	@RequestMapping("board-drop")
	public String boardDrop(Model model, HttpServletRequest request, RedirectAttributes rtts) {
		model.addAttribute("request", request);
		model.addAttribute("rtts", rtts);
		boardCommand = new BoardDeleteCommand();
		boardCommand.execute(sqlSession, model);
		return "redirect:board-list";
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="file-upload", produces="application/json")
	public String fileUpload(MultipartHttpServletRequest multiRequest, HttpServletRequest request) {
		List<MultipartFile> uploadFileList = multiRequest.getFiles("upload");
		JSONObject obj = new JSONObject();
		int size = uploadFileList.size();
		String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
		String saveFileName = null;
		if( uploadFileList != null && size > 0 ) {
			for(MultipartFile multiFile : uploadFileList) {
				if( !multiFile.isEmpty() ) {
					String originFileName = multiFile.getOriginalFilename();
					String extentionName = originFileName.substring(originFileName.lastIndexOf('.'), originFileName.length());
					originFileName = UUID.randomUUID().toString().substring(0, 8);
					saveFileName = originFileName + "_" + System.currentTimeMillis() + extentionName;
					try {
						File dir = new File(realPath);
						if( !dir.exists() ) {
							dir.mkdir();
						}
						File saveFile = new File(realPath, saveFileName);
						multiFile.transferTo(saveFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		obj.put("uploaded", "true");
		obj.put("url", multiRequest.getContextPath() + "/resources/upload/" + saveFileName);
		
		return obj.toJSONString();
	}
	
	@RequestMapping("member-write-list")
	public String memberWriteList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		boardCommand = new MemberWriteListCommand();
		boardCommand.execute(sqlSession, model);
		return "user/memberWriteList";
	}
	
	
}
