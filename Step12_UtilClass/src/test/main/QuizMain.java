package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMain {
	public static void main(String[] args) {
		//키보드로부터 문자열을 입력받을 수 있는 Scanner 객체를 생성해서 scan 이라는 지역변수에 담는다.
		Scanner scan = new Scanner(System.in);
		//문자열을 저장할 수 있는 ArrayList 객체를 생성해서 msgs라는 지역변수에 담는다.
		List<String> msgs =new ArrayList<String>();
		//반복문을 5번 돌면서 문자열을 5번 입력 받는데 입력받은 문자열을 ArrayList 객체에 순서대로 저장한다.
		for(int i = 0; i < 5; i++) {
			System.out.println("문자열 입력: ");
			String msg = scan.nextLine();
			msgs.add(msg);
		}
		//반복문을 활용해서 ArrayList에 담긴 모든 문자열을 순서대로 콘솔창에 출력하기
		for(String tmp:msgs) {
			System.out.println(tmp);
		}
	}
}
