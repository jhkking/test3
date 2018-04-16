package reviewBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reviewBoard.model.service.ReviewBoardService;
import reviewBoard.model.vo.ReviewBoard;
import reviewBoard.model.vo.ReviewComment;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/rdetail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text=html; charser=utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		ReviewBoardService bservice = new ReviewBoardService();
		int replyCount = bservice.getReplyListCount(boardNum);
		//조회수 1 증가 처리
		bservice.addReadCount(boardNum);
		//해당글 조회 하고 결과 받기
		ReviewBoard board = bservice.selectOne(boardNum);
		ArrayList<ReviewComment> list = bservice.selectReplyList(boardNum);
		
		RequestDispatcher view = null;
		
		if(board != null) {
			view = request.getRequestDispatcher("views/reviewboard/reviewDetail.jsp");
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("replyCount", replyCount);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
			request.setAttribute("message", "리뷰 상세보기 실패 ! ");
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
