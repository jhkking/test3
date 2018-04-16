package notice.contoller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet(name = "NoticeFileDownload", urlPatterns = { "/nfdown" })
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String originalFileName = request.getParameter("ofname");
		String renameFileName = request.getParameter("rfname");
		
		//프로젝트 내의 파일이 저장된 폴더 경로정보 얻기
		String readFolder = request.getSession().getServletContext().getRealPath("/nupfiles");
		System.out.println(originalFileName);

		System.out.println(renameFileName);
		//클라이언트로 내보낼 출력스트림 생성
		ServletOutputStream downOut = response.getOutputStream();
		File downFile = new File(readFolder + "/"+ renameFileName);
		
		response.setContentType("text/plain;charset=utf-8");
		//한글 파일명 인코딩처리함.
		response.addHeader("content-Disposition",
				 "attachment;filename =\""
				 + new String(originalFileName.getBytes("utf-8"),"ISO-8859-1")+"\"");
		response.setContentLength((int)downFile.length());
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		
		int read = -1;
		while((read = bin.read()) != -1) {
			downOut.write(read);
			downOut.flush();
		}
		downOut.close();
		bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
