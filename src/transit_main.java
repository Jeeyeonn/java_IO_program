import version_2.Bus;
import version_2.Taxi;

public class transit_main {

    public static void main(String[] args) {

        //시나리오 1번
        Story2();
    }

    public static void Story1(){

        Bus bus = new Bus();


        bus.add_transit(0);
        bus.add_transit(0);

        bus.showAllInfo();   //각각 버스 번호가 다른지 확인


        bus.add_person();
        bus.reset_oil();
        bus.reset_state();
        bus.reset_oil();
        bus.reset_state();
        bus.add_person();
        bus.reset_oil();


    }


    public static void Story2(){

        Taxi taxi = new Taxi();

        taxi.add_transit(1);
        taxi.add_transit(1);

        taxi.showAllInfo();

        taxi.add_person();
        taxi.reset_oil();
        taxi.take_off();
        taxi.add_person();
        taxi.reset_oil();


    }

}
