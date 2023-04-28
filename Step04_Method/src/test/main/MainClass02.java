package test.main;

import test.mypac.Airplane;
import test.mypac.Test;

public class MainClass02 {
	public static void main(String[] args) {
		Test t = new Test();
		
		//메소드 다중정의, 메소드 오버로딩
		t.send();
		
		//값을 즉석에서 만들어서 전달
		t.send(10);
		t.send("xxx");
		t.send(new Airplane());
		
		//참조되는 값을 전달
		int a = 999;
		t.send(a);
		
		String b = "하이";
		t.send(b);
		
		Airplane c =new Airplane();
		t.send(c);
		
		
	}
}
