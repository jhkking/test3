package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberAdminDeleteServlet
 */
@WebServlet("/madelete")
public class MemberAdminDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       
       String userid = request.getParameter("userid");
      int currentPage = Integer.parseInt(request.getParameter("page"));

       
         

         int result = new MemberService().deleteMember(userid);
         
         
         if(result>0)  {
          response.sendRedirect("/semi/mlist?page="+currentPage);
            
         }else {
                response.sendRedirect("/semi/views/member/memberError.html");
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