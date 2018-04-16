package reviewBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaBoard.model.service.QnaService;
import qnaBoard.model.vo.QnaBoard;
import reviewBoard.model.service.ReviewBoardService;
import reviewBoard.model.vo.ReviewBoard;
import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;
import workerBoard.model.service.WbService;
import workerBoard.model.vo.WbBoard;


/**
 * Servlet implementation class ReviewMyBoardListServlet
 */
@WebServlet("/rmblist")
public class ReviewMyBoardListServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewMyBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		

		String myId = request.getParameter("myId");
		
		
		ReviewBoardService bservice = new ReviewBoardService();
		
		ArrayList<ReviewBoard> mylist = bservice.selectMyList(myId);
		
		QnaService qservice = new QnaService();
		
		ArrayList<QnaBoard> qmylist = qservice.selectMyList(myId);
		
		vrBoardService vservice = new vrBoardService();
		ArrayList<vrBoard> vmylist = vservice.selectMyList(myId);
		
		WbService wservice = new WbService();
		ArrayList<WbBoard> wmylist = wservice.selectMyList(myId);
	
		RequestDispatcher view = null;
	
		if(!mylist.isEmpty()) {
			view = request.getRequestDispatcher("views/reviewboard/reviewMyListView.jsp");
			
			request.setAttribute("mylist", mylist);	
			request.setAttribute("qmylist", qmylist);
			request.setAttribute("vmylist", vmylist);
			request.setAttribute("wmylist", wmylist);
			request.setAttribute("myId", myId);
	
			view.forward(request, response);
			
		}else {
view = request.getRequestDispatcher("views/reviewboard/reviewMyListView.jsp");
			
			request.setAttribute("mylist", mylist);	
			request.setAttribute("qmylist", qmylist);
			request.setAttribute("vmylist", vmylist);
			request.setAttribute("wmylist", wmylist);
			request.setAttribute("myId", myId);
	
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
