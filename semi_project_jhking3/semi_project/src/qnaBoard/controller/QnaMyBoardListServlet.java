package qnaBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaBoard.model.service.QnaService;
import qnaBoard.model.vo.QnaBoard;



/**
 * Servlet implementation class QnaMyBoardListServlet
 */
@WebServlet("/qmblist")
public class QnaMyBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaMyBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String myId = request.getParameter("myId");
		System.out.println("서블릿다녀오니?");
		QnaService qservice = new QnaService();
		
		ArrayList<QnaBoard> mylist = qservice.selectMyList(myId);
	
		System.out.println(myId);
		RequestDispatcher view = null;
		if(!mylist.isEmpty()) {
			view = request.getRequestDispatcher("views/reviewboard/reviewMyListView.jsp");		
			request.setAttribute("mylist", mylist);
			request.setAttribute("myId", myId);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/qnaboard/qnaError.jsp");
			request.setAttribute("message", "내가 쓴글 보기 실패!");
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
