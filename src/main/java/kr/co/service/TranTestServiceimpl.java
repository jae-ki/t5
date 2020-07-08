package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.persistence.BoareDAO;

@Service
@Transactional
public class TranTestServiceimpl implements TranTestService {

	@Autowired
	private BoareDAO bDAO;
	
	@Override
	public void insertNupdate1(BoardVO vo) {
		bDAO.insert(vo);
		System.out.println(4/0);
		bDAO.update(vo);
	}

}
