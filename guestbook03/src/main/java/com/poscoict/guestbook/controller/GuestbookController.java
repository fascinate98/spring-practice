package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.guestbook.repository.GuestbookRepository;
import com.poscoict.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = new GuestbookRepository().findAll();
		model.addAttribute("list", list);
		
		System.out.println(guestbookRepository);
	
		return "/WEB-INF/views/index.jsp";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";  //emaillist03안적음 기술이니까
	}
	
	//delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET) //기본값 : value , method
	public String delete(Integer no,  Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST) //기본값 : value , method
	//@GetMapping 이랑 동일
	public String delete(GuestbookVo vo){

		guestbookRepository.delete(vo);
		return "redirect:/"; 
	}
	
	


}
