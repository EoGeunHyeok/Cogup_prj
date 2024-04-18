package org.example.controller;

import org.example.container.Container;
import org.example.dto.Member;
import org.example.service.MemberService;

import java.util.Scanner;

public class CheckController extends Controller {
    private int[] seat;
    private String[] reservations;
    private MemberService memberService;

    public CheckController(int[] seat) {
        this.seat = seat;
        this.reservations = new String[seat.length];
        this.memberService = Container.memberService;
    }

    @Override
    public void doAction(String cmd, String actionMethodName) {
        switch (actionMethodName) {
            case "예약":
                reserveTime();
                break;
            case "취소":
                cancelReservation();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        printReservedTimes();
        System.out.println("예약을 취소하실 시간을 입력해주세요:");
        int timeSlot = scanner.nextInt();

        if (timeSlot < 1 || timeSlot > 6) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        if (seat[timeSlot - 1] == 1) {
            System.out.println("확인 비밀번호를 입력해주세요 :");
            String name = scanner.next();
            if (name.equals(reservations[timeSlot - 1])) {
                seat[timeSlot - 1] = 0;
                reservations[timeSlot - 1] = null;
                System.out.println("예약이 취소되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("해당 시간은 예약되어 있지 않습니다.");
        }
    }

    public void printReservedTimes() {
        System.out.println("※※ 예약된 시간 목록 ※※ ");
        boolean reserved = false;
        for (int i = 0; i < seat.length; i++) {
            if (seat[i] == 1) {
                System.out.printf(" [%d 타임]", i + 1);
                reserved = true;
            }
        }
        if (!reserved) {
            System.out.println("예약된 시간이 없습니다.");
        }
        System.out.println();
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

    public void reserveTime() {
        Scanner scanner = new Scanner(System.in);
        int pax = 6;

        Member loginedMember = Container.getSession().getLoginedMember();
        if (loginedMember == null) {
            System.out.println("로그인 후 이용해주세요.");
            return;
        }

        while (pax > 0) {
            System.out.println("== 금일 예약하실 시간을 입력해주세요 ==");
            System.out.println("13시 [1타임], 14시 [2타임], 15시 [3타임], 16시 [4타임], 17시 [5타임], 18시 [6타임] ");
            printAvailableTimes(seat);

            int y = scanner.nextInt();

            if (y > 6 || y < 1) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            if (seat[y - 1] == 0) {
                System.out.println("확인 비밀번호를 입력해주세요. : ");
                String name = scanner.next();
                reservations[y - 1] = name;
                seat[y - 1] = 1;
                pax--;
                System.out.println("★★★ 예약이 완료되었습니다. ★★★ ");
                System.out.println("예약을 취소하시겠습니까? (1)예/(2)아니오");
                String cancel = scanner.next();
                if (cancel.equalsIgnoreCase("1")) {
                    seat[y - 1] = 0;
                    pax++;
                    reservations[y - 1] = null;
                    System.out.println("♣♣♣ 예약이 취소되었습니다. ♣♣♣");
                } else {
                    MemberService memberService = new MemberService();
                    String reservation = y + "타임";
                    memberService.check(loginedMember.getName(), reservation, "예약시간");
                    System.out.println("♣♣♣ 예약이 완료되었습니다. ♣♣♣");
                    System.out.printf("★★★ [%s타임] %s님의 예약이 완료되었습니다. ★★★ \n", reservations, loginedMember.getName());
                    System.out.printf("★★★ (확인 비밀번호 : %s)  ★★★ \n", name);
                }
            } else {
                System.out.println("예약이 완료된 시간입니다. 다시 예약해주세요.");
            }
            return;
        }
    }
}