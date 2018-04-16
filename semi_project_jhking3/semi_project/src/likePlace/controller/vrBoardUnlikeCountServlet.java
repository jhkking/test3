package likePlace.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import likePlace.model.service.likePlaceService;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class vrBoardUnlikeCountServlet
 */
@WebServlet("/unlikecount")
public class vrBoardUnlikeCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBoardUnlikeCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vrboardnum = Integer.parseInt(request.getParameter("vrboardnum"));
		String userId = request.getParameter("userId");

		
		vrBoard board = new vrBoard();

		int result = new likePlaceService().unlikevrBoardCount(board);
		/*System.out.println("2"+userId+board);
		int result2 = new vrBoardService().likevrBoardCount(vrboardnum);*/
		response.setContentType("text/html; charset = utf-8");
		if (result > 0) {
			response.sendRedirect("vrlist?userId="+userId);
		} else {
			response.sendRedirect("views/member/memberError.html");
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
