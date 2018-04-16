package vrBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import likePlace.model.service.likePlaceService;
import likePlace.model.vo.likePlace;
import reviewBoard.model.service.ReviewBoardService;
import reviewBoard.model.vo.ReviewBoard;
import reviewBoard.model.vo.ReviewComment;
import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.DetailComment;
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class DetailReplyInsertServlet
 */
@WebServlet("/drinsert")
public class DetailReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailReplyInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		RequestDispatcher view = null;

		int result2 = 0;

		int bno = Integer.parseInt(request.getParameter("bnum"));
		String content = request.getParameter("dcontent");
		String writer = request.getParameter("userid");
		String title = request.getParameter("title");
		String placeName = request.getParameter("place");

		System.out.println(bno + " " + content + " " + writer);
		DetailComment comment = new DetailComment(bno, writer, content);
		comment.setBno(bno);
		comment.setDcontent(content);
		comment.setDwriter(writer);

		result2 = new vrBoardService().insertComment(comment);

		System.out.println(placeName + " , " + title + " , " + writer);
		System.out.println("result2 확인>>" + result2);

		if (result2 > 0) {
			view = request.getRequestDispatcher("vrimg?title="+title+"&place="+placeName+"&bnum="+bno);
		/*	request.setAttribute("bno", bno);
			request.setAttribute("title", title);
			request.setAttribute("place", placeName);*/

			view.forward(request, response);

		} else {
			view = request.getRequestDispatcher("views/vrBoard/vrBoardError.jsp");
			request.setAttribute("message", "댓글 등록 실패 ! ");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
