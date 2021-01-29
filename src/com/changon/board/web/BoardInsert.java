package com.changon.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새글작성 삽입
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbName(request.getParameter("bName"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		vo.setbContent(request.getParameter("bContent"));
		
		String viewPage = null;
		int n = dao.insert(vo);
		if(n != 0) {
			viewPage = "boardList.do";
		}
		
		return viewPage;
	}

}
