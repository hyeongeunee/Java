package test.main;

public class MainClass07 {
	
	public static int num=999;
	
	//main 메소드는 static 메소드이다.
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//클래스명.필드명 형식으로 static 필드를 참조한다.
		int result = MainClass07.num+1;
		
		// main() 메소드와 num 필드는 둘다 MainClass07 안에 속해있으므로(같은 공간) 클래스명. 은 생략 가능하다.
		int result2 = num+1;
		
		// 아래에 정의한 test() 메소드가 호출 가능할까?
		//this.test(); //static영역에서 this 는 영향 x
		MainClass07.test();
		test();
	}
	
	public static void test() { // static 없으면 새로 선언(MainClass07.test()..)해야 사용가능.
		System.out.println("test() 메소드가 호출되었습니다.");		
	}
}
