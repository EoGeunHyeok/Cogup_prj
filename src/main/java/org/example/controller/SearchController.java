package org.example.controller;

import org.example.container.Container;
import org.example.dto.Member;
import org.example.service.MemberService;

import java.util.Scanner;

public class SearchController extends Controller {
    private Scanner sc;
    private MemberService memberService;
    private Session session;
    private String cmd;




    public SearchController() {
        sc = Container.getScanner();
        memberService = Container.memberService;
        session = Container.getSession();

    }

    public void doAction(String cmd, String actionMethodName){
        this.cmd = cmd;

        switch (actionMethodName){
            case "모음":
                Search();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }

    }

    public void Search() {
        System.out.println("       = 검색어 모음 =    ");
        System.out.println("★★★★ 띄어쓰기 주의해 주세요! ★★★★");
        System.out.println("1. 회원 가입 / 회원 로그인 / 회원 로그아웃 / 회원 정보");
        System.out.println("2. 게시글 작성 / 게시글 삭제/ 게시글 변경 / 게시글 수정 --> 회원전용.");
        System.out.println("   게시글 목록/ 게시글 검색 ");
        System.out.println("4. 게시판 확인 / 게시판 변경");
        System.out.println("5. 상담 예약/ 상담 취소 --> 회원전용.");
        System.out.println("6. 헬스장 정보 ");
        System.out.println("7. 출석 체크 / 출석 확인 --> 회원전용.");
        System.out.println(" -------------------------------------- ");


    }

}
