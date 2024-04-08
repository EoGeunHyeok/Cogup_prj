package org.example;
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

    public int display() {
        Scanner input = new Scanner(System.in);
        System.out.println("===== 회원  관리 프로그램 =====");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 출석체크하기");
        System.out.println("3. 회원 출석현황 보기");
        System.out.println("4. 상담 예약 ");
        System.out.println("5. 헬스장 정보 ");
        System.out.println("6. 종료");
        System.out.print(">>>");
        return input.nextInt();
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

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Students students = new Students();
        int[] seat = new int[6];
        int[] pit = new int[6];
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
                    reserveTime(seat);
                    break;
                case 5:
                    Imformation(pit);
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void reserveTime(int[] seat) {
        Scanner v = new Scanner(System.in);
        int pax = 6;

        while (pax > 0) {
            System.out.println("== 금일 예약하실 시간을 입력해주세요 ==");
            System.out.println("13시 [1타임], 14시 [2타임], 15시 [3타임], 16시 [4타임], 17시 [5타임], 18시 [6타임] ");
            printAvailableTimes(seat);

            int y = v.nextInt();

            if (y > 6 || y < 1) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            if (seat[y - 1] == 0) {
                System.out.println("★★★ 예약이 완료되었습니다. ★★★ ");
                seat[y - 1] = 1;
                pax--;

                System.out.println("예약을 취소하시겠습니까? (1)예/(2)아니오");
                String cancel = v.next();
                if (cancel.equalsIgnoreCase("1")) {
                    seat[y - 1] = 0;
                    pax++;
                    System.out.println("♣♣♣ 예약이 취소되었습니다. ♣♣♣");
                } else {
                    System.out.println("♣♣♣ 예약이 완료되었습니다. ♣♣♣");
                }
            } else {
                System.out.println("예약이 완료된 시간입니다. 다시 예약해주세요.");
            }
            return;
        }
    }

    public static void printAvailableTimes(int[] seat) {
        System.out.println("※※ 금일 예약 가능한 시간은 ※※ ");
        for (int i = 0; i < seat.length; i++) {
            if (seat[i] == 0) {
                System.out.printf(" [%d 타임]", i + 1);
            }
        }
        System.out.println();
        System.out.printf("예약 타임 : ");
    }

    public static void Imformation(int[] pit) {
        Scanner v = new Scanner(System.in);
        int pax = 2;

        while (pax > 0) {
            System.out.println("== 헬스장 정보 ==");
            System.out.println(" ◈ 위치 ◈ : 대전광역시 유성구 xxxxxxxx ");
            System.out.println(" ☎ 대표번호 ☎ : 042-xxxx-xxxx ");
            System.out.println(" ※ 운영시간 ※ : (평일) 06:00 ~ 23:00  (주말+공휴일) 12:00 ~ 18:00 " );
            System.out.println(" ☞ 매주 일요일 휴관. ☜");

            printImformation(pit);

            int y = v.nextInt();

            if (y > 2 || y < 1) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            if (pit[y - 1] == 0) {
                if (y == 1) {
                    System.out.println("★★★ 시설 안내로 이동하였습니다. ★★★ ");
                    System.out.println("1. 유산소존 ");
                    System.out.println("2. 프리웨이트존 ");
                    System.out.println("3. 머신존");
                    System.out.println("4. GX존 ");
                } else if (y == 2) {
                    System.out.println("★★★ 서비스 안내로 이동하였습니다. ★★★");
                    System.out.println("1. 무선 인터넷 ");
                    System.out.println("2. 반려동물 동반 ");
                    System.out.println("3. 남/녀 화장실구분");
                    System.out.println("4. 남/녀 사워실구분 ");
                }
                pax--;

                System.out.println("최기화면으로 돌아가시겠습니까? (1)예");
                String cancel = v.next();
                if (cancel.equalsIgnoreCase("1")) {
                    pit[y - 1] = 0;
                    pax++;
                    System.out.println("♣♣♣ 이동이 되었습니다. ♣♣♣");
                } else {
                    System.out.println("♣♣♣ 이동이 되었습니다. ♣♣♣");
                }
            }
            return;
        }
    }
    public static void printImformation (int[] pit) {
        System.out.println("(1) 시설 안내, (2) 사용가능 서비스 안내 ");

        System.out.println();
        System.out.printf("입력 : ");
    }
}

