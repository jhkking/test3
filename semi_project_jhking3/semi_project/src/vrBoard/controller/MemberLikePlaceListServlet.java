package vrBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class MemberLikePlaceListServlet
 */
@WebServlet("/mlikeplacelist")
public class MemberLikePlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLikePlaceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내 관심글 보기 (마이페이지)
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		/*String placeName = request.getParameter("place");*/
		
		ArrayList<vrBoard> likeBoard = new vrBoardService().searchLikePlace(userid);
		
		RequestDispatcher view = null;
			if(!likeBoard.isEmpty()) {
				view = request.getRequestDispatcher("views/vrBoard/memberLikePlaceList.jsp");
				request.setAttribute("likeBoard", likeBoard);
				/*request.setAttribute("place", placeName);*/
				view.forward(request, response);
				
			}else {
				view = request.getRequestDispatcher("views/vrBoard/memberLikePlaceList.jsp");
				request.setAttribute("likeBoard", likeBoard);
				/*request.setAttribute("place", placeName);*/
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
