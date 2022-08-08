public interface MenuChoice {
    int MAKE =1;
    int SHOW_BUS=2;
    int ADD_PERSON = 3;
    int RESET_SPEED = 4;
    int RESET_OIL = 5;
    int STATE = 6;
    public static void showMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("┌────────────Bus Menu────────────┐");
        System.out.println("│ 1.버스 개설    2.버스 전체 출력    │");
        System.out.println("│ 3.승객 탑승    4.버스 속도 변경    │");
        System.out.println("│ 5.주유량 변경  6.버스 상태 변경    │");
        System.out.println("│ 3.승객 탑승    4.버스 속도 변경    │");
        System.out.println("└────────────────────────────────┘");
    }
}
