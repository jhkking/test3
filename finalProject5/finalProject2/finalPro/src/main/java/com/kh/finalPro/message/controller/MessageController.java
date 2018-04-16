package com.kh.finalPro.message.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.finalPro.member.model.service.MemberService;
import com.kh.finalPro.member.model.vo.Member;
import com.kh.finalPro.message.model.service.MessageService;
import com.kh.finalPro.message.model.vo.Message;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private MemberService memberService;

	/*
	 * @RequestMapping(value = "/msg.do") public String
	 * blackreason(HttpServletRequest request, Model model) { ArrayList<String>
	 * rlist = messageService.selectRlist(); for(int i =0;i<rlist.size();i++) {
	 * List<Message> list = messageService.selectMessage(rlist.get(i));
	 * model.addAttribute("msglist"+(i+1), list); } int mcnt=rlist.size();
	 * model.addAttribute("mcnt", mcnt); return "message/msgMain"; }
	 */
	@RequestMapping(value = "/msg.do")
	public String selectMessage(HttpServletRequest request, Model model) {
		String loginId = request.getParameter("loginId");
		List<Message> list = messageService.selectMessage(loginId);
		
		ArrayList<Member> anotherList = new ArrayList<Member>();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getM_writer().equals(loginId)) {
				Member member2 = new Member();
				member2.setMember_id(list.get(i).getM_recv());
				Member anotherUser2 = memberService.viewMember(member2);
				anotherList.add(anotherUser2);
			} else {
				Member member2 = new Member();
				member2.setMember_id(list.get(i).getM_writer());
				Member anotherUser2 = memberService.viewMember(member2);
				anotherList.add(anotherUser2);
			}
		}
		model.addAttribute("msglist", list);
		model.addAttribute("anotherListM", anotherList);
		return "message/msgMain";
	}

	@RequestMapping(value = "/msend.do")
	public String msgSend(HttpServletRequest request, Model model, Message message) {

		String loginId = message.getM_writer();
		System.out.println("1/:" + loginId);
		int result = messageService.insertMsg(message);
		System.out.println("2/:" + loginId);
		String view = "";

		if (result > 0) {
			List<Message> list = messageService.selectMessage(loginId);
			System.out.println("3/:" + loginId);
			model.addAttribute("list", list);
			model.addAttribute("message", message);
			view = "redirect:mDetail.do?m_writer=" + message.getM_writer() + "&m_recv=" + message.getM_recv()
					+ "&m_content=" + message.getM_content() + "&loginId=" + loginId;
		} else {
			view = "../../about";
		}

		return view;
	}

	@RequestMapping(value = "/mDetail.do")
	public String msgDetail(HttpServletRequest request, Model model, Message message) {

		String loginId = request.getParameter("loginId");
		List<Message> selList = messageService.msgViewSelect(message);
		if(message.getM_recv().equals(loginId)) {
			int result = messageService.msgRead(message);
		}
		
		List<Message> list = messageService.selectMessage(loginId);
		System.out.println("zjs");
		Member member = new Member();
		if (selList.get(0).getM_writer().equals(loginId)) {
			member.setMember_id(selList.get(0).getM_recv());
		} else {
			member.setMember_id(selList.get(0).getM_writer());
		}
		Member anotherUser = memberService.viewMember(member);

		ArrayList<Member> anotherList = new ArrayList<Member>();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getM_writer().equals(loginId)) {
				Member member2 = new Member();
				member2.setMember_id(list.get(i).getM_recv());
				Member anotherUser2 = memberService.viewMember(member2);
				anotherList.add(anotherUser2);
			} else {
				Member member2 = new Member();
				member2.setMember_id(list.get(i).getM_writer());
				Member anotherUser2 = memberService.viewMember(member2);
				anotherList.add(anotherUser2);
			}
		}
		model.addAttribute("msglist2", list);
		model.addAttribute("selList", selList);
		model.addAttribute("anotherUser", anotherUser);
		System.out.println("u:" + anotherUser.getMember_id());
		model.addAttribute("anotherList", anotherList);
		for (int i = 0; i < anotherList.size(); i++) {
			System.out.println("l:" + anotherList.get(i).getMember_id());
		}

		return "message/msgView";
	}

	@RequestMapping(value = "/msginsert.do")
	public void msginsert(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("id") String writer, @RequestParam("recv") String recv, @RequestParam("writ") String writ,
			@RequestParam("content") String content, Message message) {
		response.setContentType("text/html; charset=utf-8");
		if (writer.equals(recv)) {
			message.setM_recv(writ);
		} else {
			message.setM_recv(recv);
		}

		message.setM_writer(writer);

		message.setM_content(content);
		System.out.println("/" + writer + "/" + writ + "/" + recv + "/" + content);
		int s = messageService.insertMsgRT(message);
	}

	@RequestMapping(value = "headermsg.do")
	public void headermsg(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		String loginId = request.getParameter("loginId");
		List<Message> list = messageService.selectMessage(loginId);
		int rs = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getM_read().equals("N")) {
				if(list.get(i).getM_recv().equals(loginId)) {
					rs = 1;
				}
			}
		}
		PrintWriter out = response.getWriter();
		if (rs != 0) {
			out.append("ok");
			out.flush();
		} else {
			out.append("fail");
			out.flush();
		}
	}

	@RequestMapping(value = "/msgdelete.do")
	public String msgdelete(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("m_writer") String m_writer, @RequestParam("m_recv") String m_recv) {

		String loginId = request.getParameter("loginId");
		System.out.println("/wr:" + m_writer);
		System.out.println("/re:" + m_recv);
		System.out.println("/lI:" + loginId);
		if (loginId.equals(m_writer)) {
			int result = messageService.msgdelete(m_writer, m_recv);
			System.out.println("/wr:" + m_writer);
			System.out.println("/re:" + m_recv);
		} else {
			int result = messageService.msgdelete(m_recv, m_writer);
		}

		return "redirect:msg.do?loginId=" + loginId;
	}

	@RequestMapping("/tt.do")
	public String tt() {

		return "tttttt";
	}

}