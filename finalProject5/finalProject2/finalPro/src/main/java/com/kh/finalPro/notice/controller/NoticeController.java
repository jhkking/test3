package com.kh.finalPro.notice.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.finalPro.notice.model.service.NoticeService;
import com.kh.finalPro.notice.model.vo.Notice;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@RequestMapping("nlist.do")
	public String noticeList(Model model) {
		model.addAttribute("noticelist", noticeService.noticeList());
		return "notice/noticeListView";
	}

	@RequestMapping("ndetail.do")
	public String noticeDetail(Model model, int n_no) {
		noticeService.addReadcount(n_no);
		model.addAttribute("noticedetail", noticeService.noticeDetail(n_no));
		return "notice/noticeDetailView";

	}

	@RequestMapping("ninsert.do")
	public String noticeInsert(HttpServletRequest request, Notice notice)throws IOException{
		//파일 업로드 처리
		MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest)request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		System.out.println( "CONTROLLER"+notice );
		// 웹서버 컨테이너 경로 추출함 
	    String root = request.getSession().getServletContext().getRealPath("/");
	    // 파일 저장 경로 정함
	    String savePath = root + "uploadFiles/";
	    //스프링에서는 프로젝트\target\m2e-wtp\web-resources\ 아래에 폴더를 만들어야 함
	   
		
		if(!uploadFile.isEmpty()){
			String ofileName = uploadFile.getOriginalFilename();
			
			long currentTime = System.currentTimeMillis();  
		    SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) +"."+ ofileName.substring(ofileName.lastIndexOf(".")+1);
			uploadFile.transferTo(new File(savePath + rfileName));
						
			notice.setN_original_filename(ofileName);
			notice.setN_rename_filename(rfileName);
		}else {
		notice.setN_original_filename("");
		notice.setN_rename_filename("");
		}
		noticeService.noticeInsert(notice);
		return "redirect:nlist.do";

	}

		@RequestMapping("ninsertform.do")
		public String noticeDetail() {
			return "notice/noticeInsertView";
		}
		
		@RequestMapping("/bdownfile.do")
		public void fileDownload(
				@RequestParam(value="rfile") String rfileName, 
				@RequestParam(value="ofile") String ofileName,
				HttpServletResponse response,
				HttpServletRequest request){
			// 프로젝트 내에 파일이 저장된 곳의 위치를 얻어옴
			String saveFolder = request.getSession()
				   .getServletContext().getRealPath("/uploadFiles/");			 
			
			BufferedInputStream buf = null;
			ServletOutputStream downOut = null;
				 
			try {		  
			   downOut = response.getOutputStream();
			   File downfile = new File(saveFolder + "/" + rfileName);
			   response.setContentType("text/plain; charset=utf-8");		
				//한글 파일명 인코딩 처리
				response.addHeader("Content-Disposition", "attachment; filename=\"" + 
				 new String(ofileName.getBytes("UTF-8"), "ISO-8859-1") + 
				 "\"");
			   response.setContentLength((int)downfile.length());
					  
			   FileInputStream input = new FileInputStream(downfile);
			   buf = new BufferedInputStream(input);
			   int readBytes = 0;

			   while ((readBytes = buf.read()) != -1){
				downOut.write(readBytes);
			   }
			   downOut.close();
			   buf.close();
			} catch (Exception e) {
			   e.printStackTrace();
			}
			
		}
		@RequestMapping("ndelete.do")
		public ModelAndView deleteNotice(@RequestParam("no")int no)throws Exception{
			ModelAndView mv =new ModelAndView("redirect:/nlist.do");
			Notice notice =new Notice();
			notice.setN_no(no);
			noticeService.deleteNotice(notice);
			return mv;
		}
		
		@RequestMapping(value="/nupdate.do")
		public ModelAndView openBoardUpadte(Notice notice,@RequestParam("no")int no)throws Exception{
			ModelAndView mv= new ModelAndView("/notice/noticeupdateView");
			notice.setN_no(no);
			Notice notice2 = noticeService.selectupview(notice);
			mv.addObject("noticedetail",notice2);
			return mv;
		}
		@RequestMapping(value="/nupdateView.do",method=RequestMethod.POST)
		public ModelAndView updateBoard(Notice notice,HttpServletRequest request,@RequestParam("ofile") String old_ori,@RequestParam("rfile") String old_re) throws Exception{
			ModelAndView mv = new ModelAndView("redirect:/nlist.do");
			MultipartHttpServletRequest multipartRequest =
					(MultipartHttpServletRequest)request;
			MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
			
			// 웹서버 컨테이너 경로 추출함 
		    String root = request.getSession().getServletContext().getRealPath("/");
		    // 파일 저장 경로 정함
		    String savePath = root + "uploadFiles/";
		    //스프링에서는 프로젝트\target\m2e-wtp\web-resources\ 아래에 폴더를 만들어야 함
		   
		    if(old_ori.equals("null")) {
		    	if(!uploadFile.isEmpty()){
		    		String ofileName = uploadFile.getOriginalFilename();
		    		
		    		long currentTime = System.currentTimeMillis();  
		    	    SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		    		String rfileName = simDf.format(new Date(currentTime)) +"."
		    				+ ofileName.substring(ofileName.lastIndexOf(".")+1);;
		    		uploadFile.transferTo(new File(savePath + rfileName));
		    					
		    		notice.setN_original_filename(ofileName);
		    		notice.setN_rename_filename(rfileName);
		    	}
		    }else {
		    	if(!uploadFile.isEmpty()){
		    		File deleteFile = new File(savePath +"\\"+ old_re);
		            deleteFile.delete();
		    		String ofileName = uploadFile.getOriginalFilename();
		    		
		    		long currentTime = System.currentTimeMillis();  
		    	    SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		    		String rfileName = simDf.format(new Date(currentTime)) +"."
		    				+ ofileName.substring(ofileName.lastIndexOf(".")+1);;
		    		uploadFile.transferTo(new File(savePath + rfileName));
		    					
		    		notice.setN_original_filename(ofileName);
		    		notice.setN_rename_filename(rfileName);
		    	}else {
		    		notice.setN_original_filename(old_ori);
		    		notice.setN_rename_filename(old_re);
		    	}
		    }
			
			System.out.println(notice);
			Notice notice2 =noticeService.updateNotice(notice);
			
			return mv;
			}

}
