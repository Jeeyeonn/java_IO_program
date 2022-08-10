public interface MenuChoice {
    int MAKE =1;
    int SHOW_BUS=2;
    int ADD_PERSON = 3;
    int RESET_SPEED = 4;
    int RESET_OIL = 5;
    int STATE = 6;
    int BACK = 7;
    int TAXI = 2;
    int BUS = 1;
    int EXIT = 3;
    public static void showBusMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("┌────────────version_1.Taxi.Bus Menu────────────┐");
        System.out.println("│ 1.버스 개설    2.버스 전체 출력    │");
        System.out.println("│ 3.승객 탑승    4.버스 속도 변경    │");
        System.out.println("│ 5.주유량 변경  6.버스 상태 변경    │");
        System.out.println("│ 7.뒤로가기                       │");
        System.out.println("└────────────────────────────────┘");
    }

    public static void showTaxiMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("┌────────────version_1.Taxi Menu───────────┐");
        System.out.println("│ 1.택시 개설    2.택시 전체 출력    │");
        System.out.println("│ 3.승객 탑승    4.택시 속도 변경    │");
        System.out.println("│ 5.주유량 변경                    │");
        System.out.println("│ 6.운행 종료 / 요금 계산           │");
        System.out.println("│ 7.뒤로가기                       │");
        System.out.println("└────────────────────────────────┘");
    }

    public static void showMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("┌─────────────Menu───────────────┐");
        System.out.println("│        1.버스 관련 기능          │");
        System.out.println("│        2.택시 관련 기능          │");
        System.out.println("│        3.종료                   │");
        System.out.println("└────────────────────────────────┘");
    }
}
