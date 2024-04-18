package org.example.service;


import org.example.container.Container;
import org.example.dao.CulDao;
import org.example.dao.MemberDao;
import org.example.dto.Cul;
import org.example.dto.Member;

public class MemberService {
    public MemberDao memberDao;
    public CulDao culDao;

    public MemberService(){
        memberDao = Container.memberDao;
        culDao = new CulDao();
    }
    public int join(String loginId, String loginPw, String name) {
        Member member = new Member(loginId,loginPw, name);
        return memberDao.join(member);
    }
    public Member getMemberByLoginId(String loginId) {

        return memberDao.getMemberByLoginId(loginId);
    }


    public Member getMember(int memberId) {

        return  memberDao.getMember(memberId);
    }


    public void cul(String name, String checkStatus, String checkTime) {
        Cul cul = new Cul(name, checkStatus, checkTime);
        culDao.addAttendance(cul); // CulDao를 사용하여 출석 정보를 데이터베이스에 저장
    }
}
