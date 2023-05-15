package test.main10;

import test.dto.MemberDto;
import test.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MainClass10 {
    public static void main(String[] args) {
        //수정할 회원의 정보
        int num=1;
        String name="호빵";
        String addr="독산동";

        MemberDto mem1 = new MemberDto();
        mem1.setNum(num);
        mem1.setName(name);
        mem1.setAddr(addr);

        update(mem1);
    }

    public static void update(MemberDto dto) {
        Connection conn = null;
        PreparedStatement pstmt=null;
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 미완성의 sql 문
            String sql="UPDATE member"
                    + " SET name = ?, addr = ?"
                    + " WHERE num = ?";
            //미완성의 sql문을 전달하면서 PreparedStatement 객체의 참조값 얻어오기
            pstmt=conn.prepareStatement(sql);
            // PreparedStatement 객체의 메소드를 이용해서 완성의 sql 문을 완성 시킨다. (? 에 값을 바인딩하기)
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAddr());
            pstmt.setInt(3, dto.getNum());
            //sql 문 실행하기
            pstmt.executeUpdate();
            System.out.println("회원 정보를 수정했습니다.");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}