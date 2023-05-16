package test.test;

import test.deptdao.DeptDao;
import test.deptdto.DeptDto;

import java.util.List;

public class MainClass00 {
    public static void main(String[] args) {

        List<DeptDto> list = new DeptDao().getList();

        for(DeptDto tmp:list){
            System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
        }
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("검색할 부서 번호 입력 :");
//        int deptno = scan.nextInt();
//
//        DeptDto dto = new DeptDao().getData(deptno);
//
//        if (dto != null){
//            System.out.println(deptno+"번 부서는:"+ dto.getDname()+" 주소는:"+dto.getLoc());
//        } else {
//            System.out.println(deptno+" 번 부서는 존재하지 않습니다!");
//        }
        //추가할 회원의 정보
        String dname = "xxx";
        String loc = "xx";
        int deptno = 1;

        //추가할 회원의 정보를 MemberDto 객체에 담는다.
        DeptDto dto = new DeptDto();
        dto.setDname(dname);
        dto.setLoc(loc);
        dto.setDeptno(deptno);

        //DB에 저장하기
        //new DeptDao().insert(dto);
        //new DeptDao().update(dto);
        //new DeptDao().delete(dto);
    }
}
