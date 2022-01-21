package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 
 * @RequestMapping: 클래스(타입) + 메소드(핸들러)
 * 
 * @author BIT
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/join", method = RequestMethod.GET) //기본값 : value , method
	//@GetMapping 이랑 동일
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST) //기본값 : value , method
	public String join(UserVo vo) {
		System.out.println(vo);   //jsp name이랑 필드명이 같아야 알아서 생성할떄 들어감
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping("/update")  //겟포스트 다들어옴
	public String update(@RequestParam("n") String name) {  //골뱅이 붙히면 널넣으면 에러
		/**
		 * 
		 * 만일, n이라는 이름의 파라미터가 ㅇ벗는 경우 
		 * 400bad request 에러가 발생한다.
		 */
		System.out.println(name);
		return "UserController.update()";
	}
	
	
	@ResponseBody
	@RequestMapping("/update2")  //겟포스트 다들어옴
	public String update2(
			//false면 안들어왓을떄 널, 스투루고 디폴트벨류주면 기본값설정가능
			@RequestParam(value = "n", required = true, defaultValue = "") String name, 
			@RequestParam(value = "a", required = true, defaultValue = "0")  Integer age) {  

		//지저분함
//		if(age == null) {
//			age = 0;
//		}
		
		System.out.println("---"+ name);
		System.out.println("---"+ age);
		return "UserController.update2()";
	}
}
