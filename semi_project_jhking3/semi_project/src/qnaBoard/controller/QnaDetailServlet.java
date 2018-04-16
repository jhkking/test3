package qnaBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaBoard.model.service.QnaService;
import qnaBoard.model.vo.QnaBoard;

/**
 * Servlet implementation class QnaDetailServlet
 */
@WebServlet("/qdetail")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text=html; charser=utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		QnaService bservice = new QnaService();
		
		//조회수 1 증가 처리
		bservice.addReadCount(boardNum);
		//해당글 조회 하고 결과 받기
		QnaBoard board = bservice.selectOne(boardNum);
		
		RequestDispatcher view = null;
		
		if(board != null) {
			view = request.getRequestDispatcher("views/qnaboard/qnaDetail.jsp");
			request.setAttribute("board", board);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/qnaboard/qError.jsp");
			request.setAttribute("message", "리뷰 상세보기 실패 ! ");
			view.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
