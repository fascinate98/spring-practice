package com.poscoict.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscoict.container.user.User;
import com.poscoict.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		//testBeanFactory01();
		testApplicationContext02();
	}
	
	
	
	//XML Bean Configuration(Explicit Configuration) 컨테이너는 빈 달라고하면 주는거바꼐 안해 의존성잇으면 di 해버리고 와이어링기능이 잇다는게 중요 빈생성, 주입. di
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		//id로 빈 가져오기
		user = (User)ac.getBean("user");
		System.out.println(user);
		
		//name으로 가져오기
		user = (User)ac.getBean("usr");
		System.out.println(user);
		
		//type으로 가져오기. 같은타입 겹치면 에러남
		//1. id , type을 하던지
		//2. name , type을 하던지
		user = ac.getBean("user2", User.class);
		System.out.println(user);		
		
		//2개 파라미터 생성자로 생성된 빈 가져오기
		user = ac.getBean("user3", User.class);
		System.out.println(user);	
		
		//2개 파라미터 생성자로 생성된 빈 가져오기
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		//세터를 사용한 빈 가져오기 1
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		//세터를 사용한 빈 가져오기2(DI)
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		//세터를 사용한 빈 가져오기3(list)
		user = ac.getBean("user7", User.class);
		System.out.println(user);
	}
	
	
	//XML Auto Configuration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext01.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		//빈의 id로 가져오ㅜ는거. bean id가 자동으로 설정됨. 클래스명 앞글자 소문자로한거. 오브젝트타입이라 캐스팅해줘야함
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
	}
	
	
	
	
	//XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//빈의 id로 가져오ㅜ는거. bean id가 자동으로 설정됨. 클래스명 앞글자 소문자로한거. 오브젝트타입이라 캐스팅해줘야함
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	//XML Bean Configuration(Explicit Configuration) 컨테이너는 빈 달라고하면 주는거바꼐 안해 의존성잇으면 di 해버리고 와이어링기능이 잇다는게 중요 
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		//bean id가 자동으로 설정되지 않음
		//명시적으로 설정해야한다.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
	
}
