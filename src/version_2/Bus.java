package version_2;

import version_1.Bus.Bus_State;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bus extends Transit{

    public int current_num;
    public B_State b_state;

    public Bus(){}

    public Bus(int id){
        this.id = id;
        this.current_num = 0;
        this.max_num = 30;
        this.speed  = 0;
        this.oil = 100;
        this.price = 0;
        this.b_state = B_State.DRIVING;
    }

    public void showInfo() {

        String state = "";
        if(b_state == B_State.GO_HOME)
            state = "차고지행";
        else
            state = "운행 중";

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(" 버스 번호 : "+ id);
        System.out.println(" 현재 인원 : "+ current_num);
        System.out.println(" 최대 인원 : "+ max_num);
        System.out.println(" 현재 속도 : "+ speed);
        System.out.println(" 총 요금 : "+ price);
        System.out.println(" 주유량 : "+ oil);
        System.out.println(" 현재 상태 : "+ state);
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    Scanner scanner = new Scanner(System.in);


    public Map<Integer, Bus> Bus = new HashMap<>();
    int bus_num = 0;


    public void add_transit(int select){

        if(select == 0){

            System.out.print("원하시는 버스 번호를 입력하세요 : ");
            int id = scanner.nextInt();

            //버스 번호 중복 체크
            if(id_check(id) == true){  //중복일 경우
                System.out.println("이미 등록된 버스 번호입니다.");
                //add_transit();
            }else {
                Bus model = new Bus(id);
                Bus.put(bus_num++, model);
                System.out.println("버스가 생성되었습니다.");
            }

        }else{

            System.out.print("원하시는 택시 번호를 입력하세요 : ");
            int id = scanner.nextInt();

            //버스 번호 중복 체크
            if(id_check(id) == true){  //중복일 경우
                System.out.println("이미 등록된 택시 번호입니다.");
                //add_transit();
            }else {
                System.out.print("주유량을 입력하세요 : ");
                int oil = scanner.nextInt();
                if(oil <= 0 ){
                    System.out.println("잘못된 입력입니다.");
                    //add_transit();
                }else{
                    Taxi model = new Taxi(id);
                    Taxi.put(Taxi_num++, model);
                    System.out.println("택시가 생성되었습니다.");
                }
            }

        }
    }

    //버스 번호 중복 체크
    public boolean id_check(int id){
        boolean result = false;

        for(int i : Bus.keySet()){
            if(Bus.get(i).getId()== id){
                result = true;
            }
        }

        return result;
    }

    //버스 번호에 맞는 index를 반환
    public int find_id(int id){
        int a= -1;

        for(int i : Bus.keySet()){
            if(Bus.get(i).getId()== id){
                a = i;
            }
        }

        return a;
    }


    //전체정보 출력
    public void showAllInfo() {
        for(int i=0 ; i<Bus.size() ; i++) {
            Bus.get(i).showInfo();
        }
        System.out.println("==전체 버스 정보가 출력되었습니다.==");
    }


    // 승객 탑승
    public void add_person(){
        System.out.print("탑승 승객 수 : ");
        int add_person = scanner.nextInt();
        System.out.print("버스 번호 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if( b == -1){   //해당하는 버스 번호가 없음
            System.out.println("잘못된 버스번호 입니다.");
            add_person();
        }else {

            if(Bus.get(b).getMax_num() >= (add_person + Bus.get(b).getCurrent_num())) { // 탑승 인원을 초과하였는가 ?

                if(Bus.get(b).getB_state() == B_State.DRIVING){  // 버스가 운행 중인지 ?

                    int price = Bus.get(b).getPrice() + add_person * 1000;
                    Bus.get(b).setPrice(price);

                    int c_person = Bus.get(b).getCurrent_num();
                    Bus.get(b).setCurrent_num(add_person + c_person);

                    Bus.get(b).showInfo();

                }else{ //차고지행일 경우
                    System.out.println("버스가 운행중이 아닙니다");
                }

            }else{
                System.out.println("탑승 인원을 초과하였습니다.");
                add_person();
            }
        }
    }



    // 버스 속도 재설정
    public void reset_speed() {
        System.out.println("속도 증감을 원하시면 양수를 감속을 원하시면 음수를 입력하세요");
        System.out.print("변경 속도 : ");
        int speed = scanner.nextInt();
        System.out.print("버스 번호 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if (b == -1) {   //해당하는 버스 번호가 없음
            System.out.println("잘못된 버스번호 입니다.");
            reset_speed();
        } else {
            int c_oil = Bus.get(b).getOil();
            int c_speed = Bus.get(b).getSpeed();
            if (c_oil >= 10) { // 주유량이 10 이상인가 ?

                if (c_speed + speed > 0) { //계산한 속도가 양수인가 ?
                    Bus.get(b).setSpeed(c_speed + speed);

                    System.out.println("속도 변경 완료 !");
                    Bus.get(b).showInfo();

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
        System.out.print("버스 번호 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if (b == -1) {   //해당하는 버스 번호가 없음
            System.out.println("잘못된 버스번호 입니다.");
            reset_oil();
        }else{
            int c_oil = Bus.get(b).getOil();

            if(c_oil + oil > 0) { // 주유량이 양수인가 ?


                if(c_oil + oil >= 10){  //운행할 수 있는 상태인지 ?
                    Bus.get(b).setOil(c_oil + oil);
                    Bus.get(b).showInfo();
                }else{
                    System.out.println("주유가 필요합니다.");
                    Bus.get(b).setOil(c_oil + oil);
                    Bus.get(b).setB_state(B_State.GO_HOME);
                    Bus.get(b).showInfo();
                }

            }else {
                Bus.get(b).setB_state(B_State.GO_HOME);
                Bus.get(b).setOil(0);
                System.out.println("주유량이 0이므로 운행을 종료합니다.");
                System.out.println("운행상태 변경 : 운행중 -> 차고지행");
            }
        }

    }


    public void reset_state(){
        System.out.println("운행 상태를 변경하고 싶은 버스 번호를 입력하시오 : ");
        int id = scanner.nextInt();

        int b = find_id(id);

        if (b == -1) {   //해당하는 버스 번호가 없음
            System.out.println("잘못된 버스번호 입니다.");
            reset_state();
        }else{
            B_State bus_state = Bus.get(b).getB_state();

            if(bus_state == B_State.GO_HOME){

                System.out.println("버스 운행 상태를 운행중으로 변경하시겠습니까? (y/n) : ");
                String answer = scanner.next();

                if(answer.equals("y")){
                    int c_oil = Bus.get(b).getOil();

                    if(c_oil>0){
                        Bus.get(b).setB_state(B_State.DRIVING);
                        Bus.get(b).setCurrent_num(0);
                        Bus.get(b).setPrice(0);
                        System.out.println("변경 완료 !");
                        Bus.get(b).showInfo();
                    }else{
                        System.out.println("주유량이 부족해 운행중으로 변경할 수 없습니다.");
                        Bus.get(b).showInfo();
                    }

                }else if(answer.equals("n")){

                }else{
                    System.out.println("잘못된 입력입니다.");
                    reset_state();
                }

            }else if(bus_state == B_State.DRIVING){
                System.out.println("버스 운행 상태를 차고지행으로 변경하시겠습니까? (y/n) : ");
                String answer = scanner.next();

                if(answer.equals("y")){
                    Bus.get(b).setB_state(B_State.GO_HOME);
                    System.out.println("변경 완료 !");
                    Bus.get(b).showInfo();
                }else if(answer.equals("n")){

                }else{
                    System.out.println("잘못된 입력입니다.");
                    reset_state();
                }
            }


        }

    }





    public int getCurrent_num() {
        return current_num;
    }

    public void setCurrent_num(int current_num) {
        this.current_num = current_num;
    }

    public B_State getB_state() {
        return b_state;
    }

    public void setB_state(B_State b_state) {
        this.b_state = b_state;
    }
}
