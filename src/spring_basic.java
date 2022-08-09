import Bus.Bus_Model;
import Bus.Bus_Service;
import Taxi.Taxi_Service;

import java.util.Scanner;

public class spring_basic {

    public static void main(String[] args) {

        Menu();

    }

    public static void Menu(){
        Scanner scanner = new Scanner(System.in);


        while(true) {
            MenuChoice.showMenu();

            int choice = scanner.nextInt();

            switch(choice) {
                case MenuChoice.BUS:
                    Bus_Menu();
                    break;
                case MenuChoice.TAXI:
                    Taxi_Menu();
                    break;
                case MenuChoice.EXIT:
                    System.out.println("프로그램종료");
                    System.exit(0);
                    break;

            }
        }
    }

    public static void Bus_Menu(){

        Scanner scanner = new Scanner(System.in);
        Bus_Service bus_service = new Bus_Service();

        while(true){
            MenuChoice.showBusMenu();

            int choice = scanner.nextInt();

            switch (choice) {
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
                case MenuChoice.BACK:
                    Menu();
                    break;
            }
        }
    }


    public static void Taxi_Menu(){

        Scanner scanner = new Scanner(System.in);
        Taxi_Service taxi_service = new Taxi_Service();

        while(true){
            MenuChoice.showTaxiMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case MenuChoice.MAKE:
                    taxi_service.add_Taxi();
                    break;
                case MenuChoice.SHOW_BUS:
                    taxi_service.showAllInfo();
                    break;
                case MenuChoice.ADD_PERSON:
                    taxi_service.add_person();
                    break;
                case MenuChoice.RESET_SPEED:
                    taxi_service.reset_speed();
                    break;

                case MenuChoice.RESET_OIL:
                    taxi_service.reset_oil();
                    break;

                case MenuChoice.STATE:
                    taxi_service.take_off();
                    break;
                case MenuChoice.BACK:
                    Menu();
                    break;
            }
        }
    }
}
