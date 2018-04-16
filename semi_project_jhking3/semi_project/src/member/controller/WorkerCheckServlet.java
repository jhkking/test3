package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkerCheckServlet
 */
@WebServlet("/workercheck")
public class WorkerCheckServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String workercheck = request.getParameter("worker");
      RequestDispatcher view = request.getRequestDispatcher("views/member/memberjoin.jsp"); //이 결과를 받아줄 view파일 명을 적어주면 됨(괄호 안에)
      request.setAttribute("workercheck", workercheck); //한 개뿐만 아니라 이름을 구분만 하면 여러개 저장 할 수 있음
      view.forward(request, response); //request안에 info라는 이름의 조회한 회원 정보가 들어감
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}