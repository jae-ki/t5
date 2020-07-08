package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DepartDTO;
import kr.co.persistence.DepartDAO;

@Service
@Transactional
public class DepartServiceimpl implements DepartService{
	
	@Inject
	private DepartDAO departDAO;

	@Override
	public void insert(DepartDTO dto) {
		departDAO.insert(dto);
	}

	@Override
	public List<DepartDTO> list() {
		return departDAO.list();
	}

	@Override
	public DepartDTO read(String did) {
		return departDAO.read(did);
	}

	@Override
	public DepartDTO updateui(String did) {
		return departDAO.updateui(did);
	}

	@Override
	public void update(DepartDTO dto) {
		departDAO.update(dto);
	}

	@Override
	public void delete(String did) {
		departDAO.delete(did);	
	}

	
	
}
