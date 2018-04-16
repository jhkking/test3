package workerBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import workerBoard.model.service.WbService;
import workerBoard.model.vo.WbBoard;



/**
 * Servlet implementation class WbModifyServlet
 */
@WebServlet("/wbmodify")
public class WbModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WbModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        
        //전송파일 용량제한
        int maxSize = 1024 * 1024 * 10;
        
        //전송방식 multipart인지 검사
        if(!ServletFileUpload.isMultipartContent(request)) {
           RequestDispatcher view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
           request.setAttribute("message", "form의 enctype='multipart/form-data' 설정을 하지않았음 ! ");
           view.forward(request, response);
        }
        //업로드 파일 위치 저장
        String savePath = request.getSession().getServletContext().getRealPath("/bupfiles");
        
        try {
           MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8",
                 new DefaultFileRenamePolicy());      
           int boardNum = Integer.parseInt(mrequest.getParameter("bnum"));
           String title = mrequest.getParameter("btitle");
           String writer = mrequest.getParameter("bwriter");
           String content = mrequest.getParameter("bcontent");
           String oldfile = mrequest.getParameter("boldfile");
           String filename = mrequest.getFilesystemName("bupfile");
           
           String currentPage = mrequest.getParameter("page");
           
           WbBoard board = new WbBoard();
           
           board.setWbnumber(boardNum);
           board.setWbtitle(title);
           board.setWbwriter(writer);
           board.setWbcontent(content);
           board.setWboriginalfilename(oldfile);

           if(filename != null) {
              //새로 전송한 파일이 있다면, 기존의 파일을 삭제해야함
              File deleteFile =new File(savePath+"/" + oldfile);
              deleteFile.delete();
              //객체에 수정할 파일명 기록
              board.setWboriginalfilename(filename);
              board.setRename(filename);
           }else {
              //board.setOriginalFileName(oldfile);
              board.setRename(oldfile);
           }
           
           int result = new WbService().updateQna(board);
           RequestDispatcher view = null;
           
           if(result > 0) {
              response.sendRedirect("/semi/wbdetail?bnum=" + boardNum+"&page="+currentPage);

           } else {
              view = request.getRequestDispatcher("views/wbboard/wbError.jsp");
              request.setAttribute("message", "리뷰 수정 실패 !");
              view.forward(request, response);
           }
        }catch (Exception e) {
           e.getLocalizedMessage();
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
