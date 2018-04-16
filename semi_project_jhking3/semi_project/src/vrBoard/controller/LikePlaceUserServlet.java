package vrBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import likePlace.model.service.likePlaceService;
import likePlace.model.vo.likePlace;

/**
 * Servlet implementation class LikePlaceUserServlet
 */
@WebServlet("/likeplace")
public class LikePlaceUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikePlaceUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html; charset=utf-8");
		
		//페이지
		System.out.println("hotel like로 들어왔음");
		String userId = request.getParameter("userId");
		System.out.println("likeuser : " + userId);
		ArrayList<likePlace>list = new likePlaceService().selectPlaceUser(userId);
		/*if(!list.isEmpty()) {*/
		System.out.println("list : " + list);
			System.out.println("userlike servlet 도달");
			RequestDispatcher view =request.getRequestDispatcher("views/best/bestPlace.jsp");//디스배쳐 상대경로
			request.setAttribute("likeplace", list);
			view.forward(request, response);
		/*}else {
			response.sendRedirect("views/member/memberError.jsp");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
