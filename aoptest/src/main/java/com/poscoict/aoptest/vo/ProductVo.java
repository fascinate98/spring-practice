package com.poscoict.aoptest.vo;

import org.springframework.stereotype.Service;

public class ProductVo {

	private String name;
	
	
	public ProductVo(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
	

}
