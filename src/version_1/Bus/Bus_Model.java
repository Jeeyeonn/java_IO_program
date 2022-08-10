package version_1.Bus;

import java.util.Scanner;

public class Bus_Model {

    private int id;
    private int current_num;
    private int max_num;
    private int current_speed;
    private int oil;
    private int price;
    private Bus_State bus_state;

    Scanner scanner = new Scanner(System.in);

    public Bus_Model(int id, int current_num){
        this.id = id;
        this.current_num = current_num;
        this.max_num = 30;
        this.current_speed  = 0;
        this.oil = 100;
        this.price = 0;
        this.bus_state = Bus_State.DRIVING;
    }

    public Bus_Model(){
        this.max_num = 30;
        this.oil = 100;
        this.price = 0;
        this.current_speed  = 0;
        this.bus_state = Bus_State.DRIVING;
    }




    //버스 정보 출력
    public void showBusInfo() {

        String state = "";
        if(bus_state == Bus_State.GO_HOME)
            state = "차고지행";
        else
            state = "운행 중";

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(" 버스 번호 : "+ id);
        System.out.println(" 현재 인원 : "+ current_num);
        System.out.println(" 최대 인원 : "+ max_num);
        System.out.println(" 현재 속도 : "+ current_speed);
        System.out.println(" 총 요금 : "+ price);
        System.out.println(" 주유량 : "+ oil);
        System.out.println(" 현재 상태 : "+ state);
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }


    public int getId() {
        return id;
    }

    public Bus_State getBus_state() {
        return bus_state;
    }

    public int getCurrent_num() {
        return current_num;
    }

    public int getCurrent_speed() {
        return current_speed;
    }

    public int getMax_num() {
        return max_num;
    }

    public int getOil() {
        return oil;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBus_state(Bus_State bus_state) {
        this.bus_state = bus_state;
    }

    public void setCurrent_num(int current_num) {
        this.current_num = current_num;
    }

    public void setCurrent_speed(int current_speed) {
        this.current_speed = current_speed;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }
}

