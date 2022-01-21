package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 
 * @RequestMapping: 클래스(타입) 단독 매핑
 * @author BIT
 *
 */
@Controller
@RequestMapping("/guestbook/*")  // *는 매서드랑 매피ㅣㅇ
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping  //위에서 해놔서 안줘도 댐
	public String list() {
		return "GuestbookController.list()"; 
	}
	
	@ResponseBody
	@RequestMapping  //위에서 해놔서 안줘도 댐
	public String delete() {
		return "GuestbookController.delete()"; 
	}
	
}
