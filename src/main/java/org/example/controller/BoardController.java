package org.example.controller;

import org.example.container.Container;
import org.example.dto.Board;
import org.example.service.ArticleService;
import org.example.service.MemberService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardController extends Controller{
    private Scanner sc;
    private String cmd;
    private ArticleService articleService;
    private String actionMethodName;
    private MemberService memberService;
    private Session session;

    public BoardController() {
        sc = Container.getScanner();
        articleService = Container.articleService;
        memberService = Container.memberService;
        session = Container.getSession();

    }
    public void doAction(String cmd, String actionMethodName) {
        this.cmd = cmd;

        switch (actionMethodName) {
            case "확인":
                doCurrentBoard();
                break;
            case "변경":
                doChangeBoard();
                break;
            default:
                System.out.println("존재하지 않는 명령어 입니다.");
                break;
        }

    }

    private void doChangeBoard() {
        System.out.println("1. 공지 게시판");
        System.out.println("2. 자유 게시판");
        System.out.println("게시판 번호를 입력하세요)");



        int boardId = checkScNum();
        Board board = articleService.getBoard(boardId);


        if (board == null) {
            System.out.println("해당 게시판은 존재하지 않습니다.");
        } else {
            System.out.printf("[%s 게시판]으로 변경되었습니다.\n ", board.getName());
            session.setCurrentBoard(board);
        }
    }

    private void doCurrentBoard() {
        Board board = session.getCurrentBoard();
        System.out.printf("현 게시판 : [%s 게시판]\n", board.getName());
    }
    public int checkScNum() {

        int id = 0;

        try {
            id = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다.");
            sc.nextLine();
            return 0;
        }
        return id;
    }
    private boolean isNoticeBoard() {

        return session.getCurrentBoard().getId() == 1;
    }

    private boolean isAdmin() {

        return session.isLogined() && session.getLoginedMember().getLoginId().equals("admin");
    }
}
