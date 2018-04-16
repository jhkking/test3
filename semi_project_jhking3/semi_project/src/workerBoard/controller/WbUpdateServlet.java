package workerBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import workerBoard.model.service.WbService;
import workerBoard.model.vo.WbBoard;


/**
 * Servlet implementation class WbUpdateServlet
 */
@WebServlet("/wbupdate")
public class WbUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
        int currentPage = Integer.parseInt(request.getParameter("page"));

        WbBoard board = new WbService().selectOne(boardNum);
        
        response.setContentType("text/html; charset=utf-8");
        
        RequestDispatcher view = null;
        
        if(board != null) {
           view = request.getRequestDispatcher("views/wbboard/wbModify.jsp");
           request.setAttribute("board", board);
           request.setAttribute("page", currentPage);
           view.forward(request, response);
        }else {
           view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
           request.setAttribute("message", boardNum+" 번글 수정 실패");
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
