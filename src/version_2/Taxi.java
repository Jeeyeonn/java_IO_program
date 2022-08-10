package version_2;

import version_1.Taxi.Taxi_State;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Taxi extends Transit{
    private String goal;
    private int goal_km;
    private int extra_price;
    private int basic_km;
    private T_State taxi_state;

    public Taxi(int id){
        this.id = id;
        this.oil = 100;
        this.goal = "";
        this.taxi_state = T_State.NOT_DRIVE;
        this.price = 0;
        this.goal_km = 0;
        this.max_num = 4;
        this.extra_price = 800;
        this.basic_km = 5;
    }

    public Taxi(){

    }

    Scanner scanner = new Scanner(System.in);

    public Map<Integer, Taxi> Taxi = new HashMap<>();
    int Taxi_num = 0;


    //택시 생성
    public void add_transit(int select){

        if(select == 0){

            System.out.print("원하시는 버스 번호를 입력하세요 : ");
            int id = scanner.nextInt();

            //버스 번호 중복 체크
            if(id_check(id) == true){  //중복일 경우
                System.out.println("이미 등록된 버스 번호입니다.");
                //add_transit();
            }else {
                System.out.print("몇 명이 탑승합니까? : ");
                int current_num = scanner.nextInt();
                if(current_num > 30){
                    System.out.println("탑승 인원을 초과하였습니다.");
                    //add_transit();
                }else{
                    Bus model = new Bus(id);
                    Bus.put(bus_num++, model);
                    System.out.println("버스가 생성되었습니다.");
                }
            }

        }else{

            System.out.print("원하시는 택시 번호를 입력하세요 : ");
            int id = scanner.nextInt();

            //버스 번호 중복 체크
            if(id_check(id) == true){  //중복일 경우
                System.out.println("이미 등록된 택시 번호입니다.");
                //add_transit();
            }else {
                Taxi model = new Taxi(id);
                Taxi.put(Taxi_num++, model);
                System.out.println("택시가 생성되었습니다.");
            }

        }
    }


    //버스 번호 중복 체크
    public boolean id_check(int id){
        boolean result = false;

        for(int i : Taxi.keySet()){
            if(Taxi.get(i).getId()== id){
                result = true;
            }
        }

        return result;
    }

    //버스 번호에 맞는 index를 반환
    public int find_id(int id){
        int a= -1;

        for(int i : Taxi.keySet()){
            if(Taxi.get(i).getId()== id){
                a = i;
            }
        }

        return a;
    }

    //전체정보 출력
    public void showAllInfo() {
        for(int i=0 ; i<Taxi.size() ; i++) {
            Taxi.get(i).showInfo();
        }
        System.out.println("==전체 택시 정보가 출력되었습니다.==");
    }

    //택시 정보 출력
    public void showInfo() {

        String state = "";
        if(taxi_state == T_State.DRIVING)
            state = "운행 중";
        else
            state = "일반";

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(" 택시 번호 : "+ id);
        System.out.println(" 최대 인원 : "+ max_num);
        System.out.println(" 목적지 : "+ goal);
        System.out.println(" 현재 속도 : "+ speed);
        System.out.println(" 총 요금 : "+ price);
        System.out.println(" 주유량 : "+ oil);
        System.out.println(" 현재 상태 : "+ state);
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }


    // 승객 탑승
    public void add_person(){
        System.out.println("택시 기본요금은 5000원이며, 5 거리 초과 시, 1 거리 당 800원씩 추가됩니다.");
        System.out.print("택시 번호 : ");
        int id = scanner.nextInt();
        System.out.print("목적지 : ");
        String goal = scanner.next();
        System.out.print("목적지까지 거리 : ");
        int km = scanner.nextInt();
        System.out.print("탑승 인원 : ");
        int num = scanner.nextInt();

        System.out.println();

        int b = find_id(id);

        if( b == -1){   //해당하는 택시 번호가 없음
            System.out.println("잘못된 택시 번호 입니다.");
            add_person();
        }else {

            if(Taxi.get(b).getTaxi_state() == T_State.NOT_DRIVE){  // 택시 상태가 일반인지 ?

                if(num <= Taxi.get(b).getMax_num()){

                    int oil = Taxi.get(b).getOil();

                    if(oil > 10){

                        int price = 0;

                        if (km > Taxi.get(b).getBasic_km())
                            price = 5000 + Taxi.get(b).getExtra_price() * (km-Taxi.get(b).getBasic_km());
                        else
                            price = 5000;

                        Taxi.get(b).setPrice(price);
                        Taxi.get(b).setGoal(goal);
                        Taxi.get(b).setSpeed(speed);
                        Taxi.get(b).setTaxi_state(T_State.DRIVING);

                        System.out.println("탑승 승객 수 : " + num);
                        System.out.println("잔여 승객 수 : " + (Taxi.get(b).getMax_num() - num));
                        System.out.println("기본 요금 확인 : " + 5000);
                        System.out.println("목적지 : " + Taxi.get(b).getGoal());
                        System.out.println("목적지까지 거리 : " + Taxi.get(b).getGoal_km());
                        System.out.println("지불할 요금: " + Taxi.get(b).getPrice());
                        System.out.println("상태: 운행중");
                        System.out.println();

                    }else{
                        System.out.println("주유량이 부족합니다.");
                        System.out.println("주유량을 추가한 후 승객 탑승을 해주세요.");
                    }


                }else {
                    System.out.println("잘못된 속도 값입니다.");
                    add_person();
                }


            }else{ //차고지행일 경우
                System.out.println("택시가 운행중이라 탑승할 수 없습니다.");
            }

        }
    }



    // 버스 속도 재설정
    public void reset_speed() {
        System.out.println("속도 증감을 원하시면 양수를 감속을 원하시면 음수를 입력하세요");
        System.out.print("변경 속도 : ");
        int speed = scanner.nextInt();
        System.out.print("택시 번호 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if (b == -1) {   //해당하는 택시 번호가 없음
            System.out.println("잘못된 택시 번호 입니다.");
            reset_speed();
        } else {
            int c_oil = Taxi.get(b).getOil();
            int c_speed = Taxi.get(b).getSpeed();
            if (c_oil >= 10) { // 주유량이 10 이상인가 ?

                if (c_speed + speed > 0) { //계산한 속도가 양수인가 ?
                    Taxi.get(b).setSpeed(c_speed + speed);

                    System.out.println("속도 변경 완료 !");


                } else {
                    System.out.println("잘못된 속도값입니다.");
                    reset_speed();
                }

            } else {
                System.out.println("주유량이 부족합니다.");
                System.out.println("주유량을 확인하고 속도변경을 해주세요.");
            }

        }
    }


    // 버스 주유량 재설정
    public void reset_oil() {
        System.out.println("주유량 증가를 원하시면 양수를 감소를 원하시면 음수를 입력하세요");
        System.out.print("변경 주유량 : ");
        int oil = scanner.nextInt();
        System.out.print("택시 번호 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if (b == -1) {   //해당하는 버스 번호가 없음
            System.out.println("잘못된 택시 번호 입니다.");
            reset_oil();
        }else{
            int c_oil = Taxi.get(b).getOil();

            if(c_oil + oil >= 0) { // 주유량이 양수인가 ?


                if(c_oil + oil >= 10){  //운행할 수 있는 상태인지 ?
                    Taxi.get(b).setOil(c_oil + oil);

                }else{
                    System.out.println("주유가 필요합니다.");
                    Taxi.get(b).setOil(c_oil + oil);
                }

            }else {
                System.out.println("잘못된 주유량 입니다. 다시 입력하세요");
                reset_oil();
            }
        }

    }

    //요금 정산 및 승객 하차
    public void take_off(){
        System.out.print("요금 정산 및 하차를 원하시는 택시 번호를 입력해주세요 : ");
        int id = scanner.nextInt();


        int b = find_id(id);

        if (b == -1) {   //해당하는 버스 번호가 없음
            System.out.println("잘못된 택시 번호 입니다.");
            reset_oil();
        }else{
            System.out.println();
            System.out.println("정상적으로 하차처리 되었습니다.");
            int price = Taxi.get(b).getPrice();
            System.out.println("총 요금은 " + price + "원 입니다.");
            Taxi.get(b).setTaxi_state(T_State.NOT_DRIVE);
            Taxi.get(b).setPrice(0);

            int oil = Taxi.get(b).getOil();
            System.out.println("주유량 : " + oil);
            if(oil <10)
                System.out.println("주유가 필요합니다.");

            System.out.println();
        }


    }



    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getGoal_km() {
        return goal_km;
    }

    public void setGoal_km(int goal_km) {
        this.goal_km = goal_km;
    }

    public int getExtra_price() {
        return extra_price;
    }

    public void setExtra_price(int extra_price) {
        this.extra_price = extra_price;
    }

    public int getBasic_km() {
        return basic_km;
    }

    public void setBasic_km(int basic_km) {
        this.basic_km = basic_km;
    }

    public T_State getTaxi_state() {
        return taxi_state;
    }

    public void setTaxi_state(T_State taxi_state) {
        this.taxi_state = taxi_state;
    }
}
