package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;

public class BoardUpdateComplete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 글 수정 완료 작업 진행
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent"));
		
		int n = dao.update(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "boardList.do";
			
		}
		return viewPage;
	}

}
