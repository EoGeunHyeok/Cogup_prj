package App;

import org.example.container.Container;
import org.example.controller.*;
import org.example.db.DBConnection;

public class App {
    int[] seats = new int[6];
    int[] pit = new int[2];
    public App() {
        DBConnection.DB_NAME = "sbs_proj";
        DBConnection.DB_USER = "sbsst";
        DBConnection.DB_PASSWORD = "sbs123414";
        DBConnection.DB_PORT = 3306;

        Container.getDBConnection().connect();

        Container.getSession().setCurrentBoard((Container.articleService.getBoard(1)));

    }

    public void start() {
        System.out.println("         == GMS ==       ");
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

        MemberController memberController = new MemberController(seats);
        ArticleController articleController = new ArticleController();
        ExportController exportController = new ExportController();
        CheckController checkController = new CheckController(seats);
        InformationController informationController = new InformationController(pit);
        CulController culController = new CulController();
        BoardController boardController = new BoardController();
        SearchController searchController = new SearchController();


        while (true) {

            System.out.printf("검색어 입력 : ");
            String cmd = Container.getScanner().nextLine();
            cmd = cmd.trim();

            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("종료")) {
                break;
            }

            String[] cmdBits = cmd.split(" ");

            if( cmdBits.length == 1){
                System.out.println("존재하지 않는 명령어 입니다.");
                continue;
            }
            String controllerName = cmdBits[0];
            String actionMethodName = cmdBits[1];

            Controller controller = null;

            if ( controllerName.equals("게시글")){
                controller = articleController;
            }
            else if ( controllerName.equals("회원")){
                controller = memberController;
            }
            else if ( controllerName.equals("2")){
                controller = exportController;
            }
            else if (controllerName.equals("상담")){
                controller = checkController;

            }
            else if (controllerName.equals("헬스장")){
                controller = informationController;

            }
            else if (controllerName.equals("출석")){
                controller = culController;

            }
            else if (controllerName.equals("게시판")){
                controller = boardController;

            }

            else if (controllerName.equals("검색어")){
                controller = searchController;

            }

            else {
                System.out.println("존재하지 않는 명령어입니다.");
                continue;
            }

            String actionName = controllerName + "/" + actionMethodName;

            switch ( actionName ){
                case "게시물/작성":
                case "게시물/삭제":
                case "게시물/수정":
                case "회원/로그아웃":
                case "상담/예약":
                case "상담/취소":
                case "출석/체크":
                case "출석/확인":
                    if( Container.getSession().isLogined() == false ) {
                        System.out.println("로그인 후 이용해주세요.");
                        continue;
                    }
                    break;
            }

            switch ( actionName ){
                case "회원/로그인":
                case "회원/가입":

                    if( Container.getSession().isLogined() ) {
                        System.out.println("로그아웃 후 이용해주세요.");
                        continue;
                    }
                    break;
            }


            controller.doAction(cmd, actionMethodName);
        }

        Container.getDBConnection().close();
        Container.getScanner().close();

        System.out.println("== 프로그램 종료 ==");

    }

}
