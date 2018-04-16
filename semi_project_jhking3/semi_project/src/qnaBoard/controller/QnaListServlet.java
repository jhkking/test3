package qnaBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaBoard.model.service.QnaService;
import qnaBoard.model.vo.QnaBoard;

/**
 * Servlet implementation class QnaListServlet
 */
@WebServlet("/qlist")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		//페이지
		int currentPage = Integer.parseInt(request.getParameter("page"));
		//한 페이지에 출력할 목록 갯수 지정
		int limit = 10;
		
		QnaService bservice = new QnaService();
		//전체 목록 개수 리턴
		int listCount = bservice.getListCount();
		///원하는 페이지에 대한 목록 리턴
		//HashMap<Integer, Board> map = bservice.selectMap(currentPage, limit);
		ArrayList<QnaBoard> list = bservice.selectList(currentPage, limit);
		
		//총 페이지 수 계산 : 목록이 1개이면 1페이지로 처리
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 보여줄 페이지에 대한 시작 숫자 계산
		//(1,11,21...)
		int startPage = (((int)((double)currentPage / limit +0.9 )) -1) * limit +1;
		int endPage = startPage + limit -1;
		if(maxPage<endPage) {
			endPage = maxPage;
		}
		
		RequestDispatcher view = null;
	//	if(!map.isEmpty()) {
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("views/qnaboard/qnaListView.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);

			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("views/qnaboard/qnaListView.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);

			view.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
