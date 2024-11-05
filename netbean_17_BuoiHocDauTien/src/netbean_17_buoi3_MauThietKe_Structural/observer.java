package netbean_17_buoi3_MauThietKe_Structural;

import java.util.ArrayList;
import java.util.List;

interface obsv{
    void updateinfor(float temperature, float windy, float humi);
}

interface eventprocessing{
    void registerobserver(obsv obsv);
    void removeobserver(obsv obsv);
    void notifyobserver();
}

class weatherstation implements eventprocessing{
    private List<obsv> observers;
    private float temp; 
    private float wind;
    private float humi;

    public void setTemp(float temp) {
        this.temp = temp;
        notifyobserver();
    }
    public void setWind(float wind) {
        this.wind = wind;
        notifyobserver();
    }
    public void setHumi(float humi) {
        this.humi = humi;
        notifyobserver(); // thong bao toi tat ca obsv khi hunmi thay doi 
    }
    public weatherstation(){
        this.observers = new ArrayList<>();
    }  
    public void registerobserver(obsv obsv){
        observers.add(obsv);
    }
    public void removeobserver(obsv obsv){
        observers.remove(obsv);
    }
    public void notifyobserver(){
        for(obsv x : observers){
            x.updateinfor(temp, wind, humi);
        }
    }
}

class tvdisplay implements obsv{
    public void updateinfor(float temperature, float windy, float humi){
        System.out.println("TV: nhiet do " + temperature +" gio " + windy + " do am " + humi);
    }
}

class mobilephonedisplay implements obsv{
    public void updateinfor(float temperature, float windy, float humi){
        System.out.println("mobilephone : nhiet do " + temperature +" gio " + windy + " do am " + humi);
    }    
}

public class observer{
    public static void main(String[] args) {
        weatherstation w = new weatherstation();
        
        tvdisplay tv = new tvdisplay();
        mobilephonedisplay mp = new mobilephonedisplay();
        
        w.registerobserver(tv);
        w.registerobserver(mp);
        
        System.out.println("nhiet do moi : 28.5 C");
        w.setTemp(28.5f);
        
        w.removeobserver(tv);
        
        System.out.println("nhiet do moi : 40 C");
        w.setTemp(40);
    }
}
