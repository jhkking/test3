package vrBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class VrBoardDelete
 */
@WebServlet("/vrdelete")
public class VrBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VrBoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardnum  = Integer.parseInt(request.getParameter("boardnum"));

		int delete = new vrBoardService().VrBoardDelete(boardnum);	
		int deleteboard = new vrBoardService().vrBoardDelete2(boardnum);

		RequestDispatcher view = null;
		if(delete > 0 && deleteboard> 0) {

			view = request.getRequestDispatcher("views/vrBoard/deleteSuccess.jsp");
			//request.setAttribute("map", map);
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
