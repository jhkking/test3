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
import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.DetailComment;
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class vrBoardImageServlet
 */
@WebServlet("/vrimg")
public class vrBoardImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public vrBoardImageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미지 이름가져와서 출력하기
		request.setCharacterEncoding( "utf-8");
		response.setContentType("text/html; charset=utf-8");
		String placeName=null;
		Maplocation maplo = null;
		VrBoardDetail vbd =null;
		ArrayList<DetailComment> list2 = new ArrayList<DetailComment>();
		
		int result=0;
		int bno = 0; 
	
		if(request.getParameter("place")!=null) {
		 placeName = request.getParameter("place");
		}
		System.out.println(placeName+", "+request.getParameter("title"));
		//int listCount = new vrBoardService().getListCount(placeName);
		ArrayList<vrBoard> listAll =  new vrBoardService().selectListAll();
		vrBoard board = null;
		ArrayList<likePlace> like = new ArrayList<likePlace>();
		ArrayList<vrBoard> resBoard = new ArrayList<vrBoard>();
		ArrayList<VrBoardDetail> resBoardDetail = new ArrayList<VrBoardDetail>();	
		if(request.getParameter("userid") != null) {
			like = new likePlaceService().selectListUser(request.getParameter("userid"));
		}
		if(request.getParameter("bnum")!=null) {
			bno = Integer.parseInt(request.getParameter("bnum"));
			list2 = new vrBoardService().selectReplyList(bno);
		}
		if(request.getParameter("title") != null) {
		board = new vrBoardService().selectList(request.getParameter("title"));
		System.out.println(request.getParameter("title"));
		System.out.println(board.getVrboardnum());
	    maplo =  new vrBoardService().selectLocation(board.getVrboardnum());
	    resBoard = new vrBoardService().selectResBoard(placeName);
		
		result = new vrBoardService().addReadCount(board.getVrboardnum());
	    vbd = new vrBoardService().selectDetail(board.getVrboardnum());
	    resBoardDetail = new vrBoardService().selectResBoardDetail(placeName);
	    
		}
		
		System.out.println("bno : "+bno);
		System.out.println(" >>like확인>>"+like);
		System.out.println(" >>resBoard 확인>>"+resBoard);
		System.out.println(" >>resBoardDetail 확인>>"+resBoardDetail);
		System.out.println(" >>list2 확인>>"+list2);
	
		
		RequestDispatcher view = null;
		if(listAll != null)  {
			
			view = request.getRequestDispatcher("views/vrBoard/vrBoardSelect.jsp");
			request.setAttribute("listAll", listAll);
			request.setAttribute("board", board);
			request.setAttribute("place", placeName);
			request.setAttribute("maplo", maplo);
			request.setAttribute("like", like);
			request.setAttribute("vbd", vbd);
			request.setAttribute("resBoard", resBoard);
			request.setAttribute("resBoardDetail", resBoardDetail);
			request.setAttribute("list2", list2);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/vrBoard/vrBoardError.jsp");
			request.setAttribute("message", "게시글 수정 실패 !");
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
