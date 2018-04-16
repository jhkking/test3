package workerBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import workerBoard.model.service.WbService;

/**
 * Servlet implementation class WbDeleteServlet
 */
@WebServlet("/wbdelete")
public class WbDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentpage =Integer.parseInt(request.getParameter("page"));
				
		if(new WbService().deleteQna(boardNum) > 0){
			response.sendRedirect("/semi/wblist?page="+currentpage);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
			request.setAttribute("message", "게시글 삭제 처리 실패!");
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
