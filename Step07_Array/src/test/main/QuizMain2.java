package test.main;

import java.util.Random;

public class QuizMain2 {
	public static void main(String[] args) {
		/*
		 * 2. run 했을 때
		 * 	  5개의 문자열 중에서 3개가 한 줄에 한 번에 랜덤하게 출력되게 해보세요.
		 * 	  ex ) 	cherry | apple | cherry
		 * 		  	  7	   | apple | melon
		 * 		      7    |   7   |   7
		 */
		String [] list = {"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체
		Random ran = new Random();
		int [] nums = new int[3];

		for(int i=0;i<nums.length;i++) {
			nums[i] = ran.nextInt(5);
			System.out.print(list[nums[i]]);
			if(i!=2) {
				System.out.print(" | ");
			}
		}
	}
}
