package notice.contoller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/ninsert")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿으로 이동");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int maxSize = 1024*1024*10;
		
		RequestDispatcher view = null;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "form enctype 속성 적용이 안됨");
			view.forward(request, response);
		}
		//현재 웹 컨테이너(톰캣)에서 구동중인 웹 어플리케이션의 루트 경로 알아내기!
				String root = request.getSession().getServletContext().getRealPath("/");// "/"의 뜻은 루트라는말.
				String savePath = root + "nupfiles";
				//MultipartRequest 객체 생성함 : 자동 파일 업로드
				MultipartRequest mrequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
				
				//input 값 추출
				String title = mrequest.getParameter("ntitle");
				String content = mrequest.getParameter("ncontent");
				String writer = mrequest.getParameter("nwriter");
				//객체정보를 담을 보드객체준비
				Notice notice = null;
				
				//bupfile이라는이름으로 전송된 파일 이름을 그대로 올리기위해씀
				String noticeOriginalFilename = mrequest.getFilesystemName("nupfile");
				//업로드된 첨부파일이 있다면
				if(noticeOriginalFilename !=null) {
					//파일이름을  "년월일시분초.확장자" 로 만듬
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					Date currentTime = new Date(System.currentTimeMillis());
					String noticeRenameFilename = sdf.format(currentTime) 
						+ "." + noticeOriginalFilename.substring(noticeOriginalFilename.lastIndexOf(".") + 1);
					//파일의 이름을 바꾸려면 , File 객체 생성함
					File originFile = new File(savePath + "//" + noticeOriginalFilename);
					File renameFile = new File(savePath + "//" + noticeRenameFilename);
					
					//File 클래스의 renameTo()로 파일명 바꾸기함.
					if(!originFile.renameTo(renameFile)) {
						//renameTo()가 실패했다면...
						//강제로 이름바꾸기
						//새 파일을 만들고 ,원래 파일을 읽어서 복사하고
						//원 파일을 삭제함
						int read= -1;
						byte[] buf = new byte[1024];
						FileInputStream fin = new FileInputStream(originFile);
						FileOutputStream fout = new FileOutputStream(renameFile);
						
						while((read = fin.read(buf,0,buf.length)) != -1) {
							fout.write(buf, 0, buf.length);
												
						}
						fin.close();
						fout.close();
						originFile.delete();
						
					}
					notice = new Notice(title,writer,content,noticeOriginalFilename,noticeRenameFilename);			
				}else {
					//업로드된 첨부파일이 없다면 
					notice = new Notice(title,writer,content,null,null);
				}
				
				if(new NoticeService().insertNotice(notice)>0) {
					response.sendRedirect("/semi/nlist?page=1");
				}else {
					view=request.getRequestDispatcher("views/notice/noticeError.jsp");
					request.setAttribute("message", "공지사항 등록실패");
					view.forward(request,response);
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
