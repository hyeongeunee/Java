package test.dao;

import test.dto.MemberDto;
import test.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 *  Data Access Object 만들어 보기
 *
 *  - DB 에 insert, update, delete, select 작업을 대신해 주는 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
    Connection conn = null;
    PreparedStatement pstmt=null;

    //회원 한명의 정보를 저장하고 작업의 성공 여부를 리턴해주는 메소드
    public boolean insert(MemberDto dto) {
        int rowCount = 0; //초기값을 0으로 부여
        //insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 개수를 담을 변수
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql = "insert into member"
                    + "(num, name, addr)"
                    + "values (member_seq.nextval, ?, ?)";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAddr());
            //insert or update or delete 문을 실제 수행한다. 변화된 row의 개수가 리턴된다.
            rowCount = pstmt.executeUpdate(); //수행하고 리턴되는 값을 변수에 담는다.
            System.out.println("추가되었습니다.");
        } catch (Exception e){
            e.printStackTrace();
        } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 사용
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ignored) {}
        }
        //변화된 row 의 개수가 0보다 크면 작업 성공
        return rowCount > 0;
    }

    public boolean update(MemberDto dto) {
        int rowCount = 0;
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql="UPDATE member"
                    + " SET name = ?, addr = ?"
                    + " WHERE num = ?";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAddr());
            pstmt.setInt(3, dto.getNum());
            //insert or update or delete 문을 실제 수행한다. 변화된 row의 개수가 리턴된다.
            rowCount = pstmt.executeUpdate(); //수행하고 리턴되는 값을 변수에 담는다.
            System.out.println("수정되었습니다.");
        } catch (Exception e){
            e.printStackTrace();
        } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 사용
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ignored) {}
        }
        //변화된 row 의 개수가 0보다 크면 작업 성공
        return rowCount > 0;
    }

    public boolean delete(MemberDto dto) {
        int rowCount = 0;
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql="delete from member"
                    + " WHERE num=?";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setInt(1, dto.getNum());
            //insert or update or delete 문을 실제 수행한다. 변화된 row의 개수가 리턴된다.
            rowCount = pstmt.executeUpdate(); //수행하고 리턴되는 값을 변수에 담는다.
            System.out.println("삭제되었습니다.");
        } catch (Exception e){
            e.printStackTrace();
        } finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 사용
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ignored) {}
        }
        //변화된 row 의 개수가 0보다 크면 작업 성공
        return rowCount > 0;
    }
}