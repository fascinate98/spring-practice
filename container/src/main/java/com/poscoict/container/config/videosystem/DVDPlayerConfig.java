package com.poscoict.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean //생성매소드는 달고있어야해ㅔ. 컨테이너 실행해 객체 여기다등록해..
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	
	@Bean 
	public DVDPlayer dvdPlayer() {
		return new DVDPlayer();
	}
	
	//주입(injection)하기 1
	//
}
