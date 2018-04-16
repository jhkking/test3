package com.kh.finalPro.message.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.finalPro.message.model.vo.Message;

public interface MessageService {

	List<Message> selectMessage(String loginId);
	List<Message> msgViewSelect(Message message);
	int insertMsg(Message message);
	int insertMsgRT(Message message);
	int msgRead(Message message);
	int msgdelete(String m_writer, String m_recv);
}
