package test.mypac;
/*
 * class 의 역할
 * 
 * 1. 객체의 설계도 역할
 * 	- 객체(object)는 heap 영역(사물함)에 들어 있는 물건이라고 생각하면 된다.
 * 	- class를 이용해서 객체를 원하는 시점에 원하는 개수만큼 만들어 낼 수 있다.
 * 	- 만들어진 객체가 어떤 저장소(filed)와 어떤 기능(method)을 가지게 할 지 class로 설계할 수 있다.
 * 
 * 2. data type 역할
 * 
 * 3. static 필드와 메소드를 포함하는 역할
 * 
 */
public class Car {
	
	/*
	 * [필드 정의하기]
	 * - 클래스의 { } 중괄호 안에 아래와 같은 형식으로 필드를 정의할 수 있다.
	 * - 초기 값을 부여하지 않으면 기본 값이 들어간다.
	 * - int의 기본값은 0, boolean의 기본값은 false, 참조 데이터 type의 기본값은 null
	 * 
	 * 		접근 지정자 data type    필드명 = 초기값;
	 */
	
	public String name;
	public int price;
	
	/*
	 *  [메소드 정의하기]
	 *  
	 *   접근 지정자 return type   메소드명(){
	 *   
	 *   }
	 */
	
	public void drive() {
		System.out.println(this.name+" 가(이) 달려요!");
		
		//Car a = this; //Car class 안에서 this 는 Car type임.
	}
	
	public void showInfo() {
		System.out.println("차의 이름은 "+this.name+" 이고, 가격은 "+this.price+"만원 입니다.");
	}
}
