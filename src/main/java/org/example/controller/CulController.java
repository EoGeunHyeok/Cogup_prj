package org.example.controller;

import org.example.container.Container;
import org.example.dao.MemberDao;
import org.example.dto.Member;
import org.example.service.ArticleService;
import org.example.service.MemberService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CulController extends Controller {
    private Session session;
    private Scanner input = new Scanner(System.in);
    private Date date = new Date();
    private SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 MM월 dd일");
    private ArrayList<StuInfo> studentsInfo = new ArrayList<>();
    public MemberService memberService;

    public CulController() {
        session = Container.getSession();
        memberService = new MemberService();
    }

    private void joinStudent(String name) {
        studentsInfo.add(new StuInfo(name));
        System.out.println(name + " 회원. 등록이 완료되었습니다.");
    }

    private void studentCheck(int num) {
        if (num >= studentsInfo.size() || num < 0) {
            System.out.println("회원 번호를 잘못 입력하였습니다.");
            return;
        }

        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("HH시mm분ss초");
        String str = sim.format(date);
        int hour = Integer.parseInt(str.substring(0, 2));
        int minute = Integer.parseInt(str.substring(3, 5));

        if (hour >= 9) {
            System.out.println("[출석체크 완료]");
            System.out.println("현재 시각 : " + str);
            System.out.println("출석 하였습니다.");
            studentsInfo.get(num).checkStatus = "출석";
            studentsInfo.get(num).checkTime = str;
        }
    }

    private void studentList() {
        System.out.println("<< 출석 현황 >>");
        System.out.println("|번호| 이름 | 출석상태 | 최근 출석시간");
        for (int i = 0; i < studentsInfo.size(); i++) {
            System.out.println("| " + (i + 1) + " |" + studentsInfo.get(i).name + "|  " + studentsInfo.get(i).checkStatus + "     | " + studentsInfo.get(i).checkTime);

            memberService.cul(studentsInfo.get(i).name, studentsInfo.get(i).checkStatus, studentsInfo.get(i).checkTime);
        }


    }

    public void doAction(String action, String actionMethodName) {
        switch (actionMethodName) {
            case "0":
                break;
            case "체크":
                Member loginedMember = session.getLoginedMember();
                if (loginedMember != null) {
                    boolean isRegistered = false;
                    for (StuInfo student : studentsInfo) {
                        if (student.name.equals(loginedMember.getName())) {
                            isRegistered = true;
                            break;
                        }
                    }
                    if (!isRegistered) {
                        joinStudent(loginedMember.getName());
                        System.out.println("로그인한 사용자 \"" + loginedMember.getName() + "\"를 회원 목록에 추가하였습니다.");
                    } else {
                        System.out.println("이미 등록된 사용자입니다.");
                    }
                } else {
                    System.out.println("로그인한 사용자 정보를 가져오지 못했습니다.");
                }
                System.out.println("<<<<" + simpl.format(date) + " 출석체크 >>>>");
                System.out.println("==== 회원 목록 ====");
                System.out.println("회원번호\t: 이름");
                for (int i = 0; i < studentsInfo.size(); i++) {
                    System.out.println((i + 1) + "\t:" + studentsInfo.get(i).name);
                }
                System.out.print("회원 번호를 입력하세요 : ");
                int num = input.nextInt() - 1;
                if (!loginedMember.getName().equals(studentsInfo.get(num).name)) {
                    System.out.println("다른 회원 대리 출석체크할 수 없습니다.");
                    System.out.println("처음부터 다시 시도해주세요.");
                    return;
                }
                studentCheck(num);

                break;
            case "확인":
                studentList();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }
    }

    private static class StuInfo {
        String name;
        String checkStatus = " 미출석  ";
        String checkTime;

        public StuInfo(String name) {
            this.name = name;
        }
    }
}