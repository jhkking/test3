package likePlace.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import likePlace.model.service.likePlaceService;
import member.model.service.MemberService;
import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class vrBoardLikeServlet
 */
@WebServlet("/vrlike")
public class vrBoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBoardLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int vrboardnum = Integer.parseInt(request.getParameter("placeNum"));
		int page = Integer.parseInt(request.getParameter("page"));

		int result = new likePlaceService().likevrBoard(userId,vrboardnum);

		System.out.println("dao갓다왔다");
		/*System.out.println("2"+userId+board);
		int result2 = new vrBoardService().likevrBoardCount(vrboardnum);*/
		response.setContentType("text/html; charset = utf-8");
		if (result > 0) {
			response.sendRedirect("/semi/vrlikecount?vrboardnum="+vrboardnum+"&userId="+userId+"&page="+page);
		} else {
			response.sendRedirect("/semi/views/member/memberError.html");
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
