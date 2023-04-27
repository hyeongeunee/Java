package test.mypac;

public class MyUtil {
	//static 필드
	public static String version="1.0.0";	
	//public String version="1.0.0";
	// >> new MyUtil().version << 스태틱 없으면 이런식으로 참조할 수 있음
	
	//static 메소드
	public static void send() {
		System.out.println("전송합니다.");
	}
}
 