package vrBoard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;
import workerBoard.model.service.WbService;
import workerBoard.model.vo.WbBoard;

/**
 * Servlet implementation class WorketBoardUploadServlet
 */
@WebServlet("/workerup")
public class WorkerBoardUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerBoardUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text=html; charser=utf-8");
		String imgsrc = request.getParameter("imgsrc");
		String vrcode = request.getParameter("searchoption");
		String address = request.getParameter("address");
		String opentime = request.getParameter("opentime");
		String phone = request.getParameter("phone");
		String homepageadd = request.getParameter("homepageadd");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		System.out.println(imgsrc);
		StringTokenizer str = new StringTokenizer(imgsrc, "\\");
		String [] arr = new String[str.countTokens()];
		int i = 0;
		while(str.hasMoreTokens()) {
			arr[i] = str.nextToken();
			i++;
		}
		String img = arr[i-1];
		System.out.println(img);
		//해당글 조회 하고 결과 받기
		int board = new vrBoardService().addvrBoard(vrcode, title, writer, address, img);
		ArrayList<vrBoard> boardlist = new vrBoardService().getvrBoard(title);
		int boardnum = boardlist.get(0).getVrboardnum();
		System.out.println(boardnum);
		int board_detail = new vrBoardService().addvrdetail(boardnum, address, opentime, phone, homepageadd);
		RequestDispatcher view = null;
		
		if(board > 0 && board_detail > 0) {
			view = request.getRequestDispatcher("intro.jsp");
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/wbboard/vrBoardError.jsp");
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