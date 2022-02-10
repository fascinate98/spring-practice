package com.poscoict.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscoict.container.videosystem.Avengers;
import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean //생성매소드는 달고있어야해ㅔ. 컨테이너 실행해 객체 여기다등록해..
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	//주입안댄채로감/ 잘못댓코드
//	@Bean 
//	public DVDPlayer dvdPlayer() {
//		return new DVDPlayer();
//	}
//	
	//주입(injection)하기 1
	// Bean 생성 메소드를 직접 호출하는 방법
	// 생성자주입
	//주입이 된 상태로 가야함 
//	@Bean
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	
	//주입(injection)하기 2
	// 파라미터로 빈 전달하기
	// 생성자주입
	//주입이 된 상태로 가야함 
//	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	
	//주입(injection)하기 3
	// 파라미터로 빈 전달하기
	// setter주입
	//주입이 된 상태로 가야함 
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
	
	
	//같은 타입의 빈을 생성할 경우
	@Bean(name="dvdPlayer04")
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
}
