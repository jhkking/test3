package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MembersearchGenderServlet
 */
@WebServlet(name = "MembersearchGender", urlPatterns = { "/msgender" })
public class MembersearchGenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersearchGenderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("gdkeyword");
        int currentPage = Integer.parseInt(request.getParameter("page"));
		// 한 페이지에 출력할 목록 갯수 지정
		int limit = 10;

		MemberService mservice = new MemberService();
		// 전체 목록 개수 리턴
		int listCount = mservice.getListCount();

        
        ArrayList<Member> list = new MemberService().selectSearchGender(keyword);
     // 총 페이지 수 계산 : 목록이 1개이면 1페이지로 처리
     		int maxPage = (int) ((double) listCount / limit + 0.9);

     		// 현재 보여줄 페이지에 대한 시작 숫자 계산
     		// (1,11,21...)
     		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
     		int endPage = startPage + limit - 1;
     		if (maxPage < endPage) {
     			endPage = maxPage;
     		}

        
        if(!list.isEmpty()) {
                RequestDispatcher view = request.getRequestDispatcher("views/member/memberListView.jsp");
                request.setAttribute("list", list);
                request.setAttribute("currentPage", currentPage);
    			request.setAttribute("maxPage", maxPage);
    			request.setAttribute("startPage", startPage);
    			request.setAttribute("endPage", endPage);
    			request.setAttribute("listCount", listCount);
                view.forward(request, response);
        }else {
              response.sendRedirect("/semi/views/member/memberError.jsp");
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
