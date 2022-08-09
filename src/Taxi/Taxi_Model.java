package Taxi;

import Bus.Bus_State;

public class Taxi_Model {

    private int id;
    private int current_num;
    private int max_num;
    private int speed;
    private int km;
    private int price;
    private int oil;
    private String goal;
    private Taxi_State taxi_state;

    Taxi_Model(){
        this.max_num = 4;
        this.speed = 0;
        this.price = 0;
        this.oil = 0;
        this.km = 0;
        this.goal = "";
        this.taxi_state = Taxi_State.NOT_DRIVE;
    }

    Taxi_Model(int id, int oil){
        this.id = id;
        this.oil = oil;
        this.goal = "";
        this.taxi_state = Taxi_State.NOT_DRIVE;
        this.current_num = 0;
        this.price = 0;
        this.km = 0;
        this.max_num = 4;
    }


    //택시 정보 출력
    public void showTaxiInfo() {

        String state = "";
        if(taxi_state == Taxi_State.DRIVING)
            state = "운행 중";
        else
            state = "일반";

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(" 택시 번호 : "+ id);
        System.out.println(" 현재 인원 : "+ current_num);
        System.out.println(" 최대 인원 : "+ max_num);
        System.out.println(" 목적지 : "+ goal);
        System.out.println(" 현재 속도 : "+ speed);
        System.out.println(" 총 요금 : "+ price);
        System.out.println(" 주유량 : "+ oil);
        System.out.println(" 현재 상태 : "+ state);
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public int getCurrent_num() {
        return current_num;
    }

    public int getPrice() {
        return price;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getOil() {
        return oil;
    }

    public int getMax_num() {
        return max_num;
    }

    public int getId() {
        return id;
    }

    public int getKm() {
        return km;
    }

    public Taxi_State getTaxi_state() {
        return taxi_state;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCurrent_num(int current_num) {
        this.current_num = current_num;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTaxi_state(Taxi_State taxi_state) {
        this.taxi_state = taxi_state;
    }
}
