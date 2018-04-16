package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 전송값에 한글이 있을 경우 인코딩처리함
		request.setCharacterEncoding("utf-8");
		//2. 전송값 꺼내서 변수에 기록하기 또는 객체에 저장하기
		String userid =request.getParameter("userid");
		String userpwd =request.getParameter("userpwd");
		
		//3. 비지니스 로직 처리하는 서비스 클레스의 해당 메소드를 실행하고,
		//처리결과를 받음
		Member member =new MemberService().selectMember(userid,userpwd);
		
		//4. 받은 결과를 가지고 성공/실패에 대한 뷰페이지(파일)을 선택해서 내보냄
		response.setContentType("text/html; charset=utf-8");
		if(member != null) {
			System.out.print(member.toString());
			   HttpSession session = request.getSession();
               System.out.println(member.getSmemberId() + 
                     " 에게 부여된 세션 아이디 : " + session.getId());
               session.setMaxInactiveInterval(10 * 60);  //10분뒤에 자동 파기
               session.setAttribute("member", member);
               //response.sendRedirect("views/member/loginSuccess.jsp");
               //이거 index jsp 쓰는거
               response.sendRedirect("/semi/intro.jsp");
		}else {
			response.sendRedirect("views/member/memberError.jsp");
		}
		
		
	}

}
