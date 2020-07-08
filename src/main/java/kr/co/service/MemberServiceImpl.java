package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDAO;

	@Override
	public void insert(MemberDTO dto) {
		memberDAO.insert(dto);
		
	}
	@Override
	public List<MemberDTO> list() {
		return memberDAO.list();
	}
	@Override
	public MemberDTO read(String id) {
		return memberDAO.read(id);
	}
	@Override
	public MemberDTO updateui(String id) {
		return memberDAO.updateui(id);
	}
	@Override
	public void update(MemberDTO dto) {
		memberDAO.update(dto);
	}
	@Override
	public void delete(String id) {
		memberDAO.delete(id);
	}

}
