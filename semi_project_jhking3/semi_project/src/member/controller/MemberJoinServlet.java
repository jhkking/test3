package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet("/minsert")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  request.setCharacterEncoding("utf-8");
		  
		  String workerCheck = request.getParameter("workercheck");
		  
	      String smemberId = request.getParameter("smemberId");
	      String smemberPwd = request.getParameter("smemberPwd");
	      String smemberPwdHint = request.getParameter("smemberPwdHint");
	      String smemberPwdAns = request.getParameter("smemberPwdAns");
	      String smemberName = request.getParameter("smemberName");
	      int smemberIdNumber = Integer.parseInt(request.getParameter("smemberIdNumber"));
	      String smemberAddress = request.getParameter("smemberAddress");
	      String smemberGender = request.getParameter("smemberGender");
	      String smemberPhone = request.getParameter("smemberPhone");
	      String smemberPhone1 = request.getParameter("smemberPhone1");
	      String smemberPhone2 = request.getParameter("smemberPhone2");
	      String smemberEmail = request.getParameter("smemberEmail");
	      String smemberPhone3 = smemberPhone+"-"+smemberPhone1+"-"+smemberPhone2; 
	      
	      Member member = new Member(smemberId, smemberPwd, smemberPwdHint, smemberPwdAns, smemberName, smemberIdNumber,
	                              smemberAddress, smemberGender, smemberPhone3, smemberEmail,"n",workerCheck);
	      System.out.println(member);
	      int result = new MemberService().insertMember(member);
	      
	      response.setContentType("text/html; charset=utf-8");
	      if(result > 0 ) {
	    	  if(workerCheck.equals("n")) {
	    	  response.sendRedirect("views/member/joinSuccessMember.jsp");
	    	  }else {
	            response.sendRedirect("views/member/joinSuccessWorker.jsp");
	    	  }
	      } else {
	              
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
