package workerBoard.controller;

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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import qnaBoard.model.vo.QnaBoard;
import workerBoard.model.service.WbService;
import workerBoard.model.vo.WbBoard;

/**
 * Servlet implementation class WbInsertServlet
 */
@WebServlet("/wbinsert")
public class WbInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//업로드할 파일의 용량 제한 : 10Mbyte
		int maxSize = 1024 * 1024 * 10;
		
		RequestDispatcher view = null;
		
		//enctype="multipart/form-data"로 전송디었는지 확인
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
			request.setAttribute("message", "form enctype 속성 적용 안됨 !");
			view.forward(request, response);
		}
		
		//현재 웹 컨테이너에서 구동중인  웹 어플리케이션의 루투 경로 알아내기
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "bupfiles";
		
		//MultipartRequest mrequest 객체 생성함 : 자동 파일 업로드됨
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8",  new DefaultFileRenamePolicy());
		
		String title = mrequest.getParameter("btitle");
		String content = mrequest.getParameter("bcontent");
		String writer = mrequest.getParameter("bwriter");
		
		WbBoard board = null;
		
		String originalFileName = mrequest.getFilesystemName("bupfile");
		//업로드된 파일이 있다면
		 if(originalFileName != null) {
			 //파일이름을 "년월일시분초.확장자" 로 만드는 작업
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
			 Date currentTime = new Date(System.currentTimeMillis()); //시스템에서 현재시간에 대한 정보를 알아와서 millisecond단위로 바꿔줌
			 String renameFileName = sdf.format(currentTime) + "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			 
			 //파일의 이름을 바꾸려면, File 객체 생성
			 File originFile = new File(savePath + "\\" + originalFileName);
			 File renameFile = new File(savePath + "\\" + renameFileName);
			 
			 //File 클래스의 renameTo()로 파일명 바꾸기
			 if(!originFile.renameTo(renameFile)) {
				 //renameRo()가 실패 했다면...
				 //강제로 이름바꾸기함
				 //새 파일 만들고, 원래 파일 읽어서 복사하고
				 //원래파일 지우기
				 int read = -1;
				 byte[] buf = new byte[1024];
				 FileInputStream fin = new FileInputStream(originFile);
				 FileOutputStream fout = new FileOutputStream(renameFile);
				 
				 while((read = fin.read(buf,0, buf.length)) !=-1 ) {
					 fout.write(buf, 0, buf.length);
				 }
				 fin.close();
				 fout.close();
				 originFile.delete();
			 }
			 board = new WbBoard(title, writer, content, originalFileName, renameFileName);
		 }else {
			 //업로드된 첨부파일이 없다면
			 board = new WbBoard(title, writer, content, null, null);
		 }
		 /*int result = new BoardService().insertBoard(board);
		 if(result >0) {*/
		 if(new WbService().insertBoard(board)>0) {
			 response.sendRedirect("/semi/wblist?page=1");
		 }else {
			 view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
			 request.setAttribute("message","리뷰 등록 등록 실패");
			 view.forward(request, response);
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
