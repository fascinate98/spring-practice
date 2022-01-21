package com.poscoict.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.emaillist.repository.EmaillistRepository;
import com.poscoict.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = new EmaillistRepository().findAll();
		model.addAttribute("list", list);
		
		System.out.println(emaillistRepository);
	
		return "/WEB-INF/views/index.jsp";
	}
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";  //emaillist03안적음 기술이니까
	}
}
