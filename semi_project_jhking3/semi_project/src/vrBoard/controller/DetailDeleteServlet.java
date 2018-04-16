package vrBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vrBoard.model.service.vrBoardService;

/**
 * Servlet implementation class DetailDeleteServlet
 */
@WebServlet("/drdelete")
public class DetailDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 댓글 삭제
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      
      int cnum = Integer.parseInt(request.getParameter("cno"));
      int bno = Integer.parseInt(request.getParameter("bnum"));
      String userid = request.getParameter("userid");
      String placeName = request.getParameter("place");
      String title = request.getParameter("title");
      
      RequestDispatcher view = null;
      if(new vrBoardService().deleteReply(cnum) > 0){
         System.out.println("확인해보자:  "+title+" "+placeName);
         view = request.getRequestDispatcher("vrimg?title="+title+"&place="+placeName+"&bnum="+bno);
        /* request.setAttribute("title", title);
         request.setAttribute("place", placeName);
         request.setAttribute("bno", bno);*/
         view.forward(request, response);

         
      }else{
         view = request.getRequestDispatcher("views/reviewboard/reviewError.jsp");
         request.setAttribute("message", "댓글 삭제 처리 실패!");
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