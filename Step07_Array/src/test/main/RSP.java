package test.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class RSP {
    public static void main(String[] args) {
    	System.out.println("(가위:0), (바위:1), (보:2) 입력하세요 : ");
    	Scanner in = new Scanner(System.in);
    	int me = in.nextInt();
    	System.out.println(me);

        String [] list = {"가위", "바위", "보"};
        Random ran=new Random();
        int com = ran.nextInt(3);
        
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"가위");
        map.put(1,"바위");
        map.put(2,"보");
        
        System.out.println("나 : " + list[me] + " vs  Com : " + list[com]);

        if (me >= 3) {
            System.out.println("0 ~ 2의 값을 입력하세요 !");
        } else if ((me + 1) % 3 == com) {
            System.out.println("졌습니다!");
        } else if (me == com) {
            System.out.println("비겼습니다!");
        } else {
            System.out.println("이겼습니다!");
        }
        
        
    }
}