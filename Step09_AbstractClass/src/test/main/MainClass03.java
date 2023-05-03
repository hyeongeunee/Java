package test.main;

import test.mypac.Zoo;

public class MainClass03 {
	public static void main(String[] args) {
		// Zoo 객체를 생성해서 참조값을 z1이라는 변수에 담아 보세요.
		Zoo z1 = new Zoo();
		// z1 안에 들어 있는 참조값을 이용해서 getMonkey() 메소드를 호출 후 리턴되는 값을 m1 이라는 변수에 담아보세요.
		Zoo.Monkey m1 = z1.getMonkey(); //Zoo.Monkey import 하기 싫으면 이렇게 써두댐
		// 리턴된 Monkey 객체의 say() 메소드 호출해보기
		m1.say();
		
		// Zoo 객체를 생성해서 참조값을 z2이라는 변수에 담아보세요
		Zoo z2 = new Zoo();
		// z2 안에 들어 있는 참조값을 이용해서 getTiger() 메소드를 호출 후 리턴되는 값을 t1이라는 변수에 담아보세요.
		Zoo.Tiger t1 = z2.getTiger();
		// 리턴된 Tiger객체의 say() 메소드 호출해보기
		t1.say();
	}
}
