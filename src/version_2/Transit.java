package version_2;

import java.util.HashMap;
import java.util.Map;

abstract class Transit {

    int id;
    int max_num;
    int speed;
    int oil;
    int price;


    public Map<Integer, Bus> Bus = new HashMap<>();
    int bus_num = 0;

    public Map<Integer, Taxi> Taxi = new HashMap<>();
    int Taxi_num = 0;


    public void start(){};
    public void reset_speed(){};
    public void reset_oil(){};
    public void add_person(){};
    public void reset_state(){};
    public void add_transit(int a){};
    public boolean id_check(int id){ return  false;};
    public int find_id(int num){return  num;}
    public void showAllInfo(){};
    public void showInfo(){};

    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setId(int id) {
        this.id = id;
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
