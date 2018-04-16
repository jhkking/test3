package notice.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/nlist")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//페이지 처리
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int limit = 10;
		
		NoticeService nservice = new NoticeService();
		//전체 목록 갯수를 리턴받는다.
		int listCount = nservice.getListCount();
		
		ArrayList<Notice> list = nservice.selectList(currentPage,limit);
		
		int maxPage = (int)((double)listCount / limit +0.9);
		//현재 보여줄 페이지에 대한 시작 숫자 계산
		//(1,11,21,....)
		int startPage=(((int)((double)currentPage / limit +0.9)) -1 )*limit+1;
		int endPage = startPage+limit -1;
		if(maxPage<endPage) {
			endPage = maxPage;
		}
		
		RequestDispatcher view = null;
		if(!list.isEmpty()) {
			view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage",currentPage);
			request.setAttribute("maxPage", new Integer(maxPage));
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage",currentPage);
			request.setAttribute("maxPage", new Integer(maxPage));
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
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
