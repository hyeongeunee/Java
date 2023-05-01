package test.main;

import java.util.Random;

public class QuizMain3 {
	public static void main(String[] args) {
		/*
		 * 3. 우연히 3개가 모두 같게 나왔을 때는 "당첨됬습니다!"를 출력하고
		 * 	  하나라도 다르면 "꽝"을 출력하도록 프로그래밍 해보세요.
		 * 	  ex ) 	cherry | apple | cherry
		 * 			꽝
		 * 		      7    |   7   |   7
		 * 			당첨됬습니다!
		 */
		String [] list = {"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체
		Random ran = new Random();
		int [] nums = new int[3];

		for(int i=0; i<nums.length; i++) {
			nums[i] = ran.nextInt(5);
			System.out.print(list[nums[i]]);
			if(i!=2) {
				System.out.print(" | ");
			} 
		}
		
		//이쪽 부분 for 문 안써도 됨 ㅠ
		for (int i = 1; i < 3; i++) {
			if (nums[i] == nums[i-1] && nums[i]==nums[i+1]) {
				System.out.println("\n" + "당첨됬습니다");
				break;
			} else {
				System.out.println("\n" +"꽝");
				break;
			}
		}
		/*
		 *	if(nums[0] == nums[1] && nums[1] == nums[2]) {
         *		System.out.println("당첨됬습니다!");
      	 *	} else {
         *		System.out.println("꽝");
         *	}
		 */
	}
}
