package test.main;

import java.util.*;

public class MainClass10 {
	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		names.add("주뎅이");
		names.add("덩어리");
		
		//반복자(Iterator) 객체 얻어내기 (저장된 item을 일렬로 세웠다고 생각하면 됨)
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		System.out.println("---------");
		
		names.forEach((item)->{
			System.out.println(item);
		});
		
		//특정 item(데이터, 참조값) 존재 여부 알아내기
		boolean isContain = names.contains("김구라");
		//저장된 item 의 갯수
		int size = names.size();
		//특정 item 삭제 
		names.remove("해골");
		//모든 아이템 삭제
		names.clear();
	}
}
