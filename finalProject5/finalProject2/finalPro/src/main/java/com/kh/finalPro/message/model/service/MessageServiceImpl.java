package com.kh.finalPro.message.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalPro.message.model.dao.MessageDao;
import com.kh.finalPro.message.model.vo.Message;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> selectMessage(String loginId) {
		ArrayList<String> rlist = messageDao.selectRlist(loginId);
		return messageDao.selectMessage(rlist,loginId);
	}

	@Override
	public List<Message> msgViewSelect(Message message) {
		// TODO Auto-generated method stub
		return messageDao.msgViewSelect(message);
	}

	@Override
	public int insertMsg(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insertMsg(message);
	}

	@Override
	public int insertMsgRT(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insertMsgRT(message);
	}

	@Override
	public int msgRead(Message message) {
		// TODO Auto-generated method stub
		return messageDao.msgRead(message);
	}
	@Override
	   public int msgdelete(String m_writer, String m_recv) {
	      // TODO Auto-generated method stub
	      return messageDao.msgdelete(m_writer,m_recv);
	   }


}