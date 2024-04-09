package org.example.file;

import java.util.Scanner;

public class Information {
    public static void infotmation(int[] pit) {
        Scanner v = new Scanner(System.in);
        int pax = 2;

        while (pax > 0) {
            System.out.println("== 헬스장 정보 ==");
            System.out.println(" ◈ 위치 ◈ : 대전광역시 유성구 xxxxxxxx ");
            System.out.println(" ☎ 대표번호 ☎ : 042-xxxx-xxxx ");
            System.out.println(" ※ 운영시간 ※ : (평일) 06:00 ~ 23:00  (주말+공휴일) 12:00 ~ 18:00 " );
            System.out.println(" ☞ 매주 일요일 휴관. ☜");

            printInformation(pit);

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

    public static void printInformation(int[] pit) {
        System.out.println("(1) 시설 안내, (2) 사용가능 서비스 안내 ");

        System.out.println();
        System.out.printf("입력 : ");
    }

}


