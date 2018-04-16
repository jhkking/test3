package com.kh.finalPro.message.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.finalPro.message.model.vo.Message;

@Repository("messageDao")
public class MessageDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<Message> selectMessage(ArrayList<String> rlist,String loginId) {

		List<Message> list = new ArrayList<Message>();
		for (int i = 0; i < rlist.size(); i++) {
			Message ms = new Message();
			ms.setM_writer(loginId);
			ms.setM_recv(rlist.get(i));
			Message msg = mybatis.selectOne("messageMapper.selectMessage", ms);
			list.add(msg);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			Message imsi = new Message();
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getM_no() < list.get(j).getM_no()) {
					imsi = list.get(i);
					list.set(i, list.get(j));
					list.set(j, imsi);
				}
			}
		}

		return list;
	}

	public ArrayList<String> selectRlist(String loginId) {
		List<Message> list = mybatis.selectList("messageMapper.selectCnt",loginId);

		ArrayList<String> list2 = new ArrayList<String>();
		;
		for (Message m : list) {
			if (!m.getM_writer().equals(loginId)) {
				list2.add(m.getM_writer());
			}
		}
		for (Message m : list) {
			if (!m.getM_recv().equals(loginId)) {
				list2.add(m.getM_recv());
			}
		}
		ArrayList<String> resultList = new ArrayList<String>();
		for (int i = 0; i < list2.size(); i++) {
			if (!resultList.contains(list2.get(i))) {
				resultList.add(list2.get(i));
			}
		}
		

		return resultList;
	}

	public int insertMsg(Message message) {
		// TODO Auto-generated method stub
		return mybatis.insert("messageMapper.insertMessage", message);
	}

	public List<Message> msgViewSelect(Message message) {
		// TODO Auto-generated method stub
		return mybatis.selectList("messageMapper.msgViewSelect", message);
	}

	public int insertMsgRT(Message message) {
		// TODO Auto-generated method stub
		return mybatis.insert("messageMapper.insertMessageRT", message);
	}

	public int msgRead(Message message) {
		// TODO Auto-generated method stub
		return mybatis.update("messageMapper.msgRead",message);
	}
	public int msgdelete(String m_writer, String m_recv) {
	      // TODO Auto-generated method stub
	      Message message = new Message();
	      message.setM_writer(m_writer);
	      message.setM_recv(m_recv);
	      int result = mybatis.update("messageMapper.msgDelete",message);
	      result = mybatis.update("messageMapper.msgDelete2",message);
	      return result;
	   }

	

}