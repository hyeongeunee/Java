package test.main16;

import test.dao.MemberDao;
import test.dto.MemberDto;

import java.util.List;

public class MainClass16 {
    public static void main(String[] args) {
        //모든 회원의 정보를 얻어오고 싶다면?
        List<MemberDto> list = new MemberDao().getList();
        //얻어와서 뭘하지? 콘솔창에 출력
        for(MemberDto tmp:list){
            System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
        }
    }
}
