package com.changon.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;
import com.changon.board.dao.BoardDAO;
import com.changon.board.vo.BoardVO;
import com.changon.board.vo.ReplyVO;

public class BoardView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 상세보기
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		ReplyVO rvo = new ReplyVO(); // 댓글 가져오기
		
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>(); // 댓글 담기 list
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		rvo.setBid(Integer.parseInt(request.getParameter("bId"))); // 댓글 가져오기
		
		vo = dao.select(vo); // 메인 글 읽기
		
		dao = new BoardDAO();
		list = dao.replySelect(rvo); // 댓글 읽기
		
		request.setAttribute("vo", vo); // 메인 글
		request.setAttribute("list", list); // 댓글
		
		return "board/boardView";
	}

}
