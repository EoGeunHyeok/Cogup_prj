package app;

import org.example.file.MemberJoin;
import org.example.file.Information;
import org.example.file.Reservation;


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

    public int display() {
        Scanner input = new Scanner(System.in);
        System.out.println("       ");
        System.out.println("===== 회원  관리 프로그램 =====");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 출석체크하기");
        System.out.println("3. 회원 출석현황 보기");
        System.out.println("4. 상담 예약 ");
        System.out.println("5. 헬스장 정보 ");
        System.out.println("6. 회원가입 ");
        System.out.println("7. 종료");
        System.out.print(">>>");
        return input.nextInt();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Students students = new Students();
        int[] seat = new int[6];
        int[] pit = new int[6];

        MemberJoin memberJoin = new MemberJoin() ;
        while (true) {
            int select = students.display();
            switch (select) {
                case 1:
                    System.out.print("이름을 입력하세요 :");
                    students.joinStudent(input.next());
                    break;
                case 2:
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
                case 3:
                    students.studentList();
                    break;
                case 4:
                    Reservation.reserveTime(seat);
                    break;
                case 5:
                    Information.infotmation(pit);
                    break;
                case 6:
                    MemberJoin.memberJoin();
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

}
    public void dispaly() {

    }
}
