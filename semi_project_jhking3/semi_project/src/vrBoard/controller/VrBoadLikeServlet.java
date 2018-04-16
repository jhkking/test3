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
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.VrBoardDetail;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class VrBoadLikeServlet
 */
@WebServlet("/vrBoardlike")
public class VrBoadLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VrBoadLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// vrBoard좋아요기능
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		int vrboardnum = Integer.parseInt(request.getParameter("placeNum"));
		String title = request.getParameter("title");
		String placeName = request.getParameter("place");
		
		int result = new likePlaceService().likevrBoard(userId,vrboardnum);
		int result2 = new likePlaceService().likevrBoardCount(vrboardnum);
		
		vrBoard board = new vrBoardService().selectList(request.getParameter("title"));
		ArrayList<vrBoard> listAll =  new vrBoardService().selectListAll();
		ArrayList<likePlace> like = new likePlaceService().selectListUser(request.getParameter("userid"));
		Maplocation maplo =  new vrBoardService().selectLocation(board.getVrboardnum());
		VrBoardDetail vbd = new vrBoardService().selectDetail(board.getVrboardnum());
		ArrayList<vrBoard> resBoard = new vrBoardService().selectResBoard(placeName);
		ArrayList<VrBoardDetail> resBoardDetail = new vrBoardService().selectResBoardDetail(placeName);


		
		response.setContentType("text/html; charset = utf-8");
		RequestDispatcher view = null;
		if (result > 0 && result2 >0) {
			view = request.getRequestDispatcher("views/vrBoard/vrBoardSelect.jsp");
			request.setAttribute("listAll", listAll);
			request.setAttribute("board", board);
			request.setAttribute("place", placeName);
			request.setAttribute("title", title);
			request.setAttribute("userid", userId);
			request.setAttribute("like", like);
			request.setAttribute("maplo", maplo);
			request.setAttribute("vbd", vbd);
			request.setAttribute("resBoard", resBoard);
			request.setAttribute("resBoardDetail", resBoardDetail);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/vrBoard/vrBoardError.jsp");
			request.setAttribute("message", "좋아요  추가 오류 !");
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
