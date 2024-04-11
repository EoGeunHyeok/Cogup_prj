package org.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class StuInfo {
    String name;
    String checkStatus = " 미출석  ";
    String checkTime; // New field to store attendance time

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
            studentsInfo.get(num).checkTime = str; // Storing attendance time
        }
    }

    public void studentList() {
        System.out.println("<< 출석 현황 >>");
        System.out.println("|번호| 이름 | 출석상태 | 출석시간");
        for (int i = 0; i < studentsInfo.size(); i++) {
            System.out.println("| " + (i + 1) + " |" + studentsInfo.get(i).name + "|  " + studentsInfo.get(i).checkStatus + "     | " + studentsInfo.get(i).checkTime);
        }
        return;
    }
}
public class CulController extends Controller {

    Scanner input = new Scanner(System.in);
    Students students = new Students();

    public void doAction(String action, String actionMethodName) {
        switch (actionMethodName) {
            case "0":
                System.out.print("이름을 입력하세요 :");
                students.joinStudent(input.next());
                break;
            case "1":
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
                students.studentCheck(num);
                break;
            case "3":
                students.studentList();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }
    }
}

