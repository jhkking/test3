package reviewBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import reviewBoard.model.service.ReviewBoardService;
import reviewBoard.model.vo.ReviewBoard;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/rbupdateview")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int boardNum = Integer.parseInt(request.getParameter("bnum"));
		      int currentPage = Integer.parseInt(request.getParameter("page"));

		      ReviewBoard board = new ReviewBoardService().selectOne(boardNum);
		      
		      response.setContentType("text/html; charset=utf-8");
		      
		      RequestDispatcher view = null;
		      
		      if(board != null) {
		         view = request.getRequestDispatcher("views/reviewboard/reviewModify.jsp");
		         request.setAttribute("board", board);
		         request.setAttribute("page", currentPage);
		         view.forward(request, response);
		      }else {
		         view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
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
