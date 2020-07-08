package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
public class ReplyServiceimpl implements ReplyService{

	@Autowired
	private ReplyDAO rDAO;
	
	
	@Override
	public int insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return rDAO.insert(vo);
	}


	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return rDAO.list(bno);
	}


	@Override
	public int update(ReplyVO vo) {
		// TODO Auto-generated method stub
		return rDAO.update(vo);
	}


	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return rDAO.delete(rno);
	}


	
}
