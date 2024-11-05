package netbean_17_buoi7_dongbo_batdongbo;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class future_BatDongBo {
    
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        
        // tao 1 calltable tra ve ket qua 
        Callable<String> task = () -> {
            try{
                System.out.println("dang thuc hien tac vu bat dong bo");
                TimeUnit.SECONDS.sleep(2000);
            }catch(Exception exx){
                System.out.println(exx.toString());
            }
            return "Ket qua tac vu";
        };
        
        // gui tac vu toi excutors service va nhan 1 future 
        Future<String> future = ex.submit(task);
    }
}
