package com.changon.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.common.Command;

public class BoardInputForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새글작성 form 전달
		return "board/boardInputForm";
	}

}
