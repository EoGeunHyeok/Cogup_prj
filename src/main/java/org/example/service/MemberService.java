package org.example.service;


import org.example.container.Container;
import org.example.controller.Session;
import org.example.dao.CheckDao;
import org.example.dao.CulDao;
import org.example.dao.MemberDao;
import org.example.dto.Check;
import org.example.dto.Cul;
import org.example.dto.Member;

public class MemberService {
    public MemberDao memberDao;
    public CulDao culDao;
    public CheckDao checkDao;
    public Session Session;

    public MemberService(){
        memberDao = Container.memberDao;
        culDao = new CulDao();
        checkDao = new CheckDao();
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
        culDao.addAttendance(cul);
    }

    public void check(String name, String reservation , String checkPw, String time){
        Check check = new Check(name, reservation, checkPw, time);
        checkDao.addCheck(check);

    }

    public Member getLoginedMember(String loginId) {
        return memberDao.getMemberByLoginId(loginId);

    }

    public void cancelCheck(int timeSlot){
            checkDao.cancelCheck(timeSlot);
        }

}
