package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 삭제
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.parseInt(request.getParameter("row")));
		
		int n = dao.delete(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "boardList.do";
		}
		return viewPage;
	}

}
