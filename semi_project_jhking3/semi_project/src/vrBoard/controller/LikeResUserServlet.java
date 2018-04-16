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
 * Servlet implementation class LikeResUserServlet
 */
@WebServlet("/likeres")
public class LikeResUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeResUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		//페이지
		System.out.println("res like로 들어왔음");
		String userId = null;
		ArrayList<likePlace> list = new ArrayList<likePlace>();
		if (request.getParameter("userId")!=null) {
			userId = request.getParameter("userId");
			list = new likePlaceService().selectResUser(userId);
		}
		System.out.println("likeuser : " + userId);
		
		/*if(!list.isEmpty()) {*/
			System.out.println("list : " + list);
			System.out.println("userlike servlet 도달");
			RequestDispatcher view =request.getRequestDispatcher("views/best/bestRes.jsp");//디스배쳐 상대경로
			request.setAttribute("likeres", list);
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
