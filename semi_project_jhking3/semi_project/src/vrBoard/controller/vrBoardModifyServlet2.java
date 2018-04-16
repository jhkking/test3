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

/**
 * Servlet implementation class vrBoardModifyServlet2
 */
@WebServlet("/vrmodify2")
public class vrBoardModifyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBoardModifyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text=html; charser=utf-8");
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		String imgsrc = request.getParameter("imgsrc");
		String vrcode = request.getParameter("searchoption");
		String address = request.getParameter("address");
		String opentime = request.getParameter("opentime");
		String phone = request.getParameter("phone");
		String homepageadd = request.getParameter("homepage");
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
		System.out.println("i : " + i);
		String img = "";
		if(i == 1 || i == 0) {
			img = imgsrc;
		} else {
			img = arr[i-1];
		}
		System.out.println(img);
		//해당글 조회 하고 결과 받기
		int board = new vrBoardService().updatevrBoard(boardnum, vrcode, title, writer, address, img);
		int detailboard = new vrBoardService().updatevrDetail(boardnum, address, opentime, phone, homepageadd);
	
		RequestDispatcher view = null;
		
		if(board > 0 && detailboard > 0) {
			view = request.getRequestDispatcher("vrdetail?num="+boardnum+"&address="+address+"&opentime="+opentime+"&phone="+phone+"&homepageadd="+homepageadd);
	
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
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
