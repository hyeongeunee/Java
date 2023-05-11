package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		
		/*
			InputStream is = System.in;
			InputStreamReader isr =new InputStreamReader(is);
			//문자열 1줄씩 입력 받을 수 있는 객체
			BufferedReader br = new BufferedReader(isr);
		*/
		
		//한 줄로 표현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//BufferedReader 객체의 readLine() 메소드를 이용해서 문자열 한 줄을 읽어들이기
			String line = br.readLine();
			System.out.println("line : "+ line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
