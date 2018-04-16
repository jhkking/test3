package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/myinfo")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 조회 처리용 컨트롤러
		String userid = request.getParameter("userid"); //변수 이름이 틀려버리면 null값을 가져오기 때문에 대소문자를 구별해서 잘 적어줘야함
		// ∇서비스 메소드 쪽으로 값을 넘기고 DB에서 결과 받기
		Member member = new MemberService().selectMember(userid);
		System.out.println("servlet통과");
		// ∇return된 값 즉, 전달 받은 값을 가지고 성공 실패 판단하기
	if(member != null) {
			// session은 로그인 용으로만 써야함 이 부분은 로그인 용이 아니기 때문에 세션을 이용할 필요 X
			// 전달(forwarding)처리를 하기위한 방법으로 쓰이는 클래스가 RequestDispatcher이기 때문에 이걸 사용
			// ∇RequestDispatcher은 상대 경로만 사용할 수 있는 메소드임을 주의해야함(절대 경로 작성 시 에러 발생)
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberDetail.jsp"); //이 결과를 받아줄 view파일 명을 적어주면 됨(괄호 안에)
			request.setAttribute("info", member); //한 개뿐만 아니라 이름을 구분만 하면 여러개 저장 할 수 있음
			view.forward(request, response); //request안에 info라는 이름의 조회한 회원 정보가 들어감
		} else {
			response.sendRedirect("views/member/memberError.jsp");
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
