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
 * Servlet implementation class WbReplyServlet
 */
@WebServlet("/wbreply")
public class WbReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbReplyServlet() {
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
		
		WbService bservice = new WbService();
		//원글 조회
		WbBoard originBoard = bservice.selectOne(boardNum);
		
		//댓글 객체 생성
		WbBoard replyBoard = new WbBoard();
		replyBoard.setWbcontent(replyContent);
		replyBoard.setWbtitle(replyTitle);
		replyBoard.setWbwriter(replyWriter);
		replyBoard.setWblevel(originBoard.getWblevel() + 1);
		replyBoard.setWbref(originBoard.getWbref());
		//댓글의 댓글일 때 참조하는 댓글 번호 처리
		if(replyBoard.getWblevel() == 2)
			replyBoard.setWbreplyref(
					originBoard.getWbnumber());
		replyBoard.setWbreplyseq(1);
		
		//기존의 등록된 댓글의 boardReplySeq 값 1씩 증가처리
		//1->2, 2->3, 3->4 로 변경 처리 요청
		bservice.updateReplySeq(replyBoard);
		
		//댓글 등록
		int result = bservice.insertReply(
				originBoard, replyBoard);
		
		if(result > 0) {
			response.sendRedirect("/semi/wblist?page=" 
							+ currentPage);
		}else {
			RequestDispatcher view = 
				request.getRequestDispatcher("views/wbboard/wbError.jsp");
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
