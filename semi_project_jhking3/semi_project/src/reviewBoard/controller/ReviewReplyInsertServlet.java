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
 * Servlet implementation class ReviewReplyInsertServlet
 */
@WebServlet("/rrinsert")
public class ReviewReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		RequestDispatcher view = null;
	
		int bno = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		String content = request.getParameter("bcontent");
		String writer = request.getParameter("bwriter");
		ReviewBoardService bservice = new ReviewBoardService();
		
		ReviewComment comment = new ReviewComment(bno,writer,content);
		int result = bservice.insertComment(comment);
		int replyCount = bservice.getReplyListCount(bno);
		//조회수 1 증가 처리
		bservice.addReadCount(bno);
		//해당글 조회 하고 결과 받기
		ReviewBoard board = bservice.selectOne(bno);
		ArrayList<ReviewComment> list = bservice.selectReplyList(bno);
		
	
		if(result > 0) {
			view = request.getRequestDispatcher("views/reviewboard/reviewDetail.jsp");
			request.setAttribute("board", board);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("replyCount", replyCount);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
			request.setAttribute("message", "댓글 등록 실패 ! ");
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
