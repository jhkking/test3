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
 * Servlet implementation class LikePlaceListServlet
 */
@WebServlet("/placelist")
public class LikePlaceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikePlaceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		ArrayList<vrBoard> list = new vrBoardService().selectPlaceList();

		String userId = request.getParameter("userId");
		System.out.println("여기 명소 서블릿 : " + userId);
		RequestDispatcher view = null;
	//	if(!map.isEmpty()) {
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("likeuser?userId="+userId);
			//request.setAttribute("map", map);
			request.setAttribute("listPlace", list);
			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
			request.setAttribute("message", "게시글 페이지별 조회 실패!");
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
