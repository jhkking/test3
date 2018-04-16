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
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/mupdate")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String smemberId = request.getParameter("smemberid");
		String smemberPwd = request.getParameter("smemberpwdA");
		String smemberName = request.getParameter("smembername");
		int smemberIdNumber = Integer.parseInt(request.getParameter("smemberidnumber"));
		String smemberAddress = request.getParameter("address");
		String smemberGender = request.getParameter("gender");
		String smemberPhone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		String smemberEmail = request.getParameter("email");

		Member member = new Member(smemberId, smemberPwd, smemberName, smemberIdNumber, smemberAddress, smemberGender, smemberPhone, smemberEmail);

		int result = new MemberService().updateMember(member);

		response.setContentType("text/html; charset = utf-8");
		if (result > 0) {
			response.sendRedirect("/semi/myinfo?userid="+member.getSmemberId());
		} else {
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
