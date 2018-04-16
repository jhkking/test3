package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

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
 * Servlet implementation class MemberFindIdServlet
 */
@WebServlet("/mfid")
public class MemberFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 한글로 인코딩할필요없다 영어로하기때문
/*				request.setCharacterEncoding("utf-8");
				//전송온 값이 있으면 추출해서 변수에 담기
				String name = request.getParameter("smemberName");
				String idnumber=request.getParameter("smemberIdNumber");
				String email = request.getParameter("smemberEmail");
				
				Member member = new MemberService().findId(name,idnumber,email);
				response.setContentType("text/html;charset=utf-8");
				
				RequestDispatcher view = null;
				if(member!=null) {
					view = request.getRequestDispatcher("views/member/memberFind.jsp");
					request.setAttribute("message","찾으시는 아이디는 <u>"+ member.getSmemberId()+"</u> 입니다");
					view.forward(request, response);
				}else {
					view=request.getRequestDispatcher("views/member/memberFind.jsp");
					request.setAttribute("message", "회원정보가 없거나 틀렸습니다.");
					view.forward(request, response);
				}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//전송온 값이 있으면 추출해서 변수에 담기
		String name = request.getParameter("name");
		String idnumber=request.getParameter("idnumber");
		String email = request.getParameter("email");
		
		Member member = new MemberService().findId(name,idnumber,email);
		JSONObject job=new JSONObject();
		if(member!=null) {
		
/*		job.put("name",URLEncoder.encode(member.getSmemberName(),"utf-8"));
		job.put("idnumber", member.getSmemberIdNumber());
		job.put("email", member.getSmemberEmail());*/
		String f="찾으시는 아이디는 ";
		String l=" 입니다.";
		job.put("smemberid", f+member.getSmemberId() +l);
		System.out.println("job : "+job.toJSONString());
		}else {
			job.put("smemberid", "정보가 틀리거나 없습니다.");
		}
		
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter output = response.getWriter();
		output.print(job.toString());
		output.flush();
		output.close();
		
	}

}
