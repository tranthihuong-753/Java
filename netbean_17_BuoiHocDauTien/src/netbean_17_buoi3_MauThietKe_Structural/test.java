package netbean_17_buoi3_MauThietKe_Structural;

import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
                a();
                b();
            } catch (InterruptedException ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        b();
    }
    static void a(){
        System.out.println("a1");
        int i;
        for(i = 0 ; i < 7 ; i++){
            System.out.println("    a"+i);
        }
    }
    static void b(){
        System.out.println("b2");
    }    
}
