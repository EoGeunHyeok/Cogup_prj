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
        System.out.println("== GMS ==");
        System.out.println(" -------------------------------------- ");
        System.out.println("= 명령어 모음 =");
        System.out.println("1. 회원가입 : 0 1");
        System.out.println("2. 로그인/로그아웃 : 0 2/3");
        System.out.println("3. 현재 게시판 확인 : 1 currentBoard");
        System.out.println("4. 게시판 변경 : 1 changeBoard");
        System.out.println("5. 게시물 리스트 : 1 list");
        System.out.println("6. 게시물 상세 : 1 detail ");
        System.out.println("7. 게시물 작성(로그인후 이용) : 1 write ");
        System.out.println("8. 게시물 수정/삭제 : 1 modify/delete  ");
        System.out.println("9. 상담예약 : 3 1  ");
        System.out.println("10. 헬스장 정보 : 4 1  ");
        System.out.println("11. 출석체크/출석확인: 5 1/2  ");
        System.out.println(" -------------------------------------- ");

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();
        ExportController exportController = new ExportController();
        CheckController checkController = new CheckController(seats);
        InformationController informationController = new InformationController(pit);
        CulController culController = new CulController();



        while (true) {

            System.out.printf("명령어 입력 : ");
            String cmd = Container.getScanner().nextLine();
            cmd = cmd.trim();

            if (cmd.length() == 0) {
                continue;
            }

            if (cmd.equals("exit")) {
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

            if ( controllerName.equals("1")){
                controller = articleController;
            }
            else if ( controllerName.equals("0")){
                controller = memberController;
            }
            else if ( controllerName.equals("2")){
                controller = exportController;
            }
            else if (controllerName.equals("3")){
                controller = checkController;

            }
            else if (controllerName.equals("4")){
                controller = informationController;

            }
            else if (controllerName.equals("5")){
                controller = culController;

            }

            else {
                System.out.println("존재하지 않는 명령어입니다.");
                continue;
            }

            String actionName = controllerName + "/" + actionMethodName;

            switch ( actionName ){
                case "1/write":
                case "1/delete":
                case "1/modify":
                case "0/logout":
                case "3/1":
                case "5/1":
                case "5/2":
                    if( Container.getSession().isLogined() == false ) {
                        System.out.println("로그인 후 이용해주세요.");
                        continue;
                    }
                    break;
            }

            switch ( actionName ){
                case "0/2":
                case "0/1":

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
