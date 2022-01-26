package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping: 메소드 단독 매핑
 * @author BIT
 *
 */

@Controller
public class BoardController {
	
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	
	
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable("no") Long bordarNo) { //기본타입 넣었을때 널이면 에러  @PathVariable어떤값을 받을지. 위랑 아래 첫번쨰 같아야하고 두번쨰랑 아래꺼 같아야
		return "BoardController.view("+ bordarNo +")";
	}
}
