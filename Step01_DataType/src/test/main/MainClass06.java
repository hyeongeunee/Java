package test.main;

public class MainClass06 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		//기본데이터 타입에는 null을 넣을 수 없다(선언만 하면 데이터 만들어지지도 않음).
		int num1;
		//int num1 = 0;
		String name1;
		//String name1 = null;
		
		//아직 만들어지지 않았기 때문에 num1은 참조 불가
		//int result = 10 + num1;
		
		//아직 만들어지지 않았기 때문에 name1은 참조 불가 
		//System.out.println(name1);
		
		System.out.println("main 메소드가 종료됩니다.");
	}
}
