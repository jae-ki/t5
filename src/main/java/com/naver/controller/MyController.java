package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.util.utils;

@Controller
public class MyController {
	
	@RequestMapping(value="test", method = RequestMethod.GET)
	public void test(String name) {
		name = utils.toKor(name);
		
		System.out.println(name);
	}
	
	@RequestMapping(value="good", method = RequestMethod.GET)
	public void good(Model model) {
		model.addAttribute("test", "test입니다.");
	}
	
	@RequestMapping(value="world", method = RequestMethod.GET)
	public void world() {
		
	}
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

}
