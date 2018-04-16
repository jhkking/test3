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
 * Servlet implementation class VrListSelectServlet
 */
@WebServlet("/vrselect")
public class VrListSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VrListSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String title = request.getParameter("title");
	
		
		vrBoard board =  new vrBoardService().selectList(title);


		RequestDispatcher view = null;
		if(board != null)  {
			
			view = request.getRequestDispatcher("views/vrBoard/vrDetail.jsp");
			request.setAttribute("board", board);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/vrBoard/vrBoardError.jsp");
			request.setAttribute("message", "게시글 수정 실패 !");
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
