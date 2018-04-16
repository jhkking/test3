package notice.contoller;

import java.io.File;
import java.io.IOException;

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
 * Servlet implementation class NoticeModify
 */
@WebServlet("/nupdate")
public class NoticeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int maxSize=1024*1024*10;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 설정을 하지않았음 ! ");
	         view.forward(request, response);
		}
		//업로드 파일  위치 저장
		String savePath=request.getSession().getServletContext().getRealPath("/nupfiles");
		
		try {
			MultipartRequest mrequest=new MultipartRequest(request, savePath,maxSize, "utf-8",
		               new DefaultFileRenamePolicy());
			int noticeNum = Integer.parseInt(mrequest.getParameter("num"));
			String title=mrequest.getParameter("ntitle");
			String writer=mrequest.getParameter("nwriter");
			String content=mrequest.getParameter("ncontent");
			String oldfile=mrequest.getParameter("noldfile");
			String filename=mrequest.getFilesystemName("nupfile");
			String currentPage=mrequest.getParameter("page");
			
			Notice notice = new Notice();
			notice.setNoticeNum(noticeNum);
			notice.setNoticeTitle(title);
			notice.setNoticeWriter(writer);
			notice.setNoticeContent(content);
			notice.setNoticeOriginalFilename(oldfile);
			
			if(filename !=null) {
				File deleteFile = new File(savePath+"/"+oldfile);
				deleteFile.delete();
				//객체에 수정할 파일명 기록
				notice.setNoticeOriginalFilename(filename);
				notice.setNoticeRenameFilename(filename);
			}else {
				notice.setNoticeRenameFilename(oldfile);
			}
			
			int result = new NoticeService().updateNotice(notice);
			RequestDispatcher view=null;
			
			if(result>0) {
				response.sendRedirect("/semi/ndetail?num="+noticeNum+"&page="+currentPage);
			}else {
				view = request.getRequestDispatcher("views/notice/noticeError.jsp");
				request.setAttribute("message", "리뷰수정 실패");
				view.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
