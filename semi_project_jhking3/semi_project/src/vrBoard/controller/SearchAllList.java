package vrBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class SearchAllList
 */
@WebServlet("/searchall")
public class SearchAllList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		int sccurrentPage = Integer.parseInt(request.getParameter("page"));
		//한 페이지에 출력할 목록 갯수 지정
		int sclimit = 5;
		String keyword = request.getParameter("searchkey");
		String searchoption = request.getParameter("searchoption");
		System.out.println(keyword);
		System.out.println(searchoption);
		vrBoardService vservice = new vrBoardService();
		
		//전체 목록 개수 리턴
		int listCount = vservice.getListCount();
		
		///원하는 페이지에 대한 목록 리턴
		//HashMap<Integer, Board> map = bservice.selectMap(currentPage, limit);
		ArrayList<vrBoard> searchList = vservice.searchList(sccurrentPage, sclimit, keyword, searchoption);
		
		//총 페이지 수 계산 : 목록이 1개이면 1페이지로 처리
		int maxPage = (int)((double)listCount / sclimit + 0.9);
		
		//현재 보여줄 페이지에 대한 시작 숫자 계산
		//(1,11,21...)
		int scstartPage = (((int)((double)sccurrentPage / sclimit +0.9 )) -1) * sclimit +1;
		int scendPage = scstartPage + sclimit -1;
		if(maxPage<scendPage) {
			scendPage = maxPage;
		}
		/*ArrayList<vrBoard> list = new vrBoardService().selectList();*/
		
		System.out.println(searchList);
		RequestDispatcher view = null;
	//	if(!map.isEmpty()) {
		if(!searchList.isEmpty()) {
			view = request.getRequestDispatcher("views/vrBoard/searchAllList.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("searchList", searchList);
			request.setAttribute("scurrentPage", sccurrentPage);
			request.setAttribute("smaxPage", maxPage);
			request.setAttribute("sstartPage", scstartPage);
			request.setAttribute("sendPage", scendPage);
			request.setAttribute("slistCount", listCount);
			request.setAttribute("skeyword", keyword);
			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("views/vrBoard/searchNoData.jsp");
			//request.setAttribute("map", map);
			request.setAttribute("searchList", searchList);
			request.setAttribute("skeyword", keyword);
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
