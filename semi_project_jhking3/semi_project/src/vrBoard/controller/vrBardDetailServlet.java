package vrBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.*;


/**
 * Servlet implementation class vrBardDetailServlet
 */
@WebServlet("/vrdetail")
public class vrBardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int page = Integer.parseInt(request.getParameter("page"));

		vrBoard board = new vrBoardService().selectOne(num);
		VrBoardDetail detail = new vrBoardService().detailselectOne(num);
		RequestDispatcher view = null;
		if(board!=null && detail!=null) {

			view = request.getRequestDispatcher("views/vrBoard/vrBoardwriterDetailView.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("board", board);
			request.setAttribute("detail", detail);
			request.setAttribute("page", page);


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
