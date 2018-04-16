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
import vrBoard.model.vo.Maplocation;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class BestPlaceServlet
 */
@WebServlet("/bestplace")
public class BestPlaceServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */  
    public BestPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=utf-8");
      int currentPage = Integer.parseInt(request.getParameter("page"));
      //한 페이지에 출력할 목록 갯수 지정
      int limit = 5;
      
      vrBoardService vservice = new vrBoardService();
      int listCount = vservice.getPlaceListCount();
      System.out.println(vservice);
      //전체 목록 개수 리턴
      /*int listCount = vservice.getListCount();
      System.out.println(listCount);*/
      ///원하는 페이지에 대한 목록 리턴
      //HashMap<Integer, Board> map = bservice.selectMap(currentPage, limit);
      ArrayList<vrBoard> list = vservice.PlaceList(currentPage, limit);

      ArrayList<Maplocation> maplist = vservice.BestMapList();
      System.out.println("listcount = " + listCount);
      //총 페이지 수 계산 : 목록이 1개이면 1페이지로 처리
      int maxPage = (int)((double)listCount / limit + 0.9);
      
      //현재 보여줄 페이지에 대한 시작 숫자 계산
      //(1,11,21...)
      int startPage = (((int)((double)currentPage / limit +0.9 )) -1) * limit +1;
      int endPage = startPage + limit -1;
      if(maxPage<endPage) {
         endPage = maxPage;
      }
      /*ArrayList<vrBoard> list = new vrBoardService().selectList();*/
System.out.println("펏 페이지 : " + startPage);
System.out.println("last : " + endPage);

      RequestDispatcher view = null;
   //   if(!map.isEmpty()) {
      if(!list.isEmpty()) {
         view = request.getRequestDispatcher("views/best/bestPlace.jsp");
         //request.setAttribute("map", map);
         request.setAttribute("placelist", list);
         request.setAttribute("maplist", maplist);
         request.setAttribute("currentPagepl", currentPage);
         request.setAttribute("maxPagepl", maxPage);
         request.setAttribute("startPagepl", startPage);
         request.setAttribute("endPagepl", endPage);
         request.setAttribute("listCountpl", listCount);
         view.forward(request, response);
         
      }else {
         view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
         request.setAttribute("message", "게시글 페이지별 조회 실패!");
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