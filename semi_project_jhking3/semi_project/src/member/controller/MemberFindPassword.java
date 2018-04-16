package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberFindPassword
 */
@WebServlet("/mfpwd")
public class MemberFindPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//아이디 한글로 인코딩할필요없다 영어로하기때문
//		request.setCharacterEncoding("utf-8");
//		//전송온 값이 있으면 추출해서 변수에 담기
//		String id = request.getParameter("smemberId");
//		String pwdHint = request.getParameter("pwdHint");
//		String pwdAnswer=request.getParameter("pwdAnswer");
//		
//		Member member = new MemberService().findPwd(id,pwdHint,pwdAnswer);
//		response.setContentType("text/html;charset=utf-8");
//		
//		RequestDispatcher view = null;
//		if(member!=null) {
//			System.out.println("멤버는 널값이아니다");
//			view = request.getRequestDispatcher("views/member/memberFind.jsp");
//			request.setAttribute("message", "찾으시는 비밀번호는 <u> "+member.getSmemberPwd()+"</u> 입니다");
//			view.forward(request, response);
//		}else {
//			System.out.println("멤버는 널값이다");
//			view=request.getRequestDispatcher("views/member/memberFind.jsp");
//			request.setAttribute("message", "찾기 에러");
//			view.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//전송온 값이 있으면 추출해서 변수에 담기
		String smemberId = request.getParameter("id");
		String pwdHint=request.getParameter("hint");
		String pwdAnswer = request.getParameter("ans");
		System.out.println(smemberId+pwdHint+pwdAnswer);
		Member member = new MemberService().findPwd(smemberId,pwdHint,pwdAnswer);
		JSONObject job=new JSONObject();
		if(member!=null) {
/*		job.put("name",URLEncoder.encode(member.getSmemberName(),"utf-8"));
		job.put("idnumber", member.getSmemberIdNumber());
		job.put("email", member.getSmemberEmail());*/
		String f="찾으시는 비밀번호는 ";
		String l=" 입니다.";
		job.put("smemberPwd", f+member.getSmemberPwd() +l);
		System.out.println("job : "+job.toJSONString());
		}else {
			job.put("smemberPwd", "정보가 틀리거나 없습니다.");
			System.out.println("job : "+job.toJSONString());
		}
		
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter output = response.getWriter();
		output.print(job.toString());
		output.flush();
		output.close();
	}

}
