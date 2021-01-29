package com.changon.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.board.web.BoardDelete;
import com.changon.board.web.BoardInputForm;
import com.changon.board.web.BoardInsert;
import com.changon.board.web.BoardList;
import com.changon.board.web.BoardUpdateComplete;
import com.changon.board.web.BoardUpdateForm;
import com.changon.board.web.BoardView;
import com.changon.board.web.MainCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// HashMap 생성
	private HashMap<String, Command> map = new HashMap<String, Command>();

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/boardView.do", new BoardView());
		map.put("/boardInputForm.do", new BoardInputForm());
		map.put("/boardInsert.do", new BoardInsert());
		map.put("/boardDelete.do", new BoardDelete());
		map.put("/boardUpdateForm.do", new BoardUpdateForm());
		map.put("/boardUpdateComplete.do", new BoardUpdateComplete());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		// View Resolve 설정하여 WEB-INF 내부 파일 접근 가능
		//if(viewPage.endsWith(".jsp")) viewPage = "/WEB-INF/jsp/" + viewPage; 
		
		// viewPage가 .do로 끝나지 않으면, viewPage를 "/WEB-INF/jsp/" + viewPage + ".jsp"과 같이 만들어라.
		// Command 호출 시 .jsp 없어도 OK
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
