package kr.or.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.DepartDTO;
import kr.co.service.DepartService;

@Controller
@RequestMapping("depart")
public class DepartController {

	@Inject
	private DepartService departService;
	
	@RequestMapping(value = "/delete/{did}" , method = RequestMethod.GET)
	public String delete(@PathVariable("did") String did) {
		departService.delete(did);
		return "redirect:/depart/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(DepartDTO dto) {
		departService.update(dto);
		return "redirect:/depart/list";	
	}
	
	@RequestMapping(value = "/update/{did}", method = RequestMethod.GET)
	public String updateui(@PathVariable("did") String did, Model model) {
		DepartDTO dto = departService.updateui(did);
		model.addAttribute("dto", dto);
		return "/depart/update";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(String did, Model model) {
		DepartDTO dto = departService.read(did);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<DepartDTO> list = departService.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(DepartDTO dto) {
		departService.insert(dto);
		return "redirect:/depart/list";
	}
	
	@RequestMapping("/insert")
	public void insert() {
		
	}
}
