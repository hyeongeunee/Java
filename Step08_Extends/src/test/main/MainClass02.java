package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
/*
 *  지역 변수나 필드 앞에 선언하는 data type 은 (참조 데이터 type)
 *  
 *  그 안에 들어있는 참조 값의 사용 설명서 라고 생각하면 된다.
 *  
 *  그렇기 때문에 그 지역변수나 필드에 . 을 찍으면 사용 설명서에 명시된 기능만 사용할 수 있다.
 *  
 *  java 의 모든 객체는 다형성을 가질 수 있다.
 *  
 *  다형성은 type 이 여러 개라는 의미이다. 
 */
public class MainClass02 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 HandPhone type 지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		//Phone 객체를 생성해서 나온 참조값을 Phone type 지역변수 p2에 담기
		Phone p2 = new HandPhone();
		//Phone 객체를 생성해서 나온 참조값을 Object type 지역변수 p3에 담기
		Object p3 = new HandPhone();
		
		p1.call();
		p1.takePicture();
		p1.mobileCall();
		p2.call();
	}
}
