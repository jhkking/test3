package reviewBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reviewBoard.model.service.ReviewBoardService;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/rrdelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 삭제
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int cNum = Integer.parseInt(request.getParameter("cno"));
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentpage =Integer.parseInt(request.getParameter("page"));
				
		if(new ReviewBoardService().deleteReply(cNum) > 0){
			response.sendRedirect("/semi/rdetail?bnum="+boardNum+"&page="+currentpage);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
			request.setAttribute("message", "댓글 삭제 처리 실패!");
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
