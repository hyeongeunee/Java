package test.deptdao;

import test.deptdto.DeptDto;
import test.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 *  Data Access Object 만들어 보기
 *
 *  - DB 에 insert, update, delete, select 작업을 대신해 주는 객체를 생성할 클래스 설계하기
 */

public class DeptDao {
    Connection conn = null;
    PreparedStatement pstmt=null;
    int rowCount = 0;

    //인자로 전달되는 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
    public DeptDto getData(int deptno){
        ResultSet rs = null;
        //MemberDto 객체의 참조값을 담을 지역변수 미리 만들기
        DeptDto dto = null;

        try {
            //Connection 객체의 참조값 얻어오기
            Connection conn = null;
            PreparedStatement pstmt=null;
            conn = new DBConnect().getConn();
            String sql = "SELECT dname, loc"
                    + " FROM dept"
                    + " WHERE deptno = ?";
            pstmt = conn.prepareStatement(sql);
            //select 문이 미완성이라면 여기서 완성한다.
            pstmt.setInt(1, deptno);
            //select 문 수행하고 결과를 ResultSet 으로 리턴받기
            rs = pstmt.executeQuery();
            //반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
            while (rs.next()) {
                //현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //MemberDto 객체에 회원 한 명의 정보를 담는다
                dto = new DeptDto();
                dto.setDeptno(deptno);
                dto.setDname(dname);
                dto.setLoc(loc);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
        return dto;
    }

    //전체 회원의 정보를 리턴하는 메소드
    public List<DeptDto> getList(){
        //회원 정보를 누적할 객체
        List<DeptDto> list = new ArrayList<>();

        //필요한 객체를 담을 지역 변수를 미리 만들기
        ResultSet rs = null;
        try {
            //Connection 객체의 참조값 얻어오기
            Connection conn = null;
            PreparedStatement pstmt=null;
            conn = new DBConnect().getConn();
            String sql = "SELECT deptno, dname, loc"
                    + " FROM dept"
                    + " ORDER BY deptno DESC";
            pstmt = conn.prepareStatement(sql);
            //select 문이 미완성이라면 여기서 완성한다.

            //select 문 수행하고 결과를 ResultSet 으로 리턴받기
            rs = pstmt.executeQuery();
            //반복문 돌면서 ResultSet 에 있는 row 에 있는 정보를 추출한다.
            while (rs.next()) {
                //현재 커서가 존재하는 row 에 있는 정보를 추출해서 사용한다.

                //row 에 있는 회원 정보를 MemberDto 객체에 담아서
                DeptDto dto = new DeptDto();
                dto.setDeptno(rs.getInt("deptno"));
                dto.setDname(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
                //List 에 누적시킨다.
                list.add(dto);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
        //회원 정보가 누적된 List 객체의 참조값을 리턴한다.
        return list;
    }

    //회원 한명의 정보를 저장하고 작업의 성공 여부를 리턴해주는 메소드
    public boolean insert(DeptDto dto) {
        //insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 개수를 담을 변수
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql = "insert into dept"
                    + "(deptno, dname, loc)"
                    + "values (?, ?, ?)";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setInt(1, dto.getDeptno());
            pstmt.setString(2, dto.getDname());
            pstmt.setString(3, dto.getLoc());
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

    public boolean update(DeptDto dto) {
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql="UPDATE dept"
                    + " SET dname = ?, loc = ?"
                    + " WHERE deptno = ?";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setString(1, dto.getDname());
            pstmt.setString(2, dto.getLoc());
            pstmt.setInt(3, dto.getDeptno());
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

    public boolean delete(DeptDto dto) {
        try {
            //Connection 객체의 참조값 얻어오기
            conn = new DBConnect().getConn();
            //실행할 sql문
            String sql="delete from dept"
                    + " WHERE deptno=?";
            //sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
            pstmt = conn.prepareStatement(sql);
            //sql 문이 ? 가 존재하는 미완성이라면 여기서 완성한다.
            pstmt.setInt(1, dto.getDeptno());
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
