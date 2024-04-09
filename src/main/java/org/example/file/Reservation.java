package org.example.file;

import java.util.Scanner;

public class Reservation {
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
}
