package qnaBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaBoard.model.service.QnaService;
import qnaBoard.model.vo.QnaBoard;

/**
 * Servlet implementation class QnaReplyServlet
 */
@WebServlet("/qreply")
public class QnaReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		String replyTitle = request.getParameter("btitle");
		String replyWriter = request.getParameter("bwriter");
		String replyContent = request.getParameter("bcontent");
		
		QnaService bservice = new QnaService();
		//원글 조회
		QnaBoard originBoard = bservice.selectOne(boardNum);
		
		//댓글 객체 생성
		QnaBoard replyBoard = new QnaBoard();
		replyBoard.setContent(replyContent);
		replyBoard.setTitle(replyTitle);
		replyBoard.setQnawriter(replyWriter);
		replyBoard.setQnalevel(originBoard.getQnalevel() + 1);
		replyBoard.setQnaref(originBoard.getQnaref());
		//댓글의 댓글일 때 참조하는 댓글 번호 처리
		if(replyBoard.getQnalevel() == 2)
			replyBoard.setQnareplyref(
					originBoard.getQnano());
		replyBoard.setQnareplyseq(1);
		
		//기존의 등록된 댓글의 boardReplySeq 값 1씩 증가처리
		//1->2, 2->3, 3->4 로 변경 처리 요청
		bservice.updateReplySeq(replyBoard);
		
		//댓글 등록
		int result = bservice.insertReply(
				originBoard, replyBoard);
		
		if(result > 0) {
			response.sendRedirect("/semi/qlist?page=" 
							+ currentPage);
		}else {
			RequestDispatcher view = 
				request.getRequestDispatcher("views/qna/qnaError.jsp");
			request.setAttribute("message", boardNum + 
					"번 글에 대한 댓글 달기 실패!");
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
