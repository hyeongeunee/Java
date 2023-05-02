package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 Object type p3 라는 지역변수에 담아보세요.
		Object p3 = new HandPhone();
		//Object type p3 변수에 담긴 값을 Phone type p2 라는 변수에 담기
		Phone p2 = (Phone)p3; //Object type이 Phone type이여야 가능 > 캐스팅(casting) 필요
		//Object type p3 변수에 담긴 값을 HandPhone type p1 라는 변수에 담기
		HandPhone p1 = (HandPhone)p3; 
	}
}
