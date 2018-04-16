package vrBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.*;


/**
 * Servlet implementation class vrBoardModifyServlet
 */
@WebServlet("/vrmodify")
public class vrBoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardnum  = Integer.parseInt(request.getParameter("boardnum"));

		vrBoard Board = new vrBoardService().VrBoardModify(boardnum);
		VrBoardDetail detail = new vrBoardService().VrDetailModify(boardnum);
		

		RequestDispatcher view = null;
		if(Board!=null) {

			view = request.getRequestDispatcher("views/vrBoard/vrBoardModifyView.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("Board", Board);
			request.setAttribute("detail", detail);
			request.setAttribute("boardnum", boardnum);

			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
			request.setAttribute("message", "수정 실패!");
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
