package test.deptdto;
/*
    Data Transfer Object

    - 여러가지의 정보를 하나의 객체에 담기 위해 설계된 클래스
    - 필드의 접근 지정자는 모두 private
    - 접근 메소드 setter, getter 메소드가 있어야한다.
    - 디폴트(기본)생성자가 있어야 한다.
    - 인자로 필드의 모든 값을 전달 받는 생성자도 있어야 한다.(있으면 좋음 option)
 */
public class DeptDto {
    //필드의 접근 지정자를 private
    private int deptno;
    private String dname;
    private String loc;


    //디폴트 생성자
    public DeptDto() {}

    // 마우스 우클릭 -> source -> generate 메뉴에서 constructor 와 setter, getter 메소드 생성 가능
    // 필드의 data type 과 필드명만 정해지면 생성자, setter, getter 메소드도 정해진 것이다.
    public DeptDto(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
