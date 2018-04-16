package com.kh.finalPro.rootconsulting.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.finalPro.feedback.model.service.FeedbackService;
import com.kh.finalPro.feedback.model.vo.Feedback;
import com.kh.finalPro.member.model.service.MemberService;
import com.kh.finalPro.member.model.vo.Member;
import com.kh.finalPro.review.model.service.ReviewService;
import com.kh.finalPro.review.model.vo.Review;
import com.kh.finalPro.rootconsulting.model.service.RootconsultingService;
import com.kh.finalPro.rootconsulting.model.vo.Rootconsulting;

@Controller
public class RootcounsultingController {

	@Autowired
	RootconsultingService rootService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping("rootwriteform.do")
	public String rootWriteForm(Date dateFirst, Date dateLast, Model model) {
		long diff = dateLast.getTime() - dateFirst.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.println("紐뉖컯�씠�깘-->" + diffDays);
		model.addAttribute("diffDays", diffDays);
		return "rootconsulting/rootWriteForm";
	}

	@RequestMapping("datecheck.do")
	public String dateCheck() {
		return "rootconsulting/dateCheck";
	}

	@RequestMapping(value = "rootinsert.do", method = RequestMethod.POST, produces = "text/plain")
	public void rootInsert(HttpServletRequest request, Rootconsulting root) throws IOException {

		// �뙆�씪 �뾽濡쒕뱶 泥섎━
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		System.out.println("CONTROLLER" + root);
		// �쎒�꽌踰� 而⑦뀒�씠�꼫 寃쎈줈 異붿텧�븿
		/*
		 * String rootPath = request.getSession().getServletContext().getRealPath("/");
		 */
		// �뙆�씪 ���옣 寃쎈줈 �젙�븿
		String savePath = "c:/finalProject2/finalPro/src/main/webapp/images/";
		// �뒪�봽留곸뿉�꽌�뒗 �봽濡쒖젥�듃\target\m2e-wtp\web-resources\ �븘�옒�뿉 �뤃�뜑瑜� 留뚮뱾�뼱�빞 �븿

		if (!uploadFile.isEmpty()) {
			String ofileName = uploadFile.getOriginalFilename();

			long currentTime = System.currentTimeMillis();
			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) + "."
					+ ofileName.substring(ofileName.lastIndexOf(".") + 1);
			uploadFile.transferTo(new File(savePath + rfileName));

			root.setMr_original_filename(rfileName);
			root.setMr_rename_filename(ofileName);
		} else {
			root.setMr_original_filename("");
			root.setMr_rename_filename("");
		}
		String rootTitle = root.getMr_title();
		root.setMr_title(rootTitle.replaceAll(" ", "_"));
		int result = rootService.rootInsert(root);
		System.out.println("root : " + root);

	}

	@RequestMapping(value = "rootinsertLast.do", method = RequestMethod.POST, produces = "text/plain")
	public String rootInsertLast(HttpServletRequest request, Rootconsulting root) throws IOException {

		// �뙆�씪 �뾽濡쒕뱶 泥섎━
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		System.out.println("CONTROLLER222" + root);
		/*
		 * // �쎒�꽌踰� 而⑦뀒�씠�꼫 寃쎈줈 異붿텧�븿 String rootPath =
		 * request.getSession().getServletContext().getRealPath("/");
		 */
		// �뙆�씪 ���옣 寃쎈줈 �젙�븿
		String savePath = "c:/finalProject2/finalPro/src/main/webapp/images/";
		// �뒪�봽留곸뿉�꽌�뒗 �봽濡쒖젥�듃\target\m2e-wtp\web-resources\ �븘�옒�뿉 �뤃�뜑瑜� 留뚮뱾�뼱�빞 �븿

		if (!uploadFile.isEmpty()) {
			String ofileName = uploadFile.getOriginalFilename();

			long currentTime = System.currentTimeMillis();
			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) + "."
					+ ofileName.substring(ofileName.lastIndexOf(".") + 1);
			uploadFile.transferTo(new File(savePath + rfileName));

			root.setMr_original_filename(rfileName);
			root.setMr_rename_filename(ofileName);
		} else {
			root.setMr_original_filename("");
			root.setMr_rename_filename("");
		}
		String rootTitle = root.getMr_title();
		root.setMr_title(rootTitle.replaceAll(" ", "_"));

		int result = rootService.rootInsert(root);
		System.out.println("root 2222 : " + root);
		String id = root.getMr_writer();
		return "redirect:myrootlist.do?id=" + id;
	}

	@RequestMapping("myrootlist.do")
	public String myRootList(Model model, String id) {
		List<Rootconsulting> myroot = rootService.myRootList(id);
		List<Review> reviewList = reviewService.myReviewList(id);
		List<Feedback> feedbackList = feedbackService.myFeedbackList(id);
		model.addAttribute("mrlist", myroot);
		model.addAttribute("reviewlist", reviewList);
		model.addAttribute("feedbacklist", feedbackList);
		return "rootconsulting/myroot";
	}

	@RequestMapping("mrdetail.do")
	public String mrDetail(Model model, String id, String title) throws UnsupportedEncodingException {
		System.out.println(id + ",  " + title);
		int lastday = rootService.searchLastDay(id, title);
		System.out.println(lastday);
		List<Rootconsulting> myroot = rootService.mrDetail(id, title);
		String writer = myroot.get(0).getMr_writer();
		System.out.println(writer);
		Member m = new Member();
		Member member = new Member();
		member.setMember_id(writer);
		m = memberService.idChk(member);
		model.addAttribute("writerImg", m.getImg_rename_filename() );
		model.addAttribute("mrdetail", myroot);
		model.addAttribute("lastday", lastday);

		return "rootconsulting/rootDetail";
	}

	@RequestMapping("rmodifyform.do")
	public String rootModiryForm(Model model, String id, String title) {
		List<Rootconsulting> mrDetailList = rootService.mrDetail(id, title);
		int lastday = rootService.searchLastDay(id, title);
		System.out.println(mrDetailList);
		model.addAttribute("mrdetaillist", mrDetailList);
		model.addAttribute("lastday", lastday);
		return "rootconsulting/rootModifyForm";
	}

	@RequestMapping(value = "rootmodify.do", method = RequestMethod.POST, produces = "text/plain")
	public String rootModify(HttpServletRequest request, Rootconsulting root) throws IOException {

		// �뙆�씪 �뾽濡쒕뱶 泥섎━
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		System.out.println("CONTROLLER222" + root);
		/*
		 * // �쎒�꽌踰� 而⑦뀒�씠�꼫 寃쎈줈 異붿텧�븿 String rootPath =
		 * request.getSession().getServletContext().getRealPath("/");
		 */
		// �뙆�씪 ���옣 寃쎈줈 �젙�븿
		String savePath = "c:/finalProject2/finalPro/src/main/webapp/images/";
		// �뒪�봽留곸뿉�꽌�뒗 �봽濡쒖젥�듃\target\m2e-wtp\web-resources\ �븘�옒�뿉 �뤃�뜑瑜� 留뚮뱾�뼱�빞 �븿

		if (!uploadFile.isEmpty()) {
			String ofileName = uploadFile.getOriginalFilename();

			long currentTime = System.currentTimeMillis();
			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) + "."
					+ ofileName.substring(ofileName.lastIndexOf(".") + 1);
			uploadFile.transferTo(new File(savePath + rfileName));

			root.setMr_original_filename(rfileName);
			root.setMr_rename_filename(ofileName);
		} else {
			Rootconsulting r = rootService.mrDay(root);

			root.setMr_original_filename(r.getMr_original_filename());
			root.setMr_rename_filename(r.getMr_rename_filename());
		}
		String rootTitle = root.getMr_title();
		root.setMr_title(rootTitle.replaceAll(" ", "_"));

		int result = rootService.rootModify(root);
		System.out.println("root 2222 : " + root);
		String id = root.getMr_writer();
		return "redirect:myrootlist.do?id=" + id;
	}

	@RequestMapping(value = "rootmodifylast.do", method = RequestMethod.POST, produces = "text/plain")
	public String rootModifyLast(HttpServletRequest request, Rootconsulting root) throws IOException {

		// �뙆�씪 �뾽濡쒕뱶 泥섎━
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("uploadFile");
		System.out.println("CONTROLLER222" + root);
		/*
		 * // �쎒�꽌踰� 而⑦뀒�씠�꼫 寃쎈줈 異붿텧�븿 String rootPath =
		 * request.getSession().getServletContext().getRealPath("/");
		 */
		// �뙆�씪 ���옣 寃쎈줈 �젙�븿
		String savePath = "c:/finalProject2/finalPro/src/main/webapp/images/";
		// �뒪�봽留곸뿉�꽌�뒗 �봽濡쒖젥�듃\target\m2e-wtp\web-resources\ �븘�옒�뿉 �뤃�뜑瑜� 留뚮뱾�뼱�빞 �븿

		if (!uploadFile.isEmpty()) {
			String ofileName = uploadFile.getOriginalFilename();

			long currentTime = System.currentTimeMillis();
			SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rfileName = simDf.format(new Date(currentTime)) + "."
					+ ofileName.substring(ofileName.lastIndexOf(".") + 1);
			uploadFile.transferTo(new File(savePath + rfileName));

			root.setMr_original_filename(rfileName);
			root.setMr_rename_filename(ofileName);
		} else {
			Rootconsulting r = rootService.mrDay(root);

			root.setMr_original_filename(r.getMr_original_filename());
			root.setMr_rename_filename(r.getMr_rename_filename());
		}
		String rootTitle = root.getMr_title();
		root.setMr_title(rootTitle.replaceAll(" ", "_"));

		int result = rootService.rootModifyLast(root);
		System.out.println("root 2222 : " + root);
		String id = root.getMr_writer();
		return "redirect:myrootlist.do?id=" + id;
	}

}
