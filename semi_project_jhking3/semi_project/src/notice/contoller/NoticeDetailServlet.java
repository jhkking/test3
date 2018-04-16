package notice.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/ndetail")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int noticeNum=Integer.parseInt(request.getParameter("num"));
		int currentPage=Integer.parseInt(request.getParameter("page"));
	
		
		
		
		System.out.println("noticeNum:"+noticeNum);
		System.out.println("currentPage:"+currentPage);
		
		
		
		NoticeService nservice=new NoticeService();
		//조회수1증가처리
		nservice.addReadCount(noticeNum);
		//해등 글 조회하고 결과받기
		Notice notice = nservice.selectOne(noticeNum);
		
		Notice pnotice=nservice.selectPrev(noticeNum);
		Notice nnotice=nservice.selectNext(noticeNum);
		
		
		RequestDispatcher view = null;
		
		if(notice!=null) {
		
			view = request.getRequestDispatcher("views/notice/noticeDetailView.jsp");
			request.setAttribute("notice", notice);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pnotice", pnotice);
			request.setAttribute("nnotice", nnotice);
						
			
			view.forward(request, response);
		}else {
			view=request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "상세보기 실패");
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
