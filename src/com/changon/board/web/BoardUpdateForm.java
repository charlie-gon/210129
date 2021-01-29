package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.parseInt(request.getParameter("row")));
		vo = dao.editSelect(vo);
		
		request.setAttribute("vo", vo);
	
		return "board/boardUpdateForm";
	}

}
