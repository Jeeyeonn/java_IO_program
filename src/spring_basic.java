import Bus.Bus_Model;
import Bus.Bus_Service;

import java.util.Scanner;

public class spring_basic {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bus_Service bus_service = new Bus_Service();

        while(true) {
            MenuChoice.showMenu();

            int choice = scanner.nextInt();

            switch(choice) {
                case MenuChoice.MAKE:
                    bus_service.add_Bus();
                    break;
                case MenuChoice.SHOW_BUS:
                    bus_service.showAllInfo();
                    break;
                case MenuChoice.ADD_PERSON:
                    bus_service.add_person();
                    break;
                case MenuChoice.RESET_SPEED:
                    bus_service.reset_speed();
                    break;

                case MenuChoice.RESET_OIL:
                    bus_service.reset_oil();
                    break;

                case MenuChoice.STATE:
                    bus_service.reset_state();
                    break;
            }
        }

    }
}
