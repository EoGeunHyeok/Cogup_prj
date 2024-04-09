package org.example.file;

import java.util.Scanner;

class MemberService {
    public static void join(String loginId, String loginPw, String name) {
        System.out.printf("아이디 : %s , 비밀번호 : %s , 이름 : %s \n", loginId, loginPw, name);
    }
}

public class MemberJoin {
    public static void memberJoin() {
        Scanner sc = new Scanner(System.in);

        String loginId = null;

        while (true) {
            System.out.println("== 회원가입 페이지 입니다. ==");
            System.out.printf("로그인 아이디 : ");
            loginId = sc.nextLine();

            if (!isJoinableLoginId(loginId)) {
                System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", loginId);
                continue;
            }

            break;
        }

        String loginPw = null;
        String loginPwConfirm = null;

        while (true) {
            System.out.printf("로그인 비번 : ");
            loginPw = sc.nextLine();
            System.out.printf("로그인 비번확인 : ");
            loginPwConfirm = sc.nextLine();

            if (!loginPw.equals(loginPwConfirm)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                continue;
            }

            break;
        }

        System.out.printf("이름 : ");
        String name = sc.nextLine();

        MemberService.join(loginId, loginPw, name);

        System.out.printf("[%s]님! 회원가입이 완료되었습니다. 환영합니다!\n", name);
    }

    private static boolean isJoinableLoginId(String loginId) {

        return true;
    }
}