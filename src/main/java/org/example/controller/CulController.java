package org.example.controller;

import org.example.container.Container;
import org.example.dto.Member;
import org.example.service.ArticleService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class StuInfo {
    String name;
    String checkStatus = " 미출석  ";
    String checkTime;

    public StuInfo(String name) {
        this.name = name;
    }
}
class Students {

    private Date date;
    private SimpleDateFormat simpl;
    public ArrayList<StuInfo> studentsInfo = new ArrayList<StuInfo>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getSimpl() {
        return simpl;
    }

    public void setSimpl(SimpleDateFormat simpl) {
        this.simpl = simpl;
    }


    public void joinStudent(String name) {
        studentsInfo.add(new StuInfo(name));
        System.out.println(name + " 회원. 등록이 완료되었습니다.");
    }

    public void studentCheck(int num) {
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
            System.out.println("정상 출석 입니다.");
            studentsInfo.get(num).checkStatus = "출석";
            studentsInfo.get(num).checkTime = str;
        }
    }

    public void studentList() {
        System.out.println("<< 출석 현황 >>");
        System.out.println("|번호| 이름 | 출석상태 | 최근 출석시간");
        for (int i = 0; i < studentsInfo.size(); i++) {
            System.out.println("| " + (i + 1) + " |" + studentsInfo.get(i).name + "|  " + studentsInfo.get(i).checkStatus + "     | " + studentsInfo.get(i).checkTime);
        }
        return;
    }
}
public class CulController extends Controller {
    private Session session;
    public CulController() {
        session = Container.getSession();
    }

    Scanner input = new Scanner(System.in);
    Students students = new Students();

    public void doAction(String action, String actionMethodName) {
        switch (actionMethodName) {
            case "0":
                break;
            case "1":
                Member loginedMember = session.getLoginedMember();
                if (loginedMember != null) {
                    // 이미 등록된 회원인지 확인
                    boolean isRegistered = false;
                    for (StuInfo student : students.studentsInfo) {
                        if (student.name.equals(loginedMember.getName())) {
                            isRegistered = true;
                            break;
                        }
                    }

                    if (!isRegistered) {
                        students.joinStudent(loginedMember.getName());
                        System.out.println("로그인한 사용자 \"" + loginedMember.getName() + "\"를 회원 목록에 추가하였습니다.");
                    } else {
                        System.out.println("이미 등록된 사용자입니다.");
                    }
                } else {
                    System.out.println("로그인한 사용자 정보를 가져오지 못했습니다.");
                }
                students.setDate(new Date());
                students.setSimpl(new SimpleDateFormat("yyyy년 MM월 dd일"));
                SimpleDateFormat sim = students.getSimpl();
                System.out.println("<<<<" + sim.format(students.getDate()) + " 출석체크 >>>>");
                System.out.println("==== 회원 목록 ====");
                System.out.println("회원번호\t: 이름");
                for (int i = 0; i < students.studentsInfo.size(); i++) {
                    System.out.println((i + 1) + "\t:" + students.studentsInfo.get(i).name);
                }

                System.out.print("회원 번호를 입력하세요 : ");
                int num = input.nextInt() - 1;
                if (!loginedMember.getName().equals(students.studentsInfo.get(num).name)) {
                    System.out.println("다른 회원에 대해 출석체크할 수 없습니다.");
                    System.out.println("처음부터 다시 시도해주세요.");
                    return;
                }
                students.studentCheck(num);
                break;
            case "2":
                students.studentList();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }
    }
}

